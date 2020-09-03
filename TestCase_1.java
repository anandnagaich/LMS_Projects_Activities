package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCase_1 {
	static WebDriver driver;

	@BeforeMethod
	public void OpenBrowser() {
		driver = new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/lms");
	}

	  @Test
	  public void Check_PageTitle() throws Exception {
	        String page_title = driver.getTitle();
	        System.out.println("The Page Title is : "+ page_title);
	        Assert.assertEquals(page_title,"Alchemy LMS – An LMS Application");
	  }

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
