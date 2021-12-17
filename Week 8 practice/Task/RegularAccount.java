import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RegularAccount extends Account {
	public RegularAccount(String number, String status, Client owner, BigDecimal balance) {
		super(number, status, owner, balance);
	}

	@Override
	public void debit(BigDecimal amount) {
		BigDecimal newBalance = balance.subtract(amount).subtract(new BigDecimal("50.00"));

		if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Not enough money");
		}

		balance = newBalance;
		Operation operation = new Operation(
				"Debit", amount, LocalDateTime.now()
			);
		operations.add(operation);
	}
	
}