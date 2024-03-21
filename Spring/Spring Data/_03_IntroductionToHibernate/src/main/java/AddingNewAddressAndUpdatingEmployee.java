import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        final EntityManager entityManager = Utils.createEntityManager();
        final Scanner scanner = new Scanner(System.in);

        entityManager.getTransaction().begin();

        final String lastName = scanner.nextLine();

        List<Employee> employees = entityManager
                .createQuery("FROM Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList();

        if (employees.isEmpty()) {
            System.out.println("No employee found with the provided last name.");
        } else {
            Employee employee = employees.get(0);

            Address newAddress = new Address();
            newAddress.setText("Vitoshka 15");

            if (employee.getAddress() != null) {
                Address oldAddress = employee.getAddress();
                oldAddress.setText(newAddress.getText());
                entityManager.merge(oldAddress);
            } else {
                entityManager.persist(newAddress);
                employee.setAddress(newAddress);
            }

            entityManager.flush();
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        scanner.close();
    }
}
