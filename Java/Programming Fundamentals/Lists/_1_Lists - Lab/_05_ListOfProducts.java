import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _05_ListOfProducts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfProducts = Integer.parseInt(sc.nextLine());

        List<String> products = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {
            products.add(sc.nextLine());
        }

        Collections.sort(products);

        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, products.get(i));
        }
    }
}
