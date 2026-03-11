import java.util.*;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromCheckerApp {

    // Method 1: String Reverse
    public static boolean stringReverse(String text) {
        String processed = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(processed).reverse().toString();
        return processed.equals(reversed);
    }

    // Method 2: Char Array
    public static boolean charArrayMethod(String text) {
        String processed = text.replaceAll("\\s+", "").toLowerCase();
        char[] chars = processed.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // Method 3: Stack
    public static boolean stackMethod(String text) {
        String processed = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : processed.toCharArray()) stack.push(c);
        for (char c : processed.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // Method 4: Deque
    public static boolean dequeMethod(String text) {
        String processed = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : processed.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word, number, or phrase: ");
        String input = sc.nextLine();

        // Array of methods
        String[] methods = {"String Reverse", "Char Array", "Stack", "Deque"};

        for (String method : methods) {
            long startTime = System.nanoTime();
            boolean result = false;

            switch (method) {
                case "String Reverse":
                    result = stringReverse(input);
                    break;
                case "Char Array":
                    result = charArrayMethod(input);
                    break;
                case "Stack":
                    result = stackMethod(input);
                    break;
                case "Deque":
                    result = dequeMethod(input);
                    break;
            }

            long endTime = System.nanoTime();
            System.out.printf("%-12s : %s (Time: %d ns)\n",
                    method, result ? "Palindrome" : "Not Palindrome", (endTime - startTime));
        }

        sc.close();
    }
}