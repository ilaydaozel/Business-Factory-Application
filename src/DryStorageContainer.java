import java.util.Iterator;

public class DryStorageContainer<T> extends Container<T>{
	private int numberOfElements;
	private double filledCapacity;
	public DryStorageContainer(Factory factory){
		super(factory);
		filledCapacity = 0;
		numberOfElements = 0;
	}
	public DryStorageContainer(int capacity, Factory factory) {
		super(capacity,factory);
		filledCapacity = 0;
		numberOfElements = 0;
	}
	
	
	/**
	 * This method changes the position of the container between facilities. Decreases 100 tl 
	 * from the budget if the container is moved.
	 * @param dC  the facility where we want the container to transfer
	 * @param budget  the money
	 * @return  returns 1, if the container's  position has changed
	 *          returns -1, otherwise
	 */
	public int transferToDC(DistributionCenter dC,Budget budget) {
		if (super.getPosition() instanceof DistributionCenter) {
			System.out.println("Container is in the distribution center already.");
			return -1;
		}
		else {
			super.setPosition(dC); 
			budget.decreaseMoneyBy(100);
			System.out.println("Dry storage container is transfered from factory to distribution center.");
			return 1;
		}	
	}
	
	/**
	 * This method changes the position of the container between facilities. Decreases 100 tl 
	 * from the budget if the container is moved.
	 * @param f the facility where we want the container to transfer
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
			System.out.println("Dry storage container is transfered from distribution center to factory.");
			return 1;
		}
	}
	public int findDryStorageContainerIngredient(String string) {
		int number =0;
		if (string.equals("Boxed Milk")) {
			number = findBoxedMilk();
		}
		else if (string.equals("Chocolate")) {
			number = findChocolate();
		}
		else if (string.equals("Yoghurt")) {
			number = findYoghurt();
		}
		return number;
		
	}
	
	/**
	 * finds the number of the boxed milks in the dry storage container.
	 * @return  the number of the boxed milks
	 */
	private int findBoxedMilk() {
		int number = 0;
		Iterator<T> iter = super.getStack().iterator();
		while (iter.hasNext()) {
			if (iter.next().toString().equals("Boxed Milk")) {
				number++;
			}
		}
		return number;
	
	}
	/**
	 * finds the number of the chocolates in the dry storage container.
	 * @return  the number of the chocolates
	 */
	private int findChocolate() {
		int number = 0;
		Iterator<T> iter = super.getStack().iterator();
		while (iter.hasNext()) {
			if (iter.next().toString().equals("Chocolate")) {
				number++;
			}
		}
		return number;
	
	}
	/**
	 * finds the number of the yoghurts in the dry storage container.
	 * @return  the number of the yoghurts
	 */
	private int findYoghurt() {
		int number = 0;
		Iterator<T> iter = super.getStack().iterator();
		while (iter.hasNext()) {
			if (iter.next().toString().equals("Yoghurt")) {
				number++;
			}
		}
		return number;
	
	}
	
	/**
	 * This method adds the new entry to the dry storage container if the new entry is a countable element.
	 * Increases the number of elements and filled capacity of the container.
	 * If it is not countable, it throws ItemNotCountableException.Exception is working, however it is coded to be thrown as minimum as
	 * possible.
	 * @exception ItemNotCountableException   item is not countable
	 * @param newEntry   the entry to be added
	 * @return    the new entry
	 */
	public T add(T newEntry) {
		try {
			if(newEntry instanceof ICountable){
				super.getStack().push(newEntry);
				numberOfElements++;
				if (newEntry instanceof BoxedMilk) {
					filledCapacity++;
				}
				else if (newEntry instanceof Chocolate) {
					filledCapacity = filledCapacity + (0.5);
				}
				else if (newEntry instanceof Yoghurt) {
					filledCapacity = filledCapacity + 2;
				}
			}
			else {
				throw new ItemNotCountableException();
			}
		}
		catch(ItemNotCountableException e) {
			System.out.println(e.getMessage());
		}
		
		return newEntry;
	}
	
	public int getNumberOfElements() {
		return numberOfElements;
	}
	public double getFilledCapacity() {
		return filledCapacity;
	}
	
	/**
	 * This method takes an element from the  dry storage container stack and decreases the number of elements 
	 * and filled capacity.
	 * @return returns the removed object
	 */
	public T remove() {
		T removedObject = super.getStack().pop();
		if (removedObject instanceof BoxedMilk) {
			filledCapacity--;
			numberOfElements--;
		}
		else if (removedObject instanceof Chocolate) {
			filledCapacity = filledCapacity - (0.5);
			numberOfElements--;
		}
		else if (removedObject instanceof Yoghurt) {
			filledCapacity = filledCapacity - 2;
			numberOfElements--;
		}
		else {
			System.out.println("Dry Storage Container is empty!");
		}
		return removedObject;
		
	}
	
	/**
	 * checks if dry storage container has capacity as much as the given amount.
	 * @param amount the given amount
	 * @return true if it has enough capacity. False, otherwise
	 */
	public boolean haveEnoughDryStorageContainerCapacity(double amount) {
		return ((super.getCapacity()-filledCapacity) >= amount);
	}

}
