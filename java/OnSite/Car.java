public class Car extends Vehicle{
    private int numDoors;

    //Constructor
    public Car(String brand,int numDoors){
        super(brand);
        this.numDoors=numDoors;
    }

    public void start(){
        System.out.println("Car is start ");
    }

    public void stop(){
        System.out.println("Car is stop ");
    }

    public void displayinfo(){
        super.displayinfo();
        System.out.println("Type : Car");
        System.out.println("Number of doors "+numDoors);
    }
}