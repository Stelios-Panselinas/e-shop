public class Pencil extends Item{
    private double tipSize;
    private String type;
    int productCategory=2;
    
    //constructor της κλάσης με το super που αρχικοποιεί τις μεταβλητές της Item
     public Pencil(String name,double price,String description,int stock,int id,int productCategory,double tipSize,String type){
        super(name,price,description,stock,id,productCategory);
        this.tipSize=tipSize;
        this.type=type;
    }

     //επιστρέφει τις πληροφορές του συγκεκριμένου προιόντος
    public String getDetails(){
        return "the tipSize of the pencil is"+tipSize + "and the type is"+type;
    }

    //επιστρέφει την κατηγορία του προιόντος αν είναι pen pencil notebook paper
    public int getProductCategory(){
        return productCategory;
    }
}