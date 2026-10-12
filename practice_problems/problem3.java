import java.util.*;

abstract class Delivery {
    double weight;
    double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();

    abstract String getType();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }

    String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }

    String getType() {
        return "INTERNATIONAL";
    }
}

public class problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Delivery[] deliveries = new Delivery[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    deliveries[i] = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    deliveries[i] = new ExpressDelivery(weight, distance);
                    break;
                case "INTERNATIONAL":
                    double customsFee = sc.nextDouble();
                    deliveries[i] =
                            new InternationalDelivery(weight, distance, customsFee);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid delivery type");
            }
        }

        double total = 0;

        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            System.out.printf("%s: %.2f%n", delivery.getType(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}