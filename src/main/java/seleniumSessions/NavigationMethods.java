package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {
		
		// Both get & navigate to both can be used to launch the URL , technically both are exactly same.
		// If we used navigate to , internally get method is getting called.
		// To launch the application/website initially we used to use get method, later on if we want to switch to any other application/site we can use navigate to just for the difference.
		
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");

		System.out.println(driver.getTitle());

		 driver.navigate().to("https://www.amazon.com");

		// driver.navigate().to(new URL("https://www.amazon.com"));

		//driver.get("https://www.amazon.com");

		System.out.println(driver.getTitle());

		driver.navigate().back();

		System.out.println(driver.getTitle());

		driver.navigate().forward();

		System.out.println(driver.getTitle());

		driver.navigate().back();

		System.out.println(driver.getTitle());
		
		
		//refresh:
		driver.navigate().refresh();


	}

}
