package com.hris.testNG;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class App 
{
    WebDriver driver = new ChromeDriver();
    
    public String CurrentLink() {
    	return driver.getCurrentUrl();
    }
    
    public void OpenHris() {
    	driver.get("https://hris.qainfotech.com/login.php");
    	driver.findElement(By.xpath("//a[@href='#panel1']")).click();
    }
    
    public void Login(String username, String password) {
    	driver.findElement(By.xpath("//a[@href='#panel1']")).click();
    	driver.findElement(By.xpath("//input[@id='txtUserName']")).sendKeys(username);
    	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
    	driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    
    public void Logout(){
    	driver.findElement(By.xpath("//a[@href='javascript:void(0);']")).click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	WebElement logout =driver.findElement(By.xpath("//a[@href='https://hris.qainfotech.com:8086/user/logoff']"));
    	js.executeScript("arguments[0].click();", logout);
    }
}