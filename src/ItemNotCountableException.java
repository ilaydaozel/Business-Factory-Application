
@SuppressWarnings("serial")
public class ItemNotCountableException extends Exception{
	public ItemNotCountableException() {
		super("Item not countable!");
	}
	public ItemNotCountableException(String string) {
		super(string);
	}
}
