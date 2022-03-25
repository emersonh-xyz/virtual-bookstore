package BookStore;
import java.util.*;


public class Main {

    // Create ArrayList of our class objects
    private static ArrayList<Member> memberList = new ArrayList<>();
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<DVD> dvdList = new ArrayList<>();
    private static ArrayList<CD> cdList = new ArrayList<>();


    private static String name; // Get member name
    private static Boolean premium = true; // Check for if member is premium

    private static String memberChoice;
    private static int currentMember = 0; // remember which member is active

    private static Scanner sc = new Scanner(System.in);

    public static void Continue() {
        System.out.println("\nType [E] continue");
        sc.next();
    }

    public static void WelcomeScreen() {


        System.out.println("Hello there! Welcome to Em's Bookshop!");
        System.out.println("-> What should we call you?");
        name = sc.next();
        System.out.println("\nHey " + name + ",\nJust so you know" +
                " we require a membership to access our incredible selection of items.");
        System.out.println("\nWe offer a regular FREE membership and also a PREMIUM membership that will run you only $15!");
        System.out.println("-> What will you be picking? [REGULAR]/[PREMIUM]");
        int i = 0;

        while (i == 0) {

            memberChoice = sc.next();

            if (memberChoice.toUpperCase().equals("REGULAR")) {
                premium = false;
                System.out.println("Great coice! We've set you up with a regular membership card!\n" +
                        "\n╰☆ Don't lose it!");
                memberList.add(new Member(name, premium));
                currentMember = memberList.size() - 1; // Our current member is going to be the most recent one added to the list

                i = 1;
                Continue();
            } else if (memberChoice.toUpperCase().equals("PREMIUM")) {
                memberList.add(new Member(name, premium));
                currentMember = memberList.size() - 1;
                memberList.get(currentMember).spend(15);
                i = 1;
                Continue();
            } else {
                System.out.println("Please enter a valid membership option!");
            }
        }
    }



    public static void main(String args[]) {

        bookList.add(new Book("The Invention of Hugo Cabret", "Brian Selznick", 20.99, 526));
        bookList.add(new Book("The Family Chao", " Lan Samantha Chang", 9.98, 320));

        dvdList.add(new DVD("Star Wars: A New Hope", 10.00));
        dvdList.add(new DVD("Star Wars: Return of the Jedi", 20.00));

        cdList.add(new CD("It Won't Be Long", "The Hives", 5.00));
        cdList.add(new CD("Waterflame", "Surface", 10.00));

        // Create empty members without a wizard screen
        memberList.add(new Member("Mario", false, false));
        memberList.add(new Member("Luigi", false, false));
        memberList.add(new Member("Wario", false, false));
        memberList.add(new Member("Toad", false, false));
        memberList.add(new Member("Yoshi", false, false));


        boolean activeStore = true;
        int memberSelection = 0;


        // Intro phase

        while (activeStore) {
            if (memberList.size() == 0) { // If there are no members present a welcome screen
                WelcomeScreen();
            } else { // If there are existing members open a selection screen
                System.out.println("-> Please pick an option" +
                        "\n[1] - Create new member " +
                        "\n[2] - Enter store as existing member ");
                int option = 0;
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        WelcomeScreen();
                        break;
                    case 2:
                        boolean validMember = false;

                        System.out.println("Please select a member [0] -> [" + (memberList.size() - 1) + "]" );
                        for (int u = 0; u < memberList.size(); u++) {
                            System.out.println("[" + u + "] Name: " + memberList.get(u).getName() + " | Membership: " + memberList.get(u).memberStatus());
                        }

                        while (!validMember) {
                            memberSelection = sc.nextInt();
                            if (memberSelection >= 0 && memberSelection < memberList.size()) {
                                currentMember = memberSelection; // Change our current member to new member
                                name = memberList.get(memberSelection).getName(); // Reassign our name
                                premium = memberList.get(memberSelection).hasPremium(); // Reassign our premium status
                                System.out.println("\nEntering store as: " + memberList.get(memberSelection).getName());
                                Continue();
                                validMember = true;
                            } else {
                                System.out.println("Invalid member selected...");
                            }
                        }
                        break;
                }
            }


            int z = 0;

            while (z == 0) {
                System.out.println("-> What would you like to do in our store today " + name + "?" +
                        "\n[1] - Browse the store" +
                        "\n[2] - View money spent" +
                        "\n[3] - Upgrade my membership" +
                        "\n[4] - Check payment status" +
                        "\n[5] - Delete my membership" +
                        "\n[6] - View profile" +
                        "\n[7] - Create new user" +
                        "\n[8] - **DEBUG PROGRAM**");

                int select = 0;
                select = sc.nextInt();
                Boolean needsCheckout = true;


                int totalCart = 0; // Keep track of total items in cart
                double totalCheckout = 0; // Keep track of checkout price

                // Keep track of items in cart
                int bookCart = 0;
                int dvdCart = 0;
                int cdCart = 0;

                    switch (select) {
                        case 1: // Browse the store
                            while(needsCheckout) {
                            System.out.println("-> What would you like to look at today?" +
                                    "\n[1] Books " +
                                    "\n[2] DVDs " +
                                    "\n[3] CDs " +
                                    "\n[4] Checkout " +
                                    "\n-> You currently have " + totalCart + " items in your cart");
                            boolean _picking = true;

                            while (_picking) {
                                String _browseInput = sc.next();
                                if (_browseInput.equals("1")) { // BOOK SELECTION
                                    if (bookList.size() == 0) {
                                        System.out.println("╰☆ Sorry we have no books in stock right now!");
                                        _picking = false;
                                        Continue();
                                    } else {
                                        System.out.println("╰☆ We currently have these book(s) in stock!\n");
                                        int x = 0;
                                        for (; x < bookList.size(); x++) {
                                            System.out.println("[" + x + "] " + bookList.get(x).getName() + " | $" + bookList.get(x).getPrice()
                                                    + " | " + bookList.get(x).getPages() + " pages");

                                        }
                                        System.out.println("\n-> Please select a book to purchase!");
                                        int bookSelection = 0;
                                        bookSelection = sc.nextInt();
                                        if (bookSelection >= 0 && bookSelection < bookList.size()) {
                                            System.out.println("Great choice " + name + "!");
                                            System.out.println("╰☆ We've added " + bookList.get(bookSelection).getName() + " to your cart!");
                                            totalCheckout += bookList.get(bookSelection).getPrice();
                                            bookList.remove(bookSelection);
                                            bookCart++;
                                            totalCart++;
                                            _picking = false;
                                            Continue();
                                        } else {
                                            System.out.println("Invalid option provided!");
                                        }
                                    }


                                } else if (_browseInput.equals("2")) { // DVD SELECTION


                                    if (dvdList.size() == 0) {
                                        System.out.println("╰☆ Sorry we have no DVD's in stock right now!");
                                        _picking = false;
                                        Continue();
                                    } else {
                                        System.out.println("╰☆ We currently have these DVD(s) in stock!\n");
                                        int h = 0;
                                        for (; h < dvdList.size(); h++) {
                                            System.out.println("[" + h + "] " + dvdList.get(h).getName() + " | $" + dvdList.get(h).getPrice());

                                        }
                                        System.out.println("\n-> Please select a DVD to purchase!");
                                        int dvdSelection = 0;
                                        dvdSelection = sc.nextInt();
                                        if (dvdSelection >= 0 && dvdSelection < dvdList.size()) {
                                            System.out.println("Great choice " + name + "!");
                                            System.out.println("╰☆ We've added " + dvdList.get(dvdSelection).getName() + " to your cart!");
                                            totalCheckout += dvdList.get(dvdSelection).getPrice();
                                            dvdList.remove(dvdSelection);
                                            dvdCart++;
                                            totalCart++;
                                            _picking = false;
                                            Continue();
                                        } else {
                                            System.out.println("Invalid option provided!");
                                        }


                                    }
                                } else if (_browseInput.equals("3")) { // CD Selection

                                    if (cdList.size() == 0) {
                                        System.out.println("╰☆ Sorry we have no CD's in stock right now!");
                                        _picking = false;
                                        Continue();

                                    } else {
                                        System.out.println("╰☆ We currently have these CD(s) in stock!\n");
                                        int o = 0;
                                        for (; o < cdList.size(); o++) {
                                            System.out.println("[" + o + "] " + cdList.get(o).getArtist() + " - " + cdList.get(o).getName() + " | $" + cdList.get(o).getPrice());

                                        }
                                        System.out.println("\n-> Please select a CD to purchase!");
                                        int cdSelection = 0;
                                        cdSelection = sc.nextInt();

                                        if (cdSelection >= 0 && cdSelection < cdList.size()) {
                                            System.out.println("Great choice " + name + "!");
                                            System.out.println("╰☆ We've added " + cdList.get(cdSelection).getName() + " to your cart!");
                                            totalCheckout += cdList.get(cdSelection).getPrice();
                                            cdList.remove(cdSelection);
                                            cdCart++;
                                            totalCart++;
                                            _picking = false;
                                            Continue();

                                        } else {
                                            System.out.println("Invalid option provided!");
                                        }

                                    }


                                } else if (_browseInput.equals("4")) { // Checkout

                                    if (totalCart == 0) {
                                        System.out.println("You don't have any items in your cart!");
                                        needsCheckout = false;
                                    } else {
                                        System.out.println("You have " + totalCart + " items in your cart! " +
                                                "\nBooks: " + bookCart +
                                                "\nDVD's: " + dvdCart +
                                                "\nCD's: " + cdCart +
                                                "\nTotal: $" + totalCheckout +
                                                "\n-> Your card will be charged $ " + totalCheckout);

                                        memberList.get(currentMember).spend(totalCheckout);
                                        needsCheckout = false;
                                        _picking = false;
                                        Continue();
                                    }
                                } else {
                                    System.out.println("Please pick a number [1] -> [4]");
                                }
                            }
                    }
                            break;
                        case 2: // Money spent
                            System.out.println("╰☆ " + name + ", you've currently spent $" + memberList.get(currentMember).moneySpent());
                            Continue();
                            break;
                        case 3: // Upgrade membership
                            if (memberList.get(currentMember).hasPremium()) {
                                System.out.println("Silly " + name + "! You already have premium!");
                                Continue();
                            } else {
                                memberList.get(currentMember).paymentWizard();
                                Continue();
                            }
                            break;
                        case 4:
                            System.out.println(memberList.get(currentMember).premiumStatus());
                            Continue();
                            break;
                        case 5:
                            memberList.get(currentMember).revokePremium();
                            Continue();
                            break;
                        case 6:
                            memberList.get(currentMember).viewMember();
                            Continue();
                            break;
                        case 7:
                            System.out.println("Exiting store...");
                            z = 1;
                            break;
                        case 8:
                            System.out.println("Printing all members");
                            for (Member member : memberList) {
                                System.out.println(member);
                            }
                            Continue();
                            System.out.println("Printing all books");
                            for (Book book : bookList) {
                                System.out.println(book);
                            }
                            Continue();
                            System.out.println("Printing all DVD's");
                            for (DVD dvd : dvdList) {
                                System.out.println(dvd);
                            }
                            Continue();
                            System.out.println("Printing all CD's");
                            for (CD cd : cdList) {
                                System.out.println(cd);
                            }
                            break;
                        default:
                            System.out.println("Please enter a value [1] -> [7]");

                            z = 0;
                    }
            }
        }
    }
}