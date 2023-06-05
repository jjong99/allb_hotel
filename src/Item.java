public class Item extends Menu {

    Double price;

    Item(){}
    Item(String name, Double price, String description) {
        super(name, description);
        this.price = price;
    }

    @Override
    public String toString() {
        return "  " + this.name + "   W" + this.price + "\n";
    }
}