import java.util.HashMap;
import java.util.Map;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            product.quantity = quantity;
            product.price = price;
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product product1 = new Product("101", "Laptop", 50, 800.00);
        ims.addProduct(product1);

        Product product2 = new Product("102", "Phone", 100, 500.00);
        ims.addProduct(product2);

        ims.updateProduct("101", 45, 750.00);

        ims.deleteProduct("102");

        Product p = ims.getProduct("101");
        System.out.println("Product ID: " + p.productId + ", Name: " + p.productName + ", Quantity: " + p.quantity + ", Price: " + p.price);
    }
}
