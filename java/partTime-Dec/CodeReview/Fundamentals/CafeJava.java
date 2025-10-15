public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 6;
        double dripCoffee = 7;
        double latte = 8 ;
        double cappuccino= 11 ; 
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2= "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println( isReadyOrder1 ? generalGreeting + customer1 +readyMessage : generalGreeting + customer1 + pendingMessage );// Displays "Welcome to Cafe Java, Cindhuri"
        
    	// ** Your customer interaction print statements will go here ** //
        // Displays "Welcome to Cafe Java, Noah" And Her order
        System.out.println(isReadyOrder4? generalGreeting + customer4 + readyMessage +" And "+ displayTotalMessage + cappuccino :generalGreeting + customer4 + pendingMessage);
        //Displays "Welcome to Cafe Java, Sam" And Her Order
        System.out.println(isReadyOrder2? generalGreeting + customer2 + readyMessage +" And "+ displayTotalMessage + latte*2 :generalGreeting + customer4 + pendingMessage);
        if (isReadyOrder2) {
            isReadyOrder2=false;
        }else{
            isReadyOrder2=true;
        }
        System.out.println(displayTotalMessage + " $" + (latte - dripCoffee ) );

    }
}
