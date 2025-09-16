// HospitalPatientManagement.java

import java.util.ArrayList;
import java.util.List;

// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class
abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory;  // sensitive info

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    // Encapsulation - Getters and setters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected List<String> getMedicalHistory() {
        return medicalHistory;
    }

    // MedicalRecord interface methods
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + name + ":");
        if (medicalHistory.isEmpty()) {
            System.out.println("No records available.");
        } else {
            for (String rec : medicalHistory) {
                System.out.println("- " + rec);
            }
        }
    }

    // Abstract method for billing
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// InPatient subclass
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRoomCharge;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRoomCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRoomCharge = dailyRoomCharge;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    public double getDailyRoomCharge() {
        return dailyRoomCharge;
    }

    @Override
    public double calculateBill() {
        // For example: room charges + fixed service charges
        double serviceCharges = 5000;
        return (daysAdmitted * dailyRoomCharge) + serviceCharges;
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Type: In-Patient");
        System.out.println("Days Admitted: " + daysAdmitted);
        System.out.println("Daily Room Charge: ₹" + dailyRoomCharge);
        System.out.println("Total Bill: ₹" + calculateBill());
        System.out.println("-------------------------");
    }
}

// OutPatient subclass
class OutPatient extends Patient {
    private int numberOfVisits;
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, int numberOfVisits, double consultationFee) {
        super(patientId, name, age);
        this.numberOfVisits = numberOfVisits;
        this.consultationFee = consultationFee;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    @Override
    public double calculateBill() {
        return numberOfVisits * consultationFee;
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Type: Out-Patient");
        System.out.println("Number of Visits: " + numberOfVisits);
        System.out.println("Consultation Fee: ₹" + consultationFee);
        System.out.println("Total Bill: ₹" + calculateBill());
        System.out.println("-------------------------");
    }
}

// Main class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        Patient p1 = new InPatient("P001", "John Doe", 45, 5, 2000);
        Patient p2 = new OutPatient("P002", "Jane Smith", 30, 3, 500);

        p1.addRecord("Diagnosed with pneumonia");
        p1.addRecord("Prescribed antibiotics");

        p2.addRecord("Regular check-up");
        p2.addRecord("Blood pressure monitoring");

        patients.add(p1);
        patients.add(p2);

        for (Patient p : patients) {
            p.getPatientDetails();
            p.viewRecords();
            System.out.println();
        }
    }
}
