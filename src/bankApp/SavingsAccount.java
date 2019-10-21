package bankApp;

public class SavingsAccount extends Account {	
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	public SavingsAccount(String name, int SSN, AccountType type, double initDeposit) {
		super(name, SSN, type, initDeposit);
		super.number = Long.parseLong("1" + Long.toString(super.number));
		setSafetyDepositBox();
	}
	
	@Override
	public void setRate() {
		this.rate = IRate.getBaseRate() * .25;
	}
	
	@Override
	public String showInfo() {
		String s = super.showInfo();
		s += "\nSafety Deposit Box ID: " + this.safetyDepositBoxID + "\n"
				+ "Safety Deposit Box Key: " + this.safetyDepositBoxKey;
		return s;
	}
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
}
