/**
 * 
 */
package org.com1027.question1;


/**
 * Defines the fields and methods of an Agency
 * 
 * @author ih00264
 *
 */
public class Agency {
	
	
	private String name = null;
	private String phoneNumber = null;
	
	
	
	/**
	 * @param name
	 * @param phoneNumber
	 * @throws IllegalArgumentException
	 */
	public Agency(String name, String phoneNumber) {
		super();
		if (!name.matches("([A-Z])([a-z]*)(([\\s])([A-Z])([a-z]*))*")) {
			throw new IllegalArgumentException("Invalid Agency Name");
		}
		if (!phoneNumber.matches("([0-9]{5})([\\s])([0-9]{6})")) {
			throw new IllegalArgumentException("Invalid Agency Phone Number");
		}
		this.name = name;
		this.phoneNumber = phoneNumber;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	
	
	  /**
	   * @return agency information.
	   */
	@Override
	public String toString() {
		return "Agency: " + this.name + ", Phone Number: " + this.phoneNumber;
	}
	
	
}
