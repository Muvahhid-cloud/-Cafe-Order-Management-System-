import java.util.ArrayList;

class OrderManager {
    private static ArrayList<OrderItem> orders = new ArrayList<>();

    public static void addOrderItem(OrderItem item) {
        orders.add(item);
    }

    public static ArrayList<OrderItem> getOrders() {
        return orders;
    }

    public static double getTotalPrice() {
        return orders.stream().mapToDouble(OrderItem::getPrice).sum();
    }
}
