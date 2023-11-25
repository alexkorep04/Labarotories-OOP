package Tests;
import Entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeTest {
    Employee employee;
    @BeforeEach
    public void createObject() {
        employee = new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635");
    }
    @Test
    @DisplayName("Test set name method, when we set normal name")
    public void testNormalName() {
        Employee expected = new Employee("Nikita", "Korepanov", 19, "IT", "+79120532635");

        employee.setName("Nikita");

        assertThat(expected).isEqualTo(employee);
    }
    @Test
    @DisplayName("Test set name method, when we set not normal name")
    public void testNotNormalName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> employee.setName("a"));
    }


    @Test
    @DisplayName("Test set surname method, when we set normal surname")
    public void testNormalSurname() {
        Employee expected = new Employee("Alexander", "Kadukov", 19, "IT", "+79120532635");

        employee.setSurname("Kadukov");

        assertThat(expected).isEqualTo(employee);
    }

    @Test
    @DisplayName("Test set surname method, when we set not normal surname")
    public void testNotNormalSurname() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> employee.setSurname("a"));
    }

    @Test
    @DisplayName("Test set age method, when we set normal age")
    public void testNormalAge() {
        Employee expected = new Employee("Alexander", "Korepanov", 20, "IT", "+79120532635");

        employee.setAge(20);

        assertThat(expected).isEqualTo(employee);
    }

    @Test
    @DisplayName("Test set ag method, when we set not normal age")
    public void testNotNormalAge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> employee.setAge(101));
    }

    @Test
    @DisplayName("Test set department method, when we set normal department")
    public void testNormalDepartment() {
        Employee expected = new Employee("Alexander", "Korepanov", 19, "Sales", "+79120532635");

        employee.setDepartment("Sales");

        assertThat(expected).isEqualTo(employee);
    }

    @Test
    @DisplayName("Test set department method, when we set not normal department")
    public void testNotNormalDepartment() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> employee.setDepartment("a"));
    }

    @Test
    @DisplayName("Test set phone method, when we set normal phone")
    public void testNormalPhone() {
        Employee expected = new Employee("Alexander", "Korepanov", 19, "IT", "+79111111111");

        employee.setPhone("+79111111111");

        assertThat(expected).isEqualTo(employee);
    }

    @Test
    @DisplayName("Test set phone method, when we set not normal phone")
    public void testNotNormalPhone() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> employee.setPhone("89120532635"));
    }
}
