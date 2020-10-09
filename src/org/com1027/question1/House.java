/**
 * 
 */
package org.com1027.question1;
import java.util.HashMap;
import java.util.Map;


/**
 * Defines the fields and methods of a house that can be occupied
 * 
 * @author ih00264
 *
 */
public class House {
	
	private int houseNumber = 0;
	private String street = null;
	private String city = null;
	private String postCode = null;
	private int numberOfRooms = 0;
	private Map<Room, ITenant> rooms = null;
	
	
	
	/**
	 * @param houseNumber
	 * @param street
	 * @param city
	 * @param postCode
	 * @param numberOfRooms
	 * @param rooms
	 * @throws IllegalArgumentException
	 */
	public House(int houseNumber, String street, String city, String postCode, int numberOfRooms) {
		super();
		if (houseNumber <= 0) {
			throw new IllegalArgumentException("Invalid House Number");
		}
		if (!street.matches("([A-Z])([a-z]*)(([\\s])([A-Z])([a-z]*))*")) {
			throw new IllegalArgumentException("Invalid Street Name");
		}
		if (!validateCity(city)) {
			throw new IllegalArgumentException("Invalid City Name");
		}
		if (!validatePostCode(postCode)) {
			throw new IllegalArgumentException("Invalid Post Code");
		}
		if (numberOfRooms <= 0) {
			throw new IllegalArgumentException("Invalid Number of Rooms");
		}
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.numberOfRooms = numberOfRooms;
		this.rooms = new HashMap<Room, ITenant>();
	}
	
	
	  /**
	   * @return the number of available rooms left in property
	   */
	public int getAvailableRooms() {
		return this.numberOfRooms - rooms.size();
	}
	
	
	  /**
	   * @return the price of property (price of all rooms combined)
	   */
	public double getPrice() {
		double total = 0.0;
		for (Room room : rooms.keySet()) {
			total = total + room.getPrice();
		}
		return total;
	}
	
	
	  /**
	   * @return whether there are available rooms in the property
	   */
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
	public void occupyRoom(Room room, ITenant tenant) {
		if (this.isAvailable()) {
			rooms.put(room,tenant);
		}
	}
	
	
	  /**
	   * @return display of info about property
	   */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(this.houseNumber + " ");
		buffer.append(this.street + ", ");
		buffer.append(this.city + " ");
		buffer.append(this.postCode + " (");
		buffer.append(this.numberOfRooms + " bedroom house :");
		buffer.append(this.getAvailableRooms() + " available)");
		return buffer.toString();
	}
	

	  /**
	   * @return whether a city name is valid
	   */
	private boolean validateCity(String city) {
		final String CITY_REGULAR_EXPRESSION = "([A-Z])([a-z]*)(([\\s])([A-Z])([a-z]*))*";
		boolean validity = false;
		if (city.matches(CITY_REGULAR_EXPRESSION)) {
			validity = true;
		}
		else {
			validity = false;
		}
		return validity;
	}
	
	
	  /**
	   * @return whether a post code is valid
	   */
	private boolean validatePostCode(String postCode) {
		final String PCODE_REGULAR_EXPRESSION = "[A-Z]{2}[0-9]{0,2} [0-9]{0,2}[A-Z]{0,2}";
		boolean validity = false;
		if (postCode.matches(PCODE_REGULAR_EXPRESSION)) {
			validity = true;
		}
		else {
			validity = false;
		}
		return validity;
	}
	
	
}
