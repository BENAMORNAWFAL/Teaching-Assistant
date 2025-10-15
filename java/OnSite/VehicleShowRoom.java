public class VehicleShowRoom{
    public static void main(String[] args){

        //creating instance of car and motor
        Car car=new Car("Audi",4);
        Motor motor=new Motor("BMW",2);


        //Display info about vehicles
        System.out.println("Car Info");
        car.displayinfo();
        car.start();
        car.stop();
        System.out.println("Motor Info");
        // motor.displayinfo();
        // motor.start();
        // motor.stop();



    }
}