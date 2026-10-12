import java.util.*;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    abstract String getType();

    double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 150.0;
    }

    String getType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 250.0;
    }

    String getType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 400.0;
    }

    String getType() {
        return "RECLINER";
    }
}

public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int count = sc.nextInt();

            switch (type) {
                case "REGULAR":
                    tickets[i] = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    tickets[i] = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    tickets[i] = new ReclinerTicket(count);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid seat type");
            }
        }

        double total = 0;

        for (Ticket ticket : tickets) {
            double amount = ticket.calculateAmount();
            System.out.printf("%s: %.2f%n", ticket.getType(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}