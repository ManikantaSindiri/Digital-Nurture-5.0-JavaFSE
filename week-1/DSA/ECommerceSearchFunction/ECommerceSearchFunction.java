import java.util.HashMap;
import java.util.Map;

public class ECommerceSearchFunction {
    private final Map<String, String> products;

    public ECommerceSearchFunction() {
        products = new HashMap<>();
    }

    public void addProduct(String id, String name) {
        products.put(id, name);
    }

    public String searchById(String id) {
        return products.get(id);
    }

    public boolean searchByName(String name) {
        return products.containsValue(name);
    }

    public static void main(String[] args) {
        ECommerceSearchFunction search = new ECommerceSearchFunction();
        search.addProduct("P101", "Laptop");
        search.addProduct("P102", "Smartphone");
        search.addProduct("P103", "Headphones");

        System.out.println("Search by ID P102: " + search.searchById("P102"));
        System.out.println("Search by name Smartphone: " + search.searchByName("Smartphone"));
    }
}
