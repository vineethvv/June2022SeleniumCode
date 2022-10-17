package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MaximizeFullScreen {

	public static void main(String[] args) throws Exception {
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
		
		//driver.manage().window().fullscreen();  // not recommended
		//driver.get("www.google.com");
		
		BrowserUtil brUtil = new BrowserUtil();
		
		brUtil.launchBrowser("chrome");
		
		brUtil.launchUrl("https://www.google.com");

	}

}
