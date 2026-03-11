import java.util.Scanner;

// Service class to check palindrome
class PalindromeService {

    private String text;

    // Constructor
    public PalindromeService(String text) {
        this.text = text;
    }

    // Method to check palindrome (case-insensitive & ignoring spaces)
    public boolean isPalindrome() {
        String processed = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(processed).reverse().toString();
        return processed.equals(reversed);
    }

    // Optional: method to set new text
    public void setText(String text) {
        this.text = text;
    }

    // Optional: get the original text
    public String getText() {
        return text;
    }
}

public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word, number, or phrase: ");
        String input = sc.nextLine();

        // Create a PalindromeService object
        PalindromeService service = new PalindromeService(input);

        // Check palindrome
        if (service.isPalindrome()) {
            System.out.println("\"" + service.getText() + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + service.getText() + "\" is NOT a Palindrome.");
        }

        sc.close();
    }
}