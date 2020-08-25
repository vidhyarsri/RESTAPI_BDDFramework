$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/placeValidations.feature");
formatter.feature({
  "name": "Validating Map API\u0027s",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verifying Map API using CRUD operations using Data Driven concept",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "That url is entered",
  "keyword": "Given "
});
formatter.step({
  "name": "Add payload with \"\u003cname\u003e\"  \"\u003clanguage\u003e\" \"\u003caddress\u003e\" \"\u003cphoneNumber\u003e\"using Post Http request",
  "keyword": "When "
});
formatter.step({
  "name": "retrieve place_id\u0027s value from response body",
  "keyword": "And "
});
formatter.step({
  "name": "verify status is \"OK\" and scope is \"APP\" in response body",
  "keyword": "And "
});
formatter.step({
  "name": "update address as \"\u003cupdate address\u003e\" using Put Http request",
  "keyword": "When "
});
formatter.step({
  "name": "verify that updated response message is \"Address successfully updated\"",
  "keyword": "And "
});
formatter.step({
  "name": "clear data using Delete Http request. Check if status is \"OK\"",
  "keyword": "Then "
});
formatter.step({
  "name": "verify if data is successfully deleted using Get Http request and response message is \"Get operation failed, looks like place_id  doesn\u0027t exists\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "language",
        "address",
        "phoneNumber",
        "update address"
      ]
    },
    {
      "cells": [
        "AAHouse",
        "English",
        "32- SeaCross Center, USA",
        "(+91) 222 893 3007",
        "101 WestSide, USA"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verifying Map API using CRUD operations using Data Driven concept",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "That url is entered",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.entering_Url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add payload with \"AAHouse\"  \"English\" \"32- SeaCross Center, USA\" \"(+91) 222 893 3007\"using Post Http request",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.add_payload_using_post_Http_request(String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "retrieve place_id\u0027s value from response body",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.retrieve_PlaceId_from_response_body()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify status is \"OK\" and scope is \"APP\" in response body",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.verify_Status_And_Scope_In_response_body(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "update address as \"101 WestSide, USA\" using Put Http request",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.update_Address_Using_Put_HttpRequest(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that updated response message is \"Address successfully updated\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.verify_Updated_ResponseMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clear data using Delete Http request. Check if status is \"OK\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.clear_data_using_Delete_Http_request_check_if_status_is(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify if data is successfully deleted using Get Http request and response message is \"Get operation failed, looks like place_id  doesn\u0027t exists\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.verify_if_data_is_successfully_deleted_using_get_Http_request_and_response_message_is(String)"
});
formatter.result({
  "status": "passed"
});
});