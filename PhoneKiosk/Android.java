package PhoneKiosk;

public class Android extends Phone {

	// Private final instance variables
    private final String MANUFACTURER = "Samsung"; // Manufacturer of the phone
    private final String BRAND = "Note 8";		   // Model of the phone
    
    // Private instance variabe
    private Carrier carrier;					   // Carrier of the phone

    // Method to initialize the carrier string and if they're a Canadian member
    public void initialize(String carrier, boolean memberCA) 
    {
    	if (memberCA) // If customer is a Canadian member
        {
    	this.carrier.setMonthlyCostBase(50.00); // Monthly cost base for Canadian members
        } 
    	else // If not Canadian member
    	{
    		switch (carrier) // Switch statement based on who their carrier is
    		{
    			case "Verizon": // If carrier is Verizon
    			{
    				this.carrier.setSetupCostBase(20.00); // set the base setup cost
                    this.carrier.setMonthlyCostBase(65.00); // set the base monthly base cost
                    break;
                } // end of Verizon case

                case "AT&T": // If carrier is AT&T
                {
                    this.carrier.setSetupCostBase(20.00);	// set the base setup cost
                    this.carrier.setMonthlyCostBase(60.00); // set the base monthly base cost
                    break;
                } // end of AT&T case

                case "T-Mobile": // If carrier is T-Mobile
                {
                    this.carrier.setSetupCostBase(10.00);	// set the base setup cost
                    this.carrier.setMonthlyCostBase(60.00); // set the base monthly base cost
                    break;
                } // end of T-Mobile case

                default: // Default case
                {
                	System.out.println("Unknown Carrier. Try Again.%n");
                    break;
                } // end of Default case

            } // end of carrier switch

        } // end of if else statement

    } // end of initialize

    public Android(String carrier) // Contructor for Android device
    {
        switch (carrier) // Switch based on who their carrier is
        {
            case "Verizon":  // If carrier is Verizon
            {
                this.carrier = new Verizon(); // Create a Android object with costs of Verizon
                break;
            } // End of Verizon case

            case "AT&T": // If carrier is AT&T
            {
                this.carrier = new ATandT(); // Create a Android object with costs of AT&T
                break;
            } // End of AT&T case

            case "T-Mobile": // If carrier is T-Mobile
            {
            	this.carrier = new Tmobile(); // Create a Android object with costs of T-Mobile
                break;
            } // End of T-Mobile case

            default: // Default case - If input does not match any carriers above
            {
                System.out.println("Unknown PhoneKiosk.Carrier. Try Again.%n"); // Print error message
                break;
            } // End of default case

        } // end of carrier switch

    } // End of Android device contructor

    @Override
    // Overriden toString method which displays the MANUFACTURER + BRAND and carrier
    public String toString() {
        return MANUFACTURER + " " + BRAND + " on " + carrier.toString();
    } // end of toString method
} // end of Android class
