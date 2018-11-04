/*
 * Name: Adam Mohr
 * Student ID: 040669681
 * Course & Section: CST8132 301
 * Assignment: Lab 3
 * Date: Oct 2, 2018
 */

public class Client {

	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;

	public Client(String firstName, String lastName, long phoneNum, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getName() {
		// Not a true getter. Concatenates first and last names.
		return firstName + " " + lastName;
	}

	public String getEmail() {
		return email;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

}
