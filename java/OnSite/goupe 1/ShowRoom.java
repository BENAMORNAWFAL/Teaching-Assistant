abstract class ShowRoom implements Vehicle{
    private String brand;

    //Constructer 
    public ShowRoom(String brand){
        this.brand=brand;
    }

    public void displayinfo(){
        System.out.println("Brand : "+brand);

    }



}