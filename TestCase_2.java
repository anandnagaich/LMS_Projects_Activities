package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_2 {
	static WebDriver driver;

	@BeforeMethod
	public void OpenBrowser() {
		driver = new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/lms");
	}

	  @Test
	  public void Check_PageHeadinge() throws Exception {
	        String page_heading = driver.findElement(By.className("uagb-ifb-title")).getText();
	        System.out.println("The Page heading is : "+ page_heading);
	        Assert.assertEquals(page_heading, "Learn from Industry Experts");
	  }

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
