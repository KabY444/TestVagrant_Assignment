package resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\kanis\\eclipse-workspace\\TestVagrant\\src\\main\\java\\resources\\Global.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String website = prop.getProperty("UI_Source");

		if (browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Automation_WorkSpace\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(website.equalsIgnoreCase("https://www.accuweather.com/")) {
			driver.get(website);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
