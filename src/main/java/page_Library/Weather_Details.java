package page_Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Weather_Details {
	public WebDriver driver;
	
	private @FindBy(css="div.temp-container") WebElement Temperature;
	
	public Weather_Details(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String Temp() {
		String [] x= Temperature.getText().split("°C");
		String FormattedText = x[0];
		return FormattedText; 
	}
	
}
