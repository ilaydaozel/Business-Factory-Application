import java.util.Stack;


public abstract class Container<T>{
	/**
	 * the base class for containers
	 */
	private static final int CAPACITY =1000;
	private Facility position;
	private Stack<T> stack;
	public Container(Factory factory) {
		position= factory;
		stack = new Stack<T>();
	}
	public Container(int capacity, Factory factory) {
		position= factory;
		stack = new Stack<T>();
	}
	public Stack<T> getStack() {
		return stack;
	}
	public Facility getPosition() {
		return position;
	}
	public void setPosition(Facility position) {
		this.position = position;
	}
	public static int getCapacity() {
		return CAPACITY;
	}
	/**
	 * If container is not empty, it removes the first object of the container.
	 * 
	 * @return returns the removed object
	 */
	public T remove() {
		T removedObject = null;
		if(!stack.isEmpty()) {
			removedObject = stack.pop();
		}
		return removedObject;

	}
}
