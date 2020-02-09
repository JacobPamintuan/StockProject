/*
 * Item.java
 * Arrays & Object Orient Programming Assignment 2
 * ICS3U1
 * Jacob Pamintuan
 * December 05, 2019
 * The stock package contains the files for the Inventory application.
 */

package stock;

/**
 * The Item class contains the background code for the Inventory application.
 * The methods in the Item class are instantiated the Stock class as an object.
 */

public class Item {
	private static int newStockNum = 1000;
	private int itemNum, numInStock;
	private String itemName;

	/**
	 * constructor
	 * pre: none
	 * post: An item has been created. Stock and item 
	 * name have been initialized with parameters
	 */
	public Item(int numItems, String name) {
		itemNum = newStockNum;
		itemName = name;
		numInStock = numItems;
		newStockNum++;
	}
	
	/**
	 * Constructor
	 * pre: none
	 * post: A discontinued item is created (to replace an existing item)
	 * with the specified item ID. 
	 */
	public Item(int index) {
		numInStock = 0;
		itemName = "Discontinued";
		itemNum = index;
	}
	
	/**
	 * Determines if the item has been continued
	 * pre: none
	 * post: item has been validated
	 */

	public boolean validate() {
		if(!(itemName.equals("Discontinued"))) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * The stock of an item is increased.
	 * pre: The item has not yet been discontinued, and the item exists
	 * post: The amount of stock has been increased by the amount specified.
	 */
	public void add(int amt) {
			numInStock += amt;
	}
	/**
	 * The stock of an item is decreased if there is enough in stock.
	 * pre: The item has not yet been discontinued, and the item exists.
	 * post: The amount of stock has been decreased by the amount specified.
	 */
	public void subtract(int amt) {
		if (amt <= numInStock) {
			numInStock -= amt;
		} else {
			System.out.println("\nNot enough in stock.\n");
		}
	
	}
	
	/**
	 * Returns a String that represents the Item object. 
	 * pre: none 
	 * post: A string representing the Item object has been returned.
	 */
	public String toString() {
		String ID = "\nItem ID: " + itemNum + "/Item Name: " + 
					itemName + "/In Stock: " + numInStock + "\n";
		return ID;
	}
	
	
	/**
	 * Returns a true when objects have matching item IDs. 
	 * pre: none 
	 * post: true has been returned when the objects are equal, 
	 * 		 false returned otherwise.
	 */

	public boolean equals(Object item) {
		Item testItem = (Item) item;
		if (itemName.equals(testItem.itemName) || itemNum == (testItem.itemNum)) {
			return true;
		} else {
			return false;
		}
				
	}

}
