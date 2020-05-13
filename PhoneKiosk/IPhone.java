package PhoneKiosk;


public class IPhone extends Phone {

	// Final private instance variables
    private final String MANUFACTURER = "Apple";  // Manufacturer of the phone
    private final String BRAND = "iPhone 10";	  // Model of the phone
    
    // private instance variable calling on the carrier class
    private Carrier carrier;

    // Method to initialize the carrier string and if they're a Canadian member
    @Override
    public void initialize(String carrier, boolean memberCA) {
        
    	if (memberCA)	// If they're a Canadian member
        {
            this.carrier.setMonthlyCostBase(50.0); // Set the monthly cost base for Canadian members

        } 
    	else // If they're not a canadian member
    	{
    		switch (carrier) // Switch statement based on the users carrier
    		{
                case "Verizon": // If carrier is Verizon
                {	
                	
                    this.carrier.setSetupCostBase(20.00); // Set the base setup cost for Verizon
                    this.carrier.setMonthlyCostBase(70.00); // Set the base monthly cost for Verizon
                    break;
                } // end of Verizon case

                case "AT&T": // If carrier is AT&T
                {		
                    this.carrier.setSetupCostBase(15.00); // Set the base setup for AT&T
                    this.carrier.setMonthlyCostBase(60.00); // Set the base monthly cost for AT&T
                    break;
                } // end of AT&T case

                case "T-Mobile": // If carrier is T-Mobile
                {
                	this.carrier.setSetupCostBase(10.00); // Set the base setup for T-Mobile
                	this.carrier.setMonthlyCostBase(60.00);	// Set the base monthly cost for T-Mobile
                    break;
                } // End of T-Mobile case

                default: // Default case incase the carrier value does not match any listed above.
                { 
                    System.out.println("Unknown Carrier. Try Again.%n"); // Display Error message
                    break;
                } // End of Default Case

            } // End of Carrier switch

        } // End of if else statement for if canadian member

    } // end of Initialize method

    public IPhone(String carrier) // Constructor for iPhone
    {
    	switch (carrier)  // Switch based on who their carrier is
    	{
            case "Verizon": // If carrier is Verizon
            {
            	this.carrier = new Verizon(); // creater a iPhone object with properties of Verizon
            	break;
            } // end of Verizon case

            case "AT&T": // If carrier is AT&T
            {
            	this.carrier = new ATandT(); // Create a IPhone object with properties of AT&T
                break;
            } // end of AT&T case

            case "T-Mobile": // If carrier is T-Mobile
            {
            	this.carrier = new Tmobile(); // Create a iPhone object with properties of T-Mobile
            	break;
            } // end of T-Mobile case

            default: // Default case
            {
                System.out.println("Unknown Carrier. Try Again.%n");
                break;
            } // end of default case

        } // end of carrier switch
    	
    } // end of Carrier contructor


    // Overriden toString method which displays the MANUFACTURER + BRAND and carrier
    @Override
    public String toString() {
        return MANUFACTURER + " " + BRAND + " on " + carrier.toString();
    
    } // end of toString method

} // end of iPhone class
