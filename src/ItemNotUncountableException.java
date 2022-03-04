
@SuppressWarnings("serial")
public class ItemNotUncountableException extends Exception{
	public ItemNotUncountableException() {
		super("Item not uncountable!");
	}
	public ItemNotUncountableException(String string) {
		super(string);
	}
}
