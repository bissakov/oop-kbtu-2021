import java.math.BigDecimal;

import bank.*;

public class App {
	static Account regularAccount;
	static Account premiumAccount;
	static Account goldenAccount;

	public static void main(String[] args) {
		Client client = new Client("John", "+727277272", "912312121212");

		regularAccount = new RegularAccount("4400********0001", "1", client, new BigDecimal("10000.00"));
		premiumAccount = new PremiumAccount("4400********0002", "1", client, new BigDecimal("50000.00"));
		goldenAccount = new GoldenAccount("4400********0003", "1", client, new BigDecimal("99000.00"));

        ATM atm = new ATM();
        Smartphone smartphone = new Smartphone();

		// print();

		// regularAccount.credit(new BigDecimal("1000.00"));
		// premiumAccount.credit(new BigDecimal("1000.00"));
		// goldenAccount.credit(new BigDecimal("1000.00"));

		// print();

        // try {
        //     regularAccount.debit(new BigDecimal("1000.00"));
        //     premiumAccount.debit(new BigDecimal("1000.00"));
        //     goldenAccount.debit(new BigDecimal("1000.00"));
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

		// print();

		// regularAccount.paymentForService();
		// premiumAccount.paymentForService();
		// goldenAccount.paymentForService();

		// print();

        try {
            atm.getBalance(regularAccount);

            atm.withdraw(regularAccount, new BigDecimal("1200.00"));
            atm.getBalance(regularAccount);

            atm.deposit(regularAccount, new BigDecimal("998.00"));

            atm.getStatement(regularAccount);
            atm.getBalance(regularAccount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("*\t*\t*\n");

        try {
            smartphone.getBalance(goldenAccount);

            smartphone.withdraw(goldenAccount, new BigDecimal("12467.00"));
            smartphone.getBalance(goldenAccount);

            smartphone.deposit(goldenAccount, new BigDecimal("9102.00"));

            smartphone.getStatement(goldenAccount);
            smartphone.getBalance(goldenAccount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


	}

	private static void print() {
		System.out.println(regularAccount.getBalance());
		System.out.println(premiumAccount.getBalance());
		System.out.println(goldenAccount.getBalance());
		System.out.println();
	}

}