// VehicleRentalSystem.java

import java.util.ArrayList;
import java.util.List;

// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation - Getters and Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vNum) {
        this.vehicleNumber = vNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String t) {
        this.type = t;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rRate) {
        this.rentalRate = rRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Concrete method
    public void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: " + rentalRate);
    }
}

// Subclass: Car
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 2000; // Flat insurance for car
    }

    @Override
    public String getInsuranceDetails() {
        return "Car insurance: ₹2000 flat";
    }

    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.println(getInsuranceDetails());
    }
}

// Subclass: Bike
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500; // Flat insurance for bike
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance: ₹500 flat";
    }

    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.println(getInsuranceDetails());
    }
}

// Subclass: Truck
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000; // Additional logistics charge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% of rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck insurance: 10% of rental rate";
    }

    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.println(getInsuranceDetails());
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle v1 = new Car("MH12AB1234", 1500);
        Vehicle v2 = new Bike("MH14XY7890", 500);
        Vehicle v3 = new Truck("MH18TR5678", 3000);

        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            System.out.println("----------------------------");
            v.displayVehicleDetails();
            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = (v instanceof Insurable) ? ((Insurable) v).calculateInsurance() : 0;
            System.out.println("Rental Days: " + rentalDays);
            System.out.println("Rental Cost: ₹" + rentalCost);
            System.out.println("Insurance Cost: ₹" + insuranceCost);
            System.out.println("Total Payable: ₹" + (rentalCost + insuranceCost));
        }
    }
}
