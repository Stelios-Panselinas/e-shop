
import java.util.*;
public class Run  {    
    public static void main(String[] args){  

        //δημιούργεια ενός στιγμιότυπου Eshop
        Eshop e=new Eshop();
        //δημιούργεια ενός στιγμιότυπου Menu
        Menu menu=new Menu();

        Scanner scan=new Scanner(System.in);

        //δημιούργεια ενός στιγμιότυπου Buyer
        Buyer b1 = new Buyer("Buyer1","buyer1@eshop.gr");

        //δημιούργεια ενός στιγμιότυπου Buyer
        Buyer b2 = new Buyer("Buyer2","buyer2@eshop.gr");

        //δημιούργεια ενός στιγμιότυπου Buyer
        Buyer b3 = new Buyer("Buyer3","buyer3@eshop.gr");
        //δημιούργεια ενός στιγμιότυπου Owner
        Owner o1=new Owner("owner","owner@eshop.gr");

        //προσθήκη των χρηστών στην λίστα με τους χρήστες του καταστήματος
        e.addBuyer(b1);
        e.addBuyer(b2);
        e.addBuyer(b3);
        e.addOwner(o1);

        //δημιουργεία τριών στιγμιοτύπων τησ κλάσης Pen και προσθήκη στην λίστα με τα προιόντα του καταστήματοσ
        Pen p1=new Pen("pelican",1.20,"A pen designed for writters",5,127,1,"blue",0.7);
        Pen p2=new Pen("bic",1.30,"A common pen",9,128,1,"red",0.5);
        Pen p3=new Pen("bic marker",1.10,"Marker pen",5,129,1,"black",0.9);
        e.addItem(p1);
        e.addItem(p2);
        e.addItem(p3);

        //δημιουργεία τριών στιγμιοτύπων τησ κλάσης Pencil και προσθήκη στην λίστα με τα προιόντα του καταστήματοσ
        Pencil pncl1=new Pencil("faber castel_1",0.90,"Pencil for writting",9,137,2,0.7,"HB");
        Pencil pncl2=new Pencil("faber castel_2",0.70,"Pencil for drawing",4,138,2,0.5,"B");
        Pencil pncl3=new Pencil("faber castel_3",0.80,"Hard pencil",4,139,2,0.5,"H");
        e.addItem(pncl1);
        e.addItem(pncl2);
        e.addItem(pncl3);

        //δημιουργεία τριών στιγμιοτύπων τησ κλάσης notebook και προσθήκη στην λίστα με τα προιόντα του καταστήματοσ
        Notebook ntbk1=new Notebook("skag_1",1.50,"A common notebook",12,147,3,1);
        Notebook ntbk2=new Notebook("skag_2",1.90,"A4 notebook",8,148,3,3);
        Notebook ntbk3=new Notebook("skag_3",1.70,"A5 notebook",5,149,3,2);
        e.addItem(ntbk1);
        e.addItem(ntbk2);
        e.addItem(ntbk3);

        //δημιουργεία τριών στιγμιοτύπων τησ κλάσης Paper και προσθήκη στην λίστα με τα προιόντα του καταστήματοσ
        Paper ppr1=new Paper("hartiA4_1",7.80,"High qulity paper",8,157,4,1000,500);
        Paper ppr2=new Paper("hartiA4_2",5.60,"Mid qulity paper",3,158,4,900,475);
        Paper ppr3=new Paper("hartiA4_3",5.20,"Low qulity paper",5,159,4,980,450);
        e.addItem(ppr1);
        e.addItem(ppr2);
        e.addItem(ppr3);

        //δημιουργία παραγγελίας για τον αγοραστή b1
        b1.placeOrder(ppr1,2);
        b1.placeOrder(ntbk2,3);
        b1.placeOrder(pncl3,2);

        //καλούμε την μέθοδο logIn() επι του menu για να λειτουργήσει το eshop
        try{
            menu.logIn();
        }catch(NullLineReadedException ex){
            System.out.println("You have to enter your email...");
            try{menu.logIn();
            }
            catch(NullLineReadedException exc){

            }

        }    

    }
}

