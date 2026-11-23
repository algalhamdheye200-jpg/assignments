// INHERITANCE: Car extends Vehicle and reuses its fields via super().
public class Car extends Vehicle {
    private double insurancePerDay;

    public Car(String vehicleNumber, String model, double ratePerDay, int days, double insurancePerDay) {
        super(vehicleNumber, model, ratePerDay, days); // call parent constructor
        this.insurancePerDay = insurancePerDay;
    }

    // POLYMORPHISM: overrides the parent's calculateRent() (rent + insurance per day)
    @Override
    public double calculateRent() {
        return (ratePerDay + insurancePerDay) * days;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car  | " + vehicleNumber + " | " + model
                + " | Days: " + days + " | Rent: " + calculateRent());
    }
}
