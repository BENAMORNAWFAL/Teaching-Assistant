package codereview;

public class Yacht extends ShowRoomvehicle{
    private int length;

    // Constructor
    public Yacht(String brand, int length){
        super(brand);
        this.length = length;
    }

    // Implementing interface methods
    public void start(){
        System.out.println("Yacht is starting ");
    }

    public void stop(){
        System.out.println("Yacht is stopping ");
    }

    // overriding displayInfo method
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Type : Yacht");
        System.out.println("length: "+length+" feet");
    }


}
