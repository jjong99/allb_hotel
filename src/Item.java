public class Item extends Menu {

    Double price;
    int menuId;
    int itemID;

    Item(){}
    Item(String name, Double price, String description) {
        super(name, description);
        this.price = price;
        this.itemID = -1;

    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) { // Added setItemID method
        this.itemID = itemID;
    }

    @Override
    public String toString() {
        return "  " + this.name + "   W" + this.price + "\n";
    }
}