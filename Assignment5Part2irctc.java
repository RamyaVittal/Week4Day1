package Week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5Part2irctc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();
		List<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      driver.switchTo().window(newTb.get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='Later']")).click();
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		String email = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[3]")).getText();
		System.out.println("Customer care EmailID is "+email);
	      driver.switchTo().window(newTb.get(0));
	      System.out.println("Page title of  window: " + driver.getTitle());
	      driver.close();
	      
	      
	}

}
