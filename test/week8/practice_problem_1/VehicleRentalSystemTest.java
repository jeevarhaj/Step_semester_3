package week8.practice_problem_1;

public class VehicleRentalSystemTest {
    public static void main(String[] args) {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");

        Vehicle sedan = new Sedan("S1", "Sedan A");
        Vehicle suv = new SUV("U1", "SUV B");

        double charge = system.rentVehicle(customer1, sedan, 3);
        check(charge == 150.0, "Sedan charge should be 150");
        check(!sedan.isAvailable(), "Sedan should be unavailable");

        expectFailure(() -> system.rentVehicle(customer2, sedan, 2));

        system.returnVehicle(sedan);
        check(sedan.isAvailable(), "Sedan should be available after return");

        double suvCharge = system.rentVehicle(customer2, suv, 2);
        check(suvCharge == 140.0, "SUV charge should be 140");

        System.out.println("Vehicle rental tests passed.");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void expectFailure(Runnable action) {
        try {
            action.run();
            throw new AssertionError("Expected operation to fail.");
        } catch (IllegalStateException expected) {
        }
    }
}
