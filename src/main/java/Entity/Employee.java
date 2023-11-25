package Entity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
    private String name;
    private String surname;
    private int age;
    private String department;
    private String phone;

    public Employee(String name, String surname, int age, String department, String phone) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setDepartment(department);
        setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(checkNameSurnameDepartment(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Not correct value of name!");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(checkNameSurnameDepartment(surname)) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Not correct value of surname!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(checkAge(age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Not correct value of age!");
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(checkNameSurnameDepartment(department)) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Not correct value of department!");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(checkPhone(phone)) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Not correct value of phone!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, department);
    }

    private boolean checkNameSurnameDepartment(String string) {
        if(string.length() >= 2) {
            for(int i = 0; i < string.length(); i++) {
                if(!Character.isLetter(string.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean checkAge(int age) {
        return age >= 18 && age <= 100;
    }

    private boolean checkPhone(String phone) {
        Pattern pattern = Pattern.compile("\\+79\\d{9}");
        Matcher matcher = pattern.matcher(phone);
        return matcher.find();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
