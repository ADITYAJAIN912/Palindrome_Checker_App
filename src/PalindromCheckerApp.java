import java.util.Scanner;
import java.util.LinkedList;

public class PalindromCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Enter a word or number: ");
        String input = sc.nextLine();

        // Add characters to the LinkedList
        for (char ch : input.toCharArray()) {
            list.add(ch);
        }

        boolean isPalindrome = true;

        // Compare first and last elements
        while (list.size() > 1) {
            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                isPalindrome = false;
                break;
            }
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