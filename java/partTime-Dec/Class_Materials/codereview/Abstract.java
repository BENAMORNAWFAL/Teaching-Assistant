package codereview;

abstract class ShowRoomvehicle implements vehicle {
    private String brand;

    //constructer
    public ShowRoomvehicle(String brand){
        this.brand=brand;
    }

    public void displayInfo(){
        System.out.println("Brand: "+brand);
    }
}
