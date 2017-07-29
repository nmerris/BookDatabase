package coolpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDatabaseApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Book> bookList = new ArrayList<Book>(); // our simulated book db
		boolean quit = false; // true if user wants to quit this program
		Book selectedBook; // the book that corresponds to skuToLookup
		int menuChoice; // users menu selction
		boolean continueAddingAuthors = false;
		
		// want to set an upper limit on price so as not to exceed doubles range
		final double maxPrice = 100000000; // does any book cost more than a 100 million dollars?
		
		
		do {
			// display menu
			System.out.println("MENU:");
			System.out.println("1. Add a book to the database");
			System.out.println("2. Look up a book by sku");
			System.out.println("3. Quit");
			menuChoice = scanner.nextInt(); // get the user menu choice
			scanner.nextLine(); // consume the dangling \n
			
			
			switch(menuChoice) {
				case 1: // enter a new book
					// create a new empty Book object
					Book currentBook = new Book();
					
					System.out.print("Enter sku: ");
					currentBook.setSku(scanner.nextLine());
					
					System.out.print("Enter title: ");
					currentBook.setTitle(scanner.nextLine());
					
					// user can enter multiple authors
					int counter = 1;
					do {
						System.out.printf("Enter author %d: ", counter);
						currentBook.addAuthor(scanner.nextLine());
						counter++;
						
						System.out.print("Add another author? (Y/N) ");
						continueAddingAuthors = scanner.nextLine().equalsIgnoreCase("y") ? true : false;
						
					} while(continueAddingAuthors);
					
					
					System.out.print("Enter description: ");
					currentBook.setDescription(scanner.nextLine());
	
					currentBook.setPrice(getPrice(scanner, maxPrice));
					
					// add currentBook to the list
					bookList.add(currentBook);
					
					// TODO: provide user feedback if addition was successful or not
					break;
				
				case 2:  // look up a book by sku
					if(bookList.isEmpty()) { // don't allow a look up if there are no books
						System.out.println("Please add at least one book");
					} else {
						System.out.println("Enter the sku of the book you want to look up: ");
						selectedBook = lookUpBookBySku(scanner.nextLine(), bookList);
						
						// TODO: provide feedback if book was not found
						
						// display the details, I think it could be too much data to fit on one line
						System.out.println("BOOK DETAILS:");
						System.out.printf("SKU: %s\nTITLE: %s\nAUTHOR(S): %s\nDESCRIPTION: %s\nPRICE: $%.2f\n",
								selectedBook.getSku(),
								selectedBook.getTitle(),
								selectedBook.getAuthorString(),
								selectedBook.getDescription(),
								selectedBook.getPrice());
					}
					break;
					
				case 3: // quit the program
					System.out.println("Thank you, come again.");
					quit = true;
					break;
				
			} // switch
			
			// skip a space so it looks nice
			System.out.println();
			
		} while(!quit);
		

	}
	
	
	public static Book lookUpBookBySku(String sku, List<Book> bookList) {
		for(Book b : bookList) {
			if(b.getSku().equals(sku)) { // found the book
				return b;
			}
		}
		return null; // return null if no books found with given sku
	}
	
	
	/**
	 * Gets the price from Scanner.
	 * Validates: price too high, less than 0, not a number
	 * 
	 * @param scanner System input for the whole app
	 * @param maxPrice Max allowed
	 * @return Validated price
	 */
	private static double getPrice(Scanner scanner, double maxPrice) {
		boolean inputError = false; // true if user enters invalid input
		double price = 0;
		
		do {
			try { // get price and make sure it's a number not greater than maxPrice
				inputError = false;
				System.out.print("Enter price: ");
				price = scanner.nextDouble();
				if(price > maxPrice || price < 0) { // user entered number that was too large
					throw new Exception();
				}
				scanner.nextLine(); // Scanner is kind of annoying
				
			} catch(Exception e) { // user did not enter a number
				scanner.nextLine(); // consume the dangling \n or it loops forever
				inputError = true;
				System.out.printf("Please enter a positive number less than %.2f\n", maxPrice);
			};
		} while(inputError);
		
		return price;
	}
	
	

}
