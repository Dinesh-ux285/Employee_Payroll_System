import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private int id;

    private String name;

    public Employee(int id, String name) {
       this.id = id;
       this.name = name;
    }

   public String getName(){
       return name;
   }

   public int getId(){
       return id;
   }

   public abstract double calculateSalary();

   @Override
    public String toString(){
       return "Employee_Details = name = "+ name +", id = " + id + ", salary = " + calculateSalary() ;
   }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary){
        super(id,name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;

    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override

    public double calculateSalary(){
        return hourlyRate * hoursWorked;
    }
}

class PayrollSystem {
    private List<Employee> employeesList;

    public PayrollSystem() {
        employeesList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeesList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;

        for (Employee employee : employeesList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeesList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeesList) {
            System.out.println(employee + " ");
        }
    }
}

    public class Main {
        public static void main(String[] args) {
            PayrollSystem payrollSystem = new PayrollSystem();
            FullTimeEmployee emp1 = new FullTimeEmployee(101, "Dinesh", 70000);
            PartTimeEmployee emp2 = new PartTimeEmployee(102, "John", 40, 100);

            payrollSystem.addEmployee(emp1);
            payrollSystem.addEmployee(emp2);

            System.out.println("Initial Employee Deatils");
            payrollSystem.displayEmployees();
            System.out.println("Removing Employees");
            payrollSystem.removeEmployee(101);
            System.out.println("Remaining Employees Details");
            payrollSystem.displayEmployees();
        }
    }
