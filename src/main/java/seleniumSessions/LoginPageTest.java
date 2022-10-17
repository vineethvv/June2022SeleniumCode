package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) throws Exception {
	
		
		//7: By locators + BrUtil + EleUtil
		
		//browserUtil
		
		BrowserUtil brUtil = new BrowserUtil();

		WebDriver driver = brUtil.launchBrowser("chrome");

		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		brUtil.getPageTitle();
		brUtil.getPageUrl();

		// By locators
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginbtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");

		//elementUtil
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "test@gmail.com");
		eleUtil.doSendKeys(password, "test@123");
		eleUtil.doClick(loginbtn);

		//brUtil.quitBrowser();

	}

}
