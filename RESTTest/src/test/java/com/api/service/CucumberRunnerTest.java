package com.api.service;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.api.connection.Connection;
import com.api.service.config.Config;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/feature/", tags = Config.tags, plugin = { "pretty",
		"html:target/cucumber" })
public class CucumberRunnerTest {
	
	@BeforeClass
	public static void setProxyConnection(){
		System.out.println("Setting up proxy");
		//Connection.connection.proxy("proxy.domain.com", 8080, "https");
		
	}
}
