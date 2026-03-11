import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromCheckerApp{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        System.out.print("Enter a word or number: ");
        String input = sc.nextLine();

        // Add characters to both stack and queue
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;

        // Compare stack and queue elements
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.remove()) {
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