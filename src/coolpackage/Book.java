package coolpackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Models a Book
 * 
 * @author Nathan Merris
 *
 */
public class Book {
	// a book can have only one of these categories for now
	// static because we want other classes to be able to see these without create a Book instance
	private static String[] categories = {
		"Action", "Romance", "Mystery", "Thriller", "Nonfiction", "Drama", "Comedy", "Horror"
	};
	
	private String sku;
	private String title;
	private List<String> authorList;
	private String description;
	private double price;
	private String category; // only one category for now
	


	
	public Book() {
		// initialize all the fields
		sku = "";
		title = "";
		description = "";
		price = 0;
		authorList = new ArrayList<String>();
	}
	

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}


	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the author(s) as a comma separated String
	 */
	public String getAuthorString() {
		String authors = "";
		for(String s : authorList) {
			authors += s;
			authors += ", ";
		}
		
		// remove the last ", "
		return authors.substring(0, authors.length() - 2);
	}
	
	public List<String> getAuthorList() {
		return authorList;
	}
	
	
	public void addAuthor(String author) {
		authorList.add(author);
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public static String[] getAllCategories() {
		return categories;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
