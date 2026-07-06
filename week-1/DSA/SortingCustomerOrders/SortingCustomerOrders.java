import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingCustomerOrders {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("C101", 120.50));
        orders.add(new Order("C102", 45.20));
        orders.add(new Order("C103", 300.00));
        orders.add(new Order("C104", 78.90));

        Collections.sort(orders, Comparator.comparingDouble(Order::getTotalPrice).reversed());

        System.out.println("Sorted customer orders by total price:");
        for (Order order : orders) {
            System.out.println(order.getCustomerId() + " -> " + order.getTotalPrice());
        }
    }

    static class Order {
        private final String customerId;
        private final double totalPrice;

        public Order(String customerId, double totalPrice) {
            this.customerId = customerId;
            this.totalPrice = totalPrice;
        }

        public String getCustomerId() {
            return customerId;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }
}
