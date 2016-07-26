package com.api.service;

//import io.restassured.response.Response;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;



import com.api.schema.PostRequestSchema;

//import com.github.fge.jsonschema.cfg.ValidationConfiguration;
//import com.github.fge.jsonschema.main.JsonSchemaFactory;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static com.github.fge.jsonschema.SchemaVersion.DRAFTV3;
import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
/**
 * Unit test for simple App.
 */
public class AppTest  {
	@Test
	public void getRequest() {
		String baseUrl = "http://jsonplaceholder.typicode.com";
		String requestUrl = "/posts/";
		String parameter = "1";
		String request = baseUrl + requestUrl + parameter;
		String postreq = "http://jsonplaceholder.typicode.com/posts/";
		PostRequestSchema param = new PostRequestSchema("foo", "bar", 1);
		Gson gson = new Gson();
		String postparam = gson.toJson(param);
		System.out.println(postparam);
		String response = given().contentType("application/json").body(postparam).post(postreq).asString();
		//Response r = given().contentType("application/json").formParam("title", "foo").formParam("body", "bar").formParam("userId", 1).when().post(postreq);
		//String response = r.getBody().asString();
		System.out.println(response);
		//long timeInMs = given().get(request).time();
		//System.out.println(timeInMs);
		// JsonSchemaFactory jsonSchemaFactory =
		// JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();
		// For verifyoing the the value of userId
		//given().get(request).then().body("userId", equalTo(1));

		// Matching schema
		// given().get(request).then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"));
		// String schema =
		 //IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream("products-schema.json"));
		
		//String schema = "{ \"title\": \"number\"}";
		
				//given().get(request).then().assertThat()
			//	.body(JsonSchemaValidator.matchesJsonSchema(schema));
				

		// When
		// given().get(request).then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"));

	}
	
	

}
