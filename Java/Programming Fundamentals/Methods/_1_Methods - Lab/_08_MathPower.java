import java.util.Scanner;

public class _08_MathPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();

        int result = mathPower(number, power);
        System.out.println(result);
    }

    private static int mathPower(int number, int power) {
        return (int) Math.pow(number, power);
    }
}
