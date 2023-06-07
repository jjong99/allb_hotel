import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    int orderNum;
    String orderList;
    String time;
    double totalPrice;
    String request;

    Order(){}
    Order(int orderNum, String orderList, double totalPrice, String time, String request){
        this.orderNum = orderNum;
        this.orderList = orderList;
        this.totalPrice = totalPrice;
        this.time = time;
        this.request = request;
    }

    Order(int orderNum, String orderList, double totalPrice, String request){
        this.orderNum = orderNum;
        this.orderList = orderList;
        this.totalPrice = totalPrice;
        this.request = request;
        this.time = getTime();
    }

    public String getTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return now.format(dateTimeFormatter);
    }

    @Override
    public String toString() {
        return "\n1. 대기번호 : " + this.orderNum + "\n2. 주문 상품 목록 : " + this.orderList +"\n3. 주문 총 가격 : " + this.totalPrice +"W\n4. 요청사항 : " + this.request + "\n5. 주문 일시 : " + this.time + "\n";
    }

}
