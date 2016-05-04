package FyberTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplicationHomePage {
	public static WebDriver driver = null;
	
	public  ApplicationHomePage(WebDriver driver) {
		this.driver = driver;	
	}
	
	static Map<String, WebElement> elements = new HashMap<>();

	static { 
//		elements.put("appid_field", driver.findElement(By.xpath("//EditText[@id='app_id_field']")));
//		elements.put("token_field", driver.findElement(By.xpath("//EditText[@id='security_token_field']")));
//		elements.put("staging_server_checkbox", driver.findElement(By.xpath("//CheckBox[@id='use_staging_urls_checkbox']")));
//		elements.put("start_sdk_button", driver.findElement(By.xpath("//Button[@id='start_sdk']")));
//		elements.put("interstitials_tab", driver.findElement(By.xpath("//Button[@value='Interstitial']")));	
	}
	
	public WebElement get_app_id() {
		elements.put("appid_field", driver.findElement(By.xpath("//EditText[@id='app_id_field']")));
		return elements.get("appid_field");
	}
}
