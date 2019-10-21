package emailApp;

import java.util.Random;
import emailApp.Department;

public class Email {
	private final String company = "Microsoft";
	
	private final String firstName;
	private final String lastName;
	private final String address;
	private Department department;
	private int passwordLength;
	private String password;
	private int mailboxCapacity = 500;
	private String alternativeAddress = "";
	
	public Email(
			String firstName, 
			String lastName,
			String department) {
		// Set the names
		if (firstName == null || firstName.isEmpty()
				|| lastName == null || lastName.isEmpty()) {
			throw new IllegalArgumentException("Invalid username");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Set the email address
		String addr = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@";
		
		checkDepartment(department);
		if (this.department != Department.NONE) {
			addr += department.toLowerCase() + ".";
		}
		
		addr += company.toLowerCase() + ".com";
		this.address = addr;
		
		// Generate the password
		this.password = generatePassword();
	}
	
	public Email(
			String firstName,
			String lastName) {
		this(firstName, lastName, null);
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword; 
	}
	
	public void setMailboxCapacity(int newCapacity) {
		this.mailboxCapacity = newCapacity;
	}
	
	public void defineAlternativeAddress(String address) {
		this.alternativeAddress = address;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getCapacity() {
		return this.mailboxCapacity;
	}
	
	private String generatePassword() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
		
		Random r = new Random();
		this.passwordLength = r.nextInt(10) + 5;
		StringBuilder sb = new StringBuilder(this.passwordLength);
		
		for (int i = 0; i < this.passwordLength; i++) {
			int index = r.nextInt(AlphaNumericString.length());
			sb.append(AlphaNumericString.charAt(index));
		}
		
		return sb.toString();
	}
	
	private void checkDepartment(String department) {
		if (department == null) {
			this.department = Department.NONE;
		} else {
			department = department.toLowerCase();
			if (department.equals(Department.ACCOUNTING.toString().toLowerCase())) {
				this.department = Department.ACCOUNTING;
			} else if (department.equals(Department.DEVELOPMENT.toString().toLowerCase())) {
				this.department = Department.DEVELOPMENT;
			} else if (department.equals(Department.SALES.toString().toLowerCase())) {
				this.department = Department.SALES;
			} else {
				this.department = Department.NONE;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() + "\n"
				+ "Address: " + getAddress() + "\n"
				+ (this.alternativeAddress != "" ? "Alternative address: " + this.alternativeAddress + "\n" : "")
				+ "Department: " + this.department.toString().toLowerCase() + "\n"
				+ "Password: " + this.password + "\n";
	}
}
