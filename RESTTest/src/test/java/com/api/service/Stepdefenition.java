package com.api.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import javax.rmi.CORBA.Util;

import junit.framework.Assert;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.specification.RequestSpecification;

import com.api.collection.SampleService;
import com.api.connection.Connection;
import com.api.schema.PatchRequestSchema;
import com.api.schema.PostRequestSchema;
import com.api.schema.PutRequestSchema;
import com.github.fge.jsonschema.examples.Utils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefenition {

	@Given("^I am calling GetUser request\\.$")
	public void i_am_calling_GetUser_request() throws Throwable {
		Connection.requestUrl = SampleService.getUserRequest;
	}

	@When("^I am calling request with url parameter \"(.*?)\"$")
	public void i_am_calling_GetUser_request_with_parameter(String arg)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//
		Connection.requestUrl = Connection.requestUrl + arg;
	}

	@Then("^I fire the get request\\.$")
	public void i_fire_the_request() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Connection.response = Connection.connection.get(Connection.requestUrl);
		// System.out.println(Connection.response.asString());
	}

	@Then("^I should be able to get the response in \"(.*?)\" milliSeconds\\.$")
	public void i_should_be_able_to_get_the_response_in_milliSeconds(String arg1)
			throws Throwable {
		long time = Connection.response.time();
		// System.out.println("The time of request is :"+time);
		long expectedTime = Long.parseLong(arg1);
		Assert.assertTrue(time < expectedTime);

	}

	@Then("^I should be able to see the get response userId=\"(.*?)\"$")
	public void i_should_be_able_to_see_the_get_response_userId(String arg1)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//

		Connection.response.then().body("userId",
				equalTo(Integer.parseInt(arg1)));
		String response = Connection.response.asString();
		System.out.println(response);
	}

	@Then("^I should be able to see the get response Id=\"(.*?)\"$")
	public void i_should_be_able_to_see_the_get_response_Id(String arg1)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//
		// given.get(requestUrl).then()
		Connection.response.then().body("id", equalTo(Integer.parseInt(arg1)));
	}

	@Then("^I should be able to see the get response title as a valid string$")
	public void i_should_be_able_to_see_the_get_response_title_as_a_valid_string()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Connection.response.then().body("title", is(String.class));
	}

	@Then("^I should be able to see the get response body as a valid string$")
	public void i_should_be_able_to_see_the_get_response_body_as_a_valid_string()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Connection.response.then().body("body", is(String.class));

	}

	@Given("^I am calling PostUser request\\.$")
	public void i_am_calling_PostUser_request() throws Throwable {
		Connection.requestUrl = SampleService.postUserRequest;
	}

	@Then("^I set title body and userId$")
	public void i_set_title_body_userID() throws Throwable {
		PostRequestSchema param = new PostRequestSchema("foo", "bar", 1);
		Gson gson = new Gson();
		String parameters = gson.toJson(param);
		Connection.response = Connection.connection
				.contentType("application/json").body(parameters)
				.post(Connection.requestUrl);
	}

	@Then("^I fire the post request\\.$")
	public void i_fire_the_post_request() throws Throwable {

		String response = Connection.response.asString();
		Connection.response.then().statusCode(201);
		System.out.println(response);

	}

	@Then("^I should be able to see the post response title=\"(.*?)\"$")
	public void i_should_be_able_to_see_the_get_response_title(String title)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Connection.response.then().body("title", equalTo(title));

	}

	@Then("^I should be able to see the post response body=\"(.*?)\"$")
	public void i_should_be_able_to_see_the_get_response_body(String body)
			throws Throwable {
		Connection.response.then().body("body", equalTo(body));
	}

	@Then("^I should be able to see the post response userId=\"(.*?)\"$")
	public void i_should_be_able_to_see_the_post_response_userId(String UserId)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Connection.response.then().body("userId",
				equalTo(Integer.parseInt(UserId)));

	}

	@Then("^I should be able to see the post response Id=\"(.*?)\"$")
	public void i_should_be_able_to_see_the_post_response_Id(String arg1)
			throws Throwable {
		Connection.response.then().body("id", equalTo(Integer.parseInt(arg1)));
	}

	@Then("^I should be able to see the response code as \"(.*?)\" Ok\\.$")
	public void i_should_be_bale_to_see_the_response_code_as_Ok(String arg1)
			throws Throwable {
		Connection.response.then().statusCode(Integer.parseInt(arg1));
	}

	@Given("^I am calling PutUser request\\.$")
	public void i_am_calling_PutUser_request() throws Throwable {
		Connection.requestUrl = SampleService.putUserRequest;
	}

	@Then("^I set title,body,id and userId for put request$")
	public void i_set_title_body_id_and_userId_for_put_request()
			throws Throwable {
		PutRequestSchema param = new PutRequestSchema("foo", "bar", 1);
		Gson gson = new Gson();
		String parameters = gson.toJson(param);
		Connection.response = Connection.connection
				.contentType("application/json").body(parameters)
				.put(Connection.requestUrl);
	}

	@Then("^I fire the put request\\.$")
	public void i_fire_the_put_request() throws Throwable {
		String response = Connection.response.asString();
		Connection.response.then().statusCode(200);
		System.out.println(response);
	}

	@Given("^I am calling PatchUser request\\.$")
	public void i_am_calling_PatchUser_request() throws Throwable {
		Connection.requestUrl = SampleService.patchUserRequest;
	}

	@Then("^I set title: \"(.*?)\" for put request$")
	public void i_set_title_for_put_request(String arg1) throws Throwable {
		PatchRequestSchema param = new PatchRequestSchema(arg1);
		Gson gson = new Gson();
		String parameters = gson.toJson(param);
		Connection.response = Connection.connection
				.contentType("application/json").body(parameters)
				.patch(Connection.requestUrl);
	}

	@Then("^I fire patch request$")
	public void i_fire_patch_request() throws Throwable {
		System.out.println(Connection.response.asString());

	}

	@Given("^I am calling DeleteUser request$")
	public void i_am_calling_DeleteUser_request() throws Throwable {
		Connection.requestUrl = SampleService.deleteUsersRequest;
	}

	@Then("^I fire the Delete request$")
	public void i_fire_the_Delete_request() throws Throwable {
		Connection.response = Connection.connection
				.delete(Connection.requestUrl);
		System.out.println(Connection.response.asString());
	}

}
