import Access.AccessPassSystem;
import Entity.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    private Main() {
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        System.out.flush();
        AccessPassSystem accessPassSystem = new AccessPassSystem();
        int choice = 1;
        while(choice >= 1 && choice < 9) {
            showMenu();
            String name;
            String surname;
            int age;
            int id;
            String department;
            String phone;
            LocalDateTime to;
            LocalDateTime from;
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите имя работника:");
                    name = scanner.next();
                    System.out.println("Введите фамилию работника:");
                    surname = scanner.next();
                    System.out.println("Введите возраст:");
                    age = scanner.nextInt();
                    System.out.println("Введите отдел:");
                    department = scanner.next();
                    System.out.println("Введите номер телефона:");
                    phone = scanner.next();
                    accessPassSystem.addEmployee(new Employee(name, surname, age, department, phone));
                    break;
                case 2:
                    System.out.println("Введите id пропуска работника:");
                    id = scanner.nextInt();
                    accessPassSystem.deleteEmployee(id);
                    break;
                case 3:
                    System.out.println("Введите id пропуска работника:");
                    id = scanner.nextInt();
                    accessPassSystem.enterToWork(id);
                    break;
                case 4:
                    System.out.println("Введите id пропуска работника:");
                    id = scanner.nextInt();
                    accessPassSystem.exitToWork(id);
                    break;
                case 5:
                    System.out.println("Введите id пропуска работника:");
                    id = scanner.nextInt();
                    System.out.println(accessPassSystem.getEmployeeByPassId(id));
                    break;
                case 6:
                    System.out.println(accessPassSystem.getAllEmployees());
                    break;
                case 7:
                    System.out.println("Введите название отдела:");
                    department = scanner.next();
                    System.out.println(accessPassSystem.getEmployeesByDepartment(department));
                    break;
                case 8:
                    System.out.println("Введите id пропуска работника:");
                    id = scanner.nextInt();
                    System.out.println("Введите дату и время в формате yyyy-MM-dd, с которой начинать отсчет:");
                    String userInput = scanner.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    from = LocalDate.parse(userInput, formatter).atStartOfDay();
                    System.out.println("Введите дату и время в формате yyyy-MM-dd, которой завершать отсчет:");
                    userInput = scanner.next();
                    to = LocalDate.parse(userInput, formatter).atStartOfDay();
                    System.out.println(accessPassSystem.getWorkingTimeBetweenDatesForEmployee(id, from, to));
                    break;
                default:
                    break;
            }
            if(choice > 0 && choice < 9) {
                System.out.println("Введите любой символ, чтобы выйти в меню");
                String k = scanner.next();
            }
        }
    }
    private static void showMenu() {
        System.out.println("Добро пожаловать!");
        System.out.println("Сделайте выбор.");
        System.out.println("1. Добавить работника.");
        System.out.println("2. Удалить работника.");
        System.out.println("3. Указать, что работник пришел на работу.");
        System.out.println("4. Указать, что работник ушел с работы.");
        System.out.println("5. Получить работника по id.");
        System.out.println("6. Получить всех работников предприятия.");
        System.out.println("7. Получить работников из определенного отдела.");
        System.out.println("8. Получить суммарное время работы работника за промежуток времени.");
        System.out.println("0. Закрыть программу");
    }
}