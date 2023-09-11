import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public List<Product> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

  class OnlineBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("=== Online Billing System ===");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    Product product = new Product(productName, productPrice);
                    cart.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter index of product to remove: ");
                    int index = scanner.nextInt();
                    cart.removeProduct(index);
                    break;
                case 3:
                    List<Product> items = cart.getItems();
                    if (items.isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        System.out.println("=== Your Cart ===");
                        for (int i = 0; i < items.size(); i++) {
                            Product item = items.get(i);
                            System.out.println(i + ". " + item.getName() + " - $" + item.getPrice());
                        }
                        System.out.println("Total: $" + cart.calculateTotal());
                    }
                    break;
                case 4:
                    double total = cart.calculateTotal();
                    System.out.println("=== Checkout ===");
                    System.out.println("Total Amount: $" + total);
                    System.out.println("Thank you for shopping with us!");
                    System.exit(0);
                    break;
                case 5:
                    System.out.println("Exiting the Online Billing System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

