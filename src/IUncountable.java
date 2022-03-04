
public interface IUncountable extends IMaterial{
	/**
	 * adds the given uncountable object's amount to the amount of the uncountable object that extends IUncountable
	 * @param uncountableObject  the object that will be added
	 */
	public void add(IUncountable uncountableObject);
	/**
	 * substracts the uncountable object's amount from the amount of the uncountable object that extends IUncountable
	 * and creates a new uncountable object whose amount is as much as the given amount 
	 * @param amount  the amount of the object that will be substracted 
	 * @return the new created uncountable object
	 */
	public IUncountable substract(double amount);
	public double getAmount();
	public void setAmount(double amount);
	public double getPrice();
	public void setPrice(double price);
	/**
	 * calculates the price of the object for the given liters.
	 * @param liter   the amount of liter that we want to calculate
	 * @return  the calculated price of the object
	 */
	public double pricePerLiter(int liter);
	public String toString();
}
