package studentDatabaseApp;

import java.util.ArrayList;

public class Student {
	private int ID;
	private String name;
	private int year;
	
	private ArrayList<Course> courses = new ArrayList<Course>();
	private double balance;
	
	public Student(String name, int year) {
		if (name == null || year < 1) {
			throw new IllegalArgumentException("Bad name or year");
		}
		
		this.name = name;
		this.year = year;
		
		this.ID = generateID();
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean payTuition() {
		return true;
	}
	
	public int generateID() {
		return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name: " + name + "\n"
				+ "ID: " + ID + "\n"
				+ "Courses enrolled: ");
		
		for (Course course : courses) {
			sb.append("\n\t" + course.toString().toLowerCase());
		}
		
		sb.append("\nBalance: " + balance);
		
		return sb.toString();
	}
}
