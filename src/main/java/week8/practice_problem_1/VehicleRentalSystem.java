package week8.practice_problem_1;

abstract class Vehicle {
    private final String id;
    private final String model;
    private boolean available = true;

    Vehicle(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public boolean isAvailable() { return available; }

    protected void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCharge(int days);

    public double rent(int days) {
        if (!available) {
            throw new IllegalStateException("Vehicle is already rented.");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be positive.");
        }
        available = false;
        return calculateRentalCharge(days);
    }

    public void returnVehicle() {
        if (available) {
            throw new IllegalStateException("Vehicle is not currently rented.");
        }
        available = true;
    }
}

class Sedan extends Vehicle {
    Sedan(String id, String model) { super(id, model); }

    @Override
    public double calculateRentalCharge(int days) {
        return days * 50.0;
    }
}

class SUV extends Vehicle {
    SUV(String id, String model) { super(id, model); }

    @Override
    public double calculateRentalCharge(int days) {
        return days * 70.0;
    }
}

class Truck extends Vehicle {
    Truck(String id, String model) { super(id, model); }

    @Override
    public double calculateRentalCharge(int days) {
        return days * 90.0;
    }
}

class Customer {
    private final String name;

    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class VehicleRentalSystem {
    public double rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (customer == null || vehicle == null) {
            throw new IllegalArgumentException("Customer and vehicle are required.");
        }
        return vehicle.rent(days);
    }

    public void returnVehicle(Vehicle vehicle) {
        vehicle.returnVehicle();
    }
}
