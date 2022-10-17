public class Buyer extends User{
    private static int bonus;
    private static String buyerCategory; 
    private ShoppingCart shCart=new ShoppingCart();

    //constructor με ορίσματα που αρχικοποιεί τις μεταβλητές 
    public Buyer(String name,String email){
        super(name,email);
        int bonus=0;
        buyerCategory="BRONZE";
    }

    //constructor χωρίς ορίσματα
    public Buyer(){
        super();
        int bonus=0;
        buyerCategory="BRONZE";
    }

    //επιστρέφει το "καρότσι αγορών"
    public ShoppingCart getCart(){
        return shCart;
    }

    //επιστρέφει τους πόντους
    public int getBonus(){
        return bonus;
    }

    //επιστρέφει την κατηγορία του αγοραστή
    public static String getCategory(){
        return buyerCategory;
    }

    //δίνει την τιμή που δέχεται ως όρισμα στη μεταβλητή bonus
    public void setBonus(int b){
        this.bonus=b;
    }

    //υπολογίζει τους πόντους και αλλάζει την κατηγορία του αγοραστή αν είναι απαραίτητο
    public static void awardBonus(double cost){
        double b=cost*0.1;
        bonus+=(int)b;
        Buyer.setBuyerCategory(bonus);
    }

    //θέτει την κατηγορία του αγοραστή ανάλογα με τους πόντους που έχει
    public static void setBuyerCategory(int bonus){
        if(bonus>200){
            buyerCategory="GOLD";
        }
        else if(bonus>100){
            buyerCategory="SILVER";
        }
        else if(bonus<100){
            buyerCategory="BRONZE";
        }
    }

    //τοποθετεί ένα αντικείμενο στο καλάθι
    public static void placeOrder(Item i,int q){
        ItemOrdered io=new ItemOrdered(i,q);
        ShoppingCart.addItemOrdered(io,q);

    }
}