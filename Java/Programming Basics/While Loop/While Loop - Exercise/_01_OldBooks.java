import java.util.Scanner;

public class _01_OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchedBook = scanner.nextLine();
        String bookName = scanner.nextLine();
        int checkCount = 0;

        while (!bookName.equals("No More Books")) {
            if (searchedBook.equals(bookName)) {
                System.out.printf("You checked %d books and found it.", checkCount);
                return;
            }
            checkCount++;
            bookName = scanner.nextLine();
        }
        System.out.println("The book you search is not here!");
        System.out.printf("You checked %d books.", checkCount);
    }
}