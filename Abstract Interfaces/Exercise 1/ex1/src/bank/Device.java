package bank;

import java.math.BigDecimal;

public interface Device {
    public void withdraw(Account account, BigDecimal amount);
    public void deposit(Account account, BigDecimal amount);
    public void getBalance(Account account);
    public void getStatement(Account account);
}
