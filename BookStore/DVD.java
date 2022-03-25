package BookStore;

public class DVD {

    private String dvdName;
    private double dvdPrice;

    private static int count = 0;
    private int dvdID;


    public DVD(String name, double price) {

        setID(count++);
        dvdName = name;
        dvdPrice = price;

    }

    public String getName(){
        return dvdName;
    }


    public double getPrice(){
        return dvdPrice;
    }

    public int getID()
    {
        return this.dvdID;
    }

    public void setName(String name){
        dvdName = name;
    }

    public void setID(int ID) {
        this.dvdID = ID;
    }


    public void setPrice(double price){
        dvdPrice = price;
    }

    public void getInfo(){
        System.out.println("***************" +
                "\nName: " + dvdName +
                "\nPrice: " + dvdPrice +
                "\nID: " + dvdID +
                "\n***************");
    }

    @Override
    public String toString() {
        return "DVD{" +
                "dvdName='" + dvdName + '\'' +
                ", dvdPrice=" + dvdPrice +
                ", dvdID=" + dvdID +
                '}';
    }
}
