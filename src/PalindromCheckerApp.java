import java.util.Scanner;

public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word, number, or phrase: ");
        String input = sc.nextLine();

        // Remove spaces and convert to lowercase
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Reverse the processed string
        String reversed = new StringBuilder(processed).reverse().toString();

        // Check palindrome
        if (processed.equals(reversed)) {
            System.out.println("It is a Palindrome.");
        } else {
            System.out.println("It is NOT a Palindrome.");
        }

        sc.close();
    }
}