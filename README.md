# Lettings-Agency-System
Describes the property management side of a lettings agency that consists of a number of  properties  (shared)  that  have  one  or  more  room

Each question in 'src/org/com1027' correlates to a test in 'test/org/com1027'

Agency.java - defines the fields and methods of an Agency

Room.java - defines the fields and methods of a room in a property

House.java - maintains a map of the rooms and their allocated tenants in a house that can be occupied

Flat.java - similar to the House object represents the details of the flat and its tenants

ITenant.java - defines the expected behaviour for Tenant class

Tenant.java - implementation of ITenantan and provides the implementation of the interface methods 

TenantType - enumerated type to represent all possible types of tenant that can occupy properties

Property.java - abstract class that provides the structure for any property type; house or flat

PropertyManagement.java - consists of a list of properties, manages which tenants live there and displays information/infographics

