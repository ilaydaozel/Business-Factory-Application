
public interface ICountable extends IMaterial{
	/**
	 * 
	 * @return the price of the countable object
	 */
	public double getPrice();
	/**
	 * sets the price to the parameter 
	 * @param price the price that will be setted
	 */
	public void setPrice(double price);
	/**
	 * 
	 * @return a string
	 */
	public String toString();
}
