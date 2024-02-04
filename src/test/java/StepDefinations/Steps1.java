package StepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resource.TestDataBuild;
import resource.Utils;

public class Steps1 extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
//	RequestSpecification req;
	Response response;
	
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload with {string}  {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {
		    // Write code here that turns the phrase above into concrete actions
		
			 
			 res=given().spec(requestSpections())
			.body(data.addPlacePayload(name,language,address));
		}
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		
		response= res.when().post("/maps/api/place/add/json")
				.then().spec(responseSpections()).extract().response();
	}

	@Then("The api call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in responsebody is {string}")
	public void in_responsebody_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		assertEquals(js.get(keyValue).toString(),Expectedvalue);
	}


}
