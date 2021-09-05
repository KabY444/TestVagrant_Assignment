package com.Framework.TestVagrant;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_Library.LandingPage_Accuweather;
import page_Library.Weather_Details;
import resources.Base;


public class Test_Case extends Base {
	@BeforeMethod
	@BeforeTest
	public void setUp() throws IOException {
		initializeDriver();
	}
	
	@Test
	public void TC01() {
		LandingPage_Accuweather lp = new LandingPage_Accuweather(driver);
		lp.PopUp_01();
		lp.PopUp_02();
		lp.PopUp_03();
		lp.input_City();
		Weather_Details wd = lp.autosuggest_Drop();
		wd.Temp();
	}
	@AfterTest
	public void closeBrowsers() {
		TearDown();
	}
}
