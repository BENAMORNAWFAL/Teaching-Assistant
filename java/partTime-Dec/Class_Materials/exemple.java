class exemple {
    private String name;
    private int age;


    public void Display(){
        System.out.printf("the name is ",name , "and the age is ",age);
    }

    // Getters and Setters
    public String getName(){
        return this.name;
    }
    public String setName(String name){
        return this.name=name;
    }
}