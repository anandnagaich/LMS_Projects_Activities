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

public class TestCase_6 {
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
		  driver.findElement(By.id("menu-item-1507")).click();
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("uagb-ifb-title"))); //.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a"))));
	        String page_title = driver.getTitle();
	        System.out.println("The Page Title is : "+ page_title);
	        Assert.assertEquals(page_title,"My Account – Alchemy LMS");
	        
	        //Find the “Login” button on the page and click it.
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a"))); //.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a"))));
	        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a")).click();
	        
	        //Wait for form to load
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login"))); //.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a"))));
	  	  	driver.findElement(By.id("user_login")).sendKeys("root");
	  	  	driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  	  	
	  	  	driver.findElement(By.id("wp-submit")).click();
	  	  	
	  	  	//Check if login successful
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ld-logout")));
	        
	        Assert.assertTrue(driver.findElement(By.className("ld-logout")).isDisplayed());
	  	  	
	  }

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
