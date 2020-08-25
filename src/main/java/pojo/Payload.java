package pojo;

import java.util.ArrayList;

public class Payload {


	//*****************Setting values for all the payloads(Post,Delete and Put)
	//All 3 methods are declared as static. Static keyword belongs to a class. It can be invoked without an Object in another class

	public static AddPlace addPlacePayLoad(String name, String language, String address, String phoneNumber) //expects parameters name, language,address and phoneNumber. These parameters are treated as local variables
	{
		AddPlace addPlace = new AddPlace(); //Creating an Object for class "AddPlace", to access its methods, and set the values for "Post" request payload
		Location location = new Location(); //Creating an Object for class "Location" to access its methods, and set the values for "Post" request payload

		ArrayList<String> myList = new ArrayList<String>();
		myList.add("shoe park");  //ArrayList holds multiple values
		myList.add("shop");

		location.setLat(-38.383494);
		location.setLng(33.427362);

		addPlace.setAccuracy(50);
		addPlace.setAddress(address);
		addPlace.setLanguage(language);
		addPlace.setPhone_number(phoneNumber);
		addPlace.setWebsite("https://rahulshettyacademy.com");
		addPlace.setName(name);
		addPlace.setTypes(myList);
		addPlace.setLocation(location);

		return addPlace;   //"addPlace" along with its assinged values, will build JSON request body, which can be used for "Post" http request
	}

	public static UpdatePlace putPlacePayload(String placeId, String address) //Expects parameters "placeId" and "address" to update an address, using "Put" http request
	{
		UpdatePlace put = new UpdatePlace();  //Creating an Object for "updatePlace" class to access its methods, and set the values for "put" request payload

		put.setPlace_id(placeId);
		put.setAddress(address);
		put.setKey("qaclick123");
		return put;   //"put" along with its assinged values, will build JSON request body, which can be used for "Put" http request to update an address
	}

	public static DeletePlace deletePlacePayload(String placeId) //expects argument "placeId", to delete an address
	{
		DeletePlace delete = new DeletePlace();  //Creating an Object for "DeletePlace" class to access its methods, and set the values for "delete" request payload

		delete.setPlace_id(placeId);
		return delete;//"delete" along with its assigned values, will build JSON request body, which can be used for "delete" http request

	}

}
