import java.util.*;

public class Eshop{
    private static String name;
    private String email;
    private Owner owner;
    static ArrayList<Item> itemList=new ArrayList<Item>();
    static ArrayList<Buyer> buyerList=new ArrayList<Buyer>();
    static ArrayList<Owner> ownerList=new ArrayList<Owner>();
    static Scanner scan=new Scanner(System.in);

    //constructor που αρχικοποιεί το όνομα του eshop
    public Eshop(){
        this.name="BookStore";

    }

    //επιστρέφει την λίστα με τα διαθέσιμα αντκείμενα του καταστήματος
    public static ArrayList<Item> getItemList(){
        return itemList;
    }

    //επιστρέφει την λίστα με τους αγοραστές που είναι εγγεγραμμένοι
    public static ArrayList<Buyer> getBuyerList(){
        return buyerList;
    }
    
    //επιστρέφει την λίστα με τους ιδιοκτήτες που είναι εγγεγραμμένοι
    public static ArrayList<Owner> getOwnerList(){
        return ownerList;
    }
    
     //προσθέτει έναν ιδιοκτήτη στο κατάστημα αφού ελέγξει ότι δεν υπάρχει ήδη
    public static void addOwner(Owner o){
        if(ownerList.contains(o)){
            System.out.println("");
        }
        else{
            ownerList.add(o);
        }

    }

    //επιστρέφει το όνομα του μαγαζιού
    public static String getName(){
        return name;
    }

    //προσθέτει ένα αντικείμενο στο κατάστημα αφού πρώτα ελένξει αν υπάρχει ήδη
    public void addItem(Item it){
        int i=0;
        boolean found=false;
        if(itemList.contains(it)){
            System.out.println("");
        }
        else{
            itemList.add(it);
        }
    }

    //ανακτά ένα Item από την itemsList με βάση τον κωδικό του�
    public Item getItemByld(int id){
        int i=0;
        while(itemList.get(i).getId()!=id){
            i++;
        }
        return itemList.get(i);
    }

    //διαγράφει ένα αντικείμενο από το κατάστημα
    public void removeItem(Item i){
        itemList.remove(i);
    }

    //προσθέτει έναν αγοραστή στο κατάστημα αφού ελένξει ότι δεν υπάρχει ήδη
    public static void addBuyer(Buyer b){
        if(buyerList.contains(b)){
            System.out.println("");
        }
        else{
            buyerList.add(b);
        }

    }

    //διαγράφει έναν αγοραστή από το κατάστημα και αδειάζει το καλάθι του
    public static void removeBuyer(Buyer b){
        if(buyerList.contains(b)){
            b.getCart().clearCart();
            buyerList.remove(b);
        }
    }

    //αλλάζει την διαθέσιμη ποσότητα ενός προιόντος
    public static void updateItemStock(Item i){
        System.out.println("Enter the new stock of the product:");
        int quant=scan.nextInt();
        i.setStock(quant);

        System.out.println("Returning to the main menu");
        Menu.ownerStartMenu();
    }

    //εμφανίζει τις κατηγορίες των προιόντων που είναι διαθέσιμες
    public static void showCategories(){
        System.out.println("1.Pen\n2.Pencil\n3.Notebook\n4.Paper");
    }

    //παίρνει ως όρισμα το όνομα μιας κατηγορίας και επιστρέφει τα αντικείμενα της κατηγορίας αυτής
    public static void showProductsInCategory(String category){
        int counter=1;
        switch(category){
            case "pen":
            for(Item i: itemList){
                if(i.getProductCategory()==1){
                    System.out.println(""+counter+i.getName());
                    counter++;
                }
            }
            break;
            case "pencil":
            for(Item i: itemList){
                if(i.getProductCategory()==2){
                    System.out.println(""+counter+i.getName());
                    counter++;
                }
            }
            break;
            case "notebook":
            for(Item i: itemList){
                if(i.getProductCategory()==3){
                    System.out.println(""+counter+i.getName());
                    counter++;
                }
            }
            break;
            case "paper":
            for(Item i: itemList){
                if(i.getProductCategory()==4){
                    System.out.println(""+counter+i.getName());
                    counter++;
                }
            }
            break;
        }
    }

    //εμφανίζει τις πληροφορίες ένος προιόντος που δέχεται σαν όρισμα
    public void showProduct(Item i){
        i.getDetails();
    }

    //εμφανίζει τους χρήστες του eshop τους πόντους τους και την κατηγορία τους
    public static void checkStatus(){
        for(Buyer b : buyerList){
            System.out.println(b.getName()+" has "+b.getBonus()+" and is a "+b.getCategory()+" category client.");
        }
    }
}
