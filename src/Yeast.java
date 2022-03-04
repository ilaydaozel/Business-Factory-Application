
public class Yeast implements IUncountable {
	private double price;
	private double amount;
	public Yeast(){
		price=5;
		amount =0;
	}
	public Yeast(double amount) {
		price = 0.25;
		this.amount = amount;
	}
	public IUncountable substract(double amount) {
		IUncountable yeast = new Yeast(amount);
		this.amount -= amount;
		return yeast;
	}
	public void add(IUncountable yeast) {
		amount += yeast.getAmount();
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public double pricePerLiter(int liter){
		return price *liter;
	}
	public String toString() {
		return "Yeast";
	}
}
