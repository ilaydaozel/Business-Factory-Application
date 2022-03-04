
public class Cacao implements IUncountable {
	private double price;
	private double amount;
	public Cacao(){
		price=1;
		amount=0;
	}
	public Cacao(double amount) {
		price = 0.25;
		this.amount = amount;
	}
	public IUncountable substract(double amount) {
		IUncountable cacao = new Cacao(amount);
		this.amount -= amount;
		return cacao;
	}
	public void add(IUncountable cacao) {
		amount += cacao.getAmount();
	}
	public double getPrice() {
		return price;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public double pricePerLiter(int liter){
		return price *liter;
	}
	public String toString() {
		return "Cacao";
	}
}
