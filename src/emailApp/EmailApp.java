package emailApp;

public class EmailApp {

	public static void main(String[] args) {
		Email e = new Email("John", "Smith");
		e.defineAlternativeAddress("john.smith@outlook.com");
		System.out.println(e.toString());
	}
}
