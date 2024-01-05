import java.util.Scanner;
public class ATM {
	private BankAccount account;
	
	public ATM(BankAccount account) {
		this.account = account;
	}
		
	public static void main(String args[]) {
	
	
		int input = 0;
		double amount = 0;
		AccountHolder userAccount = new AccountHolder("darshan honmore", "1234567891", "sangli");
		BankAccount userBank = new BankAccount(0, 900000009, 1234, userAccount);
		ATM atm = new ATM(userBank);
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to your simple ATM! This is ATM number" + atm + ".\nPlease enter your Account Number: ");
		long number = in.nextLong();
		while (userBank.getAccountNumber() != number) {
			System.out.println("Invalid Account Number. Please enter a new one: ");
			number = in.nextLong();
		}
		System.out.println("Please enter your PIN: ");
		int pin = in.nextInt();
		while (userBank.getPIN() != pin) {
			System.out.println("Invalid PIN. Please enter a new one: ");
			pin = in.nextInt();
		}
		System.out.println("\n==================================");
		System.out.println("Hello, " + userAccount.getName());
		System.out.println("Press 1 to see bank information \nPress 2 to deposit \nPress 3 to withdraw \nPress 4 to exit");
		System.out.println("==================================");
		input = in.nextInt();
		while (input != 4) {
			switch (input) {
			case 1:
				System.out.println("\n==================================");
				System.out.println("User Information: ");
				System.out.println("Name: " + userAccount.getName());
				System.out.println("Phone: " + userAccount.getPhone());
				System.out.println("Address: " + userAccount.getAddress());
				System.out.println("Account Information: ");
				System.out.println("Account Number: " + userBank.getAccountNumber());
				System.out.println("Balance: " + userBank.getBalance());
				System.out.println("==================================");
				break;
			case 2:
				System.out.println("\n==================================");
				System.out.println("Please enter the amount you'd like to deposit: ");
				amount = in.nextDouble();
				while (userBank.deposit(amount) == 0) {
					System.out.println("Invalid number. Please enter a new number:");
					amount = in.nextDouble();
				}
				System.out.println("Deposit successful. Your new balance is: $" + userBank.getBalance());
				System.out.println("==================================");
				break;
			case 3:
				if (userBank.withdrawAble(amount) == -1) {
					System.out.println("Your balance is empty. Deposit first please.");
					break;
				}
				System.out.println("\n==================================");
				System.out.println("Please enter the amount you'd like to withdraw: ");
				amount = in.nextDouble();
				while (userBank.withdrawAble(amount) == 1 || userBank.withdrawAble(amount) == 0) {
					System.out.println("Invalid number. Please enter a valid number: ");
					amount = in.nextDouble();
				} 
				userBank.withdraw(amount);
				System.out.println("Withdrawal sucessful. Your new balance is: $" + userBank.getBalance());
				System.out.println("==================================");
				break;
			default:
				System.out.println("Invalid, please enter 1, 2, 3, or 4.");
				break;
			}
			System.out.println("\nWould you like to do anything else? \nPress 1 to see bank information \nPress 2 to deposit \nPress 3 to withdraw \nPress 4 to exit");
			input = in.nextInt();
		}
		System.out.println("Thank you! Have a nice day~");
		in.close();
	}
}