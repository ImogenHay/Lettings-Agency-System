/**
 * 
 */
package org.com1027.question4optional;

import java.text.DecimalFormat;

/**
 * Defines the fields and methods of a house that can be occupied
 * 
 * @author ih00264
 *
 */
public class House extends Property{
	
	private int numberOfRooms = 0;
	
	/**
	 * @param houseNumber
	 * @param street
	 * @param city
	 * @param postCode
	 * @param numberOfRooms
	 * @param rooms
	 */
	public House(int number, String street, String city, String postCode, int numberOfRooms) {
		super(number, street, city, postCode, numberOfRooms);
		this.numberOfRooms = numberOfRooms;
	}
	

	  /**
	   * @return display of info on all of houses occupied rooms, their individual prices and total price
	   */
	@Override
	public String displayOccupiedProperty() {
		StringBuffer buffer = new StringBuffer(this.toString() + "\n");
		for (Room room : rooms.keySet()) {
			buffer.append("	Room: " + room.getPrice() + "\n");
		}
		DecimalFormat df = new DecimalFormat("0.00");
		double total = (super.getPrice()*12);
		buffer.append("	Total: £" + df.format(total));
		return buffer.toString();
	}
	
	
	  /**
	   * @return whether there are available rooms in the flat
	   */
	@Override
	public boolean isAvailable() {
		boolean availability = true;
		if (this.numberOfRooms == rooms.size()) {
			availability = false;
		}
		else {
			availability = true;
		}	
		return availability;
	}
	
	
	  /**
	   * @param room to be occupied, tenant that will occupy it
	   */
	@Override
	public void occupyRoom(Room room, ITenant tenant) {
		if (this.isAvailable()) {
			rooms.put(room,tenant);
		}
	}
	
	
	  /**
	   * @return display of info about house
	   */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(super.toString() + " house :");
		buffer.append(super.getAvailableRooms() + " available)");
		return buffer.toString();
	}

	
}
