package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.manage().window().maximize();

		driver.findElement(By.name("username")).sendKeys("newautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
		Thread.sleep(4000);

		selectContact("Romi singh");
		selectContact("Ali khan");

		// a[text()='Ali khan']/parent::td/following-sibling::td -- 6

//		List<WebElement> contList = driver
//				.findElements(By.xpath("//a[text()='Ali khan']/parent::td/following-sibling::td"));
//
//		for (WebElement e : contList) {
//			String text = e.getText();
//			if (text.length() != 0) {
//				System.out.println(text);
//
//			}
//		}

		getUserinfo("Ali khan");
		ArrayList<String> list = getUserinfo("Romi singh");
		if(list.contains("romi@gmail.com ")) {
			System.out.println("pass");
		}
	}
	
	public static ArrayList<String> getUserinfo(String userName) {
		List<WebElement> contList = driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
		ArrayList<String> contValues = new ArrayList<String>();
		for(int i=0; i<contList.size()-1; i++) {
			String text = contList.get(i).getText();
			System.out.println(text);
			contValues.add(text);
			
		}
		return contValues;
		
	}
	
	//   //a[text()='Romi singh']/parent::td/preceding-sibling::td/input[@type='checkbox']
	
	public static void selectContact(String userName) {
		String con_xpath = "//a[text()='" + userName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(con_xpath)).click();
	}

}
