// RideHailingApplication.java

import java.util.ArrayList;
import java.util.List;

// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Vehicle class
abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = initialLocation;
    }

    // Encapsulation: getters and setters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    // Abstract method to calculate fare
    public abstract double calculateFare(double distance);

    // Concrete method to display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }
}

// Car subclass
class Car extends Vehicle {
    private double comfortCharge = 50; // flat extra charge for comfort

    public Car(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm, initialLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + comfortCharge;
    }
}

// Bike subclass
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm, initialLocation);
    }

    @Override
    public double calculateFare(double distance) {
        // Bikes have no extra charges
        return getRatePerKm() * distance;
    }
}

// Auto subclass
class Auto extends Vehicle {
    private double congestionCharge = 20; // flat congestion charge

    public Auto(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm, initialLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + congestionCharge;
    }
}

// Main class
public class RideHailingApplication {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle car = new Car("C001", "Alice", 15.0, "Downtown");
        Vehicle bike = new Bike("B001", "Bob", 10.0, "Uptown");
        Vehicle auto = new Auto("A001", "Charlie", 12.0, "Midtown");

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);

        double distance = 10.5; // distance in km

        System.out.println("Ride Fare Details for distance: " + distance + " km\n");

        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.printf("Calculated Fare: ₹%.2f\n", v.calculateFare(distance));
            System.out.println("-----------------------------");
        }

        // Demonstrate GPS update
        System.out.println("Updating locations...\n");
        car.updateLocation("Airport");
        bike.updateLocation("Mall");
        auto.updateLocation("Train Station");

        for (Vehicle v : vehicles) {
            System.out.println(v.getVehicleId() + " Current Location: " + v.getCurrentLocation());
        }
    }
}
