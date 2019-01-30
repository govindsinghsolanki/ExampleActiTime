package com.exampleActiTime.testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Create_New_BillingType {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public WebDriver driver;
	
@Test
public void testNewBillingType()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.navigate().to("http://govind-pc/login.do");
	driver.findElement(By.name("username")).sendKeys("admin");
	driver.findElement(By.name("pwd")).sendKeys("manager");
	driver.findElement(By.id("loginButton")).click();
	driver.findElement(By.xpath("//a[@href='/administration/administration.do']")).click();
    driver.findElement(By.linkText("Billing Types")).click();		
   
  String str1[]= {"abc","xyz","mno","opq"};
  for(int i=0;i<str1.length;i++)
  {
	driver.findElement(By.xpath("//input[@value='Create New Billing Type']")).click();  
    driver.findElement(By.name("name")).sendKeys(str1[i]);
    driver.findElement(By.cssSelector("input[value *='Create Billing Type']")).click();		
  }
  List<WebElement>allRows=driver.findElements(By.xpath("//table[@bgcolor='#cccccc']//tr[contains(@class,'typelisttblrow')]"));
  System.out.println(allRows.size());
  String[] str2=new String[allRows.size()];
  for(int i=0;i<allRows.size();i++)
  {
	String text2=allRows.get(i).getText();
	String text3[]=text2.split(" ");
	System.out.println(text3[0]+" ");
	str2[i] = text3[0];
  
  }
  for(int j=0;j<str2.length;j++)
  {
	  if(str2[j].equals(str1[j]))
	  {
		driver.findElement(By.linkText("delete")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	  }
  }
}
}