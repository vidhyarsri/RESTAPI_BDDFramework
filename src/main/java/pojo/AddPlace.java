package pojo;

import java.util.List;

public class AddPlace {

	/*  
	 ****************Sample request payload*************
{
"location": {
"lat": double,  =============Nested JSON
"lng": double,
},
"accuracy": int,
"name": "String",
"phone_number": "String",
"address": "String",
"types": [        
"String",       =============Array: "types" contains List of Elements
"String"
],
"website": "String",
"language": "String"
}
	 */

	//All the Variables are declared as Private. The values for these variable are set through its corresponding "setMethods" and retrieved through "getMethods"
	private int accuracy;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	private Location location;
	//private Location location; //Location is a Nested JSON. Have created another class for location variables.
	private List<String> types; //"types" contains List of Elements

	//Set and Get methods for all the variables 
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}


}
