import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order extends Item {
    String time;
    double totalPrice;

    Order(){}

    Order(String name, Double price, String description, double totalPrice) {
        super(name, price, description);
        this.time = getTime();
        this.totalPrice = totalPrice;
    }
    Order(Item item, double totalPrice){
        super(item.name, item.price, item.description);
        this.totalPrice = totalPrice;
        this.time = getTime();
    }

    public String getTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return now.format(dateTimeFormatter);
    }

    @Override
    public String toString() {
        return "3. 주문 총 가격 : " + this.totalPrice + "W\n5. 주문 시간 : " + this.time;
    }
}
