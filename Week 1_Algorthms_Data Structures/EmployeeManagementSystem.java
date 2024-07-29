class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Employee list is full.");
        }
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println("Employee ID: " + employees[i].employeeId + ", Name: " + employees[i].name);
        }
    }

    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(employeeId)) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                return;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        Employee emp1 = new Employee("E001", "John Doe", "Manager", 60000.00);
        Employee emp2 = new Employee("E002", "Jane Smith", "Developer", 50000.00);
        ems.addEmployee(emp1);
        ems.addEmployee(emp2);

        ems.traverseEmployees();

        ems.deleteEmployee("E001");
        ems.traverseEmployees();
    }
}
