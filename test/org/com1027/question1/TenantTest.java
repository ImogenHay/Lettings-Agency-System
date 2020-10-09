package org.com1027.question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TenantTest {

	@Test
	public void testGetAge() {
		Tenant tenant = new Tenant("Imogen", "Hay", 18, TenantType.STUDENT);
		assertEquals(18, tenant.getAge());
	}
	
	
	@Test
	public void testGetType() {
		Tenant tenant = new Tenant("Imogen", "Hay", 18, TenantType.STUDENT);
		assertEquals(TenantType.STUDENT, tenant.getType());
	}
	

	@Test
	public void testToString() {
		Tenant tenant = new Tenant("Imogen", "Hay", 18, TenantType.STUDENT);
		assertEquals("Imogen Hay", tenant.toString());
	}
	
	
	@Test
	public void testSecondGetAge() {
		Tenant tenant = new Tenant("Lester", "De Winter", 100, TenantType.PROFESSIONAL);
		assertEquals(100, tenant.getAge());
	}
	
	
	@Test
	public void testSecondGetType() { 
		Tenant tenant = new Tenant("Lester", "De Winter", 100, TenantType.PROFESSIONAL);
		assertEquals(TenantType.PROFESSIONAL, tenant.getType());
	}
	

	@Test
	public void testSecondToString() {
		Tenant tenant = new Tenant("Lester", "De Winter", 100, TenantType.PROFESSIONAL);
		assertEquals("Lester De Winter", tenant.toString());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTenantName() {
		Tenant tenant = new Tenant("imogen", "Hay", 18, TenantType.STUDENT);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSecondInvalidTenantName() {
		Tenant tenant = new Tenant("Im0gen", "Hay", 18, TenantType.STUDENT);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTenantSurname() {
		Tenant tenant = new Tenant("Imogen", "hay", 18, TenantType.STUDENT);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSecondInvalidTenantSurname() {
		Tenant tenant = new Tenant("Imogen", "Hay!", 18, TenantType.STUDENT);
	}
	
	
	@Test(expected = IllegalArgumentException.class) //test upper boundary of age
	public void testInvalidTenantAgeUpperBoundary() {
		Tenant tenant = new Tenant("Imogen", "Hay", 200, TenantType.STUDENT);
	}
	
	
	@Test(expected = IllegalArgumentException.class) //test lower boundary of age
	public void testInvalidTenantAgeLowerBoundary() {
		Tenant tenant = new Tenant("Imogen", "Hay", -1, TenantType.STUDENT);
	}
	
}
