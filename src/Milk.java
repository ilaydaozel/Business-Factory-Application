
public class Milk implements IUncountable {
	private double price;
	private double amount;
	public Milk(){
		price=0.25;
		amount =0;
	}
	public Milk(double amount) {
		price = 0.25;
		this.amount = amount;
	}
	public void add(IUncountable milk) {
		this.amount += milk.getAmount();
	}
	public IUncountable substract(double amount) {
		IUncountable milk = new Milk(amount);
		this.amount -= amount;
		return milk;
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
		return "Milk";
	}
}
