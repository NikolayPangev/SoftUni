import java.util.Scanner;

public class _08_PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogs = Integer.parseInt(scanner.nextLine());
        int cats = Integer.parseInt(scanner.nextLine());
        double dogsPrice = dogs * 2.50;
        double catsPrice = cats * 4.00;
        double result = dogsPrice + catsPrice;
        System.out.println(result);
    }
}