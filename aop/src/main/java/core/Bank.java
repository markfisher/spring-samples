package core;

public interface Bank {

	void debit(String accountId, double amount);

	void credit(String accountId, double amount);

}
