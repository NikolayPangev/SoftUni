import java.util.Scanner;

public class _06_Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int cakePieces = width * length;
        String command = scanner.nextLine();

        while (!command.equals("STOP")) {
            int cakeNum = Integer.parseInt(command);
            cakePieces -= cakeNum;

            if (cakePieces <= 0) {
                System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakePieces));
                return;
            }
            command = scanner.nextLine();
        }
        System.out.printf("%d pieces are left.", cakePieces);
    }
}