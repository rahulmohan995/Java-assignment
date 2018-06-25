package Gmaillogin;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Gmaillogin {
	public void NumberOfUnreadEmails(WebDriver driver)
	{
		String Value=driver.findElement(By.cssSelector(".J-Ke.n0")).getAttribute("aria-label");
		String NumberOfUnreadMessages=Value.substring(6);
		System.out.println(NumberOfUnreadMessages);
	}

	
	public static void main(String args[]) throws InterruptedException 
	{
		Gmaillogin gmail= new Gmaillogin();
		WebDriver driver= new ChromeDriver();
		driver.get("https://accounts.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("identifierId")).sendKeys("sample96rajan");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys("Sample987*#");
		driver.findElement(By.cssSelector("#passwordNext > content")).click();
		driver.findElement(By.xpath("//a[@class='WaidBe']")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		gmail.NumberOfUnreadEmails(driver);
		driver.close();
		driver.quit();
		
		
	}

}


