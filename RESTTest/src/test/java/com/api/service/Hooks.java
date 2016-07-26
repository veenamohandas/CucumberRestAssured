package com.api.service;

import com.api.connection.Connection;

import io.restassured.RestAssured;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before
	public void before() {

	}

	@After
	public void after() {

		Connection.response = null;
		Connection.requestUrl=null;
	}
}
