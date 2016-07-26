package com.api.connection;
import java.io.IOException;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Connection {
	public static RequestSpecification connection =given();
	public static Response response=null;
	public static String requestUrl=null;

}
