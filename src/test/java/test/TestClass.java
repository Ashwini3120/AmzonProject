package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	
	WebDriver driver;
	@Parameters({"browser"})
	@Test
	public void getDriver(String a) throws InterruptedException {
		if(a.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    System.out.println("Connection established to chrome");
		}
	 if (a.equalsIgnoreCase("firefox")) {
		
			System.setProperty("webdriver.firefox.driver","C:\\webdriver\\geckodriver.exe");
			//WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 System.out.println("Connection established to Firefox");
			}
		if (a.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver","C:\\webdriver\\edgedriver.exe");
			WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		    System.out.println("Connection established to Edge");						
	}
		Thread.sleep(2000);
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Application Excuting parallelly");
		driver.quit();
	}

}
