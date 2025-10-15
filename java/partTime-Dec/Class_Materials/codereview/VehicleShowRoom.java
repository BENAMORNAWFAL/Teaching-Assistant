package codereview;

public class VehicleShowRoom {
    public static void main(String[] args){
        //Creating instances of car and yacht
        Car car=new Car("Toyota", 4);
        Yacht yacht=new Yacht("Oceanco", 100);

        // Displaying info about vehicles
        System.out.println("Car Info :");
        car.displayInfo();
        car.start();
        car.stop();

        System.out.println("Yacht Info :");

        yacht.displayInfo();
        yacht.start();
        yacht.stop();







    }
}
