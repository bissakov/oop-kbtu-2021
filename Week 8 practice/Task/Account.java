import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Account {
	protected String number;
	protected String status;
	protected Client owner;
	protected BigDecimal balance;
	protected ArrayList<Operation> operations;

	public Account(String number, String status, Client owner, BigDecimal balance) {
		this.number = number;
		if (status == null || !"1".equals(status) && !"2".equals(status)) {
			throw new IllegalArgumentException("Invalid status!");
		}
		this.status = status;
		this.owner = new Client(owner.getName(), owner.getPhone(), owner.getId());
		this.balance = balance;
		this.operations = new ArrayList<Operation>();
	}

	public Client getOwner() {
		System.out.println("Inside bankaccount " + owner.getName());
		return new Client(owner.getName(), owner.getPhone(), owner.getId());
	}

	public String getNumber() {
		return number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status == null || !"1".equals(status) && !"2".equals(status)) {
			throw new IllegalArgumentException("Invalid status!");
		}
		this.status = status;
	}

	public String getBalance() {
		return balanceBuilder();
	}

	protected String balanceBuilder() {
		return "Your balance is " + balance.toString();
	}

	public void credit(BigDecimal amount) {

		balance = balance.add(amount);
		
		Operation op = new Operation(
			"Credit",
			amount,
			LocalDateTime.now());
		operations.add(op);
	}

	public void debit(BigDecimal amount) {
		BigDecimal newBalance = balance.subtract(amount);

		if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Not enough money");
		}

		balance = newBalance;
		
		Operation operation = new Operation(
				"Debit", amount, LocalDateTime.now()
			);
		operations.add(operation);
			
	}

	public void paymentForService() {
		balance = balance.subtract(new BigDecimal("2000.00"));
	}

	public void printStatement() {
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


