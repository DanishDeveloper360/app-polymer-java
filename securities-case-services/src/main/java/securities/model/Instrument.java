package securities.model;


public class Instrument {
	private String code;
	private Price price;
	
	public Instrument(String code) {
		super();
		setCode(code);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public boolean hasPrice() {
		return price != null;
	}
}