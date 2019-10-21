package utils;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import bankApp.Account;
import bankApp.AccountType;
import bankApp.CheckingAccount;
import bankApp.SavingsAccount;

public class CSV {
	
	public static LinkedList<Account> read(String path) throws IOException {
		BufferedReader csvReader = new BufferedReader(new FileReader(path));
		
		LinkedList<Account> accounts = new LinkedList<>();
		
		String row;
		try {
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    if (data.length != 4) {
			    	throw new IOException("Wrong file format");
			    }
			    
			    Account a = null;
			    AccountType accType = null;
			    String accTypeStr = data[2].toLowerCase();
			    
			    switch(accTypeStr) {
			    case "checking":
			    	accType = AccountType.CHECKING;
			    	a = new CheckingAccount(data[0], Integer.parseInt(data[1]), accType, Double.parseDouble(data[3]));
			    	break;
			    case "savings":
			    	accType = AccountType.SAVINGS;
			    	a = new SavingsAccount(data[0], Integer.parseInt(data[1]), accType, Double.parseDouble(data[3]));
			    	break;
		    	default:
		    		throw new IOException("Invalid account type");
			    }			    
			    accounts.add(a);
			}
		} catch(IOException ex) {
			throw new IOException(ex);
		} finally {
			csvReader.close();
		}
		
		return accounts;
	}
}
