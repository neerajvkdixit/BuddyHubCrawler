package com.buddyhub.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void fetchproplist(WebDriver driver){
		List<WebElement> rows = driver.findElements(By.xpath(".//div[contains(@class, '_1dwg _1w_m')]"));
		JsonArray jsonArray=new JsonArray();
		for (WebElement k:rows) {
			//Since you also have some span tags inside (and maybe something else)
			//we first get the div columns
			JsonObject object=new JsonObject();
			try{

				WebElement tableCell =  k.findElement(By.xpath(".//div[contains(@class, '_5pbx userContent _3576')]"));
				//		    tableData.add((tableCell).get(0).getText());
				System.out.println(tableCell.getText());
				object.addProperty("description", tableCell.getText());
				WebElement tableCell1 =  k.findElement(By.className("_l57"));
				System.out.println(tableCell1.getText());
				object.addProperty("price", tableCell1.getText());
				WebElement tableCell2 =  k.findElement(By.className("_l53"));
				System.out.println(tableCell2.getText());
				object.addProperty("title", tableCell2.getText());
				WebElement tableCell5 =  k.findElement(By.className("_l58"));
				System.out.println(tableCell5.getText());
				object.addProperty("locality", tableCell5.getText());
				WebElement tableCell3 =  k.findElement(By.xpath(".//*[@class='fwb fcg']/a"));
				System.out.println(tableCell3.getAttribute("href"));
				System.out.println(tableCell3.getText());
				JsonObject userObject=new JsonObject();
				userObject.addProperty("userName", tableCell3.getText());
				userObject.addProperty("userProfileUrl", tableCell3.getAttribute("href"));
				object.add("user", userObject);
				WebElement tableCell4 =  k.findElement(By.className("timestampContent"));
				System.out.println(tableCell4.getText());
				object.addProperty("postedDate", tableCell4.getText());
				JsonObject imgObject=new JsonObject();
				try{
					List<WebElement> img = k.findElements(By.xpath(".//*[@class='_2a2q']/a"));
					//				JsonArray imgArray=new JsonArray();
					int i =0;			
					for (WebElement m:img) {

						WebElement tableCelln =  m.findElement(By.xpath(".//*[@class='_46-i img']"));
						System.out.println(tableCelln.getAttribute("src"));
						imgObject.addProperty("img"+ i, tableCelln.getAttribute("src"));
						i++;
						//					imgArray.add(imgObject);
						//					System.out.println(tableCelln.getText());
						//			WebElement tableCell3 =  k.findElement(By.xpath(".//*[@class='fwb fcg']/a"));
						//			System.out.println(tableCell3.getAttribute("href"));
					}		

				}catch(Exception e)
				{
					System.out.println(e.getMessage());
					continue;
				}finally{
					object.add("imageUrl", imgObject);
				}


				System.out.println("hello");

			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}finally{
				jsonArray.add(object);
			}
	}
	public static void main( String[] args ) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rohira\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		//    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
		//    	driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rohira24gaurav@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("mnit@220811");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//		driver.get("https://www.facebook.com");
//		driver.findElement(By.className("_1frb")).click();
//		driver.findElement(By.className("_1frb")).sendKeys("flat and flatmates NOIDA + Ghaziabad");
//		driver.findElement(By.className("_585_")).click();
//		driver.findElement(By.xpath(".//*[@class='_52eh _5bcu']")).click();;
		driver.get("https://www.facebook.com/groups/FlatAndFlatmatesNoida/");
		//		driver.findElement(By.className("_52eh _5bcu")).click();
		//		List<WebElement> divElements = driver.findElements(By.xpath("//*[@id="+"js_77"+"]"));							
		//        String hell=driver.findElement(By.xpath("//*[@id="+"js_77"+"]")));
		//        String hell=driver.findElement(By.xpath("//div[@class='_1dwg _1w_m']/div/div[@class='_5pbx userContent _22jv _3576']/div[@id='id_59c41b336c3c86289183240']")).getText();
		//		WebElement element =driver.findElement(By.id("id_59c4111b1817b8e96721630"));
		/*		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class, '_1dwg _1w_m')]"));

				//Initialize a new array list to store the text
				List<String> tableData = new ArrayList<String>();

				//For each row, get the column data and store into the tableData object
				for (WebElement k:rows) {
				    //Since you also have some span tags inside (and maybe something else)
				    //we first get the div columns
					List<WebElement> tableCell =  k.findElements(By.xpath("//div[contains(@class, '_5pbx userContent _3576')]"));
//				    tableData.add((tableCell).get(0).getText());
					for(WebElement j:tableCell){
					System.out.println(j.getText());
					}	}*/

		while(true){
			
		}
		

		}
		System.out.println(jsonArray.toString());

		System.out.println("hello");

		PostClass example = new PostClass();
		//	    String json = example.bowlingJson("Jesse", "Jake");
		String response = example.post("http://52.77.1.30:8000/post/postpropdata", (jsonArray.toString()));
		System.out.println(response);



		//		String hello=".//*[@id='u_0_2p']/div[2]/div[1]/div[2]";
		//		String outsideText = driver.findElement(By.xpath(hello)).getText();
		//		String[] linkTexts = new String[divElements.size()];							
		//			int	i = 0;					
		//
		//			//extract the link texts of each link element		
		//			for (WebElement e : divElements) {							
		//			System.out.println( e.getTagName());							
		//			i++;			
		//        }		
		//				while(true){
		//					List<WebElement> frndlistbeforescrolling =  driver.findElements(By.xpath("//div[contains(@class, '_5pbx userContent _3576')]"));
		//					System.out.println("total frnds before scrolling=>"+frndlistbeforescrolling.size());
		//					WebElement lastfrnd=frndlistbeforescrolling.get(frndlistbeforescrolling.size()-1);
		//					int y=lastfrnd.getLocation().y;
		//					JavaScriptExecutor js=(JavaScriptExecutor)driver;
		//					js.executescript("window.scrollto(0,"+y+")");
		//					
		//					List<WebElement> frndlistafterscrolling =  driver.findElements(By.xpath("//div[contains(@class, '_5pbx userContent _3576')]"));
		//				if(frndlistbeforescrolling.size()==frndlistafterscrolling.size())
		//					break;
		//				}
	}
}
