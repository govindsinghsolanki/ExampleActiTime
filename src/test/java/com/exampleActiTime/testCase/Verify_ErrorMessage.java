package com.exampleActiTime.testCase;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class Verify_ErrorMessage {
    static {
      
    	System.out.println(System.getProperty("user.dir"));
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/driver/chromedriver.exe");
    }
    
	
	WebDriver driver;
	@Test
	public void testErrorMessage()
	{
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
		driver.navigate().to("http://govind-pc/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		//a[@href='/tasks/otasklist.do']
		driver.findElement(By.cssSelector("a[href='/tasks/otasklist.do']")).click();
		driver.findElement(By.linkText("Projects & Customers")).click();

		String[] s= {"abc","xyz","mno"};
		for(int i=0;i<s.length;i++)
		{
			driver.findElement(By.xpath("//input[@value='Create New Customer']")).click();
			driver.findElement(ByName.name("name")).sendKeys(s[i]);
			driver.findElement(By.name("createCustomerSubmit")).click();
		}
		WebElement successMessage = driver.findElement(By.className("successmsg"));
		String color = successMessage.getCssValue("color");
		System.out.println("RGB COLOR "+color);
		String hexaValue = Color.fromString(color).asHex();
		System.out.println(hexaValue);
		if(hexaValue.equals("#506d00"))
		{
			System.out.println("Yes Error Message Is Green");
		}
		else {
			System.out.println("No Error Message Is Not A Green");
		}
	//List<WebElement>ele=driver.findElements(By.xpath("//td[contains(@id,'customerNameCell')]"));
	
/*  To Delete ALL Element */
		
	List<WebElement> ele=driver.findElements(By.xpath("//table[@class='active_customers_projects listTable']//tbody//tr//td//input"));
	
	System.out.println(ele.size());
	
	for(int i=1;i<=ele.size();i++)
      {
         driver.findElement(By.xpath("//table[@class='active_customers_projects listTable']//tbody//tr//td[6]//input")).click();
         driver.findElement(By.xpath("//input[@value='Delete Selected']")).click();
   	     driver.findElement(By.xpath("//input[@value='Delete This Customer']")).click();
      }
	
	
    /*------To Delete Perticular Element----*/	
	
	/*String text="mno";
	for(int i=2;i<=ele.size();i++)
    {
	 String acttext= driver.findElement(By.xpath("//table[@class='active_customers_projects listTable']//tbody//tr["+i+"]//td[1]/a")).getText().trim();	
	 System.out.println(acttext);
	 if(acttext.equalsIgnoreCase(text))
      {
          driver.findElement(By.xpath("//table[@class='active_customers_projects listTable']//tbody//tr["+i+"]//td[6]//input")).click();
      	  driver.findElement(By.xpath("//input[@value='Delete Selected']")).click();
    	  driver.findElement(By.xpath("//input[@value='Delete This Customer']")).click();
    	  break;
      }
    }*/
    }

	}

