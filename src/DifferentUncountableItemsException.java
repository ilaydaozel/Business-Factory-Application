
@SuppressWarnings("serial")
public class DifferentUncountableItemsException extends Exception{

	public DifferentUncountableItemsException() {
		super("Different uncountable item type!");
	}
	public DifferentUncountableItemsException(String string) {
		super(string);
	}
}
