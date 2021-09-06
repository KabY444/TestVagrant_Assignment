package com.Framework.TestVagrant;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_Library.LandingPage_Accuweather;
import page_Library.Weather_Details;
import resources.API_Base;
import resources.Base;

public class Test_Case extends Base {
	static String UI;
	static String API;
	@BeforeTest
	public void setUp() throws IOException {
		initializeDriver();
	}
	
	@Test
	public void TC01() throws IOException, Customized_Exception {
		LandingPage_Accuweather lp = new LandingPage_Accuweather(driver);
		lp.PopUp_01();
		lp.PopUp_02();
		lp.PopUp_03();
		lp.input_City();
		Weather_Details wd = lp.autosuggest_Drop();
		UI = wd.Temp();
		double x = Double.parseDouble(UI);
		RestAssured.baseURI=API_Base.baseURI();
		String response = given().queryParam("q", API_Base.city()).queryParam("units", "metric")
		.queryParam("appid", API_Base.appId() ).when().get("/data/2.5/weather")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		API = js.getString("main.temp");
		double y = Double.parseDouble(API);
		if(y-x>3) {
			Assert.assertTrue(true); // Success
		}
		else {
			throw new Customized_Exception(); // Custom Exception in case of Failure 
		}
	
	}
	@AfterTest
	public void closeBrowsers() {
		TearDown();
	}
}
