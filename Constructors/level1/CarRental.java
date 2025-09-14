public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    // Default constructor
    public CarRental() {
        this.customerName = "";
        this.carModel = "";
        this.rentalDays = 0;
        this.dailyRate = 0.0;
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    // Copy constructor
    public CarRental(CarRental other) {
        this.customerName = other.customerName;
        this.carModel = other.carModel;
        this.rentalDays = other.rentalDays;
        this.dailyRate = other.dailyRate;
    }

    // Calculate total cost
    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    // Getters and setters (optional)
    public String getCustomerName() {
        return customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    @Override
    public String toString() {
        return "CarRental{customerName='" + customerName + "', carModel='" + carModel + "', rentalDays=" + rentalDays + ", dailyRate=" + dailyRate + "}";
    }
}
