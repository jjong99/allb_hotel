import java.util.*;

class MenuContext {
    private Map<String, List<Menu>> menus;
    private Map<String, List<Item>> menuItems;
    private List<Item> cart;
    private List<Order> orders; // 대기 주문 목록
    private List<CompletedOrder> completedOrders; // 완료 주문 목록
    private double totalPrice;
    private int orderNumber;
    private int menuCounter;
    private int itemCounter;

    public MenuContext() {
        menus = new HashMap<>();
        menuItems = new HashMap<>();
        cart = new ArrayList<>();
        orders = new ArrayList<>();
        completedOrders = new ArrayList<>();
        totalPrice = 0.0;
        orderNumber = 0;
        menuCounter = 0;
        itemCounter = 0;

        initializeMenuItems();
    }

    private void initializeMenuItems() {
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거"));
        mainMenus.add(new Menu("Forzen Custard", "매장에서 신선하게 만드는 아이스크림"));
        mainMenus.add(new Menu("Drinks", "매장에서 직접 만드는 음료"));
        mainMenus.add(new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"));

        List<Menu> orderMenus = new ArrayList<>();
        orderMenus.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
        orderMenus.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));
        orderMenus.add(new Menu("Recent Order", "최신 주문 내역 세개를 확인합니다."));

        menus.put("Main", mainMenus);
        menus.put("Order", orderMenus);

        List<Item> burgersMenus = new ArrayList<>();
        burgersMenus.add(new Item("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgersMenus.add(new Item("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgersMenus.add(new Item("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
        burgersMenus.add(new Item("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgersMenus.add(new Item("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        List<Item> frozenCustardMenu = new ArrayList<>();
        frozenCustardMenu.add(new Item("Frozen Custard Menu Item 1", 1.4, "Frozen Custard Menu Item 1 설명"));
        frozenCustardMenu.add(new Item("Frozen Custard Menu Item 2", 1.0, "Frozen Custard Menu Item 2 설명"));
        frozenCustardMenu.add(new Item("Frozen Custard Menu Item 3", 1.6, "Frozen Custard Menu Item 3 설명"));
        frozenCustardMenu.add(new Item("Frozen Custard Menu Item 4", 2.1, "Frozen Custard Menu Item 4 설명"));

        List<Item> drinksMenu = new ArrayList<>();
        drinksMenu.add(new Item("Drinks Menu Item 1", 1.0, "Drinks Menu Item 1 설명"));
        drinksMenu.add(new Item("Drinks Menu Item 2", 1.0, "Drinks Menu Item 2 설명"));

        List<Item> beerMenu = new ArrayList<>();
        beerMenu.add(new Item("Beer Menu Item 1", 3.0, "Beer Menu Item 1 설명"));
        beerMenu.add(new Item("Beer Menu Item 2", 4.0, "Beer Menu Item 2 설명"));

        menuItems.put("Burgers", burgersMenus);
        menuItems.put("Frozen Custard", frozenCustardMenu);
        menuItems.put("Drinks", drinksMenu);
        menuItems.put("Beer", beerMenu);
    }

    public List<Menu> getMenus(String key) {
        return menus.get(key);
    }

    public List<Item> getMenuItems(String key) {
        return menuItems.get(key);
    }

    public List<Item> getCart(){
        return this.cart;
    }

    public Order getOrder(int idx){
        return orders.get(idx);
    }

    public void deleteOrder(int idx){
        orders.remove(idx);
    }



    // 대기주문 목록 출력
    public void printWaiting() {
        int SIZE = orders.size();
        System.out.println("\n대기주문 "+SIZE+"개\n");
        for(int i = 0; i<SIZE; i++){
            System.out.println((i+1) + ". "+orders.get(i));
        }
    }

    // 대기주문 완료 처리
    public void CompletedOrder(int idx){
        Order co = getOrder(idx);
        orders.remove(idx);
        completedOrders.add(new CompletedOrder(co));
    }
    // 완료 주문 목록 출력
    public void printCompletedOrder() {
        for(CompletedOrder c : completedOrders){
            System.out.println(c);
        }
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        try {
            Thread.sleep(3000); // 3초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // 최신 주문 내역 3개 출력
    public void printRecentOrder(){
        System.out.println("[ 최근 완료된 주문 ]");
        Collections.sort(completedOrders, CompletedOrder::compareTo); // 주문 완료 처리된 순서대로 정렬

        int SIZE = completedOrders.size();
        if(SIZE >= 3){
            for (int i = 0; i <3; i++){
                System.out.println(completedOrders.get(i));
            }
        } else {
            for (CompletedOrder o : completedOrders){
                System.out.println(o);
            }
        }
        printWaiting();
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        try {
            Thread.sleep(3000); // 3초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addToCart(Item menuItem) {
        cart.add(menuItem);
        totalPrice += menuItem.price;
    }

    public void displayCart() {
        for (Item item : cart) {
            System.out.println(item.name + "   | " + item.price + " | " + item.description);
        }
    }

    public void addToWaiting(List<Item> cart){
        Scanner sc = new Scanner(System.in);
        System.out.println("요청 사항을 입력해주세요. (20자 이내)");

        String request = sc.nextLine();
        if (request.length() > 20){
            request = request.substring(0, 20);
        }
        String orderList = "";
        for(Item a : cart){
            orderList += a.name + ", ";
        }
        orderList = orderList.substring(0, orderList.length() - 2); // 맨 끝 , 제거
        orders.add(new Order(orderNumber, orderList, totalPrice, request));

    }



    public double getTotalPrice() {
        return totalPrice;
    }

    public int generateOrderNumber() {
        orderNumber++;
        return orderNumber;
    }


    private int generateItemID() {
        return ++itemCounter;
    }

    public void resetCart() {
        cart.clear();
        totalPrice = 0.0;
    }
    public void addMenuItem(String menuName, Item newItem) {
        if (menuItems.containsKey(menuName)) {
            List<Item> items = menuItems.get(menuName);
            items.add(newItem);
            menuItems.put(menuName, items);
            System.out.println("새로운 아이템이 등록되었습니다.");

        } else {
            System.out.println("잘못된 메뉴 이름입니다. 다시 입력해주세요.");
        }
    }
}
