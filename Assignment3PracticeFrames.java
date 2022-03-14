package Week4Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3PracticeFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame("frame1");	
		driver.switchTo().frame("frame3");
		driver.findElement(By.tagName("input")).click();
		driver.switchTo().parentFrame();
		String f1=driver.findElement(By.tagName("b")).getText();
		System.out.println(f1);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");	
		WebElement dropElement = driver.findElement(By.id("animals"));
		Select dd = new Select(dropElement);
		dd.selectByIndex(2);


	}

}
