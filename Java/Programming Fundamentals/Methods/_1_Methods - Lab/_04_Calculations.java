import java.util.Scanner;

public class _04_Calculations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        switch (command) {
            case "add":
                System.out.println(num1 + num2);
                break;
            case "subtract":
                System.out.println(num1 - num2);
                break;
            case "multiply":
                System.out.println(num1 * num2);
                break;
            case "divide":
                System.out.println(num1 / num2);
                break;
        }
    }
}
