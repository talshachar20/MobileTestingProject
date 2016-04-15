import static org.junit.Assert.*;

import java.util.HashMap;
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
	
public class Banner {
	
		public WebDriver driver = null;
		
		static HashMap<String, String> testData = new HashMap<String, String>();
		static {
			testData.put("fielddata", "tal test");
		}
		
		@Before
		public void testReady() throws Exception{
			SelendroidCapabilities capa = new SelendroidCapabilities("com.fyber.sdk.android.testapp:8.1.4-dev");
	    	driver = new SelendroidDriver(capa);
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 	    		
		}
		
		@Test 
		public void testRun() throws Exception {
			System.out.println("addin app details");

			WebElement appid = driver.findElement(By.xpath("//EditText[@id='app_id_field']"));
			appid.sendKeys("18829");
			WebElement secToken = driver.findElement(By.xpath("//EditText[@id='security_token_field']"));
			secToken.sendKeys("token");
			WebElement stagingServer = driver.findElement(By.xpath("//CheckBox[@id='use_staging_urls_checkbox']"));
			stagingServer.click();
			
			WebElement startSdk = driver.findElement(By.xpath("//Button[@id='start_sdk']"));
			startSdk.click();
			Thread.sleep(3000);   
			TouchActions action = new TouchActions(driver).scroll(0,800);
			action.perform();
			WebElement banner = driver.findElement(By.xpath("//Button[@value='Banners']"));
			banner.click();
			WebElement requestBanner = driver.findElement(By.xpath("//Button[@id='banner_request_ads']"));
			requestBanner.click();
			Thread.sleep(3000);  
			WebElement bannerView = driver.findElement(By.xpath("//Button[@id='banner_ad_view']"));
			bannerView.click();
			System.out.println("Requesting for banners");
			WebElement noBannerMessage = driver.findElement(By.xpath("//TextView[@id='message']"));
			
			assertEquals("no banner available",noBannerMessage.getText().toLowerCase());	
		}
		
		@After 
		public void tearDown() throws Exception{
			driver.quit();
		}
}


