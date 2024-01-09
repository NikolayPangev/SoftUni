import java.util.Scanner;

public class _03_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int fullCourses = numberOfPeople / capacity;
        int remainingPeople = numberOfPeople % capacity;
        int remainingCourses = 0;

        if (remainingPeople > 0 && remainingPeople < capacity) {
            remainingCourses++;
        }

        int totalCourses = fullCourses + remainingCourses;
        System.out.println(totalCourses);
    }
}