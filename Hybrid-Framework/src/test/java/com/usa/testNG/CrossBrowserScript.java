package com.usa.testNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {

	WebDriver driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			// create chrome instance
			driver = new ChromeDriver();
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
			// create Edge instance
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",  "./Driver/IEDriverServer.exe");
			// create Edge instance
			driver=new InternetExplorerDriver();
		}else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testParameterWithXML() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://shop.demoqa.com/my-account/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("alam");
		driver.findElement(By.id("password")).sendKeys("SAYEDawan2008");
		driver.findElement(By.xpath("//*[@value='Log in']")).click();
		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
		driver.quit();
	}
}
