package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	static WebDriver driver;

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		By footers = By.xpath("//footer//a");

		ArrayList<String> actFooterList = getFooterLinksList(footers);
		
		if (actFooterList.contains("Contact Us")) {
			System.out.println("PASS");
		}
	}
	
	public static ArrayList<String> getFooterLinksList(By locator) {
		List<WebElement> footerList = driver.findElements(locator);
		System.out.println(footerList.size());

		// Below array list is used to store the all footerlinks text & to return it back
		//The below is an empty arraylist & the size is zero.
		// Selenium will get us only the list of webelements (line 34), programatically we have to convert this to list of string(line 41).   
		
		ArrayList<String> eleTextlist = new ArrayList<String>();
		for (WebElement e : footerList) {
			String text = e.getText();
			eleTextlist.add(text);

		}

		return eleTextlist;
	}

}
