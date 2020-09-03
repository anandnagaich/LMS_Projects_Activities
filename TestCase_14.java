package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_14 {
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
			Actions actions = new Actions(driver);
			
			//reach to My Account Page
	        Action Act1 = actions.click(driver.findElement(By.id("menu-item-1507"))).build();
	        Act1.perform();
	        
	        //Wait until page is loaded
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a")));
	        
			//Reach to Login Form
	        Action Act2 = actions.click(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a"))).build();
	        Act2.perform();
	        	                
	        //Wait for form to load & send details
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login"))); //.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a"))));
	  	  	driver.findElement(By.id("user_login")).sendKeys("root");
	  	  	driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  	  	
			//click on Login button
	        Action Act3 = actions.click(driver.findElement(By.id("wp-submit"))).build();
	        Act3.perform();
	  	  	
			//Wait for Login and then click on All Courses page
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/ul[2]/li[2]/a")));
	        Action Act4 = actions.click(driver.findElement(By.id("menu-item-1508"))).build();
	        Act4.perform();
	        
			//Wait for course to be loaded and click on Email Marketing Strategies Course
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div/div/div/div[2]/article/a/img")));  
	        Action Act5 = actions.click(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div/div/div/div[2]/article/a/img"))).build();
	        Act5.perform();

			//Wait for Email Marketing Strategies Course to be loaded and click on Improving & Designing 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/main/article/div/div/div/div/div[3]/div[2]/div[2]/div/a/div[2]")));  
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(0,950)");
	        
			Action Act6 = actions.click(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/div/div/div/div[3]/div[2]/div[2]/div/a/div[2]"))).build();
	        Act6.perform();
	        
	        //Click on remaining course Improving & Designing
	    	//Action Act7 = actions.click(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/div/div[2]/div/a/div[2]"))).build();
	        //Act7.perform();
	        
	        //Click on Mark Complete
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("learndash_mark_complete_button")));  
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
	        js2.executeScript("javascript:window.scrollBy(0,950)");
	    	Action Act8 = actions.click(driver.findElement(By.className("learndash_mark_complete_button"))).build();
	        Act8.perform();
	                
	        //check for Completion percentage as 100%
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/main/article/div/div/div/div/div[1]/div[1]/div[1]/div/div[1]")));  
			String Comp_percent = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/div/div/div/div[1]/div[1]/div[1]/div/div[1]")).getText();
			Assert.assertEquals(Comp_percent, "100% Complete");
}

	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
