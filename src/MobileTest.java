import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import org.openqa.selenium.interactions.touch.TouchActions;

public class MobileTest {
	public WebDriver driver = null;
	
	static HashMap<String, String> testData = new HashMap<String, String>();
	static {
		testData.put("fielddata", "tal test");
	}

	
	@Before
	public void testReady() throws Exception{
    	SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.17.0");
    	driver = new SelendroidDriver(capa);
    	//Thread.sleep(12000);   	    		
	}
	
	@Test 
	public void testRun() throws Exception {
		System.out.println("getting element:");
		WebElement testField = driver.findElement(By.xpath("//EditText[@id='my_text_field']"));
		testField.sendKeys(testData.get("fielddata"));
		assertEquals(testData.get("fielddata"), testField.getText().toLowerCase());	
	}
	
	@Test 
	public void testRun2() throws Exception {
		System.out.println("getting element:");
		WebElement testField = driver.findElement(By.xpath("//EditText[@id='my_text_field']"));
		testField.sendKeys(testData.get("fielddata"));
		assertFalse(testField.getText().toLowerCase().equals("bobo"));
	}
	
	@After 
	public void tearDown() throws Exception{
		driver.quit();
	}
}
