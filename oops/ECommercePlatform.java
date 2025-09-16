// ECommercePlatform.java

import java.util.ArrayList;
import java.util.List;

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters (Encapsulation)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    // Abstract Method
    public abstract double calculateDiscount();

    // Final Price
    public double getFinalPrice() {
        double tax = (this instanceof Taxable) ? ((Taxable) this).calculateTax() : 0;
        return getPrice() + tax - calculateDiscount();
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: " + price);
    }
}

// Subclass: Electronics (Taxable)
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Electronics GST @18%";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Category: Electronics");
        System.out.println(getTaxDetails());
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: " + calculateTax());
        System.out.println("Final Price: " + getFinalPrice());
        System.out.println("-----------------------------");
    }
}

// Subclass: Clothing (Taxable)
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing GST @5%";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Category: Clothing");
        System.out.println(getTaxDetails());
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: " + calculateTax());
        System.out.println("Final Price: " + getFinalPrice());
        System.out.println("-----------------------------");
    }
}

// Subclass: Groceries (Non-Taxable)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Category: Groceries");
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: Not Applicable");
        System.out.println("Final Price: " + getFinalPrice());
        System.out.println("-----------------------------");
    }
}

// Main Class
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        productList.add(new Electronics(201, "Smartphone", 30000));
        productList.add(new Clothing(202, "T-Shirt", 1000));
        productList.add(new Groceries(203, "Rice 10kg", 800));

        for (Product p : productList) {
            // Polymorphism in action
            p.displayDetails();
        }
    }
}
