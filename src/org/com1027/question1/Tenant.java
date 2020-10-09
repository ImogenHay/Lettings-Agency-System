/**
 * 
 */
package org.com1027.question1;

/**
 * Defines the fields and methods of a tenant that can occupy a property
 * 
 * @author ih00264
 *
 */
public class Tenant implements ITenant{

	private String name = null;
	private String surname = null;
	private int age = 0;
	private TenantType type = null;
	
	
	
	/**
	 * @param name
	 * @param surname
	 * @param age
	 * @param type
	 * @throws IllegalArgumentException
	 */
	public Tenant(String name, String surname, int age, TenantType type) {
		super();
		if (!name.matches("([A-Z])([a-z]*)")) {
			throw new IllegalArgumentException("Invalid Tenant Name");
		}
		if (!surname.matches("([A-Z])([a-z]*)(([\\s])([A-Z])([a-z]*))*")) {
			throw new IllegalArgumentException("Invalid Tenant Surame");
		}
		if (age <= 0||age >= 200) {
			throw new IllegalArgumentException("Invalid Tenant Age");
		}
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.type = type;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	
	/**
	 * @return type of tenant
	 */
	@Override
	public TenantType getType() {
		return this.type;
	}
	
	
	/**
	 * @return display of tenants full name
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(this.name + " ");
		buffer.append(this.surname);
		return buffer.toString();
	}
	
}
