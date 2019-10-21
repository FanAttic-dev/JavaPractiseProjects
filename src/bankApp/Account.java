package bankApp;

import java.util.Random;

public abstract class Account implements IRate {
	private static int uniqueNum = 10000;
	
	private final String name;
	private final int SSN;
	private double balance;
	protected long number;
	protected double rate;
	private final AccountType type;
	
	public Account(String name, int SSN, AccountType accountType, double initDeposit) {
		this.name = name;
		this.SSN = SSN;
		this.balance = initDeposit;
		this.type = accountType;
		
		this.number = generateNumber();
		this.setRate();
	}
	
	public abstract void setRate();
	
	public boolean deposit(double value) {
		System.out.print("\n\tDeposit of $" + value + " to " + this.name + " ... ");
				
		if (value < 0) {
			System.out.println("FAILED");
			return false;
		}
		
		this.balance += value;
		System.out.println("SUCESSFUL");
		return true;
	}
	
	public boolean withdraw(double value) {
		System.out.print("\n\tWithdrawal of $" + value + " from " + this.name + " ... ");
		
		if (this.balance - value < 0) {
			System.out.println("FAILED");
			return false;
		}
		
		this.balance -= value;
		System.out.println("SUCESSFUL");
		return true;
	}
	public boolean transfer(Account other, int value) {
		System.out.print("Transaction of $" + value + " from " + this.name + " to " + other.name + " ... ");
		
		if (value < 0) {
			System.out.println("FAILED");
			return false;
		}
		
		if (!this.withdraw(value)) {
			System.out.println("FAILED");
			return false;
		}
		
		other.deposit(value);
		System.out.println("SUCESSFUL");
		return true;
	}
	
	public String showInfo() {
		return "Name: " + this.name + "\n"
				+ "Account type: " + this.type.toString() + "\n"
				+ "SSN: " + this.SSN + "\n"
				+ "Balance: " + this.balance + "\n"
				+ "Account number: " + this.number + "\n"
				+ "Rate: " + this.rate;
	}
	
	private long generateNumber() {
		String n = "";
		
		n += Integer.toString(this.SSN % 100);
		
		n += Account.uniqueNum;
		++Account.uniqueNum;
		
		Random r = new Random();
		n += Integer.toString(Math.abs(r.nextInt(1000)));
		
		return Long.parseLong(n);
	}
}
