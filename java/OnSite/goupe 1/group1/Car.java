package group1;
public class Car extends ShowRoomVehicle implements Interfaces {
    private int numDoors;

    //Constructor
    public Car(String brand, int numDoors){
        super(brand);
        this.numDoors=numDoors;

    }

    public void start(){
        System.out.println("Car is Starting");
    }

    public void stop(){
        System.out.println("Car is Stopping");
    }

    public void displayinfo(){
        super.displayinfo();
        System.out.println("type : Car");
        System.out.println("Number of Doors : "+numDoors);
    }
}
