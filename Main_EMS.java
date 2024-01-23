import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private String address;
    private double salary;

    public Employee(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public void updateDetails(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nSalary: $" + salary;
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employees;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        System.out.println("Enter employee details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Salary: $");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(name, address, salary);
        employees.add(employee);

        System.out.println("Employee added successfully!\n");
    }

    public void updateEmployee() {
        System.out.print("Enter the name of the employee you want to update: ");
        String searchName = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Enter new details:");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("Salary: $");
                double salary = scanner.nextDouble();

                employee.updateDetails(name, address, salary);

                System.out.println("Employee details updated successfully!\n");
                return;
            }
        }

        System.out.println("Employee not found!\n");
    }

    public void deleteEmployee() {
        System.out.print("Enter the name of the employee you want to delete: ");
        String searchName = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(searchName)) {
                employees.remove(employee);
                System.out.println("Employee deleted successfully!\n");
                return;
            }
        }

        System.out.println("Employee not found!\n");
    }

    public void displayAllEmployees() {
        System.out.println("Employee List:\n");
        for (Employee employee : employees) {
            System.out.println(employee + "\n");
        }
    }
}

public class Main_EMS {
    public static void main(String[] args) {
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    employeeManagementSystem.addEmployee();
                    break;
                case 2:
                    employeeManagementSystem.updateEmployee();
                    break;
                case 3:
                    employeeManagementSystem.deleteEmployee();
                    break;
                case 4:
                    employeeManagementSystem.displayAllEmployees();
                    break;
                case 5:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);
    }
}
