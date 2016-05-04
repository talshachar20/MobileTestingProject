package page_obects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplicationInterstitialsTab {
	public static WebDriver driver = null;
	
	public ApplicationInterstitialsTab(WebDriver driver) {
		this.driver = driver;
	}
	static Map<String, WebElement> elements = new HashMap<>();
//	static{ 
//		elements.put("request_ads", driver.findElement(By.xpath("//Button[@id='interstitial_request_ads']"))); //this won't work since we loading future page
//		elements.put("show_ad", driver.findElement(By.xpath("//Button[@id='interstitial_play_ads']")));			
//	}
	
	public WebElement request_ads_interstitials() {
		elements.put("request_ads", driver.findElement(By.xpath("//Button[@id='interstitial_request_ads']")));
		return elements.get("request_ads");
	}
	
	public WebElement show_ad() {
		elements.put("show_ad", driver.findElement(By.xpath("//Button[@id='interstitial_play_ads']")));
		return elements.get("show_ad");
	}
}
