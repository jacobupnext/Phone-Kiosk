package PhoneKiosk;

public class Moto extends Phone {

	// Private final instance variables
    private final String MANUFACTURER = "Motorola";
    private final String BRAND = "Moto G";

    // Private instance variable
    private Carrier carrier;

    // Method to initialize the instance variables
    // For moto there is only a single rate structure 
    //regardless of CA member or not, which consists of $20 base and $70/month
    // There is no need for if else statement compared to Android/IPhone
    @Override
    public void initialize(String carrier, boolean memberCA) 
    {
        this.carrier.setSetupCostBase(20.00); // Base cost setup of the Moto
        this.carrier.setMonthlyCostBase(70.00); // Base cost per month for Moto
    } // End of initalization

    public Moto(String carrier) // Create a Moto device and assign the carrier
    {
        switch (carrier) // Switch dependent on their carrier
        {
            case "Verizon": // If Carrier is Verizon
            {
                this.carrier = new Verizon(); // Create Moto phone with Verizon costs
                break;
            } // End of Verizon case
            
            case "AT&T": // If Carrier is AT&T
            {
                this.carrier = new ATandT(); // Create Moto phone with AT&T costs
                break;
            } // end of AT&T Case
            
            case "T-Mobile": // If Carrier is T-Mobile
            {
                this.carrier = new Tmobile(); // Create Moto phone with T-Mobile costs
                break;
            } // end of T-Mobile case
            
            default: // Default case
            {
                System.out.println("Unknown Carrier. Try Again.%n");
                break;
            } // end of default case

        } // end of carrier case

    } // end of create Moto device and assign to carrier

    // Overriden toString method which displays the MANUFACTURER + BRAND and carrier
    @Override
    public String toString() {
        return MANUFACTURER + " " + BRAND + " on " + carrier.toString();
    } // end of overriden toString method

} // end of Moto class