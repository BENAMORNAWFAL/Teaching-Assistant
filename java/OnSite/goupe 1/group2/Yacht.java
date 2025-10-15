public class Yacht extends ShowRoom{

    private int length;
    //Constructor
    public Yacht(String brand, int length){
        super(brand);
        this.length=length;
    }

    public void start(){
        System.out.println("Yacht is starting " );

    }
    public void stop(){
        System.out.println("Yacht is stopping");
    }
    //overriding display method
    public void displayinfo(){
        super.displayinfo();
        System.out.println("Type : Yacht" );
        System.out.println("length: "+length+" feet");
    }
}
