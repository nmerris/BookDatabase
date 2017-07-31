package coolpackage;


public class InvalidCategoryException extends Exception {
	/**
	 * Throw this exception if the user enters an invalid category from Book.
	 * Print this using toString to output an appropriate message.
	 * 
	 * @author Nathan Merris
	 *
	 */
	
	@Override
	public String toString() {
		return "Please enter a category exactly as given";
	}
	
}
