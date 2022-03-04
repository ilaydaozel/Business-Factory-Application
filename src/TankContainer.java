
import java.util.Stack;

public class TankContainer<T> extends Container<T>{
	public TankContainer(Factory factory){
		super(factory);
	}
	public TankContainer(int capacity, Factory factory) {
	   super(capacity,factory);
	}
	/**
	 * This method changes the position of the container between facilities. Decreases 100 tl 
	 * from the budget if the container is moved.
	 * @param w  the facility where we want the container to transfer
	 * @param budget  the money
	 * @return  returns 1, if the container's  position has changed
	 *          returns -1, otherwise
	 */
	public int transferToW(Warehouse w,Budget budget) {
		if (super.getPosition() instanceof Warehouse) {
			System.out.println("Container is in the warehouse already.");
			return -1;
		}
		else {
			super.setPosition(w);
			budget.decreaseMoneyBy(100);
			System.out.println("Tank container is transfered from factory to warehouse.");
			return 1;
		}
	}
	/**
	 * This method changes the position of the container between facilities. Decreases 100 tl 
	 * from the budget if the container is moved.
	 * @param f  the facility where we want the container to transfer
	 * @param budget  the money
	 * @return  returns 1, if the container's  position has changed
	 *          returns -1, otherwise
	 */
	public int transferToF(Factory f,Budget budget) {
		if (super.getPosition() instanceof Factory) {
			System.out.println("Container is in the factory already.");
			return -1;
		}
		else {
			super.setPosition(f);;
			budget.decreaseMoneyBy(100);
			System.out.println("Tank container is transfered from warehouse to factory.");
			return 1;
		}
	}
	
	/**
	 * This method adds uncountable ingredients to the tank container stack. If entry is not uncountable, it
	 * throws ItemNotUncountableException and if entry is a different type of tank container ingredient it throws 
	 * DifferentUncountableItemsException. Exceptions are working, however they are coded to be thrown as minimum as
	 * possible.
	 * 
	 * @exception ItemNotUncountableException
	 * @exception DifferentUncountableItemsException
	 * @param newEntry  the entry to be added
	 * @return the added entry
	 */
	public T add(T newEntry) {
		Stack<T> stack = super.getStack();
		try {
			if(newEntry instanceof ICountable){
				throw new ItemNotUncountableException();
			}
			if (findTankContainerIngredient("Cream")>0) {
				if (newEntry instanceof Milk) {
					throw new DifferentUncountableItemsException();
				}
				else if (newEntry instanceof Cream) {
					((IUncountable)stack.get(0)).add((IUncountable)newEntry);
				}
			}
			if (findTankContainerIngredient("Milk")>0) {
				if (newEntry instanceof Cream) {
					throw new DifferentUncountableItemsException();
				}
				else if (newEntry instanceof Milk) {
					((IUncountable)stack.get(0)).add((IUncountable)newEntry);
				}
			}
			else {
					stack.push(newEntry);
			}
		}
		catch(ItemNotUncountableException e) {
			System.out.println(e.getMessage());
		}
		catch(DifferentUncountableItemsException e) {
			System.out.println(e.getMessage());
		}
		return newEntry;
	}
	/**
	 * finds the liter of the ingredient in the tank container.
	 * @return  the liter of the ingredient
	 */
	public double findTankContainerIngredient(String string) {
		double number =0;
		if (string.equals("Milk")) {
			number = findMilk();
		}
		else if (string.equals("Cream")) {
			number = findCream();
		}
		return number;
		
	}
	/**
	 * finds the liter of the milk in the tank container.
	 * @return  the liter of the milk
	 */
	private double findMilk() {
		Stack<T> stack = super.getStack();
		double number = 0;
		if(stack.isEmpty()) {
			number=0;
		}
		else if ((stack.peek().toString().equals("Cream"))) {
			number = 0;
		}
		else if(stack.peek().toString().equals("Milk")) {
			number=((Milk)stack.get(0)).getAmount();
		}
		return number;
	}
	/**
	 * finds the liter of the cream in the tank container.
	 * @return  the liter of the cream
	 */
	private double findCream() {
		Stack<T> stack = super.getStack();
		double number = 0;
		if(stack.isEmpty()) {
			number=0;
		}
		else if ((stack.peek().toString().equals("Milk"))) {
			number = 0;
		}
		else if(stack.peek().toString().equals("Cream")) {
			number=((Cream)stack.get(0)).getAmount();
		}
		return number;
	
	}
	/**
	 * checks if tank container has capacity as much as the given amount.
	 * @param amount the given amount
	 * @return true if it has enough capacity. False, otherwise
	 */
	public boolean haveEnoughTankContainerCapacity(double amount) {
		return ((super.getCapacity()-(((IUncountable)super.getStack().get(0)).getAmount()))>=amount);
	}
	
}
