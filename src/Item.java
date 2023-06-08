public class Item extends Menu {

    double price;
    int itemID;

    Item(){}
    Item(String name, double price, String description) {
        super(name, description);
        this.price = price;
        this.itemID = -1;

    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) { 
        this.itemID = itemID;
    }

    @Override
    public String toString() {
        return "  " + this.name + "   W" + this.price + "\n";
    }
}
