import java.util.Scanner;

public class _07_TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numGroups = Integer.parseInt(scanner.nextLine());
        int numAllPeople = 0;
        int musala = 0;
        int monblan = 0;
        int kilimandjaro = 0;
        int k2 = 0;
        int everest = 0;


        for (int currentGroup = 0; currentGroup < numGroups; currentGroup++) {
            int numPeopleGroup = Integer.parseInt(scanner.nextLine());
            numAllPeople += numPeopleGroup;
            if (numPeopleGroup <= 5) {
                musala += numPeopleGroup;
            } else if (numPeopleGroup <= 12) {
                monblan += numPeopleGroup;
            } else if (numPeopleGroup <= 25) {
                kilimandjaro += numPeopleGroup;
            } else if (numPeopleGroup <= 40) {
                k2 += numPeopleGroup;
            } else {
                everest += numPeopleGroup;
            }
        }

        System.out.printf("%.2f%%\n", returnPercents(musala, numAllPeople));
        System.out.printf("%.2f%%\n", returnPercents(monblan, numAllPeople));
        System.out.printf("%.2f%%\n", returnPercents(kilimandjaro, numAllPeople));
        System.out.printf("%.2f%%\n", returnPercents(k2, numAllPeople));
        System.out.printf("%.2f%%\n", returnPercents(everest, numAllPeople));
    }

    private static double returnPercents(int numPeopleGroup, int allPeople) {
        return (double) numPeopleGroup / allPeople * 100;
    }
}