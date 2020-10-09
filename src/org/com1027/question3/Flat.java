/**
 * 
 */
package org.com1027.question3;

import java.text.DecimalFormat;

/**
 * Defines the fields and methods of a flat that can be occupied
 * 
 * @author ih00264
 *
 */
public class Flat extends Property {

	private int numberOfRooms = 0;
	private int floor = 0;
	private final static int MAINTENANCE_COSTS = 500;
	
	/**
	 * @param houseNumber
	 * @param street
	 * @param city
	 * @param postCode
	 * @param numberOfRooms
	 * @param rooms
	 * @param floor
	 */
	public Flat(int number, String street, String city, String postCode, int numberOfRooms, int floor) {
		super(number, street, city, postCode, numberOfRooms);
		this.numberOfRooms = numberOfRooms;
		this.floor = floor;

	}
	
	
	
	
	  /**
	   * @return display of info on all of flats occupied rooms, their individual prices and total price
	   */
	@Override
	public String displayOccupiedProperty() {
		StringBuffer buffer = new StringBuffer(this.toString() + "\n");
		for (Room room : rooms.keySet()) {
			buffer.append("	Room: " + room.getPrice() + "\n");
		}	
		DecimalFormat df = new DecimalFormat("0.00");
		double total = (super.getPrice()*12) + MAINTENANCE_COSTS;
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
	   * @throws IllegalArgumentException
	   */
	@Override
	public void occupyRoom(Room room, ITenant tenant) {
		if (!this.isAvailable() || rooms.containsKey(room)) {
			throw new IllegalArgumentException("Room in Flat Unavailable");
		}
		rooms.put(room,tenant);
	}
	

	  /**
	   * @return display of info about flat
	   */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(super.toString() + " flat on ");
		buffer.append(this.floor + " floor :");
		buffer.append(super.getAvailableRooms() + " available)");
		return buffer.toString();
	}

}
