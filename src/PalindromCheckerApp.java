import java.util.Scanner;

public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or number: ");
        String input = sc.nextLine();

        // Convert string to character array
        char[] chars = input.toCharArray();

        boolean isPalindrome = true;

        int start = 0;
        int end = chars.length - 1;

        // Compare characters from both ends
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Print result
        if (isPalindrome) {
            System.out.println("It is a Palindrome.");
        } else {
            System.out.println("It is NOT a Palindrome.");
        }

        sc.close();
    }
}