import java.util.Scanner;

public class _08_BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int price = Integer.parseInt(scanner.nextLine());

        double sneakers = price - 0.4 * price;
        double outfit = sneakers - 0.2 * sneakers;
        double ball = outfit / 4;
        double accessories = ball / 5;

        double total =price + sneakers + outfit + ball + accessories;
        System.out.println(total);
    }
}