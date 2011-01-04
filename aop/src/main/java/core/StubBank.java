package core;

public class StubBank implements Bank {

	public void debit(String accountId, double amount) {
		System.out.println("debit " + amount + " from " + accountId);
	}

	public void credit(String accountId, double amount) {
		System.out.println("credit " + amount + " to " + accountId);
	}

}
