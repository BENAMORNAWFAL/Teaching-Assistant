public class VehicleShowRom{
    public static void main(String[] args){
        //Creating instance of car and yacht
        Car car=new Car("BMW",2);
        Yacht yacht=new Yacht("Yamaha",25);

        //Display info about Vehicles
        System.out.println("Car Info");
        car.displayinfo();
        car.start();
        car.stop();
        System.out.println("Yacht Info");
        yacht.displayinfo();
        yacht.start();
        yacht.stop();
    }
}