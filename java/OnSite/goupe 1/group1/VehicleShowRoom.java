package group1;
public class VehicleShowRoom {
    public static void main(String[] args){

        Car car= new Car("Toyota",4);
        Yacht yacht=new Yacht("Oceanco",100);

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
