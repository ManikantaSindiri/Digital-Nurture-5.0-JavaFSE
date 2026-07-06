public class InventoryManagementSystemTest {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        inventory.addProduct("P001", "Laptop", 10, 750.0);
        inventory.addProduct("P002", "Mouse", 25, 15.5);

        if (inventory.searchProduct("P001") == null) {
            throw new IllegalStateException("Product P001 should exist");
        }

        inventory.updateStock("P001", 5);
        if (inventory.searchProduct("P001").getQuantity() != 15) {
            throw new IllegalStateException("Stock update failed");
        }

        inventory.removeProduct("P002");
        if (inventory.searchProduct("P002") != null) {
            throw new IllegalStateException("Product removal failed");
        }

        System.out.println("Inventory management tests passed.");
    }
}
