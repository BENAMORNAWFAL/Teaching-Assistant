class VehicleShowRoom {
    public static void main(String[] args) {
        // Creating instances of Car and Yacht
        Car car = new Car("Toyota", 4);
        Yacht yacht = new Yacht("Oceanco", 100);

        // Displaying information about vehicles
        System.out.println("Car Information:");
        car.displayInfo();
        car.start();
        car.stop();

        System.out.println("\nYacht Information:");
        yacht.displayInfo();
        yacht.start();
        yacht.stop();
    }
}