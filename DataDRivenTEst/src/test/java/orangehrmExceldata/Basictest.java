package orangehrmExceldata;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import datadriven.ExcelDataSupplier;
public class Basictest {
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataSupplier.class)
	public void TestLogin(String userName, String password) throws Exception {
		System.setProperty("Webdriver.gecko.driver","D:\\Automation Testing\\Softwares\\edgedriver_win64");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		AssertJUnit.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
		Thread.sleep(5000);
		driver.quit();
	
	 }

}
