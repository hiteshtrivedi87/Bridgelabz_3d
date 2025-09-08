public class Book1 {
    private String title;
    private String author;
    private double price;
    private boolean availability;

    // Constructor
    public Book1(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    // Method to borrow the book
    public boolean borrow() {
        if (availability) {
            availability = false;
            return true; // Borrowed successfully
        } else {
            return false; // Book not available
        }
    }

    // Getters and setters (optional)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return availability;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', price=" + price + ", availability=" + availability + "}";
    }
}
