
public class Yoghurt implements ICountable{
	private double price;
	public Yoghurt(){
		price=2;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return "Yoghurt";
	}
}
