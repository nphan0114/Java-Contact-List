/*
 * One object of this class represents all the information about one Contact
 */
import java.io.Serializable;
import java.util.Scanner;
public class Contact implements Comparable<Contact>, Serializable{
	private static final long serialVersionUID = 2662639432896452056L;
	private String fName;
	private String lName;
	private String phoneNumber;
	private String email;
	private String note;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private transient Scanner read = new Scanner(System.in);
	
	/*
	 * Prompt user for contact info then stores.
	 */
	protected void read() {
		System.out.print("First Name: "); // NP
        fName = read.nextLine(); // NP
        System.out.print("Phone Number: "); // NP
        phoneNumber = read.nextLine(); // NP
		System.out.print("Street Address: "); // NP
		address = read.nextLine(); // NP
		System.out.print("City: "); // NP
		city = read.nextLine(); // NP
		System.out.print("State: "); // NP
		state = read.nextLine(); // NP
		System.out.print("ZipCode: "); // NP
		zipcode = read.nextLine(); // NP
        System.out.print("E-Mail: "); // NP
        email = read.nextLine(); // NP
        System.out.print("Note: "); // NP
        note = read.nextLine(); // NP
	}
	
	/*
	 *  Gets value for first name
	 *  Need for sorting purpose
	 */
	protected String getFirstName(){
		return fName; // NP
	}
	
	/*
	 *  Gets value for last name
	 *  Need for sorting purpose
	 */
	protected String getLastName(){
		return lName; // NP
	}
	
	/*
	* Sets value for Last name
	* For loop condition purpos
	*/
	protected void setLastName() {
		System.out.print("Last Name*: "); // NP
		lName = read.nextLine(); //NP
	}
	
	/*
	 * Returns a formatted Contact info. 
	 */
	public String toString() {
		// First Last
		// Phone
		// Street Address
		// City, State ZipCode
		// Email
		// Notes
		String contact = String.format(
				"%s %s\n%s\n%s\n%s, %s %s\n%s\n%s", fName, lName, phoneNumber, address, city, state, zipcode, email, note); // NP	
		return contact;
	}
	
	/*
	 * compares the size of two different objects (specifically last name values) and returns 
	 * a corresponding integer value based upon the alphabetical assortion of the two values
	 */
	public int compareTo(Contact contact) { // YE
		int byLastName = this.lName.compareToIgnoreCase(contact.getLastName()); // YE
		if (byLastName == 0) { // YE
			return this.fName.compareToIgnoreCase(contact.getFirstName()); // YE
			} 
		return byLastName; // YE

	}
}

