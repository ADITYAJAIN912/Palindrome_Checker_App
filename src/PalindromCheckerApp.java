import java.util.Scanner;

public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or number: ");
        String input = sc.nextLine();

        // Reverse the string using StringBuilder
        String reversed = new StringBuilder(input).reverse().toString();

        // Check if palindrome
        if (input.equalsIgnoreCase(reversed)) {
            System.out.println("It is a Palindrome.");
        } else {
            System.out.println("It is NOT a Palindrome.");
        }

        sc.close();
    }
}