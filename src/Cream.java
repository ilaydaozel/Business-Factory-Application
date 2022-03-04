
public class Cream implements IUncountable  {
	private double price;
	private double amount;
	public Cream(){
		price=0.30;
		amount =0;
	}
	public Cream(double amount) {
		price = 0.25;
		this.amount = amount;
	}
	public IUncountable substract(double amount) {
		IUncountable cream = new Cream(amount);
		this.amount -= amount;
		return cream;
	}
	public void add(IUncountable cream) {
		amount += cream.getAmount();
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
		return "Cream";
	}
}
