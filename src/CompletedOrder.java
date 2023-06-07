public class CompletedOrder extends Order {
    String completiontime;

    CompletedOrder(){
    }

    CompletedOrder(Order order){
        super(order.orderNum, order.orderList, order.totalPrice, order.time, order.request);
        this.completiontime = getTime();
    }

    @Override
    public String toString() {
        return "\n1. 대기번호 : " + this.orderNum + "\n2. 주문 상품 목록 : " + this.orderList +"\n3. 주문 총 가격 : " + this.totalPrice + "W\n4. 요청사항 : " + this.request + "\n5. 주문 일시 : " + this.time + "\n6. 완료 주문 일시 : " +this.completiontime+ "\n";
    }

}
