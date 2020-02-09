/*
 * Inventory.java
 * Arrays & Object Orient Programming Assignment 2
 * ICS3U1
 * Jacob Pamintuan
 * December 05, 2019
 * The stock package contains the files for the Inventory application.
 */

package stock;

import java.util.Scanner;

/**
 * The Inventory class contains the client code for the Inventory application.
 */

public class Inventory {

	public static void main(String[] args) {
		Stock inventory = new Stock();
		Scanner in = new Scanner(System.in);
		int choice, addOrSubtract;
		int itemID, numInStock, changeStockBy;
		String itemName;
		boolean run = true;
		do {
			do {
				System.out.println("Menu: \n1. Add a new Item" + "\n2. Add or remove from an existing item"
						+ "\n3. Discontinue an item" + "\n4. Display all items" + "\nEnter -1 to quit");

				choice = in.nextInt();
			} while ((choice > 4 || choice < -1) || choice == 0);

			System.out.println();

			switch (choice) {
			case -1:
				run = false;
				break;
			case 1:
				System.out.println("Adding a new Item: ");
				System.out.print("Enter Item Name (One word): ");
				itemName = in.next();

				System.out.print("Enter the number of items in stock: ");
				numInStock = in.nextInt();
				System.out.println();

				inventory.addItem(itemName, numInStock);

				break;
			case 2:
				System.out.print("\nEnter the Item ID: ");
				itemID = in.nextInt();
				if (inventory.validate(itemID)) {

					do {
						System.out.println("Would you like to add or subtract? ");
						System.out.println("1. Add" + "\n2. Subtract");
						addOrSubtract = in.nextInt();
					} while (addOrSubtract != 1 && addOrSubtract != 2);

					if (addOrSubtract == 1) {
						System.out.print("Enter the amount you want to add: ");
					} else {
						System.out.print("Enter the amount you want to subtract: ");
					}
					changeStockBy = in.nextInt();
					inventory.changeNumInStock(addOrSubtract, itemID, changeStockBy);
				}

				break;
			case 3:
				System.out.print("Enter the Item ID: ");
				itemID = in.nextInt();
				inventory.discontinueItem(itemID);
				break;
			case 4:
				System.out.println("Displaying all Items: ");
				inventory.displayAll();
				break;

			}

		} while (run);
		in.close();

	}
}
