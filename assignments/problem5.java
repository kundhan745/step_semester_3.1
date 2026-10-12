import java.util.*;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    String getType() {
        return "AC";
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    String getType() {
        return "WASHER";
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        boolean[] saverRequested = new boolean[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            String mode = "";
            if (sc.hasNextLine()) {
                String remaining = sc.nextLine().trim();
                mode = remaining.toUpperCase();
            }

            saverRequested[i] = mode.equals("SAVER");

            switch (type) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AC(hours);
                    break;
                case "TV":
                    appliances[i] = new TV(hours);
                    break;
                case "WASHER":
                    appliances[i] = new Washer(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid appliance type");
            }
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            Appliance appliance = appliances[i];

            if (saverRequested[i] && !(appliance instanceof SaverMode)) {
                System.out.println(
                        appliance.getType() + ": saver mode not supported"
                );
                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested[i]) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(), units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}