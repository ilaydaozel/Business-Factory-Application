
public class Budget {
	private double money;
	public Budget(){
		setMoney(10000);
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void decreaseMoneyBy(double amount) {
		money -= amount;
	}
	public void increaseMoneyBy(double amount) {
		money += amount;
	}
	public boolean haveEnoughMoney(double amount) {
		return money>=amount;
	}
	public String toString() {
		System.out.println("Money: "+ money);
		return "";
	}
}
