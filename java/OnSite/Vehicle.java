public class Vehicle implements ShowRoom{
    private String brand;

    //Constructor
    public Vehicle(String brand){
        this.brand=brand;
    }

    public void displayinfo(){
        System.out.println("Brand : "+brand);
    }
     public void start(){
        System.out.println("Motor is start ");
    }

    public void stop(){
        System.out.println("Motor is stop ");
    }
}