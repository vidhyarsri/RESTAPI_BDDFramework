package stepDefinitions;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.Payload;
import static io.restassured.RestAssured.given;



public class StepDefinitions  
{
	//Every step in features file has its corresponding method in StepDefinitions class
    
    //Variables are declared globally (at class level), so all the methods can access it
	Logger logger;          //log4j- Logger class captures info/activities at the time of program execution, using logs such as, info, warn, error and fatal
	String postResponse;    //captures response body of post request
	String updatedResponse; //captures response body of put request
	String deleteResponse;  //captures response body of delete request
	String getResponse;     //captures response body of get request
	String placeId;         //captures a PlaceId after adding an address
	Properties prop;        //Created Properties class object to read properties file
	JsonPath postJsonPath;  //creating an object for JsonPath class to retrieve each nodes in "post" response body
	JsonPath putJsonPath;   //creating an object for JsonPath class to retrieve data from "put" response body
	JsonPath deleteJsonPath;//creating an object for JsonPath class to retrieve data from "delete" response body
	JsonPath getJsonPath;   //creating an object for JsonPath class to retrieve data from "get" response body



	@Given("That url is entered")
	public void entering_Url() 
	{ 

		logger=Logger.getLogger("MapsAPI");  //getLogger method- Retrieves a logger named according to the value of the name parameter("MapsAPI")
		PropertyConfigurator.configure("Log4j.properties"); //A Log report is generated based on the configurations specified in "Log4j.properties" file, in project directory

		try {
			prop =new Properties();   //Creating an object for Properties class to read data in config.properties file.
			FileInputStream file = new FileInputStream("./Configuration/config.properties");//FileInputStream class to specify path for properties file.
			prop.load(file); //Integrates Properties class with FileInputStream path
		}catch (Exception e) {
			System.out.println("Exception is: "+ e.getMessage());//In case of failure, the fail message is captured here.
		}


		logger.info("Url"); //log 4j
		RestAssured.baseURI  = prop.getProperty("url"); //"getProperty" reads data from properties file to access the URL

	}

	
	@When("Add payload with {string}  {string} {string} {string}using Post Http request")
	public void add_payload_using_post_Http_request(String name, String language, String address, String phoneNumber) //expects parameters name, language,address and phoneNumber. These parameters are treated as local variables
	//parameters will receive values from feature file, which will be placed in "addPlacePayLoad" method in "Payload" class, to build a "post" request payload 
	{
		logger.info("Sending \"POST\" request and extracting the response as a String");
		//given: Pre-conditions such as, path or query parameter, contentType and request body
		//When: are actions such as, Post, get, delete or get request
		//then: Output/validations
		postResponse =given().queryParam(prop.getProperty("key")).contentType(prop.getProperty("header")).body(Payload.addPlacePayLoad(name, language, address, phoneNumber))
				     .when().post(prop.getProperty("post")) //Sending a post http request to the server 
				     .then().extract().response().asString(); //extracting values from "post" response body as String, and storing them in variable "postResponse"
	}

	@When("retrieve place_id's value from response body")
	public void retrieve_PlaceId_from_response_body() 
	{
		logger.info("Extract \"Place_Id\" from \"post\" response body");
		postJsonPath= new JsonPath(postResponse); //Creating an object for JsonPath class and parsing the "postResponse" variable to retrieve each nodes in "post" Json response body
		placeId= postJsonPath.getString("place_id"); //extracting place_id's value from "post" Json response body
		System.out.println("\n*********PlaceID: "+placeId);
	}

	@When("verify status is {string} and scope is {string} in response body")
	public void verify_Status_And_Scope_In_response_body(String arg1, String arg2) //parameters receives data from features file
	{
		logger.info("Verifying Status and Scope in \"Post\" response body");
	    Assert.assertEquals(arg1, postJsonPath.get("status"));  //Comparing expected and and actual results
		Assert.assertEquals(arg2,postJsonPath.get("scope"));


	}

	//In this method, address is updated based on "place_id", which was retrieved in previous method, using "Put" http request 
	@When("update address as {string} using Put Http request")
	public void update_Address_Using_Put_HttpRequest(String updateAddress) //parameter receives "updateAddress" data from feature file, which will be placed in "putPlacePayLoad" method in "Payload" class, to build "put" request payload
	{
		logger.info("Sending \"Put\" request to update the address and extracting the response as a String");
		updatedResponse = given().queryParam(prop.getProperty("key")).contentType(prop.getProperty("header")).body(Payload.putPlacePayload(placeId, updateAddress))
				.when().put(prop.getProperty("put"))
				.then().extract().response().asString(); //extracting values in "put" response body as String, and storing them in variable "updatedResponse"
	}

	@When("verify that updated response message is {string}")
	public void verify_Updated_ResponseMessage(String message) 
	{
		logger.info("Verifying updated message in \"Put\" response body");
		putJsonPath= new JsonPath(updatedResponse); //Creating an object for JsonPath class and parsing the "updatedResponse" variable to retrieve updated message in "put" Json response body
		Assert.assertEquals(message, putJsonPath.get("msg"));
	}

	//In this method, address is deleted, using "Delete" http request 
	@Then("clear data using Delete Http request. Check if status is {string}")
	public void clear_data_using_Delete_Http_request_check_if_status_is(String status) //parameter receives data from feature file, which will be used in "deletePlacePayload" method in "Payload" class, to build "delete" request payload
	{
		logger.info("Sending \"Delete\" request to clear the address and extracting the response as a String");
		deleteResponse =given().queryParam(prop.getProperty("key")).contentType(prop.getProperty("header")).body(Payload.deletePlacePayload(placeId))
				       .when().delete(prop.getProperty("delete"))
				       .then().extract().response().asString(); //extracting values in "delete" response body as String, and storing them in variable "deleteResponse"

		logger.info("verifying if status is \"OK\" in response body, after deleting the address");
		deleteJsonPath= new JsonPath(deleteResponse); //Creating an object for JsonPath class and parsing the "deleteResponse" variable to retrieve values in "delete" Json response body
		Assert.assertEquals(status, deleteJsonPath.get("status"));

	}

	//In this method, address is retrieved through "get" http request, using "place_id" which was retrieved in previous method
	@Then("verify if data is successfully deleted using Get Http request and response message is {string}")
	public void verify_if_data_is_successfully_deleted_using_get_Http_request_and_response_message_is(String deleteMessage) //parameter "String deleteMessage" receives data from feature file
	{
		logger.info("Verifying if address has been successfully deleted using \"Get\" request"); 
		getResponse= given().queryParam("key", "qaclick123").queryParam("place_id", placeId) //.body not required for "get" request
				    .when().get(prop.getProperty("get"))
				    .then().extract().response().asString(); //extracting values in "get" response body as String, and storing them in variable "getResponse"

		getJsonPath= new JsonPath(getResponse);//Creating an object for JsonPath class and parsing the "getResponse" variable to retrieve values in "get" Json response body
		Assert.assertEquals(deleteMessage, getJsonPath.get("msg"));
	}

}