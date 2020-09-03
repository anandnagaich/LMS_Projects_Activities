package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_8 {
	static WebDriver driver;
	static WebDriverWait wait;


	@BeforeMethod
	public void OpenBrowser() {
		driver = new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/lms");
		wait = new WebDriverWait(driver, 10);
	}

	  @Test
	  public void Check_MyAccountpage() throws Exception {
		  driver.findElement(By.id("menu-item-1506")).click();
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wpforms-8-field_0"))); //.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a"))));
	  	  	driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Test User 1");
	  	  	driver.findElement(By.id("wpforms-8-field_1")).sendKeys("abc@gmail.com"); 	  	
	  	  	driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Test Case 8 - LMS Project");
	  	  	driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Testing the page"); 	  	
	  	  	driver.findElement(By.id("wpforms-submit-8")).click();
	  	  	
	  	  	//Check if login successful
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wpforms-confirmation-8")));
	        
	        String Confirmation_message = driver.findElement(By.id("wpforms-confirmation-8")).getText();
	        
	        Assert.assertEquals(Confirmation_message, "Thanks for contacting us! We will be in touch with you shortly.");
	  	  	
	  }

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
