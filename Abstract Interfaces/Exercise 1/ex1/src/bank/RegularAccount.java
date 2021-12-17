package bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RegularAccount extends Account {
	public RegularAccount(String number, String status, Client owner, BigDecimal balance) {
		super(number, status, owner, balance);
	}
    
    @Override
    protected String balanceBuilder() {
        return "Your regular account balance is " + super.balance.toString();
    }
    
    @Override
    public void credit(BigDecimal amount) {
		balance = balance.add(amount);
		Operation op = new Operation("Credit", amount, LocalDateTime.now());
		operations.add(op);
    }
    
    @Override
    public void debit(BigDecimal amount) {
		BigDecimal newBalance = balance.subtract(amount).subtract(new BigDecimal("50.00"));

		if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Not enough money");
		}

		balance = newBalance;
		Operation operation = new Operation("Debit", amount, LocalDateTime.now());
		operations.add(operation);
    }
    
    @Override
    public void paymentForService() {
        balance = balance.subtract(new BigDecimal("2000.00"));
    }
    
    @Override
    public void getStatement() {
		StringBuilder sb = new StringBuilder();
		sb.append("Account statement\n");
		for (Operation s: operations) {
			if (s == null) {
				break;
			}
			sb.append(s.toString()).append("\n");
		}
		System.out.println(sb);
    }
}
