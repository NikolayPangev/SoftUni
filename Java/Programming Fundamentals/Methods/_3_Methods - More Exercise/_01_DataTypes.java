import java.util.Scanner;

public class _01_DataTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        switch (name) {
            case "int" -> {
                int num = sc.nextInt();
                System.out.println(num * 2);
            }
            case "double", "real" -> {
                double realNum = sc.nextDouble();
                System.out.printf("%.2f", realNum * 1.5);
            }
            case "string" -> System.out.printf("$%s$", sc.next());
        }
    }
}
