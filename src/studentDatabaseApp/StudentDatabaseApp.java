package studentDatabaseApp;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		System.out.println("<---| Student Database Manager |--->");
		System.out.println("How many students do you want to add?");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		for (int i = 0; i < n; i++) {
			System.out.println("\nName: ");
			String name = sc.nextLine().trim();
			
			System.out.println("\nYear: ");
			int year = sc.nextInt();
			
			Student s = new Student(name, year);
			students.add(s);
		}
	}

}
