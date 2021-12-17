package bank;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Account {
    protected String accountNumber;
    protected String status;
    protected Client ownerName;
    protected BigDecimal balance;
    protected ArrayList<Operation> operations;

    public Account(String accountNumber, String status, Client ownerName, BigDecimal balance) {
        this.accountNumber = accountNumber;
        if (status == null || !"1".equals(status) && !"2".equals(status)) {
            throw new IllegalArgumentException("Invalid Status!");
        }
        this.status = status;
        this.ownerName = new Client(ownerName.getName(), ownerName.getPhone(), ownerName.getId());
        this.balance = balance;
        this.operations = new ArrayList<Operation>();
    }

    public String getNumber() {
        return accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public Client getOwner() {
        return ownerName;
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

    protected abstract String balanceBuilder();

    public abstract void credit(BigDecimal balance);

    public abstract void debit(BigDecimal balance);

    public abstract void paymentForService();

    public abstract void getStatement();
}
