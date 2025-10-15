package group1;
abstract public class ShowRoomVehicle implements Interfaces{
    private String brand;

    //Constructer
    public ShowRoomVehicle(String brand){
        this.brand=brand;
    }

    public void displayinfo(){
        System.out.println("Brand : "+brand);
    }

    
}
