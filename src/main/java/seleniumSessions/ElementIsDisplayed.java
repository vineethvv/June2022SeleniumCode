package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisplayed {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
//		boolean flag = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
//		if(flag) {
//			
//			System.out.println("ele is displayed");
//		}
//		else {
//			
//			System.out.println("ele is not displayed");
//		}
		
		By searchfield = By.id("twotabsearchtextbox");
		
		if(doEleIsDisplayed(searchfield)) {
			
			System.out.println("ele is displayed");
			doSendKeys(searchfield, "macbook pro");
			
		}else {
			
			System.out.println("ele is not displayed");
		}
		
		
	}
	
	public static boolean doEleIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	

}
