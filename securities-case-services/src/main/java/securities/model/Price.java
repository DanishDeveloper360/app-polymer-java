package securities.model;


public class Price {
	private long when;
	private double amount;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getWhen() {
		return when;
	}
	public void setWhen(long when) {
		this.when = when;
	}
}