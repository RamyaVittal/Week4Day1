package Week4Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2Assign3Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement ele = driver.findElement(By.xpath("(//span[@class='catText' and contains(text(),'Fashion')])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		System.out.println("Sport Shoes count: "+driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText());
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement el11= driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']"));
		action.moveToElement(el11).click().perform();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		 String sortssel = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		 if(sortssel.equals("Price Low To High")) {
			 System.out.println("Successfully sorted");
		 }
		// driver.navigate().refresh();
	 WebElement e1= driver.findElement(By.xpath("//input[@name='fromVal']"));
		 e1.clear();
		 e1.sendKeys("900");
		 WebElement e2 = driver.findElement(By.xpath("//input[@name='toVal']"));
		 e2.clear();
		 e2.sendKeys("1200");
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")));
		 WebElement e4=driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"));
		 action.moveToElement(e4).click().perform();
		 Thread.sleep(2000);
		driver.navigate().refresh();
		 WebElement e5=driver.findElement(By.linkText("Black"));
		 action.moveToElement(e5).click().perform();
		 //driver.findElement(By.xpath("")).click();
		 String filt1=driver.findElement(By.xpath("(//div[@class='filters'])[1]/div[1]")).getText();
		 System.out.println(filt1);
		 String filt2 = driver.findElement(By.xpath("(//div[@class='filters'])[1]/div[2]")).getText();
		 System.out.println(filt2);
		 if((filt1.startsWith("Price:"))&&(filt2.startsWith("Color:")))
	System.out.println("Filters applied");
		 WebElement e3 = driver.findElement(By.xpath("//section[@class='js-section clearfix dp-widget dp-fired']/div"));
		 action.moveToElement(e3).perform();
		 driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		 String pri = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
	 		System.out.println("Shoe cost :"+pri);
	 		String off = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
	 		System.out.println("shoe offer :"+off);
	 		WebElement scr= driver.findElement(By.xpath("//img[@class='cloudzoom']"));		
	 		 File screenshot= scr.getScreenshotAs(OutputType.FILE);
	 		 File image=new File("./snaps/imageshoe.png");
	 		 FileUtils.copyFile(screenshot, image);
	 		 WebElement El = driver.findElement(By.xpath("//div[@class='close close1 marR10']"));
	 		 El.click();
	 		 driver.close();
	}
	
}
