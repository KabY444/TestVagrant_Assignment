package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class API_Base {
	static Properties prop = new Properties();
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\kanis\\eclipse-workspace\\TestVagrant\\src\\main\\java\\resources\\API_Global.properties");
		prop.load(fis);
	}
	public String baseURI() {
		String Uri =  prop.getProperty("URI");
		return Uri;
	}
	public String city() {
		String city = prop.getProperty("CITY");
		return city;
	}
	public String appId() {
		String API_Key = prop.getProperty("APPID");
		return API_Key;
	}
	

}
