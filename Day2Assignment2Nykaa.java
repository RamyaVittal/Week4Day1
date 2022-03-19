package Week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.TabableView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2Assignment2Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement ele = driver.findElement(By.linkText("Brands"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris",Keys.ENTER);
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String filterval =	driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		if(filterval.equals("Shampoo")) {
			System.out.println("Filter applied successfully for Shampoo");
					}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(text(),'Oreal Paris Colour Protect Shampoo')])[1]")).click();
		List<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		System.out.println("Price of the loreal shampoo: "+driver.findElement(By.xpath("(//span[text()='MRP:']/following::span)[1]")).getText());
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		WebElement fram=driver.findElement(By.xpath("//div[@id='portal-root']//iframe"));
		driver.switchTo().frame(fram);
		String checktot = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("GrandTotal: "+checktot);
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		String grantot = driver.findElement(By.xpath("(//div[@class='value']//following-sibling::span)[2]")).getText();
		System.out.println("Grand tot in checkout: "+grantot);
		String newstr=checktot.replaceAll("[^a-zA-Z0-9]","");
		if(newstr.equals(grantot)) {
			System.out.println("Grandtotal from step14 and above step are same");
		}
Thread.sleep(5000);
driver.close();


		
		
		
		
	}

}
