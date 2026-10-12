import java.util.*;

abstract class TravelBooking {
    static final double BOOKING_FEE = 50.0;
    double distanceKm;

    TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateBaseFare();

    abstract String getMode();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class Bus extends TravelBooking {
    Bus(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return distanceKm * 2.0;
    }

    String getMode() {
        return "BUS";
    }
}

class Train extends TravelBooking {
    Train(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class Flight extends TravelBooking {
    Flight(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return 2500 + distanceKm * 4.0;
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings[i] = new Bus(distance);
                    break;
                case "TRAIN":
                    bookings[i] = new Train(distance);
                    break;
                case "FLIGHT":
                    bookings[i] = new Flight(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }
        }

        for (TravelBooking booking : bookings) {
            System.out.printf(
                    "%s: %.2f%n",
                    booking.getMode(), booking.calculateTotal()
            );
        }

        sc.close();
    }
}