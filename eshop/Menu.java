import java.util.*;
import java.io.*;
public class Menu {
    static Scanner scan=new Scanner(System.in);
    private static String answer;

    //login και ταυτοποίηση
    public static int logIn() throws NullLineReadedException {
        System.out.println("Welcome to our online shop!");
        System.out.print("Please give your email to continue:");
        boolean found=false;
        answer=scan.nextLine();
        if(answer.equals("")){throw new IllegalArgumentException("exception");}
        for (int counter = 0; counter < Eshop.getOwnerList().size(); counter++) {

            if(Eshop.getOwnerList().get(counter).getEmail().equals(answer)){

                Menu.ownerStartMenu();

            }else{
                try{
                    for(int i=0;i<Eshop.getBuyerList().size();i++){
                        if(Eshop.getBuyerList().get(i).getEmail().equals(answer)){
                            found=true;
                            Menu.buyerStartMenu(Eshop.getBuyerList().get(i));
                        }

                    }
                    if(found==false){
                        System.out.println("To continue to the shop you have to Sign In first");
                        Buyer b_new=new Buyer();
                        System.out.print("Enter your name:");
                        answer=scan.nextLine();
                        while(answer.equals("")){
                            System.out.print("Please enter your name:");
                            answer=scan.nextLine();
                        }
                        b_new.setName(answer);
                        System.out.print("Enter your email:");
                        answer=scan.nextLine();
                        while(answer.equals("")){
                            System.out.print("Please enter your email:");
                            answer=scan.nextLine();
                        }
                        b_new.setEmail(answer);
                        Eshop.addBuyer(b_new);
                        Menu.buyerStartMenu(b_new);
                    }
                }catch(ConcurrentModificationException e){
                    System.out.println(e);  
                    System.out.println("Clearing Cart...");
                    ShoppingCart.clearCart();
                    Menu.buyerStartMenu();
                }
            }
            return 0;
        }
        return 0;
    }

        //το αρχικό μενού του ιδιοκτήτη
        public  static void ownerStartMenu(){
            boolean exit=false;
            System.out.println("Hello "+Owner.getName()+"  Admin:"+Owner.getIsAdmin());
            System.out.println("1.browse store   2.check status   3.back   4exit");
            do{
                System.out.println("To choose one option type the name of the option:");
                answer=scan.nextLine();

                switch(answer){
                    case"browse store":
                    try{
                        Menu.browseStoreOwner();
                    }catch(InvalidInputException ex){
                        System.out.println(ex);
                    }
                    exit=true;
                    break;

                    case "check status":
                    Menu.checkStatus();
                    break;

                    case "exit":
                    exit=true;
                    Menu.exitFromProgram();
                    break;

                    default:
                    System.out.println("Invalid command!");
                    break;
                }
            }while(!exit);

        }

        //το αρχικό μενού του επισκέπτη με χαιρετισμό
        public static void buyerStartMenu(Buyer b){
        boolean exit=false;
        System.out.println("Hello "+b.getName()+" your points are "+b.getBonus()+" and you are in "+b.getCategory()+" category");
        System.out.println("1.browse store   2.view cart   3.check out   4.back   5.logOut   6.exit");
        do{
            System.out.println("To choose one option type the name of the option:");
            answer=scan.nextLine();
            switch(answer){
                case"browse store":
                try{
                    Menu.browseStoreBuyer();
                }
                catch(InvalidInputException exc){System.out.println(exc);
                }
                exit=true;
                break;

                case "view cart":
                Menu.viewCart();
                exit=true;
                break;

                case "check out":
                Menu.checkOut();
                exit=true;
                break;

                case"back":
                exit=true;
                Menu.ownerStartMenu();
                break;

                case "logOut":
                exit=true;
                Menu.logOut();
                break;

                case"exit":
                Menu.exitFromProgram();
                exit=true;
                break;

                default:
                System.out.println("Invalid command!");
                break;
            }
        }while(!exit);
    }

    //αρχικό μενού επισκέπτη χωρίς τον χαιρετισμό
    public static void buyerStartMenu(){
        boolean exit=false;
        System.out.println("1.Browse Store   2.View Cart   3.Check Out   4.back   5.LogOut   6.Exit");
        System.out.println("To choose one option type the name of the option:");
        answer=scan.nextLine();
        do{
            switch(answer){
                case"browse store":
                try{
                    Menu.browseStoreBuyer();
                }
                catch(InvalidInputException exc){System.out.println(exc);
                }
                exit=true;
                break;

                case "view cart":
                Menu.viewCart();
                exit=true;
                break;

                case "check out":
                Menu.checkOut();
                exit=true;
                break;

                case"back":
                exit=true;
                Menu.buyerStartMenu();
                break;

                case "logOut":
                exit=true;
                Menu.logOut();
                break;

                case"exit":
                exit=true;
                Menu.exitFromProgram();
                break;

                default:
                System.out.println("Invalid command!");
                break;
            }
        }while(!exit);
    }
    //browse store του ιδιοκτήτη αλλάζει την ποσότητα ενός προιόντος
    public static void browseStoreOwner() throws InvalidInputException{
        boolean cont=false;
        Eshop.showCategories();
        do{
            System.out.print("Type the name of a category to see the products:");
            answer=scan.nextLine();
            switch(answer){
                case "pen":
                Eshop.showProductsInCategory(answer);
                cont=true;
                break;

                case "pencil":
                Eshop.showProductsInCategory(answer);
                cont=true;
                break;

                case"notebook":
                cont=true;
                Eshop.showProductsInCategory(answer);
                break;

                case"paper":
                cont=true;
                Eshop.showProductsInCategory(answer);
                break;

                default: 
                System.out.println("Invalid command!");
                break;
            }
        }while(!cont);

        System.out.print("Type the name of a product to see more details:");
        answer=scan.nextLine();
        boolean found=false;
        for(Item i:Eshop.getItemList()){
            if(answer.equals(i.getName())){
                found=true;
            }
        }
        if(found==false){
            throw new InvalidInputException("The item doesn't exist!");
        }

        for(Item i: Eshop.getItemList()){
            if(answer.equals(i.getName())){
                Eshop.updateItemStock(i);
            }
        }

    }

    //εμαφνίζει την λίστα με του εγγεγραμμένους χρήστες και δίνει την δυνατότητα στον ιδιοκτήτη να διαγράψει κάποιον
    public static void checkStatus(){

        boolean cont=false;
        Eshop.checkStatus();
        System.out.print("To see the shopping cart of a client type his name:");
        answer=scan.nextLine();
        for(Buyer b:Eshop.getBuyerList()){
            if(b.getName().equals(answer)){
                b.getCart().showCart();
                do{
                    System.out.print("Do you want to remove this client?(y/n)");
                    answer=scan.nextLine();
                    switch(answer){
                        case "y":
                        cont=true;
                        Eshop.removeBuyer(b);
                        System.out.println("Going back to the main menu...");
                        Menu.ownerStartMenu();
                        break;

                        case "n":
                        cont=true;
                        System.out.println("Returning to the main menu...");
                        Menu.ownerStartMenu();
                        break;

                        default:
                        System.out.println("Invalid command!");
                        break;
                    }
                }while(!cont);

            }
        }
    }
    //επιστροφή στο κυρίως μενού του ιδιοκτήτη
    public void goBackOwner(){
        System.out.println("Going back to the main menu...");
        Menu.ownerStartMenu();
    }

    //επιστροφή στο κυρίως μενού του αγοραστή
    public void goBackBuyer(){
        System.out.println("Going back to the main menu...");
        Menu.buyerStartMenu();
    }

    //αποσυνδέεται οχρήστης ή ο ιδιοκτήτης και επιστρέφει στο σημείο εισόδου του eshop
    public static void logOut(){
        System.out.println("You have loged out returning to the login screen...");
        try{Menu.logIn();}
        catch(NullLineReadedException e){System.out.println("exception");}
    }

    //τερματίζεται το πρόγραμμα
    public static void exitFromProgram(){
        System.exit(0);
    } 

    //browse store του αγοραστή του εμαφνίζει όλες τις κατηγορίες προιόντων και έχει την δυνατότη να προσθέσει ένα αντικείμενο στο καλάθι του
    public static void browseStoreBuyer() throws InvalidInputException{
        boolean cont=false;
        System.out.println("This is the Eshop "+Eshop.getName());
        Eshop.showCategories();

        do{
            System.out.print("Type the name of a category to see the products:");
            answer=scan.nextLine();
            switch(answer){
                case "pen":
                Eshop.showProductsInCategory(answer);
                cont=true;
                break;

                case "pencil":
                Eshop.showProductsInCategory(answer);
                cont=true;
                break;

                case"notebook":
                cont=true;
                Eshop.showProductsInCategory(answer);
                break;

                case"paper":
                cont=true;
                Eshop.showProductsInCategory(answer);
                break;

                default: 
                System.out.println("Invalid command!");
                break;
            }
        }while(!cont);

        System.out.print("Type the name of a product to see more details:");
        answer=scan.nextLine();
        boolean found=false;
        for(Item i:Eshop.getItemList()){
            if(answer.equals(i.getName())){
                found=true;
            }
        }

        if(found==false){throw new InvalidInputException("The item doesn't exist!");
        }

        for(int i=0;i<Eshop.getItemList().size();i++){
            if(Eshop.getItemList().get(i).getName().equals(answer)){
                System.out.println(Eshop.getItemList().get(i).getDetails());
                boolean contin=false;
                do{
                    System.out.print("Do you want to buy this product?(y/n)");
                    answer=scan.nextLine();
                    switch(answer){
                        case "y":
                        System.out.print("How many pieces do you want to add to your Cart?");
                        int pieces=scan.nextInt();
                        scan.nextLine();
                        Buyer.placeOrder(Eshop.getItemList().get(i),pieces);
                        Menu.viewCart();
                        contin=true;
                        break;

                        case "n":
                        System.out.println("Going back to the main menu...");
                        Menu.buyerStartMenu();
                        contin=true;
                        break;

                        default:System.out.println("Invalid command!");

                    }
                }while(!contin);

            }

        }
    }

    //εμφανίζει το καλάθι και τις επιλογές που έχει ο χρήστης
    public static void viewCart(){
        boolean con=false;
        if(ShoppingCart.getOrderList().isEmpty()){
            System.out.println("Your cart is empty. Going back to the main menu...\n");
            Menu.buyerStartMenu();
        }
        else{
            ShoppingCart.showCart();
            System.out.println("OPTIONS:\n1.select an item  2.clear cart  3.check out  4.continue shopping");
            do{
                System.out.print("To choose one option type the option's name :");
                answer=scan.nextLine();
                switch(answer){
                    case "select an item":
                    System.out.print("Delete or modify?\nType the option name:");
                    answer=scan.nextLine();
                    if(answer.equals("delete")){
                        System.out.print("Which item do you want to delete? Type the item's name:");
                        answer=scan.nextLine();
                        for(ItemOrdered io:ShoppingCart.getOrderList()){
                            if(io.getItem().getName().equals(answer)){
                                ShoppingCart.removeItemOrdered(io);
                            }
                        }
                        System.out.println("The item deleted." );
                        Menu.viewCart();
                    }
                    else if(answer.equals("modify")){
                        System.out.print("Which item do you want to modify? Type the item's name:");
                        answer=scan.nextLine();
                        for(ItemOrdered io:ShoppingCart.getOrderList()){
                            if(io.getItem().getName().equals(answer)){
                                ShoppingCart.changeItemOrderedQuantity(io);
                            }
                        }
                        Menu.viewCart();
                    }
                    System.out.print("Going back...");
                    Menu.buyerStartMenu();
                    con=true;
                    break;

                    case "clear cart":
                    System.out.println("Deleting all items..");
                    ShoppingCart.clearCart();
                    System.out.println("Your cart is empty!");
                    Menu.buyerStartMenu();
                    con=true;
                    break;

                    case "check out":
                    System.out.println("Checking out...");
                    ShoppingCart.checkOut();
                    con=true;
                    break;

                    case"continue shopping":
                    con=true;
                    System.out.println("Going back to the main menu...");
                    Menu.buyerStartMenu();
                    con=true;
                    break;

                    default:
                    System.out.println("Invalid command!");
                    break;
                }
            }while(!con);
        }
    }

    //ολοκληρώνει τις αγορές του και επιστρέφει στην είσοδο του eshop
    public static void checkOut(){
        ShoppingCart.checkOut();
    }
}