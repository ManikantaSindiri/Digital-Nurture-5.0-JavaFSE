import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private final Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(String id, String name, int quantity, double price) {
        if (inventory.containsKey(id)) {
            throw new IllegalArgumentException("Product ID already exists: " + id);
        }

        inventory.put(id, new Product(id, name, quantity, price));
    }

    public void updateStock(String id, int quantityChange) {
        Product product = searchProduct(id);
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + id);
        }
        product.setQuantity(product.getQuantity() + quantityChange);
    }

    public Product searchProduct(String id) {
        return inventory.get(id);
    }

    public void removeProduct(String id) {
        inventory.remove(id);
    }

    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static class Product {
        private final String id;
        private final String name;
        private double price;
        private int quantity;

        public Product(String id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", quantity=" + quantity +
                    ", price=" + price +
                    '}';
        }
    }
}
