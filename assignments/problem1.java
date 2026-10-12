import java.util.*;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.90;
    }

    String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.95;
    }

    String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + 10;
    }

    String getType() {
        return "GUEST";
    }
}

public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    customers[i] = new Student(amount);
                    break;
                case "STAFF":
                    customers[i] = new Staff(amount);
                    break;
                case "GUEST":
                    customers[i] = new Guest(amount);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid customer type");
            }
        }

        double total = 0;

        for (Customer customer : customers) {
            double finalAmount = customer.calculateAmount();
            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}