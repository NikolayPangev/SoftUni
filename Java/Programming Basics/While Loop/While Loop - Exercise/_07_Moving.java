import java.util.Scanner;

public class _07_Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int volume = width * length * height;
        int neededVolume = 0;

        while (!command.equals("Done")) {
            int space = Integer.parseInt(command);
            neededVolume += space;

            if (volume < neededVolume) {
                System.out.printf("No more free space! You need %d Cubic meters more.", neededVolume - volume);
                break;
            }
            command = scanner.nextLine();
        }

        if (volume > neededVolume) {
            System.out.printf("%d Cubic meters left.", volume - neededVolume);
        }
    }
}