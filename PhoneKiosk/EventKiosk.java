package PhoneKiosk;

import java.util.ArrayList;  // Importing Array List utility
import java.util.Scanner;	// Importing Scanner utility

/**@author Jacob Barnard
 * CMSY-166-001
 * Program Description:
 * This program gets user input for if a customer is wanting to buy a new  phone, then asks if they are a Canadian
 * Member. If they're a Canadian member they pay no setup cost and a monthy cost of $50.00. If they're not a Canadian
 * member they are charged different setup/monthly costs based on who their carrier and device maker. If the device is a
 * Moto it goes on a single rate structure regardless of if they're a canadian member or not. This program gets all of
 * this information and puts it into an array list to then get displayed when their is no more customers wanting
 * to buy a new phone.
 * Due: 5/12/2020 12:00 AM
 */

public class EventKiosk {


	public static void main(String[] args) {
		// Instance variables
		boolean memberCA = false;   // if the member is a Canadian customer
		String newPhone = "";		// value to hold the model
		String newCarrier = "";		// value to hold the name of Carrier

		ArrayList<Phone> newCustomers = new ArrayList<>();	// Create an array list

	// Ask user if there is a customer
	System.out.println("Is there a customer wanting to buy a new phone? (Y/N): ");
	
	Scanner input = new Scanner(System.in);		// Instaniating a Scanner object
	
	// input validation for when user enters 'Y' or 'y'
	while (input.nextLine().equalsIgnoreCase("y")) {
	
	// Ask if the user is a Canadian member
	System.out.println("Is the customer a CA member? (Y/N): ");
	
	// If user enters 'y' or 'Y' memberCA becomes true
	memberCA = (input.nextLine().equalsIgnoreCase("y"));
	
	// Prompt user for their type of phone
	System.out.println("What type of phone (iPhone, Android, or Moto): ");
	
	// Set the user input as newPhone String
	newPhone = input.nextLine();
	
	// Prompt user for the carrier
	System.out.println("What carrier? (Verizon, AT&T, or T-Mobile): ");
	
	// Set the user input equal to newCarrier String
	newCarrier = input.nextLine();
	
		// Switch statement dependent on the newPhone String value
		switch (newPhone) {
		
		// when newPhone = iPhone
		case "iPhone": 
			{
			
			// Create an iPhone object with their carrier
			Phone nextPhone = new IPhone(newCarrier);
			
			// Initializing the carrier and if they're a Canadian member
			nextPhone.initialize(newCarrier, memberCA);
			
			// Add phone to the Array list
			newCustomers.add(nextPhone);
		break;
		} // end of iPhone case
		
		// when newPhone = Android
		case "Android": {
			
			// Create a new Android phone object
			Phone nextPhone = new Android(newCarrier);
			
			// Initialize the Android object based on carrier/if Canadian member
			nextPhone.initialize(newCarrier, memberCA);
			
			// Add the phone to the array list
			newCustomers.add(nextPhone);
		break;
		} // end of Android case
		
		// When newPhone = Moto
		case "Moto": {
		
			// Create a new Moto phone object
		    Phone nextPhone = new Moto(newCarrier);
		
		    nextPhone.initialize(newCarrier, memberCA);
		
		    newCustomers.add(nextPhone);
		    break;
		} // end of Moto case
		
		// Default case incase the value doesn't match any of the above
		default: {
		
		    System.out.println("Unrecognized phone. Try Again."); // Print error message for unrecongnized phones
		break;
		} // end of default case
		
	} // end of newPhone switch
		
		// Prompt user if there is another customer
		System.out.println("Is there a customer wanting to buy a new phone? (Y/N): ");
	
	    } // end of while loop
	
	    displayReport(newCustomers); // Call on the displayReport method to display the array list
	    input.close(); // Close the input stream
	
	} // end of main method
	
	// Method to display the report
	public static void displayReport(ArrayList<Phone> newCustomers) {
	
	//          /* Program Header*/
	    System.out.printf("%s%n%s%n%s%n%n",
	
	"==========================================================",
	
	"= Columbia 50th Annversary Phone Signup Drive =",
	
	"==========================================================");
	
	System.out.println("New Customers:\n"); // Display new customers title
	
	// Enhanced loop for iterating over the collection
	// (Phones to newCustomers)
	for (Phone phone : newCustomers) {
	
		// Print from the toString method (manufacturer + brand + cost)
	    System.out.printf("%s%n", phone.toString());
	
	} // end of for loop
	
} // end of display report

} // end of eventKiosk class