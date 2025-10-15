// Concrete class for Yachts
class Yacht extends ShowRoomVehicle {
    private int length;

    public Yacht(String brand, int length) {
        super(brand);
        this.length = length;
    }

    // Implementing interface methods
    public void start() {
        System.out.println("Yacht is starting.");
    }

    public void stop() {
        System.out.println("Yacht is stopping.");
    }

    // Overriding displayInfo method
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Yacht");
        System.out.println("Length: " + length + " feet");
    }
}
