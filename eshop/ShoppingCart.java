import java.util.*;
public class ShoppingCart{
    static ArrayList<ItemOrdered> orderList=new ArrayList<ItemOrdered>();
    static Scanner scan=new Scanner(System.in);

    //constructor χωρίς ορίσματα
    public ShoppingCart(){    
    }

    //επιστρέφει την λίστα με τα αντικείμενα που έχουν προστεθεί στο καλάθι
    public static ArrayList<ItemOrdered> getOrderList(){
        return orderList;
    }

    //προσθέτει ένα αντικείμενο στο καλάθι
    public static void addItemOrdered(ItemOrdered i,int quan){

        if(i.getItem().getStock()>=quan){
            int stock=i.getItem().getStock();
            i.getItem().setStock(stock-quan);
            int k=orderList.indexOf(i);
            if(k!=-1){
                int quant=orderList.get(k).getQuantity();
                orderList.get(k).setQuantity(quant+quan);
            }
            else{
                i.setQuantity(quan);
                orderList.add(i);
            }
        }
        else if(quan>i.getItem().getStock()){
            System.out.println("There are only "+i.getItem().getStock()+" items in stock. \nPlease enter again the pieces that you want:");
            int q=scan.nextInt();
            int k=orderList.indexOf(i);
            if(k!=-1){
                int quant=orderList.get(k).getQuantity();
                orderList.get(k).setQuantity(quant+q);
            }
            else{
                i.setQuantity(q);
                orderList.add(i);
            }
        }else{
            System.out.println("The product is out of stock. Returning back to the main menu...");
            Menu.buyerStartMenu();
        }
    }

    
    //αφαιρεί ένα αντικείμενο από το καλάθι
    public static void removeItemOrdered(ItemOrdered i){
        for(ItemOrdered io : orderList){
            if(io.getItem().equals(i.getItem())){
                orderList.remove(io);
                int stock=i.getItem().getStock();
                i.getItem().setStock(stock++);
            }
        }
    }

    //αλλάζει την ποσότητα ενός προιόντος 
    public static void changeItemOrderedQuantity(ItemOrdered io){
        System.out.print("Enter the new quantity:");
        int quant=scan.nextInt();
        scan.nextLine();
        if(io.getItem().getStock()>=quant){            
            io.setQuantity(quant);
            System.out.println("Modification is done!");
            Menu.viewCart();
        }
        else if (quant<io.getQuantity()){
            int dif=io.getQuantity()-quant;
            io.getItem().setStock(dif);
            io.setQuantity(quant);
            System.out.println("Modification is done!");
        }
        else if(io.getItem().getStock()==0){
            System.out.println("The product is out of stock");
            Menu.viewCart();
        }
        else{
            System.out.print("There are in the shop only "+io.getItem().getStock()+" item. Please enter the new quantity:");
            quant=scan.nextInt();
            io.setQuantity(quant);
            System.out.println("Modification is done!");
            Menu.viewCart();
        }
    }

    //εμφανίζει τα προιόντα που βρίσκονται στο καλάθι και το συνολικό ποσό της παραγγελίας
    public static void showCart(){
        double total=0.0;
        for(ItemOrdered io: orderList){
            System.out.print(""+io.getQuantity()+"\t"+io.getItem().getName()+"\t"+io.getItem().getPrice()+"\n");
            
        }
        System.out.println("Total: "+ShoppingCart.calculateNet());
    }

    //καθαρίζει το καλάθι
    public  static void clearCart(){
        for(ItemOrdered io: orderList){
            ShoppingCart.removeItemOrdered(io);
        }
    }

    //πληρωμή της παραγγελίας
    public static void checkOut(){
        ShoppingCart.showCart();
        System.out.print("Do you want to check out?(y/n):");
        String answer=scan.nextLine();
        if(answer.equals("y")){
            Buyer.awardBonus(ShoppingCart.calculateNet());

            

            double total=ShoppingCart.calculateNet()+ShoppingCart.calculateCourierCost();
            System.out.println("The total amount is:"+total);
            System.out.println("Thank you for shopping to our store\nReturning back to the login screen...");
            orderList.clear();
            
            try{
            Menu.logIn();}
            catch(NullLineReadedException e){}
        }
        else if(answer.equals("n")){
            System.out.println("Continue shopping...");
            Menu.buyerStartMenu();
        }

    }

    //υπολογίζει και επιστρέφει το κόστος της παραγγελίας
    public static double calculateNet(){
        double total=0;
        int q;
        for(ItemOrdered io: orderList){
            q=io.getQuantity();
            total+=q*io.getItem().getPrice();
        }
        return total;
    }

    
    //υπολογίζει και επιστρέφει το κόστος ων μεταφορικών ανάλογα την κατηγορία του πελάτη
    public static double calculateCourierCost(){
        double shippingcost=ShoppingCart.calculateNet()*0.02;
        if(Buyer.getCategory().equals("BRONZE")){
            if(shippingcost<3){
                shippingcost=3;
            }
        }
        else if(Buyer.getCategory().equals("SILVER")){
            if(shippingcost<3){
                shippingcost=3;
            }
            shippingcost=shippingcost/2;
        }
        else if(Buyer.getCategory().equals("GOLD")){
            shippingcost=0;
        }
        return shippingcost;
    }
}
