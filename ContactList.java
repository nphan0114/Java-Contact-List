/*
 * One object of this class represents all the contacts in the list.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ContactList implements Serializable{
	private static final long serialVersionUID = -2978556538540681687L; // Unique ID for saving to disk class
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private static transient Scanner read = new Scanner(System.in);
	
	/*
	 * Add a new contact to the list
	 */
	protected void addPerson(Contact newContact) {
		contacts.add(newContact); // NP
	}
	
	/*
	 * Returns a single contact's information to the console
	 */
	public String toString(){
		return contacts+""; // NP
	}
	/*
	 * Prints entire Contact list
	 */
	protected void printList(){
		int count = 1; // YE
		Collections.sort(contacts); // YE		
		for (Contact name : contacts) { // YE
			System.out.println("\n---Contact " + count++ + "---\n" + name); // YE
		}
	}
	
	/*
	 *  Look up contact by last name and prints their information 
	 *  to the console if a related contact is found. 
	 */
	protected void searchByLastName(String strToSearch){
	    int count = 1; // count purpose
		boolean found = false; // MM
		for (int i = 0; i < contacts.size(); i++) { // MM
			if (contacts.get(i).getLastName().toLowerCase().equals(strToSearch.toLowerCase())) { // MM
				Contact c = contacts.get(i); // MM
				System.out.println("\n---Contact " + count++ + "---\n" + c); // MM
				found = true; // MM
			}
		}
		if (found == false) // MM
			System.out.println("There is no one in the contact list with the given last name"); // MM
	}
	
	/*
	* Prints home menu
	*/
	protected void printMenu() {
		System.out.println("\n---Home Menu---\n"); // NP
		System.out.println("[1] Add contact\n[2] Print list\n[3] Search by last name\n[4] Quit program\n"); // NP
	}
	/*
	* Runs program with switch statement
	* for user to select task
	*/
	protected void runLoop() {
	    int option; // NP
		boolean run = true; // NP
		while(run) { // NP
			printMenu(); // NP
			option = choiceValidation(4); // NP
			switch(option) { // NP
				case 0: break; // restart loop  // NP
				case 1: Contact p = new Contact(); // NP
						p.setLastName();  // NP
						if(p.getLastName().isEmpty() || p.getLastName().matches("\\p{Blank}+")) { // NP
							System.out.println("Invalid entry. Try again."); // NP
							option = 0; // NP
							break; // NP
						}
				        p.read(); // NP
						addPerson(p); // NP
						break; // NP
				case 2: printList(); // NP
						break; // NP
				case 3: System.out.print("Please enter the last name you want to search for: " ); // MM
						String nameSearched = read.nextLine(); // MM
						searchByLastName(nameSearched); // MM
						break; // MM
				case 4: run = false; // quits program  // NP
			}
		}
	}
	/*
	 * Validate option selection
	 */
	protected int choiceValidation(int maxOption) {
		int option = 0;	 // NP
		System.out.print("Select Option: "); // NP
		try { // NP
			option = read.nextInt(); // NP
		} catch(InputMismatchException e) { // NP
		    // reset loop of non-int input // NP
			option = 0; // NP
		} finally { // NP
			read.nextLine(); // NP
			if (option > maxOption || option < 1 ) { // NP
				System.out.println("Invalid choice. Try again."); // NP
				option = 0; // NP
			}
		}
		return option; // NP
	}
}
