package gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 
public class gmail {

	
	public void NumberOfUnreadEmails(WebDriver driver)
	{
		String Value=driver.findElement(By.cssSelector(".J-Ke.n0")).getAttribute("aria-label");
		String NumberOfUnreadMessages=Value.substring(6);
		System.out.println(NumberOfUnreadMessages);
	}

	public static void main(String args[]) throws InterruptedException 
	{
		gmail gmail= new gmail();
		
	//	opens Gmail Login
		WebDriver driver= new ChromeDriver();
		driver.get("https://accounts.google.com");
   //	driver.manage().window().maximize();
		
	//	enters emailid and click next
		driver.findElement(By.id("identifierId")).sendKeys("Enter emailId");
		driver.findElement(By.id("identifierNext")).click();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		
	// enters password and click next
		driver.findElement(By.xpath("//div//input[@class='whsOnd zHQkBf' and @type='password']")).sendKeys("Enter Password");
		driver.findElement(By.id("passwordNext")).click();
	
	//  clicks open the mail box
		driver.findElement(By.xpath("//a[@class='WaidBe']")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
	// initially gives the number of unread emails
		gmail.NumberOfUnreadEmails(driver);
	
	//	opens the first unread email
		driver.findElement(By.xpath("//tr[@class = 'zA zE']")).click();
	
	//	finally gives the number of unread emails
		gmail.NumberOfUnreadEmails(driver);
		
	//	closes the tab
		driver.close();
		driver.quit();
			
	}

}