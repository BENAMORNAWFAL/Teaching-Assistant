public class Car extends ShowRoom{
    private int numDoors;

    //Constructor
    public Car(String brand, int numDoors){
        super(brand);
        this.numDoors=numDoors;
    }

    public void start(){
        System.out.println("Car is starting " );

    }
    public void stop(){
        System.out.println("Car is stopping");
    }
    //overriding display method
    public void displayinfo(){
        super.displayinfo();
        System.out.println("Type : Car" );
        System.out.println("number of doors "+numDoors );
    }
    
}
