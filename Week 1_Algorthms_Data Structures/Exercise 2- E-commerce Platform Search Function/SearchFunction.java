class Product {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class SearchFunction {

    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.productName.equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = productName.compareTo(products[mid].productName);
            if (res == 0)
                return products[mid];
            if (res > 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("101", "Laptop", "Electronics"),
                new Product("102", "Phone", "Electronics"),
                new Product("103", "Tablet", "Electronics"),
        };

        // Sort products array by productName for binary search
        java.util.Arrays.sort(products, (p1, p2) -> p1.productName.compareTo(p2.productName));

        Product foundProduct = linearSearch(products, "Phone");
        if (foundProduct != null) {
            System.out.println("Product found using linear search: " + foundProduct.productName);
        } else {
            System.out.println("Product not found using linear search.");
        }

        foundProduct = binarySearch(products, "Phone");
        if (foundProduct != null) {
            System.out.println("Product found using binary search: " + foundProduct.productName);
        } else {
            System.out.println("Product not found using binary search.");
        }
    }
}
