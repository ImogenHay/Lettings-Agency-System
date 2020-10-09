/**
 * 
 */
package org.com1027.question4optional;
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
	
	
	/**
	 * @return display of age infographics 
	 */
	public String displayInfographics() {
		StringBuffer buffer = new StringBuffer("Age Group of Tenants:\n");
		int age0to16 = 0;
		int age17to25 = 0;
		int age26to35 = 0;
		int age36to49 = 0;
		int age50to60 = 0;
		int age60plus = 0;
		double total = 0.0;
		
		int students = 0;
		int professionals = 0;
		int avr_students = 0;
		int avr_professionals = 0;
		
		for (Property property : properties) { 
			for (ITenant tenant : property.rooms.values()) {
				total++;
				if (tenant.getAge() < 17) {
					age0to16++;
				}
				else if (tenant.getAge() < 26){
					age17to25++;
				}
				else if (tenant.getAge() < 36){
					age26to35++;
				}
				else if (tenant.getAge() < 50){
					age36to49++;
				}
				else if (tenant.getAge() < 61){
					age50to60++;
				}
				else {
					age60plus++;
					
				}
				if (tenant.getType() == TenantType.STUDENT) {
					students++;
					avr_students += tenant.getAge(); 
				}
				else {
					professionals++;
					avr_professionals += tenant.getAge();
				}
			}
		}
	buffer.append((age0to16/total)*100 + "% 0-16\n");
	buffer.append((age17to25/total)*100 + "% 17-25\n");
	buffer.append((age26to35/total)*100 + "% 26-35\n");
	buffer.append((age36to49/total)*100 + "% 36-49\n");
	buffer.append((age50to60/total)*100 + "% 50-60\n");
	buffer.append((age60plus/total)*100 + "% 60+\n");
	
	buffer.append("\nAverage Age of Students = " + avr_students/students);
	buffer.append("\nAverage Age of Professionals = " + avr_professionals/professionals);
	
	System.out.println(buffer.toString());
	return buffer.toString();
	}
}
