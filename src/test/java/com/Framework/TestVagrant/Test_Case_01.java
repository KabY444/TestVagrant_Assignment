package com.Framework.TestVagrant;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_Library.LandingPage_Accuweather;
import resources.Base;


public class Test_Case_01 extends Base {
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
		lp.autosuggest_Drop();
	}
}
