package datadriven;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
// import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Basictest {
	
	 @Test(dataProvider = "loginData", dataProviderClass = ExcelDataSupplier.class)
	    public void TestLogin(String userName, String password) throws Exception {
		 System.setProperty("WebDriver.gecko.driver", "D:\\\\Automation Testing\\\\Softwares\\\\edgedriver_win64");
		 	
			WebDriver driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();
	        
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Change the duration accordingly
	        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
	        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        AssertJUnit.assertTrue(driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed());
	        Thread.sleep(3000);
	        driver.close();
	     }

}
