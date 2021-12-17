import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {

        Account regularAccount = new RegularAccount("4400********0001", "John", new BigDecimal("10000.00"));
        Account premiumAccount = new PremiumAccount("4500********0002", "Michael", new BigDecimal("50000.00"));
        Account goldenAccount = new GoldenAccount("4600********0003", "David", new BigDecimal("99000.00"));

        ATM<Account> atm = new ATM<Account>();

        print(atm, regularAccount, new BigDecimal("999.00"), new BigDecimal("800.00"));
        print(atm, premiumAccount, new BigDecimal("1111.00"), new BigDecimal("8888.00"));
        print(atm, goldenAccount, new BigDecimal("50000.00"), new BigDecimal("41000.00"));
    }

    static void print(ATM<Account> atm, Account account, BigDecimal withdrawAmount, BigDecimal depositAmount) {
        try {
            atm.getBalance(account);

            atm.withdraw(account, withdrawAmount);
            atm.getBalance(account);

            atm.deposit(account, depositAmount);

            atm.getBalance(account);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n****************\n");
    }
}

abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected BigDecimal balance;

    public Account(String accountNumber, String ownerName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getBalance() {
        return balanceBuilder();
    }

    protected abstract String balanceBuilder();

    public abstract void credit(BigDecimal balance);

    public abstract void debit(BigDecimal balance);
}

class RegularAccount extends Account {
	public RegularAccount(String number, String owner, BigDecimal balance) {
		super(number, owner, balance);
	}

    @Override
    protected String balanceBuilder() {
        return "Your regular account balance is " + super.balance.toString();
    }
    
    @Override
    public void credit(BigDecimal amount) {
		balance = balance.add(amount);
    }
    
    @Override
    public void debit(BigDecimal amount) {
		BigDecimal newBalance = balance.subtract(amount).subtract(new BigDecimal("50.00"));

		if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Not enough money");
		}

		balance = newBalance;
    }
}

class PremiumAccount extends Account {
	public PremiumAccount(String number, String owner, BigDecimal balance) {
		super(number, owner, balance);
	}

    @Override
	protected String balanceBuilder() {
		return "Your premium account balance is " + balance.toString();
	}

    @Override
    public void credit(BigDecimal amount) {
		balance = balance.add(amount);
    }

	@Override
	public void debit(BigDecimal amount) {
		BigDecimal newBalance = balance.subtract(amount);

		if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Not enough money");
		}

		balance = newBalance.add(new BigDecimal("150.00"));;
	}
}

class GoldenAccount extends Account {
	public GoldenAccount(String number, String owner, BigDecimal balance) {
		super(number, owner, balance);
	}

	@Override
	protected String balanceBuilder() {
		return "Your golden account balance is " + balance.toString();
	}

    @Override
    public void credit(BigDecimal amount) {
		balance = balance.add(amount);
    }

	@Override
	public void debit(BigDecimal amount) {
		BigDecimal newBalance = balance.subtract(amount);

		if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Not enough money");
		}

		balance = newBalance.add(new BigDecimal("100.00"));;
	}
}

class ATM<T extends Account> {
    public void withdraw(T account, BigDecimal amount) {
        account.debit(amount);
    }

    public void deposit(T account, BigDecimal amount) {
        account.credit(amount);
    }

    public void getBalance(T account) {
        System.out.println(account.getBalance() + "\n");
    }
}


