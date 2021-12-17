import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operation {
	private String opType;
	private BigDecimal amount;
	private LocalDateTime time;	

	public Operation(String opType, BigDecimal amount, LocalDateTime time) {
		this.opType = opType;
		this.amount = amount;
		this.time = time;
	}

	@Override
	public String toString() {
		return "{" + opType + " " + amount.toString() + " " + time.toString() + " ";
	}
}