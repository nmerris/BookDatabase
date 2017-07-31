	This program simulates a book database.  The user is presented with
	a menu to add books, or look up book(s) by various criteria.
	A book contains the following data: sku, author(s), title, description,
	category, and price.


	SAMPLE OUTPUT>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	2
	Please add at least one book

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	1
	Enter sku: Java1001
	Enter title: Head First Java
	Enter author 1: Kathy Sierra
	Add another author? (Y/N) y
	Enter author 2: Bert Bates
	Add another author? (Y/N) n
	Enter description: Easy to read Java workbook
	Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	nonfiction
	Enter price: $47.50
	Successfully added one book
	Book database now contains: 1 book(s)

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	1
	Enter sku: Java1002
	Enter title: Thinking in Java
	Enter author 1: Bruce Eckel
	Add another author? (Y/N) N
	Enter description: Details about Java under the hood
	Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	NONFICTION
	Enter price: $20
	Successfully added one book
	Book database now contains: 2 book(s)

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	1
	Enter sku: Orcl1003
	Enter title: OCP: Oracle Certified Professional Java SE
	Enter author 1: Jeanne Boyarsky
	Add another author? (Y/N) n
	Enter description: Everything you need to know in one place
	Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	acktion
	Please enter a category exactly as given
	Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	action
	Enter price: $-4
	Please enter a positive number less than 100000000.00
	Enter price: $99999999999999999
	Please enter a positive number less than 100000000.00
	Enter price: $one million
	Please enter a positive number less than 100000000.00
	Enter price: $45
	Successfully added one book
	Book database now contains: 3 book(s)

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	1
	Enter sku: Zombie1005
	Enter title: The Maker's Guide to the Zombie Apocalypse
	Enter author 1: Simon Monk
	Add another author? (Y/N) n
	Enter description: Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi
	Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	Action
	Enter price: $16.5
	Successfully added one book
	Book database now contains: 4 book(s)

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	1
	Enter sku: Rasp1006
	Enter title: Raspberry Pi Projects for the Evil Genius
	Enter author 1: Donald Norris
	Add another author? (Y/N) n
	Enter description: A dozen fiendishly fun projects for the Raspberry Pi!
	Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	NONFICTION
	Enter price: $14.75
	Successfully added one book
	Book database now contains: 5 book(s)

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	1
	Enter sku: TestSku1000
	Enter title: Test Title 1000
	Enter author 1: Bert Bates
	Add another author? (Y/N) y
	Enter author 2: Bubba Gump
	Add another author? (Y/N) n
	Enter description: Test description 1000
	Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	comedy
	Enter price: $99.99
	Successfully added one book
	Book database now contains: 6 book(s)

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	1
	Enter sku: TestSku2000
	Enter title: Test Title 2000
	Enter author 1: Lt. Dan
	Add another author? (Y/N) n
	Enter description: Shrimpin fun
	Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	romance
	Enter price: $0.05
	Successfully added one book
	Book database now contains: 7 book(s)

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	2
	Enter the sku of the book you want to look up: this sku does not exist
	No book was found with that sku

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	2
	Enter the sku of the book you want to look up: Java1002
	BOOK DETAILS......
	SKU: Java1002
	TITLE: Thinking in Java
	AUTHOR(S): Bruce Eckel
	DESCRIPTION: Details about Java under the hood
	CATEGORY: Nonfiction
	PRICE: $20.00

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	3
	Enter an author of the book(s) you want to look up: Bert Bates
	Found 2 book(s)
	BOOK 1 DETAILS......
	SKU: Java1001
	TITLE: Head First Java
	AUTHOR(S): Kathy Sierra, Bert Bates
	DESCRIPTION: Easy to read Java workbook
	CATEGORY: Nonfiction
	PRICE: $47.50
	BOOK 2 DETAILS......
	SKU: TestSku1000
	TITLE: Test Title 1000
	AUTHOR(S): Bert Bates, Bubba Gump
	DESCRIPTION: Test description 1000
	CATEGORY: Comedy
	PRICE: $99.99

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	4
	Enter a category of the book(s) you want to look up: Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	nonfiction
	Found 3 book(s)
	BOOK 1 DETAILS......
	SKU: Java1001
	TITLE: Head First Java
	AUTHOR(S): Kathy Sierra, Bert Bates
	DESCRIPTION: Easy to read Java workbook
	CATEGORY: Nonfiction
	PRICE: $47.50
	BOOK 2 DETAILS......
	SKU: Java1002
	TITLE: Thinking in Java
	AUTHOR(S): Bruce Eckel
	DESCRIPTION: Details about Java under the hood
	CATEGORY: Nonfiction
	PRICE: $20.00
	BOOK 3 DETAILS......
	SKU: Rasp1006
	TITLE: Raspberry Pi Projects for the Evil Genius
	AUTHOR(S): Donald Norris
	DESCRIPTION: A dozen fiendishly fun projects for the Raspberry Pi!
	CATEGORY: Nonfiction
	PRICE: $14.75

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	3
	Enter an author of the book(s) you want to look up: this author does not exist
	No book was found with that author

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	4
	Enter a category of the book(s) you want to look up: Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	Roooomance
	Please enter a category exactly as given
	Enter one category from the following:
	Action, Romance, Mystery, Thriller, Nonfiction, Drama, Comedy, Horror
	ROMANCE
	Found 1 book(s)
	BOOK 1 DETAILS......
	SKU: TestSku2000
	TITLE: Test Title 2000
	AUTHOR(S): Lt. Dan
	DESCRIPTION: Shrimpin fun
	CATEGORY: Romance
	PRICE: $0.05

	MENU: (Enter one of the following numbers)
	1. Add a book to the database
	2. Look up book by sku
	3. Look up book(s) by author
	4. Look up book(s) by category
	5. Quit
	5
	Thank you, come again.


