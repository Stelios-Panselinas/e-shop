public class Notebook extends Item{
    private int sections;
    int productCategory=3;
    
    //constructor της κλάσης με το super που αρχικοποιεί τις μεταβλητές της Item
    public Notebook(String name,double price,String description,int stock,int id,int productCategory,int sections){
        super(name,price,description,stock,id,productCategory);
        this.sections=sections;
    }
    
    //επιστρέφει τις πληροφορές του συγκεκριμένου προιόντος
    public String getDetails(){
        return "the sections of the notebook are"+sections;
    }

     //επιστρέφει την κατηγορία του προιόντος αν είναι pen pencil notebook paper
    public int getProductCategory(){
        return productCategory;
    }
}