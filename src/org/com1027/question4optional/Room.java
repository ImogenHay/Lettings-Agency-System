/**
 * 
 */
package org.com1027.question4optional;

/**
 * Defines the fields and methods of a room in a property
 * 
 * @author ih00264
 *
 */
public class Room {
	
	
	private double price = 0.0;
	
	
	/**
	 * @param price
	 * @throws IllegalArgumentException
	 */
	public Room(double price) {
		super();
		if (price <= 0) {
			throw new IllegalArgumentException("Invalid Room Price");
		}
		this.price = price;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return this.price;
	}

	
}
