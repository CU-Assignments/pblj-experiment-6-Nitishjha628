import java.util.*;
class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

public class LMBEXp {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int numEmployees = obj.nextInt();
        obj.nextLine();

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = obj.nextLine();
            System.out.print("Age: ");
            int age = obj.nextInt();
            System.out.print("Salary: ");
            double salary = obj.nextDouble();
            obj.nextLine();

            employees.add(new Employee(name, age, salary));
        }

        System.out.println("\nOriginal list of employees:");
        employees.forEach(System.out::println);

        System.out.println("\nChoose sorting criteria:");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Age");
        System.out.println("3. Sort by Salary");
        System.out.print("Enter your choice (1, 2, or 3): ");
        int choice = obj.nextInt();

        switch (choice) {
            case 1:
                employees.sort(Comparator.comparing(Employee::getName));
                System.out.println("\nSorted by Name:");
                break;
            case 2:
                employees.sort(Comparator.comparingInt(Employee::getAge));
                System.out.println("\nSorted by Age:");
                break;
            case 3:
                employees.sort(Comparator.comparingDouble(Employee::getSalary));
                System.out.println("\nSorted by Salary:");
                break;
            default:
                System.out.println("Invalid choice! Sorting by Name by default.");
                employees.sort(Comparator.comparing(Employee::getName));
                System.out.println("\nSorted by Name:");
                break;
        }

        employees.forEach(System.out::println);
    }
}