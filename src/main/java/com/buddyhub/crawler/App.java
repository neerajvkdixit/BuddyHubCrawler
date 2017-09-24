package com.buddyhub.crawler;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rohira\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver  = new ChromeDriver();
//    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    	driver.get("http://www.facebook.com");
//    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("XXXVVVX");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("XVVV");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		driver.get("https://www.facebook.com");
		driver.findElement(By.className("_1frb")).click();
		driver.findElement(By.className("_1frb")).sendKeys("noida flat and flatmates");
		driver.findElement(By.className("_585_")).click();
		driver.findElement(By.className("_52eh _5bcu")).click();
//		List<WebElement> divElements = driver.findElements(By.xpath("//*[@id="+"js_77"+"]"));							
//        String hell=driver.findElement(By.xpath("//*[@id="+"js_77"+"]")));
//        String hell=driver.findElement(By.xpath("//div[@class='_1dwg _1w_m']/div/div[@class='_5pbx userContent _22jv _3576']/div[@id='id_59c41b336c3c86289183240']")).getText();
//		WebElement element =driver.findElement(By.id("id_59c4111b1817b8e96721630"));
		String hello="//*[@id=\"id_59c42219d98436874019067\"]";
		String outsideText = driver.findElement(By.xpath(hello)).getText();
		//		String[] linkTexts = new String[divElements.size()];							
//			int	i = 0;					
//
//			//extract the link texts of each link element		
//			for (WebElement e : divElements) {							
//			System.out.println( e.getTagName());							
//			i++;			
//        }		

    }
}
