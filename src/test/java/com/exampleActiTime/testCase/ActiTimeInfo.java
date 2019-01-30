package com.exampleActiTime.testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ActiTimeInfo {
	  static {
	      
	    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/driver/chromedriver.exe");
	    }

	  WebDriver driver;
		@Test
		public void testActiTimeInfo()
		{
			driver=new ChromeDriver();
		    driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    
			driver.navigate().to("http://govind-pc/login.do");
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("pwd")).sendKeys("manager");
			driver.findElement(By.id("loginButton")).click();
			driver.findElement(By.className("right")).click();
			driver.findElement(By.xpath("//div[contains(text(),'About actiTIME')]")).click();
			driver.findElement(By.linkText("www.actitime.com")).click();
		}
}