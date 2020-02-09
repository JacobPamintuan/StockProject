/*
 * Stock.java
 * Arrays & Object Orient Programming Assignment 2
 * ICS3U1
 * Jacob Pamintuan
 * December 05, 2019
 * The stock package contains the files for the Inventory application.
 */

package stock;
import java.util.ArrayList;

/**
 * The Stock class contains the background code for the Inventory application.
 * The methods in the Stock class are instantiated the Inventory class as the
 * inventory object.
 */

public class Stock {
	private ArrayList<Item> items;

	/**
	 * constructor 
	 * pre: none 
	 * post: items has been initialized
	 */
	public Stock() {
		items = new ArrayList<Item>();
	}

	/**
	 * Adds a new item to the items inventory. 
	 * pre: none 
	 * post: An item has been
	 * added to the items inventory
	 */
	public void addItem(String name, int num) {
		Item newItem;

		newItem = new Item(num, name);

		items.add(newItem);
		System.out.println("Item added to inventory: " + newItem.toString());
	}

	/**
	 * Discontinues a specific item. 
	 * pre: none: 
	 * post: an existing item has been
	 * discontinued
	 */
	public void discontinueItem(int index) {
		int stockIndex = index - 1000;

		if (items.size() == 0) {
			System.out.println("There are no items in the inventory. ");
		} else {

			Item replacement = new Item(index);
			if (stockIndex > -1 && stockIndex < items.size()) {
				items.set(stockIndex, replacement);
				System.out.println("Item discontinued");

			} else {
				System.out.println("Item does not exist");
			}
		}

		System.out.println();
	}
	
	/**
	 * Validates whether or not the item exists, or whether or not it has
	 * been discontinued.
	 * pre: none
	 * post: Item has been validated
	 */

	public boolean validate(int ID) {
		Item stock;
		boolean value = false;
		int stockIndex = ID - 1000;
		
		if (stockIndex >= 0 && stockIndex < items.size()) {
			stock = items.get(stockIndex);
			value = stock.validate();

			if (value == false) {
				System.out.println("ITEM HAS BEEN DISCONTINUED.\n");
			}
			return value;
			
		} else {
			System.out.println("Item does not exist");
			return value;
		}
	}

	/**
	 * Adds or subtracts stock from a specific item. An addOrSubtract of 1 adds
	 * stock and an addOrSubtract of 2 subtracts stock. 
	 * pre: addOrSubtract is either 1 or 2. 
	 * post: An item's stock has increased or decreased.
	 */
	public void changeNumInStock(int addOrSubtract, int ID, int amt) {
		int stockIndex = ID - 1000;
		Item stock;

		if (stockIndex > -1 && stockIndex < items.size()) {
			stock = items.get(stockIndex);
			if (addOrSubtract == 1) {
				stock.add(amt);
				items.set(stockIndex, stock);
				System.out.println(stock);
			} else if (addOrSubtract == 2) {
				stock.subtract(amt);
				items.set(stockIndex, stock);
				System.out.println(stock);
			}
		} else {
			System.out.println("\nItem does not exist.\n");
		}
	}

	/**
	 * Displays all of the items in the inventory, 
	 * with their respective information
	 * pre: none 
	 * post: Item ID, item name, and the 
	 * amount in stock are displayed for
	 * each item
	 */
	public void displayAll() {
		if (items.size() != 0) {
			for (Object element : items) {
				System.out.println(element);
			}
		} else {
			System.out.println("There are no items. ");
		}
	}

}
