import java.util.Scanner;

public class SubstringComparison {
    public static String substringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = scanner.next();

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        // Validate indices
        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid start or end index!");
        } else {
            String customSubstring = substringUsingCharAt(text, start, end);
            String builtInSubstring = text.substring(start, end);
            boolean isEqual = compareUsingCharAt(customSubstring, builtInSubstring);

            System.out.println("Custom Substring: " + customSubstring);
            System.out.println("Built-in Substring: " + builtInSubstring);
            System.out.println("Are substrings equal? " + isEqual);
        }
        scanner.close();
    }
}
