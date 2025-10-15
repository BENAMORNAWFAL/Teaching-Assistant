package group1;
public class Yacht extends ShowRoomVehicle{

    private int length;

    //constructer
    public Yacht(String brand, int length){
        super(brand);
        this.length=length;
    }

    public void start(){
        System.out.println("Yacht is starting");
    }
    public void stop(){
        System.out.println("Yacht is stopping");
        
    }
    public void displayinfo(){
        super.displayinfo();
        System.out.println("Type : Yacht");
        System.out.println("length "+length+" feet");
    }


}
