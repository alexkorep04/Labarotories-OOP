package Tests;

import Access.AccessPass;
import Entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;

public class AccessPassTest {
    AccessPass accessPass;
    @BeforeEach
    public void createObject() {
        accessPass = new AccessPass(1, new Employee("Alexander", "Korepanov", 19, "IT", "+79120532635"));
    }
    @Test
    @DisplayName("Test add entering method")
    public void testEntering() {
        accessPass.addEntering(LocalDateTime.MIN);

        assertThat(accessPass.getTimesOfEntering()).contains(LocalDateTime.MIN);
    }

    @Test
    @DisplayName("Test add exiting method")
    public void testExiting() {
        accessPass.addExiting(LocalDateTime.MIN);

        assertThat(accessPass.getTimesOfExiting()).contains(LocalDateTime.MIN);
    }
}
