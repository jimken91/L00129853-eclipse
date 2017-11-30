package ie.lyit.serialize;

import ie.lyit.hotel.Customer;

public interface CustomerDao {

	public void readRecordsFromFile();

	public void writeRecordsToFile();

	public void add();

	public void list();

	public Customer view();

	public void edit();

	public void delete();

}
