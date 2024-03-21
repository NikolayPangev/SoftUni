import entities.Employee;

import java.util.Scanner;

public class FindEmployeesByFirstName {
    public static void main(String[] args) {
        Utils.createEntityManager()
                .createQuery("FROM Employee WHERE firstName LIKE CONCAT(:letters, '%')", Employee.class)
                .setParameter("letters", new Scanner(System.in).nextLine())
                .getResultList()
                .forEach(employee -> System.out.printf("%s %s - %s - ($%s)%n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getJobTitle(),
                        employee.getSalary()));
    }
}
