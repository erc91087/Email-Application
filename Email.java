package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String id;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;
	private int defaultPasswordLength = 8;
	private int defaultIDLength = 6;
	private String alternateEmail;
	private String companySuffix = "codecompany.com";
	
		// Constructor to receive first & last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMPLOYEE NAME: " + this.firstName + " " + this.lastName);
		
			// Call a method asking for department - return the department
		this.department = setDepartment();
//		System.out.println("\nDepartment: " + this.department);
		
			// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
//		System.out.println("\nYour password is: " + this.password);
		
			// Call a method that returns a random ID
		this.id = randomID(defaultIDLength);
		
			// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
//		System.out.println("Your email is: " + email);
		
	}
	
		// Ask for the department
	private String setDepartment() {
		System.out.print("\nDEPARTMENT CODES:\n1: Human Resources"
				+ "\n2: Development"
				+ "\n3: Accounting"
				+ "\n4: Sales"
				+ "\n5: Customer Service"
				+ "\n0: None"
				+ "\n\nEnter Department Code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		
		if (depChoice == 1) { return "human_resources"; }
		else if (depChoice == 2) { return "development"; } 
		else if (depChoice == 3) { return "accounting"; }
		else if (depChoice == 4) { return "sales"; }
		else if (depChoice == 5) { return "customer_service"; }
		else { return ""; }
	}
	
		// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%";
		char[] password = new char[length];
		
		for (int i = 0; i < length; i++) {
			int random = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(random);
		}
		return new String(password);
	}
	
		// Generate a random ID
	private String randomID(int length) {
		String idSet = "0123456789";
		char[] id = new char[length];
		
		for (int i = 0; i < length; i++) {
			int random = (int) (Math.random() * idSet.length());
			id[i] = idSet.charAt(random);
		}
		return new String(id);
	}
	
		// Set the mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
		// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
		// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
		// Get methods
	public int getMailBoxCapacity() {
		return mailBoxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "\nEmployee Information: " +
				"\n\nDISPLAY NAME: " + firstName + " " + lastName + 
				"\nID: " + id +
				"\nCOMPANY EMAIL: " + email + 
				"\nPASSWORD: " + password +
				"\nMAILBOX CAPACITY: " + mailBoxCapacity + " e-mails";
	}
	

}
