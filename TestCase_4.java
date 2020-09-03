package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_4 {
	static WebDriver driver;

	@BeforeMethod
	public void OpenBrowser() {
		driver = new FirefoxDriver();
	    driver.get("https://alchemy.hguy.co/lms");
	}

	  @Test
	  public void Check_SecondPopularcourse() throws Exception {
	        String SecondPopularcourse = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[4]/div[2]/div/div[2]/div/div/div/div[2]/article/div[2]/h3")).getText();
	        
	        System.out.println("The Second most popular page is : "+ SecondPopularcourse);
	        Assert.assertEquals(SecondPopularcourse, "Email Marketing Strategies");
	  }

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
