package Access;

import Entity.Employee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccessPass {
    private int passId;
    private Employee employee;
    private List<LocalDateTime> timesOfEntering;
    private List<LocalDateTime> timesOfExiting;

    public AccessPass(int passId, Employee employee) {
        this.passId = passId;
        this.employee = employee;
        timesOfEntering = new ArrayList<>();
        timesOfExiting = new ArrayList<>();
    }

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<LocalDateTime> getTimesOfEntering() {
        return timesOfEntering;
    }

    public void setTimesOfEntering(List<LocalDateTime> timesOfEntering) {
        this.timesOfEntering = timesOfEntering;
    }

    public List<LocalDateTime> getTimesOfExiting() {
        return timesOfExiting;
    }

    public void setTimesOfExiting(List<LocalDateTime> timesOfExiting) {
        this.timesOfExiting = timesOfExiting;
    }

    public void addEntering(LocalDateTime time) {
        timesOfEntering.add(time);
    }

    public void addExiting(LocalDateTime time) {
        timesOfExiting.add(time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessPass that = (AccessPass) o;
        return passId == that.passId && Objects.equals(employee, that.employee) && Objects.equals(timesOfEntering, that.timesOfEntering) && Objects.equals(timesOfExiting, that.timesOfExiting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passId, employee, timesOfEntering, timesOfExiting);
    }

    @Override
    public String toString() {
        return "AccessPass{" +
                "passId=" + passId +
                ", employee=" + employee +
                ", timesOfEntering=" + timesOfEntering +
                ", timesOfExiting=" + timesOfExiting +
                '}';
    }
}
