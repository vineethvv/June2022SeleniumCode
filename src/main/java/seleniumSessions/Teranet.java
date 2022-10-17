package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teranet {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();// browser - ch

		driver.get("http://qa4.lms.dhltd.corp/#/login");
		
		driver.navigate().refresh();
		
		driver.manage().window().maximize();	
		
		Thread.sleep(4000);
		
		driver.findElement(By.id("txtUserName")).sendKeys("Brenta.Charles@teranet.ca");
		driver.findElement(By.id("txtPassword")).sendKeys("Orange@#2022");
		driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
		
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("//button/span[text()=' Work Queues ']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='Potential Moves']")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[@class='k-button ng-star-inserted'][text()=' Clear Filters ']")).click();
		
		Thread.sleep(2000);
		
		ArrayList<String> moveslist = getpotentialmovesdata("VIN20220624063809");
		System.out.println(moveslist);


	}
	
	// //a[text()=' VIN20220624063809 ']/parent::td/following-sibling::td
	
	public static ArrayList<String> getpotentialmovesdata(String userName) {
		List<WebElement> moves = driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
		ArrayList<String> movesValues = new ArrayList<String>();
		for(int i=0; i<moves.size()-1; i++) {
			String text = moves.get(i).getText();
			System.out.println(text);
			movesValues.add(text);
			
		}
		return movesValues;
		
	}

}
