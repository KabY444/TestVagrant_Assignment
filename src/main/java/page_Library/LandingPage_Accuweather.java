package page_Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage_Accuweather {
	public WebDriver driver; 
	
	//private @FindBy(xpath = "//input[@name='commit']") WebElement Submit;
	
	private @FindBy(xpath="//div[text()='I Understand']") WebElement popUp_01;
	private @FindBy(xpath="//button[text()='No, Thanks']") WebElement popUp_02;
	private @FindBy(css="svg.pro-tip__close.close-icon" ) WebElement popUp_03;
	private @FindBy(css="input.search-input") WebElement Input_TextField;
	
	public LandingPage_Accuweather(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void PopUp_01() {
		popUp_01.click();
	}
	public void PopUp_02() {
		popUp_02.click();
	}
	public void PopUp_03() {
		popUp_03.click();
	}
	public void input_City() {
		Input_TextField.sendKeys("Delhi");
	}
	public void autosuggest_Drop() {
		List<WebElement> options = driver.findElements(By.cssSelector("div.results-container div"));
		
		for(WebElement store : options) {
			if(store.getText().equalsIgnoreCase("Delhi, Delhi, IN")) {
				store.click();
				break;
			}
		}
	}
	
}


