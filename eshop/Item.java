import java.util.*;
public abstract class Item{
    private String name;
    private double price;
    private String description;
    private int stock;
    private int id;
    int productCategory;
    Scanner scan=new Scanner(System.in);

    //constructor με ορίσματα που αρχικοποιεί τις μεταβλητές 
    public Item(String name,double price,String description,int stock,int id,int productCategory){
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
        this.id=id;
        this.productCategory=productCategory;
    }

    //επιστρέφει την τιμή της μεταβλητής name
    public String getName(){return name;}

    //επιστρέφει την τιμή της μεταβλητής id
    public int getId(){return id;}

    //παίρνει ως όρισμα έναν ακέραιο και αρχικοποιεί την μεταβλητή stock με τον ακέραιο αυτό
    public void setStock(int stock){
        this.stock=stock;
    }

    //επιστρέφει την τιμή της μεταβλητής stock
    public int getStock(){
        return stock;
    }

    //επιστρέφει τις βασικές πληροφορίες ενός προιόντος
    public String getBasicInfo(){
        return name+" it costs "+price+" is a "+description+"   stock "+stock+" id:"+id;
    }

    //αφηρημένη κλάση που επιστρέφει ένα string και το σώμα της δηλώνεται στις κλάσεις που κληρονομούν την κλάση αυτή
    public abstract String getDetails();

    //αφηρημένη κλάση που επιστρέφει ένα int και το σώμα της δηλώνεται στις κλάσεις που κληρονομούν την κλάση αυτή
    public abstract int getProductCategory();

    //επιστρέφει την τιμή της μεταβλητής price
    public double getPrice(){
        return price;
    }

    //επιστρέφει όλες τις πληροφορίες ενός προιόντος
    public String toString(){
        return getBasicInfo()+getDetails();
    }

}