package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementHandling {
	
	// If we made it as static then we can use the driver anywhere in our programme
	
	static WebDriver driver;    // driver -  ref variable, WebDriver - WD is the 'type' for driver ref variable

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//create a webelement + perform action (click, sendKeys, select, isDiplayed, getText)
		
		
		//1.
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		//2.
//		WebElement emailId = driver.findElement(By.id("input-email"));   // WebElement is the return type of findelement
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
		
		//3. By locator: OR
		
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//				
//		WebElement emailId = driver.findElement(email);
//		WebElement pwd = driver.findElement(password);
//
//		emailId.sendKeys("test@gmail.com");
//		pwd.sendKeys("test@123");
		
		//4. By locator + generic function
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(email).sendKeys("test@gmail.com");
//		getElement(password).sendKeys("test@123");
		
		//5: By locators + getElement + actions generic function
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(email, "test@gmail.com");
//		doSendKeys(password, "test@123");
		
		//6: By locator + ElementUtil --> generic functions
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginbtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
		
		//Note - If we create the object of a class having constructor , by default that constructor will be called first
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(email, "test@gmail.com");
		eleUtil.doSendKeys(password, "test@123");
		eleUtil.doClick(loginbtn);
		
		//7: By locators + BrUtil + EleUtil

	}
	
	// The below methods we can use for the 5th method out these 7 methods
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
		
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}

}
