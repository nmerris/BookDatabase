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
		List<Book> bookListWithGivenAuthor = new ArrayList<Book>(); // book(s) with a given author
		List<Book> bookListWithGivenCategory = new ArrayList<Book>(); // book(s) with a given category
		int menuChoice; // users menu selction
		boolean continueAddingAuthors = false;
		
		
		// want to set an upper limit on price so as not to exceed doubles range
		final double maxPrice = 100000000; // does any book cost more than a 100 million dollars?
		
		
		do {
			// display menu
			System.out.println("MENU:");
			System.out.println("1. Add a book to the database");
			System.out.println("2. Look up a book by sku");
			System.out.println("3. Look up book(s) by author");
			System.out.println("4. Look up book(s) by category");
			System.out.println("5. Quit");
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
					
					// for now, user can only enter a single Category
					currentBook.setCategory(getCategoryFromUser(scanner));
					
					
					currentBook.setPrice(getPriceFromUser(scanner, maxPrice));
					
					// add currentBook to the list
					bookList.add(currentBook);
					
					// TODO: provide user feedback if addition was successful or not (?)
					break;
				
				case 2:  // look up a book by sku
					if(bookList.isEmpty()) { // don't allow a look up if there are no books
						System.out.println("Please add at least one book");
					} else {
						System.out.print("Enter the sku of the book you want to look up: ");
						selectedBook = lookUpBookBySku(scanner.nextLine(), bookList);
						
						if(selectedBook == null) {
							System.out.println("No book was found with that sku");
						}
						else {
							System.out.println("BOOK DETAILS:");
							displayBookDetails(selectedBook);
						}

					}
					break;
					
				case 3: // look up book(s) by author
					if(bookList.isEmpty()) { // don't allow a look up if there are no books
						System.out.println("Please add at least one book");
					} else {
						System.out.print("Enter an author of the book(s) you want to look up: ");
						// get book(s) with given author
						bookListWithGivenAuthor = lookUpBookByAuthor(scanner.nextLine(), bookList);
						
						if(bookListWithGivenAuthor.size() == 0) { // no books were found
							System.out.println("No book was found with that author");
						} else { // at least one book was found
							System.out.printf("Found %d book(s)\n", bookListWithGivenAuthor.size());
							
							// display the details
							for(Book b : bookListWithGivenAuthor) {
								System.out.printf("BOOK %d DETAILS\n", bookListWithGivenAuthor.indexOf(b) + 1);
								displayBookDetails(b);
							}	
						}
					}
					break;
					
				case 4: // look up book(s) by category
					if(bookList.isEmpty()) {
						System.out.println("Please add at least one book");
					}
					else {
						System.out.print("Enter a category of the book(s) you want to look up: ");
						
						bookListWithGivenCategory = 
								lookUpBookByCategory(getCategoryFromUser(scanner), bookList);
						
						if(bookListWithGivenCategory.size() == 0) { // no books were found
							System.out.println("No book was found with that category");
						} else { // at least one book was found
							System.out.printf("Found %d book(s)\n", bookListWithGivenCategory.size());
							
							// display the details
							for(Book b : bookListWithGivenCategory) {
								System.out.printf("BOOK %d DETAILS\n", bookListWithGivenCategory.indexOf(b) + 1);
								displayBookDetails(b);
							}	
						}
						
					}
					break;
					
				case 5: // quit the program
					System.out.println("Thank you, come again.");
					quit = true;
					break;
				
			} // switch
			
			// skip a space so it looks nice
			System.out.println();
			
		} while(!quit);
		

	}
	
	



	public static void displayBookCategories() {
		String categories = "";
		for(String s: Book.getAllCategories()) {
			categories += s;
			categories += ", ";
		}
		
		// remove the last ", " and display it
		System.out.println(categories.substring(0,  categories.length() - 2));
	}
	
	
	public static void displayBookDetails(Book b) {
		System.out.printf("SKU: %s\nTITLE: %s\nAUTHOR(S): %s\nDESCRIPTION: %s\nPRICE: $%.2f\n",
				b.getSku(),
				b.getTitle(),
				b.getAuthorString(),
				b.getDescription(),
				b.getPrice());
	}
	
	
	// will return an empty list if no books found
	private static List<Book> lookUpBookByCategory(String category, List<Book> bookList) {
		List<Book> bookListWithGivenCategory = new ArrayList<Book>(); // the book(s) with given category
		
		for(Book b : bookList) {
			if(b.getCategory().equalsIgnoreCase(category)) { // found a book with given category
				bookListWithGivenCategory.add(b); // add it to the list to return
			}
		}
		return bookListWithGivenCategory;
	}
	
	
	// will return an empty list if no books found
	public static List<Book> lookUpBookByAuthor(String author, List<Book> bookList) {
		// I am assuming a book would not have the same author listed twice
		// in a real database, this could be easily enforced
		List<Book> bookListWithGivenAuthor = new ArrayList<Book>(); // the book(s) with given author
		
		for(Book b : bookList) { // iterate through all the books
			List<String> authorList = b.getAuthorList(); // get author list of one book
			for(String s : authorList) {
				// using ignorecase, maybe user has caps lock on?  err on the side of returning more books
				if(s.equalsIgnoreCase(author)) { // check if the author matches
					bookListWithGivenAuthor.add(b); // add the book to the List we are returning
				}
			}
		}
		return bookListWithGivenAuthor;
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
	private static double getPriceFromUser(Scanner scanner, double maxPrice) {
		boolean inputError; // true if user enters invalid input
		double price = 0;
		
		do {
			try { // get price and make sure it's a number not greater than maxPrice
				inputError = false;
				System.out.print("Enter price: $");
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
	
	
	private static String getCategoryFromUser(Scanner scanner) {
		boolean inputError; // true if user enters invalid input
		String category = "";
		
		do {
			try {
				inputError = false;
				System.out.println("Enter one category from the following:");
				displayBookCategories();
				category = scanner.nextLine(); // get user entry for category
				
				boolean foundMatchingCategory = false;
				for(String s : Book.getAllCategories()) { // iterate through all possible categories
					if(s.equals(category)) { // user entered a valid category
						foundMatchingCategory = true;
					}
				}
				
				if(!foundMatchingCategory) { // user did not enter a valid category
					throw new Exception();
				}
				
			} catch(Exception e) {
				inputError = true;
				System.out.println("Please enter a category exactly as given");
			};
		} while(inputError);
		
		return category; // only possible to get here if a valid category was entered
	}
	
	
}
