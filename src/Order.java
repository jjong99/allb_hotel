import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order extends Item {
    String time;

    Order(){}

    Order(String name, Double price, String description) {
        super(name, price, description);
        this.time = getTime();
    }
    Order(Item item){
        super(item.name, item.price, item.description);
        this.time = getTime();
    }

    public String getTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return now.format(dateTimeFormatter);
    }
}
