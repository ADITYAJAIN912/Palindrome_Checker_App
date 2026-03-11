import java.util.Scanner;

// Strategy Interface
interface PalindromCheckerApp {
    boolean isPalindrome(String text);
}

// Concrete Strategy 1: String Reverse
class ReverseStringStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String processed = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(processed).reverse().toString();
        return processed.equals(reversed);
    }
}

// Concrete Strategy 2: Character Array
class CharArrayStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
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
}

// Concrete Strategy 3: Stack-Based
import java.util.Stack;
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String processed = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : processed.toCharArray()) stack.push(c);
        for (char c : processed.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// Context Class
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        return strategy.isPalindrome(text);
    }
}

// Client
public class StrategyPatternPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word, number, or phrase: ");
        String input = sc.nextLine();

        // Using Reverse String Strategy
        PalindromeCheckerContext checker = new PalindromeCheckerContext(new ReverseStringStrategy());
        System.out.println("Using Reverse String Strategy: " +
                (checker.check(input) ? "Palindrome" : "Not Palindrome"));

        // Switch to Character Array Strategy
        checker.setStrategy(new CharArrayStrategy());
        System.out.println("Using Char Array Strategy: " +
                (checker.check(input) ? "Palindrome" : "Not Palindrome"));

        // Switch to Stack Strategy
        checker.setStrategy(new StackStrategy());
        System.out.println("Using Stack Strategy: " +
                (checker.check(input) ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}