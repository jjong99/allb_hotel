public class CompletedOrder extends Order implements Comparable<CompletedOrder> {
    String completiontime;

    CompletedOrder(){
    }

    CompletedOrder(Order oder){
        super(oder.orderNum, oder.orderList, oder.totalPrice, oder.time);
        this.completiontime = getTime();
    }

    @Override
    public String toString() {
        return "\n1. 대기번호 : " + this.orderNum + "\n2. 주문 상품 목록 : " + this.orderList +"\n3. 주문 총 가격 : " + this.totalPrice + "W\n5. 주문 일시 : " + this.time + "\n6. 완료 주문 일시 : " +this.completiontime+ "\n";
    }
    @Override
    public int compareTo(CompletedOrder order) {
        return this.time.compareTo(order.time);
    }


}
