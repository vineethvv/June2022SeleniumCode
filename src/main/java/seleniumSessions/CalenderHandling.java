package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandling {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.id("datepicker")).click();
		//selectDate("17");
		
		selectFutureDate("February 2023", "30");
		

	}
	
	public static void selectFutureDate(String expMonthYear, String dateNum) {
		
		if (Integer.parseInt(dateNum)<=0) {

			System.out.println("Wrong date passed....Please pass the right date/day...." + dateNum);
			return;
		}
		
		if(expMonthYear.contains("February") && Integer.parseInt(dateNum)>29) {
			
			System.out.println("Wrong date passed....Please pass the right date/day for Feb month...."+ dateNum);
			return;
		}
		
		if(Integer.parseInt(dateNum)>31) {
			
			System.out.println("Wrong date passed....Please pass the right date/day...."+ dateNum);
			return;
		}
		
		String actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		System.out.println(actMonthYear);
		
		while(!actMonthYear.equalsIgnoreCase(expMonthYear)) {
			
			//Click on next
			
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonthYear = driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
			System.out.println(actMonthYear);
		}
		
		selectDate(dateNum);
	}
	
	
	public static void selectDate(String dateNum) {
		
		driver.findElement(By.xpath("//a[text()='"+dateNum+"']")).click();
	}

}
