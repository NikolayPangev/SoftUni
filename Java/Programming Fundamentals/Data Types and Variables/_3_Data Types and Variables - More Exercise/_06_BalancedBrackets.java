import java.util.Scanner;
import java.util.Stack;

public class _06_BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            for (char symbol : input.toCharArray()) {
                if (symbol == '(') {
                    stack.push(symbol);
                } else if (symbol == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        System.out.println("UNBALANCED");
                        return;
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}