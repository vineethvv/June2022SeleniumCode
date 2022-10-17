package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlerWithAllWindows {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//parent window
		Thread.sleep(5000);
		
		// getWindowHandle / getWindowHandles is used to get the window id, then only we will be able to switch b/w parent & child windows

		String parentWindowId = driver.getWindowHandle();
		
		
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[1]")).click();//linkedin
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[2]")).click();//fb
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[3]")).click();//tw
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[4]")).click();//YT
		
		// Set is a collection in java
		// Set is not a order based collection like list /Array list ie it does not maintain the index like 0 ,1 ,2 ..........

		Set<String> handles = driver.getWindowHandles();
		
		// Iterator is a concept in java which will help me to fetch the value from those collection which are order less ie which does not maintain the order.
		// property of iterator is whenever we applied iterator on any collection, it will always start pointing just above the position of the set object
		
		Iterator<String> it = handles.iterator();
		
		//hasNext() is used to check whether we have the next element, if have then we will move to next element by using next().
		
		while(it.hasNext()) {
			
			// next is used to move the iterator to the next position to goto the next element
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String title = driver.getTitle();
			System.out.println(title);
			Thread.sleep(2000);
			
			// The below condition is used to not to close the parent window
			
				if(!windowId.equals(parentWindowId)) {
					driver.close();

				}
			
		}
		
		// The below is used to get the driver back to parent window after closing all the child windows
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());

	}

}
