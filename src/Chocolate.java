
public class Chocolate implements ICountable{
	private double price;
	public Chocolate(){
		price=4;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return "Chocolate";
	}
}
