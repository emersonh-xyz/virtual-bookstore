package BookStore;

public class Book {

    private String bookName;
    private String bookAuthor;
    private int bookPages;
    private double bookPrice;

    private static int count = 0;
    private int bookID;


    public Book(String name, String author, double price, int pages) {

        setID(count++);
        bookName = name;
        bookAuthor = author;
        bookPages = pages;
        bookPrice = price;

    }

    public String getName(){
        return bookName;
    }

    public String getAuthor(){
        return bookAuthor;
    }

    public int getPages(){
        return bookPages;
    }

    public double getPrice(){
        return bookPrice;
    }

    public int getID()
    {
        return this.bookID;
    }

    public void setName(String name){
        bookName = name;
    }

    public void setAuthor(String author){
        bookAuthor = author;
    }

    public void setID(int ID) {
        this.bookID = ID;
    }

    public void setPages(int pages){
        bookPages = pages;
    }


    public void setPrice(double price){
        bookPrice = price;
    }

    public void getInfo(){
        System.out.println("***************" +
                "\nName: " + bookName +
                "\nAuthor: " + bookAuthor +
                "\nPrice: " + bookPrice +
                "\nPages: " + bookPages +
                "\nID: " + bookID +
                "\n***************");
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPages=" + bookPages +
                ", bookPrice=" + bookPrice +
                ", bookID=" + bookID +
                '}';
    }
}
