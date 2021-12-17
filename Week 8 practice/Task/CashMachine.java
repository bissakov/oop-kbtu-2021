import java.math.BigDecimal;

public class CashMachine {
	public void withdraw(Account account, BigDecimal amount) {
		account.debit(amount);
	}

	public void deposit(Account account, BigDecimal amount) {
		account.credit(amount);
	}
}