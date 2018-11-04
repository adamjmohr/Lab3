import java.util.Scanner;
import java.text.DecimalFormat;

/*
 * Name: Adam Mohr
 * Student ID: 040669681
 * Course & Section: CST8132 301
 * Assignment: Lab 3
 * Date: Oct 2, 2018
 */

public class Bank {

	private String bankName;
	private Account[] accounts;
	private Scanner input;

	public Bank() {
		// Initialize Scanner and prompts for input.
		this.input = new Scanner(System.in);

		System.out.print("Bank name: ");
		this.bankName = input.nextLine();

		// Based on input - initializes accounts array with proper length.
		System.out.print("Number of accounts: ");
		this.accounts = new Account[input.nextInt()];
		/*
		 * try { this.accounts = new Account[input.nextInt()]; } catch
		 * (NumberFormatException e) {
		 * System.out.print("Invalid input. Number of accounts: "); input.reset(); }
		 */

		for (int i = 0; i < accounts.length; i++) {
			// Prompts for input to satisfy the number of accounts.
			System.out.print("Client first name: ");
			String firstName = input.next();

			System.out.print("Client last name: ");
			String lastName = input.next();

			System.out.print("Client phone number: ");
			long phoneNum = input.nextLong();

			System.out.print("Client email address: ");
			String email = input.next();

			// Uses instance variables to generate a new Client using parameterized
			// constructor.
			Client client = new Client(firstName, lastName, phoneNum, email);

			System.out.print("Opening balance: ");
			double balance = input.nextDouble();

			// Uses instance variables to generate new Account for each one in array.
			Account account = new Account(client, balance);
			accounts[i] = account;

		}

	}

	public void printAccounts() {
		DecimalFormat df = new DecimalFormat("0.00");

		// Prints out Account info for every Account in the array using for-each loop.
		for (Account account : accounts) {
			System.out.println(
					account.getName() + ", " + account.getClient().getEmail() + ", " + account.getClient().getPhoneNum()
							+ ", " + account.getAccountNum() + ", " + "$" + df.format(account.getBalance()));
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");

		Bank bank = new Bank();

		System.out.println();
		System.out.println("P or p: printAccounts");
		System.out.println("W or w: withdraw from account");
		System.out.println("D or d: deposit into account");
		System.out.println("Q or q: quit program");

		// boolean checks to see if loop is running.
		boolean running = true;
		while (running) {

			System.out.print("Enter input: ");
			// Converts input to lower case.
			String userInput = input.nextLine().toLowerCase();

			// Reset input after every loop iteration.
			//input.reset();

			// Switch statement to determine what to do with input and what info to prompt for.
			switch (userInput) {
			case "p": {
				bank.printAccounts();
				break;
			}
			case "w": {
				System.out.print("Index of account: ");
				int accountIndex = input.nextInt();

				System.out.print("Amount to withdraw: ");
				double withdrawAmount = input.nextDouble();

				// Checks to see if there are sufficient funds to withdraw successfully.
				if (!bank.accounts[accountIndex].withdraw(withdrawAmount)) {
					System.out.println(
							"Insufficient Funds! Balance is $" + df.format(bank.accounts[accountIndex].getBalance()));
				}
				break;
			}
			case "d": {
				System.out.print("Index of account: ");
				int accountIndex = input.nextInt();

				System.out.print("Amount to deposit: ");
				double depositAmount = input.nextDouble();

				// Deposits money into account at certain index in array.
				bank.accounts[accountIndex].deposit(depositAmount);
				break;
			}

			// If input equals q, boolean turns false and program terminates.
			case "q": {
				running = false;
				break;
			}

			}
		}
		input.close();
	}
}
