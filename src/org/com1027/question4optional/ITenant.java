/**
 * 
 */
package org.com1027.question4optional;

/**
 *  Defines the expected behaviour for Tenant class
 * 
 * @author ih00264
 *
 */
public interface ITenant {

	public int getAge();
	
	
	/**
	 * @return type of tenant
	 */
	public TenantType getType();
	
	
	/**
	 * @return information about tenant
	 */
	public String toString();
	
	
}
