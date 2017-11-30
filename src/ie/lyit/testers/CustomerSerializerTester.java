
/**
 * Class: B.Sc. in Computing
 * Instructor: Maria Boyle
 * Description: Models a CustomerSerializerTester
 * Date: 13/11/2017
 * @author Jamie Kennedy
 * StudentNumber L00129853
 * @version 1.0
**/

package ie.lyit.testers;

import java.util.Scanner;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {

	public static void main(String[] args) {
		// gathers info from customerSerializer singleinstance 
		CustomerSerializer customerSerializer = CustomerSerializer.getSingleInstance();
		int option = 0;

		// Deserialize the ArrayList from the File,
		// i.e. read the customers ArrayList from the file back into the ArrayList
		customerSerializer.readRecordsFromFile();
		Scanner keyboardIn = new Scanner(System.in);
		// pop up add goes to main screen if you dont add this
		customerSerializer.add();
		// Create a Menu Object
		// do/while to loop around the menu
		do {

			System.out.println("\t1. Add");
			System.out.println("\t2. List");
			System.out.println("\t3. View");
			System.out.println("\t4. Edit");
			System.out.println("\t5. Delete");
			System.out.println("\t6. Quit");
			System.out.println("Enter option:");
			option = keyboardIn.nextInt();
			// switch on the option and call the appropriate method
			switch (option) {
			case 1:
				customerSerializer.add();
				break;
			case 2:
				customerSerializer.list();
				break;
			case 3:
				customerSerializer.view();
				break;
			case 4:
				customerSerializer.edit();
				break;
			case 5:
				customerSerializer.delete();
				break;
			case 6:
				break;
			default:
				System.out.println("INVALID OPTION...");
			}

		} while (option != 6);

		// Serialize the ArrayList to the File
		// i.e. write the customers ArrayList back into the the file
		customerSerializer.writeRecordsToFile();
		keyboardIn.close();
	}

}
