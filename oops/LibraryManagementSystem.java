// LibraryManagementSystem.java

import java.util.ArrayList;
import java.util.List;

// Interface
interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}

// Abstract class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved;
    private String reservedBy;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
        this.reservedBy = null;
    }

    // Encapsulation
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setReserved(boolean status) {
        this.isReserved = status;
    }

    protected void setReservedBy(String name) {
        this.reservedBy = name;
    }

    protected String getReservedBy() {
        return reservedBy;
    }

    protected boolean isReserved() {
        return isReserved;
    }

    // Abstract Method
    public abstract int getLoanDuration(); // in days

    // Concrete Method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass: Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    @Override
    public void reserveItem(String borrower) {
        if (!isReserved()) {
            setReserved(true);
            setReservedBy(borrower);
            System.out.println("Book reserved by " + borrower);
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Type: Book");
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Availability: " + (checkAvailability() ? "Available" : "Reserved by " + getReservedBy()));
        System.out.println("-----------------------------");
    }
}

// Subclass: Magazine
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public void reserveItem(String borrower) {
        if (!isReserved()) {
            setReserved(true);
            setReservedBy(borrower);
            System.out.println("Magazine reserved by " + borrower);
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Type: Magazine");
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Availability: " + (checkAvailability() ? "Available" : "Reserved by " + getReservedBy()));
        System.out.println("-----------------------------");
    }
}

// Subclass: DVD
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem(String borrower) {
        if (!isReserved()) {
            setReserved(true);
            setReservedBy(borrower);
            System.out.println("DVD reserved by " + borrower);
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Type: DVD");
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Availability: " + (checkAvailability() ? "Available" : "Reserved by " + getReservedBy()));
        System.out.println("-----------------------------");
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        LibraryItem item1 = new Book("B001", "1984", "George Orwell");
        LibraryItem item2 = new Magazine("M001", "National Geographic", "Various Authors");
        LibraryItem item3 = new DVD("D001", "Inception", "Christopher Nolan");

        items.add(item1);
        items.add(item2);
        items.add(item3);

        // Reserve some items
        ((Reservable) item1).reserveItem("Alice");
        ((Reservable) item3).reserveItem("Bob");

        // Display details (Polymorphism)
        for (LibraryItem item : items) {
            item.getItemDetails();
        }
    }
}
