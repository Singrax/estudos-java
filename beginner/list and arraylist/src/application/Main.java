package application;

import entitites.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many employees will be registered?");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {

            System.out.println("Employee #" + (i + 1) + ":");
            System.out.printf("Id:");
            int id = sc.nextInt();
            while (hasId(employees, id)) {
                System.out.print("Id already taken! Try again: ");
                id = sc.nextInt();
            }
            sc.nextLine();
            System.out.println("Name:");
            String name = sc.nextLine();
            System.out.println("Salary:");
            double salary = sc.nextDouble();

            employees.add(new Employee(id, name, salary));
        }

        System.out.println("Enter the employee id that will have the salary increase:");
        int id = sc.nextInt();

        Employee emp = null;
        for (Employee e : employees) {
            if (e.getId() == id) {
                emp = e;
                break;
            }
        }
        System.out.println("Enter the percentage:");
        double percentage = sc.nextDouble();

        if (emp != null) {
            emp.increaseSalary(percentage);
        }
        else {
            System.out.println("This id does not exist!");
        }
        System.out.println("List of employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        sc.close();
    }

    public static boolean hasId(List<Employee> list, int id) {
        for (Employee e : list) {
            if (e.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
