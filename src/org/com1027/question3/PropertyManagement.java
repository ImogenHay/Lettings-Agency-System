/**
 * 
 */
package org.com1027.question3;
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
	private List<Property> properties = null;
	
	
	
	/**
	 * @param estateAgency
	 */
	public PropertyManagement(Agency estateAgency) {
		super();
		this.estateAgency = estateAgency;
		this.properties = new ArrayList<Property>(); //when object created a new empty array list is created
	}
	
	
	/**
	 * @param property to be added to list of properties
	 */
	public void addProperty(Property property) {
		properties.add(property);
	}
	
	
	/**
	 * @param property to be occupied, room to be occupied, tenant that will occupy room
	 */
	public void addTenant(Property property, Room room, Tenant tenant) {
		property.occupyRoom(room, tenant);
	}
	
	
	/**
	 * @return info of all properties in list of properties depending on availability
	 */
	public String displayProperties() {
		StringBuffer buffer = new StringBuffer();
		for (Property property : properties) { //loop repeated for each property in list of properties
			if (property.isAvailable()) {
				buffer.append(property.toString() + "\n"); //adds output of toString method in property class to buffer
			}
			else {
				buffer.append(property.displayOccupiedProperty() + " (Council Tax: £"); //adds output of method in property class to display variable
				buffer.append(property.councilTax + ")\n");
			}		
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
	public void removeProperty(Property property) {
		if (!properties.contains(property)) { //checks if property passed to parameter is in this objects list of properties
			throw new IllegalArgumentException("Property not in List"); //throws exception if not in list to avoid errors in code
		}
		properties.remove(property); //can only remove properties that are in list of properties
	}
	
	
	/**
	 * @return percentage of properties managed by agency that are exempt from council tax
	 */
	public double percentageCouncilTaxExemption() {
		double exempt = 0.0;
		for (Property property : properties) { //loop repeated for each property in list of properties
			if (property.councilTax == 0.0 && !property.isAvailable()) { //if property fully occupied and exempt from tax
				exempt++;
			}
		}
		return (exempt/(properties.size()))*100;
	}
	
	
	/**
	 * @return display of information on properties managed by agency that are exempt from council tax
	 */
	public String displayAllCouncilTaxExemptProperties() {
		StringBuffer buffer = new StringBuffer();
		for (Property property : properties) { //loop repeated for each property in list of properties
			if (property.councilTax == 0.0 && !property.isAvailable()) { //if property fully occupied and exempt from tax
				buffer.append(property.displayOccupiedProperty() + "\n"); 
			}
		}
		return buffer.toString();
	}
}
