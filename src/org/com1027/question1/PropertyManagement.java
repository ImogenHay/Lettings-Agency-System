/**
 * 
 */
package org.com1027.question1;
import java.util.ArrayList;
import java.util.List;

/**
 * Defines the fields and methods of class that manages properties
 * 
 * @author ih00264
 *
 */
public class PropertyManagement {

	/** Agency that manages properties */
	private Agency estateAgency = null;
	
	/** List of properties managed by Agency*/
	private List<House> properties = null;
	
	
	
	/**
	 * @param estateAgency
	 */
	public PropertyManagement(Agency estateAgency) {
		super();
		this.estateAgency = estateAgency;
		this.properties = new ArrayList<House>(); //when object created a new empty array list is created
	}
	
	
	/**
	 * @param property to be added to list of properties
	 */
	public void addProperty(House property) {
		properties.add(property);
	}
	
	
	/**
	 * @param property to be occupied, room to be occupied, tenant that will occupy room
	 */
	public void addTenant(House property, Room room, Tenant tenant) {
		property.occupyRoom(room, tenant);
	}
	
	
	/**
	 * @return info of all properties in list of properties
	 */
	public String displayProperties() {
		StringBuffer buffer = new StringBuffer(); //creates StringBuffer object to make it easy to append more Strings
		for (House property : properties) { //loop repeated for each property in list of properties
			buffer.append(property.toString() + "\n"); //adds output of toString method in House class to buffer
		}
		return buffer.toString(); //returns string displaying info on all properties in list depending on availability
	}
	
	
	/**
	 * @return agency information
	 */
	public String getEstateAgency() {
		return estateAgency.toString();
	}
	
	
	/**
	 * @param property that will be removed from list
	 * @throws IllegalArgumentException
	 */
	public void removeProperty(House property) {
		if (!properties.contains(property)) { //checks if property passed to parameter is in this objects list of properties
			throw new IllegalArgumentException("Property not in List"); //throws exception if not in list to avoid errors in code
		}
		properties.remove(property); //can only remove properties that are in list of properties
	}
	
	
}
