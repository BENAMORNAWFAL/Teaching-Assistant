public class VehicleShowRoom {
    public static void main(String[] args){
        //creating instance of car and yacht
        Car car=new Car("Toyota",2);
        Yacht yacht=new Yacht("Yamaha", 100);
        
        //Display info about vehicles
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
