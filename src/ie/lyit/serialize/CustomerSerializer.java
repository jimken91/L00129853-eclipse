/**
 * Class: B.Sc. in Computing
 * Instructor: Maria Boyle
 * Description: Models a CustomerSerializer
 * Date: 13/11/2017
 * @author Jamie Kennedy
 * StudentNumber L00129853
 * @version 1.0
**/

package ie.lyit.serialize;

import java.util.Scanner;
import ie.lyit.hotel.Customer;
import java.util.ArrayList;
import java.io.*;

public class CustomerSerializer implements CustomerDao {
	// Construct customerList ArrayList
	private ArrayList<Customer> customers;

	private final String FILENAME = "customers.ser";
	//static singleinstance holds one instance of the class
	private static CustomerSerializer singleInstance;

	
	//private constructor - prevents other classes from creating objects
	private CustomerSerializer() {
		System.out.println("OK-Inside CustomerSerializer class constructor...");
		// Construct CustomerList ArrayList
		customers = new ArrayList<Customer>();
	}

	public static CustomerSerializer getSingleInstance() {
		if (singleInstance == null) {
			singleInstance = new CustomerSerializer();
			System.out.println("OK-single object created:" + singleInstance);
		}
		return singleInstance;

	}

	public void displaySingleton() {
		System.out.println("CustomerSerializer object:" + singleInstance);
	}

	public void add() {
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();
		// And add it to the customers ArrayList
		customers.add(customer);
	}

	public void list() {
		// for every Customer object in customers
		for (Customer tmpCustomer : customers)
			// display it
			System.out.println(tmpCustomer);

	}

	// This method will serialize the customers ArrayList when called,
	// i.e. it will write it to a file called books.ser

	public Customer view() {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		// Read the number of the Customer to be viewed from the user
		System.out.println("ENTER NUMBER OF CUSTOMER : ");
		int customerToView = keyboard.nextInt();

		// for every Customer object in customers
		for (Customer tmpCustomer : customers) {
			// if it's number equals the number of the customerToView
			if (tmpCustomer.getNumber() == customerToView) {
				// display it
				System.out.println(tmpCustomer);
				return tmpCustomer;

			}

		}

		// if we reach this code the customer was not found so return null
		return null;
	}

	public void edit() {
		// Call view() to find, display, & return the customer to edit
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
		if (tempCustomer != null) {
			// get it's index
			int index = customers.indexOf(tempCustomer);
			// read in a new customer and...
			tempCustomer.read();
			// reset the object in customers
			customers.set(index, tempCustomer);
		}
	}

	public void delete() {
		// Call view() to find, display, & return the customer to delete
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
		if (tempCustomer != null)
			// ...remove it from customers
			customers.remove(tempCustomer);
	}

	// This method will serialize the customers ArrayList when called,
	// i.e. it will write it to a file called customers.ser
	public void writeRecordsToFile() {
		ObjectOutputStream os = null;
		try {
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);

			os = new ObjectOutputStream(fileStream);

			os.writeObject(customers);
		} catch (FileNotFoundException fNFE) {
			System.out.println("Cannot create file to customer list.");
		} catch (IOException ioE) {
			System.out.println(ioE.getMessage());
		} finally {
			try {
				os.close();
			} catch (IOException ioE) {
				System.out.println(ioE.getMessage());
			}
		}
	}

	// This method will deserialize the customers ArrayList when called,
	// i.e. it will restore the ArrayList from the file customers.ser
	@SuppressWarnings("unchecked")
	public void readRecordsFromFile() {
		ObjectInputStream is = null;

		try {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);

			is = new ObjectInputStream(fileStream);

			customers = (ArrayList<Customer>) is.readObject();
		} catch (FileNotFoundException fNFE) {
			System.out.println("Cannot create file to customer list.");
		} catch (IOException ioE) {
			System.out.println(ioE.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				is.close();
			} catch (IOException ioE) {
				System.out.println(ioE.getMessage());
			}
		}
	}

}
