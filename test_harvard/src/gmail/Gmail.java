package gmailAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Gmail {

	public WebDriver driver;

	

	public void numberOfUnreadEmails(WebDriver driver) {
		String Value = driver.findElement(By.cssSelector(".J-Ke.n0")).getAttribute("aria-label");
		String NumberOfUnreadMessages = Value.substring(6);
		System.out.println(NumberOfUnreadMessages);
	}

	public static void main(String args[]) throws InterruptedException {
		Gmail gmail = new Gmail();

		// opens Gmail Login
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.google.com");
		driver.manage().window().maximize();

		// enters emailid and click next
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("Sample96rajan@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

		// enters password and click next
		driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Sample987*#");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'COMPOSE']")));

		// initially gives the number of unread emails
		gmail.numberOfUnreadEmails(driver);

		// opens the first unread email
		driver.findElement(By.xpath("//tr[@class = 'zA zE']")).click();

		// finally gives the number of unread emails
		gmail.numberOfUnreadEmails(driver);

		// closes the tab
		driver.close();
		driver.quit();

	}

}