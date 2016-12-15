/*
 * Tests class Contacts by calling all methods on a Contact object.
 */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class TestContactList {
	public static void main(String args[]) {
	    
	    /*
		 *  Create new list and add the new person to the Contact List
		 */
		ContactList contactList = new ContactList();
		try { // CD
			FileInputStream fis = new FileInputStream("output"); // CD
			ObjectInputStream ois = new ObjectInputStream(fis); // CD
			contactList = (ContactList)ois.readObject(); // CD
			fis.close(); // CD
			ois.close(); // CD
		} catch(Exception ex) {} // CD
		/*
		 * Create a new person object
		 * Adds person to the list
		 */
     contactList.runLoop();
        
		try {  // CD
			FileOutputStream fos = new FileOutputStream("output");  // CD
			ObjectOutputStream oos = new ObjectOutputStream(fos);  // CD
			oos.writeObject(contactList); // CD
			oos.close(); // CD
		} catch(Exception ex) { // CD
			ex.printStackTrace(); // CD
		}
	}
}

