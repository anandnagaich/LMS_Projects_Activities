package TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_7 {
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
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("uagb-ifb-title"))); //.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a"))));
	        
	        List<WebElement> list = driver.findElements(By.cssSelector(".ld_course_grid"));
	        
	        System.out.println("The Total number of courses is : " + list.size());
	        Assert.assertEquals(list.size(), 3);
	  	  	
	  }

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
