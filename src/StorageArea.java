import java.util.LinkedList;
import java.util.Queue;

public class StorageArea<T> {
	private static final int CAPACITY = 10000;
	private Queue<T> queue;
	private int numberOfElements;
	private double filledCapacity;
	
	public StorageArea() {
		queue = new LinkedList<T>();
		numberOfElements = 0;
		filledCapacity = 0;
	}

	public Queue<T> getQueue() {
		return queue;
	}
	public double getFilledCapacity() {
		return filledCapacity;
	}

	public static int getCapacity() {
		return CAPACITY;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}
	/** 
	 * checks if  storage area has enough capacity
	 * @param amount  the checked capacity amount 
	 * @return true if it has enough capacity, false otherwise
	 * 
	 */
	public boolean haveEnoughAreaCapacity(int amount) {
		boolean result;
		if (CAPACITY-filledCapacity>=amount) {
			result = true;
		}
		else {
			result = false;
		}
		return result;
	}
	
	/** 
	 * checks if  storage area has enough elements
	 * @param amount  the checked element amount 
	 * @return true if it has enough elements, false otherwise
	 * 
	 */
	public boolean haveEnoughAreaElements(int amount) {
		boolean result;
		if(numberOfElements>=amount) {
			result=true;
		}
		else {
			result=false;
		}
		return result;
	}
	/**
	 * adds a countable object to the queue
	 * @param countable added object
	 */
	public void add(T countable) {
		queue.add(countable);
		numberOfElements++;
		if (countable instanceof BoxedMilk) {
			filledCapacity++;
		}
		else if (countable instanceof Chocolate) {
			filledCapacity += (0.5);
		}
		else if (countable instanceof Yoghurt) {
			filledCapacity += (2);
		}
	}
	
	/**
	 * removes a object if the queue is not empty
	 * @return removed object
	 */
	public T remove() {
		T object = null;
		if(haveEnoughAreaElements(1)) {
			object = queue.remove();
			numberOfElements--;
			if (object instanceof BoxedMilk) {
				filledCapacity--;
			}
			else if (object instanceof Chocolate) {
				filledCapacity -= (0.5);
			}
			else if (object instanceof Yoghurt) {
				filledCapacity -= (2);
			}
		}
		else {
			System.out.println("Storage Area is empty!");
		}
		
		return object;
	}
}
