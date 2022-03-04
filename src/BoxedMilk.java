
public class BoxedMilk implements ICountable{
	private double price;
	public BoxedMilk(){
		price=1;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return "Boxed Milk";
	}
}
