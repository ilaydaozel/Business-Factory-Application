
public class StorageTank<T>{
	private static final int CAPACITY=10000;
	private T uncountable;
	
	@SuppressWarnings("unchecked")
	public StorageTank(IUncountable uncountable) {
		this.uncountable = (T)uncountable ;
	}
	/**
	 * If tank has enough capacity add the item
	 * @param uncountable added object
	 */
	public void add(T uncountable) {
		if(haveEnoughTankCapacity(((IUncountable)uncountable).getAmount())){
			((IUncountable)this.uncountable).add((IUncountable)uncountable);
		}
		else {
			System.out.println("Storage Tank doesn't have enough capacity!");
			
		}
	}
	
	/**
	 * If tank has enough elements substract the item
	 * @param uncountable removed object
	 */
	public IUncountable remove(double amount) {
		IUncountable uncountable=null;
		if(haveEnoughTankElements(amount)) {
			uncountable= ((IUncountable)this.uncountable).substract(amount);
		}
		else {
			System.out.println("Storage Tank doesn't have enough elements!");
		}
		return uncountable;
	}
	/** 
	 * checks if  storage tank has enough capacity
	 * @param amount  the checked capacity amount 
	 * @return true if it has enough capacity, false otherwise
	 * 
	 */
	public boolean haveEnoughTankCapacity(double amount) {
		boolean result;
		if(CAPACITY- ((IUncountable)uncountable).getAmount()>=amount) {
			result=true;
		}
		else {
			result=false;
		}
		return result;
	}
	public T getUncountable() {
		return uncountable;
	}

	public void setUncountable(T uncountable) {
		this.uncountable = uncountable;
	}

	public static int getCapacity() {
		return CAPACITY;
	}

	/** 
	 * checks if  storage tank has enough elements
	 * @param amount  the checked element amount 
	 * @return true if it has enough elements, false otherwise
	 * 
	 */
	public boolean haveEnoughTankElements(double amount) {
		boolean result;
		if(((IUncountable)uncountable).getAmount()>=amount) {
			result=true;
		}
		else {
			result=false;
		}
		return result;
	}

}