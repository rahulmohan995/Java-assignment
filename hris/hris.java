package hris;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hris {
	
	public static void main(String args[]) {
	hris hris= new hris();
	WebDriver driver= new ChromeDriver();
	driver.get("https://hris.qainfotech.com/login.php");
	driver.findElement(By.xpath("//a[@href='#panel1']")).click();
	driver.findElement(By.xpath("//input[@id='txtUserName']")).sendKeys("rahulmohan");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Rahul@321#");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	driver.findElement(By.xpath("//a[@href='javascript:void(0);']")).click();
	

//	WebDriverWait wait = new WebDriverWait(driver, 15);
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://hris.qainfotech.com:8086/user/logoff']")));

	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebElement logout =driver.findElement(By.xpath("//a[@href='https://hris.qainfotech.com:8086/user/logoff']"));
	js.executeScript("arguments[0].click();", logout);
	}
}
