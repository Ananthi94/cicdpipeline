package demoProject11;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchDriver() throws MalformedURLException {
		/*
		 * DesiredCapabilities dr=null; dr=DesiredCapabilities.chrome();
		 * dr.setBrowserName("chrome"); dr.setPlatform(Platform.WIN11);
		 */
		ChromeOptions opt=new ChromeOptions();
		opt.setPlatformName("Windows 11");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\chromedriver.exe");
		driver=new RemoteWebDriver(new URL(" http://192.168.31.73:4444"),opt);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void test1(){
		driver.navigate().to("https://automationtalks.com/");
		System.out.println("Test1 "+driver.getTitle());
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	

}
