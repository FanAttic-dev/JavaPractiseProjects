package bankApp;

import java.io.IOException;
import java.util.LinkedList;

import utils.CSV;

public class BankAccountApp {

	public static void main(String[] args) throws IOException {		
		LinkedList<Account> accounts = CSV.read("C:\\Users\\attil\\Documents\\eclipse-workspace\\JavaProjects\\src\\bankApp\\NewBankAccounts.csv");
		
		for (Account a : accounts) {
			System.out.println(a.showInfo() + "\n\n--------------------\n");
		}
		
		accounts.get(0).withdraw(123.45);
		accounts.get(1).deposit(123.45);
		
		accounts.get(2).transfer(accounts.get(3), 500);
		accounts.get(4).transfer(accounts.get(5), 500);
	}
	
}
