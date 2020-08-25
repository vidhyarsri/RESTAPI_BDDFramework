Feature: Validating Map API's

Scenario Outline: Verifying Map API using CRUD operations using Data Driven concept
    Given That url is entered
    When Add payload with "<name>"  "<language>" "<address>" "<phoneNumber>"using Post Http request
	And retrieve place_id's value from response body
	And verify status is "OK" and scope is "APP" in response body
	When update address as "<update address>" using Put Http request
	And verify that updated response message is "Address successfully updated"
	Then clear data using Delete Http request. Check if status is "OK" 
	And  verify if data is successfully deleted using Get Http request and response message is "Get operation failed, looks like place_id  doesn't exists"

	
	Examples:
	|name 	 | language |address		          |phoneNumber       |update address|
	|AAHouse | English  |32- SeaCross Center, USA |(+91) 222 893 3007|101 WestSide, USA|
