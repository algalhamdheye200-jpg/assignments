// INHERITANCE: Bike extends Vehicle and reuses its fields via super().
public class Bike extends Vehicle {
    private static final double DISCOUNT = 0.10;

    public Bike(String vehicleNumber, String model, double ratePerDay, int days) {
        super(vehicleNumber, model, ratePerDay, days); // call parent constructor
    }

    // POLYMORPHISM: overrides calculateRent() to apply a 10% discount on the total
    @Override
    public double calculateRent() {
        double total = super.calculateRent();
        return total - total * DISCOUNT;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike | " + vehicleNumber + " | " + model
                + " | Days: " + days + " | Rent: " + calculateRent());
    }
}
