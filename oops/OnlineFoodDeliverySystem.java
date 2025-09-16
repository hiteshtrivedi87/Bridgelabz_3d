// OnlineFoodDeliverySystem.java

import java.util.ArrayList;
import java.util.List;

// Interface
interface Discountable {
    void applyDiscount(double discountPercent);
    String getDiscountDetails();
}

// Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation - Getters and setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int qty) {
        this.quantity = qty;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    private double discountPercent = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        total = total - (total * discountPercent / 100);
        return total;
    }

    @Override
    public void applyDiscount(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: " + discountPercent + "%";
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Type: Vegetarian");
        System.out.println(getDiscountDetails());
        System.out.println("Total Price: ₹" + calculateTotalPrice());
        System.out.println("-------------------------");
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {
    private double discountPercent = 0;
    private double additionalChargePerUnit = 20; // e.g., extra charge for non-veg

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double baseTotal = getPrice() * getQuantity();
        double additionalCharges = additionalChargePerUnit * getQuantity();
        double total = baseTotal + additionalCharges;
        total = total - (total * discountPercent / 100);
        return total;
    }

    @Override
    public void applyDiscount(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: " + discountPercent + "%";
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Type: Non-Vegetarian");
        System.out.println("Additional Charge per unit: ₹" + additionalChargePerUnit);
        System.out.println(getDiscountDetails());
        System.out.println("Total Price: ₹" + calculateTotalPrice());
        System.out.println("-------------------------");
    }
}

// Main Class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        VegItem veg1 = new VegItem("Paneer Tikka", 150, 2);
        NonVegItem nonVeg1 = new NonVegItem("Chicken Biryani", 250, 1);
        VegItem veg2 = new VegItem("Veg Fried Rice", 120, 3);

        // Apply discounts
        veg1.applyDiscount(10);      // 10% discount on Paneer Tikka
        nonVeg1.applyDiscount(5);    // 5% discount on Chicken Biryani
        veg2.applyDiscount(0);       // no discount

        order.add(veg1);
        order.add(nonVeg1);
        order.add(veg2);

        double grandTotal = 0;
        System.out.println("Order Details:");
        for (FoodItem item : order) {
            item.getItemDetails();
            grandTotal += item.calculateTotalPrice();
        }

        System.out.println("Grand Total Payable: ₹" + grandTotal);
    }
}
