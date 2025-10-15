public class Motor extends Vehicle{
    private int numWheels;

    //Constructor
    public Motor(String brand,int numWheels){
        super(brand);
        this.numWheels=numWheels;
    }

    // public void start(){
    //     System.out.println("Motor is start ");
    // }

    // public void stop(){
    //     System.out.println("Motor is stop ");
    // }

    public void displayinfo(){
        super.displayinfo();
        System.out.println("Type : Motor");
        System.out.println("Number of Wheels "+numWheels);
    }

}