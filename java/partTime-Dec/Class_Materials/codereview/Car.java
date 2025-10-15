package codereview;

public class Car extends ShowRoomvehicle {
    private int numDoors;

    // Constructor
    public Car(String brand , int numDoors){
        super(brand);
        this.numDoors=numDoors;
    }

    public void start(){
        System.out.println("Car is starting ");
    }

    public void stop(){
        System.out.println("Car is stopping ");
    }

    // Overrinding displayInfo method
    public void displayInfo(){
        super.displayInfo();
        System.out.println("type : Car");
        System.out.println("Number of Doors: "+ numDoors);
        
    }

}
