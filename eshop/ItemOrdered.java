public class ItemOrdered
{
    private Item item;
    private int quantity;

    public ItemOrdered(Item item,int q){
        this.item=item;
        quantity=q;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public Item getItem(){
        return item;
    }
}
