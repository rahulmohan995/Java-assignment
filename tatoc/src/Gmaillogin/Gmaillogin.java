package Gmaillogin;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions; 

public class Gmaillogin {
	
	public void NumberOfUnreadEmails(WebDriver driver)
	{
		String Value=driver.findElement(By.cssSelector("#\\3a jh > div > div.aio.UKr6le > span > a")).getAttribute("aria-label");
		String NumberOfUnreadMessages=Value.substring(6);
		System.out.println(NumberOfUnreadMessages);
	}

	
	public static void main(String args[]) throws InterruptedException 
	{
		Gmaillogin gmail= new Gmaillogin();
		WebDriver driver= new ChromeDriver();
		driver.get("https://accounts.google.com");
		driver.findElement(By.id("identifierId")).sendKeys("rahulmohan995@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys("Afrodox@789");
		driver.findElement(By.cssSelector("#passwordNext > content")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		gmail.NumberOfUnreadEmails(driver);
		
		
	}

}
