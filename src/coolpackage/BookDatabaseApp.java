package coolpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDatabaseApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Book> bookList = new ArrayList<Book>(); // our simulated book db
		final int numBooksToCreate = 100;
		boolean quit = false; // true if user wants to quit
		String skuToLookup; // the sku to look up
		Book selectedBook; // the book that corresponds to skuToLookup
		int menuChoice;
		
	
		
		
		
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
					System.out.println("Enter sku: ");
					String sku = scanner.nextLine();
					
					System.out.println("Enter title: ");
					String title = scanner.nextLine();
					
					System.out.println("Enter author: ");
					String author = scanner.nextLine();
					
					System.out.println("Enter description: ");
					String descr = scanner.nextLine();
					
					System.out.println("Enter price: ");
					double price = scanner.nextDouble();
					scanner.nextLine(); 
					
					// create a Book, add it to the list
					bookList.add(new Book(sku, title, author, descr, price));
					
					// TODO: provide user feedback if addition was successful or not
					break;
				
				case 2:  // look up a book by sku
					System.out.println("Enter the sku of the book you want to look up: ");
					skuToLookup = scanner.nextLine(); // get the sku
					selectedBook = lookUpBookBySku(skuToLookup, bookList);
					
					// display the details, I think it could be too much data to fit on one line
					System.out.printf("SKU: %s\nTITLE: %s\nAUTHOR: %s\nDESCRIPTION: %s\nPRICE: %f\n",
							selectedBook.getSku(),
							selectedBook.getTitle(),
							selectedBook.getAuthor(),
							selectedBook.getDescription(),
							selectedBook.getPrice());
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
	
	

}
