package gmailAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import gmail.gmail;

public class Gmail {
	
public static WebDriver driver;
	
	public void waitTime(int sec)
	{
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public void NumberOfUnreadEmails(WebDriver driver)
	{
		String Value=driver.findElement(By.cssSelector(".J-Ke.n0")).getAttribute("aria-label");
		String NumberOfUnreadMessages=Value.substring(6);
		System.out.println(NumberOfUnreadMessages);
	}

	public static void main(String args[]) throws InterruptedException 
	{
		gmail Gmail= new gmail();
		
	//	opens Gmail Login
		WebDriver driver= new ChromeDriver();
		driver.get("https://accounts.google.com");
		driver.manage().window().maximize();
		
	//	enters emailid and click next
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("Sample96rajan@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		Gmail.waitTime(4);
	//	driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
			
	// enters password and click next
		driver.findElement(By.xpath("//div//input[@class='whsOnd zHQkBf' and @type='password']")).sendKeys("Sample987*#");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
	
	//  clicks open the mail box
		driver.findElement(By.xpath("//a[@class='WaidBe']")).click();
		Gmail.waitTime(4);
	//	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				
		
	// initially gives the number of unread emails
		Gmail.NumberOfUnreadEmails(driver);
	
	//	opens the first unread email
		driver.findElement(By.xpath("//tr[@class = 'zA zE']")).click();
	
	//	finally gives the number of unread emails
		Gmail.NumberOfUnreadEmails(driver);
		
	//	closes the tab
		driver.close();
		driver.quit();
			
	}

}