class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings = savings + amount;
        } else {
            System.out.println("Invalid deposit");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal");
        } else if (amount > savings) {
            System.out.println("Insufficient savings");
        } else {
            savings = savings - amount;
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

public class problem1 {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}