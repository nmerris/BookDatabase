package coolpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDatabaseApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Book> booksList = new ArrayList<Book>(); // our simulated book db
		final int numBooksToCreate = 100;
		boolean addMoreBooks; // yes if user wants to add more books
		
	
		do {
			System.out.println("Enter sku: ");
			String sku = scanner.nextLine();
			
			System.out.println("Enter title: ");
			String title = scanner.nextLine();
			
			System.out.println("Entere author: ");
			String author = scanner.nextLine();
			
			System.out.println("Enter description: ");
			String descr = scanner.nextLine();
			
			System.out.println("Enter price: ");
			double price = scanner.nextDouble();
			scanner.nextLine(); // consume the dangling \n
			
			// create a Book, add it to the list
			booksList.add(new Book(sku, title, author, descr, price));
			
			System.out.println("Would you like to enter another book? (Y/N)");
			addMoreBooks = scanner.nextLine().equalsIgnoreCase("y") ? true : false;
			
		} while(addMoreBooks);
	
		
		
		

	}
	
	
	public static Book lookUpBookBySku(String sku, ArrayList<Book> bookList) {
		for(Book b : bookList) {
			if(b.getSku().equals(sku)) { // found the book
				return b;
			}
		}
		return null; // return null if no books found with given sku
	}
	
	

}
