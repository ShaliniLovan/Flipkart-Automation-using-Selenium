import java.io.File;
import java.io.IOException;
import org.apache.commons.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver.Timeouts;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FLIPKART {
	
	public static void main(String[] args) throws InterruptedException, IOException
	{
		  
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\shlovan\\Downloads\\chromedriver.exe");  
	 
	    WebDriver driver=new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    
        driver.get("https://www.flipkart.com/");
        Thread.sleep(2000);
        
        //navigate to facebook page
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().back();
        
        //title 
        String str ="Flipkart Explore Plus";
        if(((JavascriptExecutor)driver).executeScript("return document.title;").toString()== str)  
        
            System.out.println("PASS");
       
        else
        
            System.out.println("FAIL");
      
       driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   
       //current URL
       String url =  driver.getCurrentUrl();    
       System.out.print("Current URL: "+url);
       
       //refresh
       driver.navigate().refresh(); 
       
      
       //search mobiles
       driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys("Mobile");
       
       //brand
       driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
      
       //select mobile
       driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();
    
       //highlight
       WebElement hlight =driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]"));
       JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       jsExecutor.executeScript("arguments[0].style.border='3px solid red'",hlight);
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       Thread.sleep(200);
       
       //screenshots
       TakesScreenshot ts = (TakesScreenshot)driver;
       File source = ts.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(source, new File("screenshot1.png"));
       
         ((JavascriptExecutor)driver).executeScript("window.open()");
           ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
           driver.switchTo().window(tabs.get(1));
           driver.get("https://www.flipkart.com/realme-c21-cross-blue-64-gb/p/itmf4062d3f37c1a?pid=MOBGF4895YRNAHFZ&lid=LSTMOBGF4895YRNAHFZ3XABXU&marketplace=FLIPKART&q=mobiles&store=tyy%2F4io&srno=s_1_1&otracker=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&fm=SEARCH&iid=f1acdf8f-f075-4304-ba8f-47e5430167b7.MOBGF4895YRNAHFZ.SEARCH&ppt=sp&ppn=sp&ssid=nlua3f7lcw0000001629270193776&qH=eb4af0bf07c16429");
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           TakesScreenshot ts1 = (TakesScreenshot)driver;
           File source1 = ts1.getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(source1, new File("screenshot2.png"));
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           Thread.sleep(200);
           driver.quit();
           
           
           
           
	}}