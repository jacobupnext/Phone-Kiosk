package PhoneKiosk;


abstract public class Carrier {

    // Private instance variables
	private String name = "Unknown Carrier"; // Name of the carrier
    private double setupCostBase = 0.00;     // Base setup cost
    private double monthlyCostBase = 0.00;	 // Base monthly cost

    // Constructor for the carrier object
    public Carrier(String name) {
    	this.name = name;
    	
    } // end of carrier object constructor

    //         /*SET METHODS*/
    
    // Set method for the setupCostBase
    public void setSetupCostBase(double setupCostBase) 
    {

        this.setupCostBase = setupCostBase;
    } // end of setupCostBase
   
    // Set method for the base monthly cost base
    public void setMonthlyCostBase(double monthlyCostBase) 
    {
        this.monthlyCostBase = monthlyCostBase;
    } // end of setMonthlyCostBase
    
    //        /*End of set methods*/

    // Get method for the  name of the carrier
    public String getName() {

        return name;
    } // end of get carrier name

    @Override
    
    // To String method (Name of the carrier + cost of setup + 
    // the base setup cost + the monthly cost of the device)
    public String toString() {

        return (name + " - Setup cost: " + setupCostBase + ", Monthly cost: " + monthlyCostBase);
    } // end of toString method

} // end of Carrier class
