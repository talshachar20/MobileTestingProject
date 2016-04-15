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
		}
		Map<String, WebElement> elements = new HashMap<>();
		public void fillElelments(){ 
			elements.put("appid_field", driver.findElement(By.xpath("//EditText[@id='app_id_field']")));
			elements.put("token_field", driver.findElement(By.xpath("//EditText[@id='security_token_field']")));
		}
		
		@Before
		public void testReady() throws Exception{
			SelendroidCapabilities capa = new SelendroidCapabilities("com.fyber.sdk.android.testapp:8.1.6-452");
	    	driver = new SelendroidDriver(capa);
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	    	fillElelments();
		}
		
		@Test 
		public void testRun() throws Exception {
			System.out.println("addin app details");
			elements.get("appid_field").sendKeys(testData.get("application_id"));
			elements.get("token_field").sendKeys(testData.get("token_field"));
			WebElement stagingServer = driver.findElement(By.xpath("//CheckBox[@id='use_staging_urls_checkbox']"));
			stagingServer.click();
			
			WebElement startSdk = driver.findElement(By.xpath("//Button[@id='start_sdk']"));
			startSdk.click();
			Thread.sleep(3000);   
			TouchActions action = new TouchActions(driver).scroll(0,800);
			action.perform();
			WebElement interstitialTab = driver.findElement(By.xpath("//Button[@value='Interstitial']"));
			interstitialTab.click();
			WebElement requestAds = driver.findElement(By.xpath("//Button[@id='interstitial_request_ads']"));
			requestAds.click();
			Thread.sleep(3000);  		
			//assertEquals("no banner available",noBannerMessage.getText().toLowerCase());	
		}
		
		@After 
		public void tearDown() throws Exception{
			driver.quit();
		}
}


