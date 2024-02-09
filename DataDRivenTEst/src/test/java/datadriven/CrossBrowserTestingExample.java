package datadriven;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CrossBrowserTestingExample {
    private WebDriver chromeDriver;
    private WebDriver ieDriver;
    
    @BeforeMethod
    public void setUp() {
        // Set path to Chrome and Edge drivers
//        System.setProperty("webdriver.chrome.driver", "D:\\Automation Testing\\Softwares\\chromedriver-win64");
//        System.setProperty("webdriver.edge.driver", "D:\\Automation Testing\\Softwares\\edgedriver_win64");
    	
    	
    }
    @Test
    public void testLoginChrome() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
        // Login test steps
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Change the duration accordingly
        driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        AssertJUnit.assertTrue(driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed());
        Thread.sleep(3000);
    }
    
    @Test
    public void testEdgeBrowser() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
        // Login test steps
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Change the duration accordingly
        driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        AssertJUnit.assertTrue(driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed());
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterMethod
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
        if (ieDriver != null) {
            ieDriver.quit();
        }
    }
}