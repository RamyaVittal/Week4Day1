package Week4Day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev73874.service-now.com/");
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Shadow@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement a = driver.findElement(By.id("filter"));
		a.sendKeys("incidents");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Incidents'][1]")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//a[@class='breadcrumb_link']/b[text()='All']")).click();
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		 Set<String> allWindowHandleSet = driver.getWindowHandles();
		 List<String> allWindowHandleList = new ArrayList<String>();
		 allWindowHandleList.addAll(allWindowHandleSet);
		 String newWindow = allWindowHandleList.get(1);
		 driver.switchTo().window(newWindow);
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//td[3]/a[@class='glide_ref_item_link'][1]")).click();
		 Thread.sleep(2000);
		 System.out.println("Something to check if the above code executed without any issue");
		 String defaultWin = allWindowHandleList.get(0);
		 driver.switchTo().window(defaultWin);
		driver.switchTo().frame("gsft_main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.findElement(By.id("incident.short_description")).sendKeys("Some description to be added");
		 String incval = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		 driver.findElement(By.xpath("//button[@name='not_important' and @id='sysverb_insert']")).click();
		//List<WebElement> tablecol3=driver.findElements(By.xpath("//tbody[@class='list2_body']//following::a[@class='linked formlink']"));
		//String firstcol3val = tablecol3.get(0).getText();
		driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']")).sendKeys(incval,Keys.ENTER);
		 Thread.sleep(1000);
		 WebElement tablecol3=driver.findElement(By.xpath("//tbody[@class='list2_body']//following::a[@class='linked formlink']"));
		String firstcol3val = tablecol3.getText();
		if(incval.equals(firstcol3val)) {
			System.out.println("Incident successfully created");
		}
		 File screenShot = driver.getScreenshotAs(OutputType.FILE);
		 File img = new File("./snaps/finalpage.jpg");
			FileUtils.copyFile(screenShot, img);
			 
}


	}


