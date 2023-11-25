package Tests;

import Access.AccessPass;
import Access.AccessPassSystem;
import Entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccessPassSystemTest {
    AccessPassSystem accessPassSystem;
    @BeforeEach
    public void createObject() {
        accessPassSystem = new AccessPassSystem();
    }
    @Test
    @DisplayName("Test add method")
    public void testAdd() {
        AccessPass accessPass =  new AccessPass(1, new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));
        accessPassSystem.addEmployee(new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));

        assertThat(accessPassSystem.getPasses()).contains(accessPass);
    }
    @Test
    @DisplayName("Test delete method")
    public void testDelete() {
        AccessPass accessPass =  new AccessPass(1, new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));
        accessPassSystem.addEmployee(new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));
        accessPassSystem.deleteEmployee(1);

        assertThat(accessPassSystem.getPasses()).doesNotContain(accessPass);
    }
    @Test
    @DisplayName("Test employee by id method")
    public void testEmployeeById() {
        AccessPass accessPass =  new AccessPass(1, new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));
        accessPassSystem.addEmployee(new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));

        Employee expected = new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635");

        Employee response = accessPassSystem.getEmployeeByPassId(1);

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test get employees  method")
    public void testEmployees() {
        AccessPass accessPass1 =  new AccessPass(1, new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));
        AccessPass accessPass2 =  new AccessPass(2, new Employee("Nikita", "Korepanov", 19, "IT", "+79120532635"));
        accessPassSystem.addEmployee(new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));
        accessPassSystem.addEmployee(new Employee("Nikita", "Korepanov", 19, "IT", "+79120532635"));

        List<Employee> expected = List.of(new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"), new Employee("Nikita", "Korepanov", 19, "IT", "+79120532635") );

        List<Employee> response = accessPassSystem.getAllEmployees();

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test get employees by department  method")
    public void testEmployeesByDep() {
        AccessPass accessPass1 =  new AccessPass(1, new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));
        AccessPass accessPass2 =  new AccessPass(2, new Employee("Nikita", "Korepanov", 19, "IT", "+79120532635"));
        AccessPass accessPass3 =  new AccessPass(3, new Employee("Ivan", "Korepanov", 19, "Sales", "+79120532635"));
        accessPassSystem.addEmployee(new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));
        accessPassSystem.addEmployee(new Employee("Nikita", "Korepanov", 19, "IT", "+79120532635"));
        accessPassSystem.addEmployee(new Employee("Ivan", "Korepanov", 19, "Sales", "+79120532635"));

        List<Employee> expected = List.of(new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"), new Employee("Nikita", "Korepanov", 19, "IT", "+79120532635") );

        List<Employee> response = accessPassSystem.getEmployeesByDepartment("IT");

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test get working time by employee")
    public void testWorkEmployees() {
        Employee employee = new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635");
        accessPassSystem.addEmployee(employee);
        accessPassSystem.getPasses().stream().findFirst().get().addEntering(LocalDateTime.of(2023, 1, 1, 12, 0 ,0));
        accessPassSystem.getPasses().stream().findFirst().get().addExiting(LocalDateTime.of(2023, 1, 1, 12, 50 ,0));
        accessPassSystem.getPasses().stream().findFirst().get().addEntering(LocalDateTime.of(2023, 1, 1, 17, 0 ,0));
        accessPassSystem.getPasses().stream().findFirst().get().addExiting(LocalDateTime.of(2023, 1, 1, 20, 0 ,0));

        int expected = 230;

        int response = accessPassSystem.getWorkingTimeBetweenDatesForEmployee(1, LocalDateTime.MIN, LocalDateTime.MAX);

        assertThat(expected).isEqualTo(response);
    }
}
