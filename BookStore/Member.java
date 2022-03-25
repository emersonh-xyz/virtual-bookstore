package BookStore;
import java.util.Scanner;

public class Member {



    Scanner sc = new Scanner(System.in); // Scanner for Constructor
    private String memberName; // Member name
    private int memberID; // Unique Identifier for each member
    private static int count = 0; // Used to increment memberID
    private double moneySpent = 0; // Amount of money spent

    // PREMIUM MEMBERSHIP
    private boolean hasPremium; // Check if member is premium
    private String paymentMethod; // Payment method (Debit/Credit)
    private String cardNumber; // Card number
    private boolean paymentDue; // Check if a payment is due



    public Member(String memberName, boolean hasPremium, boolean Wizard){
        setID(count++); // Increment ID each construct
        this.memberName = memberName;
        this.hasPremium = hasPremium;
        this.memberID++;
    }


    // Member consturctor
    public Member(String memberName, boolean hasPremium) {
        setID(count++); // Increment ID each construct
        this.memberName = memberName;
        this.hasPremium = hasPremium;
        this.memberID++;

        if(this.hasPremium){ // Check if they are premium
            System.out.println("--> " + this.memberName + ", as a premium member please enter a payment method (Debit/Credit)");
            int i = 0;
            while (i == 0){ // Loop
                this.paymentMethod = sc.nextLine().toUpperCase(); // Take
                if(this.paymentMethod.equals("DEBIT") || this.paymentMethod.equals("CREDIT")) {
                    i = 1; // Break loop
                } else
                    System.out.println("Invalid tender provided, please try again");
            }
            System.out.println("--> Please enter your " + this.paymentMethod + " card number: ");
            this.cardNumber = sc.nextLine(); // Take card input
            System.out.println("**Card accepted**");
            System.out.println("-> " + this.memberName + ", your card has been charged $15 for the membership");
            this.moneySpent += 15;
            this.paymentDue = false;
            System.out.println("Great coice! We've set you up with a premium membership card!\n" +
                    "\n╰☆ Don't lose it!");
            System.out.println("\nType [E] continue");
            sc.next();
            System.out.println("*************************");
            System.out.println(
                    "Name: " + this.memberName +
                            "\nID: " + this.memberID +
                            "\nMembership: Premium" +
                            "\nSpent: $" + this.moneySpent +
                            "\nPayment Method: " + this.paymentMethod +
                            "\nCard Number: " + this.cardNumber + "" +
                            "\nPayment due: " + paymentDue);

            System.out.println("*************************");

        } else {
            System.out.println("*************************");
            System.out.println(
                    "Name: " + this.memberName +
                            "\nID: " + this.memberID +
                            "\nMembership: Regular" +
                            "\nSpent: $" + this.moneySpent);
            System.out.println("*************************");
        }
    } // end of constructor

    // Upgrade an account
    public void upgrade() {
        System.out.println("Hi " + this.memberName + ", your account has been upgraded!");
        System.out.println("Please make sure to make your $15 deposit to avoid termination...");
        this.hasPremium = true;
        this.paymentDue = true;
    }

    public void paymentWizard() {
            System.out.println("Welcome " + this.memberName + ", to the payment plan wizard");
            System.out.println("-> How will you be paying today? (DEBIT/CREDIT)");
            int i = 0;
            while (i == 0) { // Loop
                this.paymentMethod = sc.nextLine().toUpperCase();
                if (this.paymentMethod.equals("DEBIT") || this.paymentMethod.equals("CREDIT")) {
                    i = 1; // Break loop
                } else
                    System.out.println("Invalid tender provided, please try again");
            }
            System.out.println("--> Please enter your " + this.paymentMethod + " card number: ");
            this.cardNumber = sc.nextLine(); // Take card input
            System.out.println("**Card accepted**");
            System.out.println("╰☆ " + this.memberName + ", your card has been charged $15 for the membership!");
            this.moneySpent += 15;
            this.paymentDue = false;
            this.hasPremium = true;


    }

    public void revokePremium(){
        if(this.hasPremium){
            System.out.println(this.memberName + ", your premium has been removed!");
            this.hasPremium = false;
        } else {
            System.out.println(this.memberName + ", you don't have a premium membership to delete!");
        }
    }

    public void setID(int memberID) {
        this.memberID = memberID;
    }

    public void spend(double amount) {
        this.moneySpent = this.moneySpent + amount;
    }

    // return memberID
    public int getID() {
        return this.memberID;
    }


    public double moneySpent() {
        return this.moneySpent;
    }
    // return memberName
    public String getName() {
        return this.memberName;
    }

    // return cardNumber
    public String getCard() {
        return this.cardNumber;
    }

    // return paymentMethod
    public String getTender(){
        return this.paymentMethod;
    }

    // return hasPremium
    public boolean hasPremium(){
        return this.hasPremium;
    }

    // return String of membership
    public String memberStatus(){
        if (this.hasPremium){
            return "Premium";
        }
        return "Regular";

    }

    public void viewMember(){

        System.out.println("*************************");
        System.out.println(
                "Name: " + this.memberName +
                        "\nID: " + this.memberID +
                        "\nMembership: " + memberStatus() +
                        "\nSpent: $" + this.moneySpent +
                        "\nPayment Method: " + this.paymentMethod +
                        "\nCard Number: " + this.cardNumber + "" +
                        "\nPayment due: " + paymentDue);

        System.out.println("*************************");


    }

    // Check if payment is due
    public String premiumStatus() {
        if (paymentDue) {
            return "╰☆ Hi " + this.memberName + ", you have a payment due for this month!";
        }

        return " ╰☆" + this.memberName + ", you currently don't have a payment due at this time!";

    }




     // Override our toString to print out our arrayList properly


    @Override
    public String toString() {
        return "Member{" +
                ", memberName='" + memberName + '\'' +
                ", memberID=" + memberID +
                ", moneySpent=" + moneySpent +
                ", hasPremium=" + hasPremium +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", paymentDue=" + paymentDue +
                '}';
    }
}
