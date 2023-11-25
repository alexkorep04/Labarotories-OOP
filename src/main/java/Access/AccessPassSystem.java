package Access;

import Entity.Employee;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AccessPassSystem {
    private Set<AccessPass> passes;
    private int curId;
    public AccessPassSystem() {
        passes = new LinkedHashSet<>();
        curId = 1;
    }

    public void addEmployee(Employee employee) {
        passes.add(new AccessPass(curId, employee));
        curId++;
    }

    public void deleteEmployee(int id) {
        AccessPass deletedPass = passes.stream().filter(pass -> pass.getPassId() == id).findFirst().get();
        passes.remove(deletedPass);
    }

    public void enterToWork(int id) {
        AccessPass accessPass = passes.stream().filter(pass -> pass.getPassId() == id).findFirst().get();
        accessPass.addEntering(LocalDateTime.now());
    }

    public void exitToWork(int id) {
        AccessPass accessPass = passes.stream().filter(pass -> pass.getPassId() == id).findFirst().get();
        accessPass.addExiting(LocalDateTime.now());
    }

    public Employee getEmployeeByPassId(int id) {
        return passes.stream().filter(pass -> pass.getPassId() == id).findFirst().get().getEmployee();
    }

    public List<Employee> getAllEmployees() {
        return passes.stream().map(AccessPass::getEmployee).toList();
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return passes.stream().map(AccessPass::getEmployee).filter(employee -> department.equals(employee.getDepartment())).toList();
    }

    public int getWorkingTimeBetweenDatesForEmployee(int id, LocalDateTime from, LocalDateTime to) {
        AccessPass accessPass = passes.stream().filter(pass -> pass.getPassId() == id).findFirst().get();
        List<LocalDateTime> enters = accessPass.getTimesOfEntering();
        List<LocalDateTime> exits = accessPass.getTimesOfExiting();
        int sumMinutes = 0;
        if(exits.size() != enters.size()) {
            throw new IllegalArgumentException("Not correct data!");
        }
        for(int i = 0; i < enters.size(); i++) {
            sumMinutes += Math.abs(Duration.between(exits.get(i), enters.get(i)).toMinutes());
        }
        return sumMinutes;
    }

    public Set<AccessPass> getPasses() {
        return passes;
    }
}
