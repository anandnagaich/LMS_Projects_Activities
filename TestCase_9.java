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

public class TestCase_9 {
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
		  driver.findElement(By.id("menu-item-1508")).click();
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div/main/article/div/section[2]/div[2]/div/div/div/div[1]/article/div[2]/p[2]/a")));
	        
	        driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[2]/div[2]/div/div/div/div[1]/article/div[2]/p[2]/a")).click();
	                
	        String Page_title = driver.getTitle();
	        
	        Assert.assertEquals(Page_title, "Social Media Marketing – Alchemy LMS");
	  	  	
	  }

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
