import java.util.Scanner;
public class tax {


    interface Taxable {
        double SALES_TAX = 0.07;
        double INCOME_TAX = 0.105;

        double calTax();
    }

    class Employee implements Taxable {
        private int empID;
        private String name;
        private double salary;

        public Employee(int empID, String name, double salary) {
            this.empID = empID;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public double calTax() {
            return salary * INCOME_TAX;
        }
    }

    class Product implements Taxable {
        private int pid;
        private double price;
        private int quantity;

        public Product(int pid, double price, int quantity) {
            this.pid = pid;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public double calTax() {
            return price * SALES_TAX * quantity;
        }
    }

    public class DriverMain {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Employee ID: ");
            int empID = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Employee Salary: ");
            double salary = scanner.nextDouble();

            Employee employee = new Employee(empID, name, salary);
            double incomeTax = employee.calTax();
            System.out.println("Income Tax for " + name + ": " + incomeTax);

            System.out.print("Enter Product ID: ");
            int pid = scanner.nextInt();
            System.out.print("Enter Product Price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter Product Quantity: ");
            int quantity = scanner.nextInt();

            Product product = new Product(pid, price, quantity);
            double salesTax = product.calTax();
            System.out.println("Sales Tax for Product ID " + pid + ": " + salesTax);

            scanner.close();
        }
    }
}

