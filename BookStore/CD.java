package BookStore;

public class CD {

    private String cdName;
    private String cdArtist;
    private double cdPrice;

    private static int count = 0;
    private int cdID;


    public CD(String name, String artist, double price) {

        setID(count++);
        cdArtist = artist;
        cdName = name;
        cdPrice = price;

    }

    public String getName(){
        return cdName;
    }


    public String getArtist(){
        return cdArtist;
    }


    public double getPrice(){
        return cdPrice;
    }

    public int getID()
    {
        return this.cdID;
    }

    public void setName(String name){
        cdName = name;
    }

    public void setID(int ID) {
        this.cdID = ID;
    }


    public void setPrice(double price){
        cdPrice = price;
    }

    public void getInfo(){
        System.out.println("***************" +
                "\nName: " + cdName +
                "\nPrice: " + cdPrice +
                "\nID: " + cdID +
                "\n***************");
    }

    @Override
    public String toString() {
        return "CD{" +
                "cdName='" + cdName + '\'' +
                ", cdPrice=" + cdPrice +
                ", cdID=" + cdID +
                '}';
    }
}
