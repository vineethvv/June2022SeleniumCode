package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		Thread.sleep(3000);
		
		//Multiple selection
        while(true) {
			
			if(driver.findElements(By.xpath("//td[text()='India']")).size()>0) {
				
				selectMultipleCountry("India");
		
			}
			
			WebElement next = driver.findElement(By.linkText("Next"));
			
			if(next.getAttribute("class").contains("disabled")) {
				
				System.out.println("Pagination is over ...");
				break;
			}
			
			next.click();
			Thread.sleep(1000);
			
        }
		
		/*
		 * //Single selection while(true) {
		 * 
		 * if(driver.findElements(By.xpath("//td[text()='Denmark']")).size()>0) {
		 * selectCountry("Denmark"); break;
		 * 
		 * } else { // Pagination logic
		 * 
		 * System.out.println("Country not found....Clicking on next"); WebElement next
		 * = driver.findElement(By.linkText("Next"));
		 * 
		 * if(next.getAttribute("class").contains("disabled")) {
		 * 
		 * System.out.println("Pagination is over ...Country still not found...");
		 * break; }
		 * 
		 * next.click();
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 */

	}

	public static void selectMultipleCountry(String countryName) {

		List<WebElement> countryList = driver
				.findElements(By.xpath("//td[text()='India']/preceding-sibling::td/input[@type='checkbox']"));

		for (WebElement e : countryList) {

			e.click();
		}
	}

	public static void selectCountry(String CountryName) {

		driver.findElement(By.xpath("//td[text()='" + CountryName + "']/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

}
