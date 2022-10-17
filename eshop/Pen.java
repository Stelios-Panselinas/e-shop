import java.util.*;
public class Pen extends Item{
    private String color;
    private double tipSize;
    int productCategory=1;
    Scanner scan=new Scanner(System.in);
    
    //constructor της κλάσης με το super που αρχικοποιεί τις μεταβλητές της Item
    public Pen(String name,double price,String description,int stock,int id,int productCategory,String color,double tipSize){
        super(name,price,description,stock,id,productCategory);
        this.color=color;
        this.tipSize=tipSize;
    }

    //επιστρέφει την κατηγορία του προιόντος αν είναι pen pencil notebook paper
    public int getProductCategory(){
        return productCategory;
    }

    //επιστρέφει τις πληροφορές του συγκεκριμένου προιόντος
    public String getDetails(){
        return "  the color of the pen is "+color+" and the tip size is "+tipSize;
    }
}