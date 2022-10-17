public class Paper extends Item{
    private int weight,pages;
    int productCategory=4;
    
    //constructor της κλάσης με το super που αρχικοποιεί τις μεταβλητές της Item
     public Paper(String name,double price,String description,int stock,int id,int productCategory,int pages,int weight){
        super(name,price,description,stock,id,productCategory);
        this.pages=pages;
        this.weight=weight;
    }

    //επιστρέφει τις πληροφορές του συγκεκριμένου προιόντος
    public String getDetails(){
        return  "the weight of the paper is"+ weight + "and the pages are"+pages;
    }

    //επιστρέφει την κατηγορία του προιόντος αν είναι pen pencil notebook paper
    public int getProductCategory(){
        return productCategory;
    }
}