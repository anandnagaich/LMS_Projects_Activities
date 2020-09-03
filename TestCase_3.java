package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_3 {
	static WebDriver driver;

	@BeforeMethod
	public void OpenBrowser() {
		driver = new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/lms");
	}

	  @Test
	  public void Check_Firstboxheading() throws Exception {
	        String Firstboxheading = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[2]/div[2]/div[1]/div[2]/div/div/div/div/div[2]/h3")).getText();
	        
	        System.out.println("The Page heading is : "+ Firstboxheading);
	        Assert.assertEquals(Firstboxheading, "Actionable Training");
	  }

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
