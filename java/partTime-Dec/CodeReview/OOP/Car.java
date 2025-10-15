// Concrete class for Cars
class Car extends ShowRoomVehicle {
    private int numDoors;

    public Car(String brand, int numDoors) {
        super(brand);
        this.numDoors = numDoors;
    }

    // Implementing interface methods
    public void start() {
        System.out.println("Car is starting.");
    }

    public void stop() {
        System.out.println("Car is stopping.");
    }

    // Overriding displayInfo method
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car");
        System.out.println("Number of Doors: " + numDoors);
    }
}

