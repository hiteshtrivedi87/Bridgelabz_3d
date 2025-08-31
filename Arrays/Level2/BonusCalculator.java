import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] employeeData = new double[10][2]; // salary, years of service
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary and years of service for employee " + (i + 1) + ":");
            double salary = sc.nextDouble();
            double years = sc.nextDouble();

            if (salary < 0 || years < 0) {
                System.out.println("Invalid input. Enter positive values.");
                i--;
                continue;
            }

            employeeData[i][0] = salary;
            employeeData[i][1] = years;
        }

        for (int i = 0; i < 10; i++) {
            double sal = employeeData[i][0];
            double yrs = employeeData[i][1];

            if (yrs > 5) {
                bonus[i] = sal * 0.05;
            } else {
                bonus[i] = sal * 0.02;
            }

            newSalary[i] = sal + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += sal;
            totalNewSalary += newSalary[i];
        }

        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}
