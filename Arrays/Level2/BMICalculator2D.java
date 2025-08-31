import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; // weight, height, BMI
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight (kg) and height (m) for person " + (i + 1) + ":");
            double weight = sc.nextDouble();
            double height = sc.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input. Re-enter values.");
                i--;
                continue;
            }

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);

            double bmi = personData[i][2];
            if (bmi < 18.5)
                status[i] = "Underweight";
            else if (bmi < 25)
                status[i] = "Normal";
            else if (bmi < 30)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d - Height: %.2f, Weight: %.2f, BMI: %.2f, Status: %s\n",
                    (i + 1), personData[i][1], personData[i][0], personData[i][2], status[i]);
        }
    }
}
