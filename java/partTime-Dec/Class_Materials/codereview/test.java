package codereview;

public class test {
    public static void main(String[] args) {

        String myStr1 = "Hello";
        String myStr2 = "Hello";
        String myStr3 = new String("Hello");
        System.out.println(myStr1 == myStr2); // compares the memory location of two objects, while "equals" compares the contents of two objects.
        System.out.println(myStr1.equals(myStr2)); // Returns true because they are equal
        System.out.println(myStr1==myStr3); // false
        

    }
}
