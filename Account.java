import java.util.Random;

/*
 * Name: Adam Mohr
 * Student ID: 040669681
 * Course & Section: CST8132 301
 * Assignment: Lab 3
 * Date: Oct 2, 2018
 */

public class Account {

	private long accountNum;
	private Client client;
	private double balance;

	public Account(Client client, double balance) {
		this.client = client;
		this.balance = balance;
		
		// Generates random long value for accountNum.
		Random random = new Random();
		this.accountNum = random.nextLong();
	}

	public void deposit(double amt) {
		this.balance += amt;
	}

	public boolean withdraw(double amt) {
		// Checks to see if there is sufficient balance to withdraw. If not, returns false.
		if (this.balance < amt) {
			return false;
		} else {
			this.balance -= amt;
			return true;
		}
	}

	public long getAccountNum() {
		return accountNum;
	}

	public Client getClient() {
		return client;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		// Calls Client's getName() method.
		return client.getName();
	}

}
