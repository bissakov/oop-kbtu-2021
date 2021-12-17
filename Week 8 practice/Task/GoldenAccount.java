import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GoldenAccount extends Account {
	public GoldenAccount(String number, String status, Client owner, BigDecimal balance) {
		super(number, status, owner, balance);
	}

	@Override
	public void debit(BigDecimal amount) {
		BigDecimal newBalance = balance.subtract(amount);

		if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Not enough money");
		}

		balance = newBalance.add(new BigDecimal("100.00"));;
		Operation operation = new Operation(
				"Debit", amount, LocalDateTime.now()
			);
		operations.add(operation);
	}
	
	@Override
	public void paymentForService() {
		balance = balance.subtract(new BigDecimal("3000.00"));
	}

	@Override
	protected String balanceBuilder() {
		return "Your golden account balance is " + balance.toString();
	}	

	public String sample(){return "Golden";}
}