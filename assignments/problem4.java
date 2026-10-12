import java.util.*;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    abstract String getType();

    double calculateFare() {
        return Math.max(100.0, km * getRate());
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10.0;
    }

    String getType() {
        return "MINI";
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14.0;
    }

    String getType() {
        return "SEDAN";
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18.0;
    }

    String getType() {
        return "SUV";
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            times[i] = sc.next().toUpperCase();

            switch (type) {
                case "MINI":
                    cabs[i] = new Mini(km);
                    break;
                case "SEDAN":
                    cabs[i] = new Sedan(km);
                    break;
                case "SUV":
                    cabs[i] = new SUV(km);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            Cab cab = cabs[i];

            if (times[i].equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(cab.getType() + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (times[i].equals("NIGHT")) {
                fare = ((NightService) cab).applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", cab.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}