package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class API_Base {
	static Properties prop = new Properties();
	public static String baseURI() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\kanis\\eclipse-workspace\\TestVagrant\\src\\main\\java\\resources\\API_Global.properties");
		prop.load(fis);
		String Uri =  prop.getProperty("URI");
		return Uri; 
	}
	public static String city() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\kanis\\eclipse-workspace\\TestVagrant\\src\\main\\java\\resources\\API_Global.properties");
		prop.load(fis);
		String city = prop.getProperty("CITY");
		return city;
	}
	public static String appId() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\kanis\\eclipse-workspace\\TestVagrant\\src\\main\\java\\resources\\API_Global.properties");
		prop.load(fis);
		String API_Key = prop.getProperty("APPID");
		return API_Key;
	}
}
