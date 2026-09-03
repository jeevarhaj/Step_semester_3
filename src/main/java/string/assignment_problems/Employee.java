package string.assignment_problems;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public void printSalary() {
        System.out.println(name + " | Final Salary: " + salary);
    }

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("Alice", 50000),
                new Employee("Bob", 55000),
                new Employee("Charlie", 60000)
        };

        double bonus = 5000;

        for (Employee employee : employees) {
            employee.raiseSalary(bonus);
            employee.printSalary();
        }
    }
}