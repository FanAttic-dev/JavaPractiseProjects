package bankApp;

public class CheckingAccount extends Account {
	private int debitCardNumber;
	private int debitCardPIN;
	
	public CheckingAccount(String name, int SSN, AccountType type, double initDeposit) {
		super(name, SSN, type, initDeposit);
		super.number = Long.parseLong("2" + Long.toString(super.number));
		
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		this.rate = IRate.getBaseRate() * .15;
	}
	
	@Override
	public String showInfo() {
		String s = super.showInfo();
		s += "\nDebit Card Number: " + this.debitCardNumber + "\n"
				+ "Debit Card PIN: " + this.debitCardPIN;
		return s;
	}
	
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}
}
