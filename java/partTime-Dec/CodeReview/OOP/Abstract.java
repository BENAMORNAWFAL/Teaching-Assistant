// Abstract class for vehicles in the showroom
abstract class ShowRoomVehicle implements Vehicle {
    protected String brand;

    public ShowRoomVehicle(String brand) {
        this.brand = brand;
    }

    // Common method for all vehicles in the showroom
    public void displayInfo() {
        System.out.println("Brand: " + brand);
    }
}
