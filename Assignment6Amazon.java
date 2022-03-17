package Week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		String price=driver.findElement(By.xpath("//div[@data-index='2']//span[@class='a-price']//span[@class='a-price-whole']")).getText();
		System.out.println("Price of first product is "+price);
		String CustRatingno=driver.findElement(By.xpath("//div[@data-index='2']//div[@class='a-row a-size-small']//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("Tot No of CustomerRatings are "+CustRatingno);
		WebElement starRating=driver.findElement(By.xpath("//div[@data-index='2']//div[@class='a-row a-size-small']//a[@class='a-popover-trigger a-declarative']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(starRating).click().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement ele=driver.findElement(By.xpath("//div[@id='a-popover-content-2']//a[@class='a-link-normal 5star']"));
		String fivestar=ele.getAttribute("title");
		 System.out.println("five star percentage: "+fivestar);
		 driver.findElement(By.xpath("//div[@data-index='2']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
		 List<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      driver.switchTo().window(newTb.get(1));	
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.id("add-to-cart-button")).click();
	driver.switchTo().activeElement();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("attach-added-to-cart-message")));
//driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();

		String tot = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-total-string']")).getText();
		String carttotprice=driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("Cart message: "+tot+""+carttotprice);
				

		
	}

}
