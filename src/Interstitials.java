import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import org.openqa.selenium.interactions.touch.TouchActions;
	
public class Interstitials {
	
		public WebDriver driver = null;
		
		static HashMap<String, String> testData = new HashMap<String, String>();
		static {
			testData.put("application_id", "9685");
			testData.put("token", "token");
			testData.put("application_package", "com.fyber.sdk.android.testapp:8.1.6-dev");
		}
		Map<String, WebElement> elements = new HashMap<>();
		public void fillElelments(){ 
			elements.put("appid_field", driver.findElement(By.xpath("//EditText[@id='app_id_field']")));
			elements.put("token_field", driver.findElement(By.xpath("//EditText[@id='security_token_field']")));
			elements.put("staging_server_checkbox", driver.findElement(By.xpath("//CheckBox[@id='use_staging_urls_checkbox']")));
			elements.put("start_sdk_button", driver.findElement(By.xpath("//Button[@id='start_sdk']")));
			elements.put("interstitials_tab", driver.findElement(By.xpath("//Button[@value='Interstitial']")));
			elements.put("request_ads", driver.findElement(By.xpath("//Button[@id='interstitial_request_ads']")));
			elements.put("show_ad", driver.findElement(By.xpath("//Button[@id='interstitial_play_ads']")));			
		}
		
		@Before
		public void testReady() throws Exception{
			SelendroidCapabilities capa = new SelendroidCapabilities(testData.get("application_package"));
	    	driver = new SelendroidDriver(capa);
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	    	fillElelments();
		}
		
		@Test 
		public void testRun() throws Exception {
			System.out.println("addin app details");
			elements.get("appid_field").sendKeys(testData.get("application_id"));
			elements.get("token_field").sendKeys(testData.get("token"));
			elements.get("staging_server_checkbox").click();
			elements.get("start_sdk_button").click();
			Thread.sleep(3000);   
			TouchActions action = new TouchActions(driver).scroll(0,800);
			action.perform();
			elements.get("interstitials_tab").click();
			clickTwice(elements.get("request_ads"));
			Thread.sleep(10000);
			assertEquals(true, elements.get("show_ad").isEnabled());	
		}
		
		@After 
		public void tearDown() throws Exception{
			driver.quit();
		}
		
		private void clickTwice(WebElement buttonElement) throws InterruptedException {
			buttonElement.click();
			Thread.sleep(3000);
			buttonElement.click();
		}
}


