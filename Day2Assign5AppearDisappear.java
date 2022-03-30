package Week4Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2Assign5AppearDisappear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("http://www.leafground.com/pages/disapper.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebElement el = driver.findElement(By.xpath("//button"));
			System.out.println("Button displayed as: "+el.getText());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.invisibilityOf(el));
			if(el.isDisplayed())
			{
				System.out.println("Button is displayed");
			}
			else
			{
				System.out.println("Button is disappeared");
			}
driver.switchTo().newWindow(WindowType.TAB);
driver.get("http://www.leafground.com/pages/appear.html");
WebElement el2=driver.findElement(By.xpath("//button[@id='btn']"));
wait.until(ExpectedConditions.visibilityOf(el2));
if(el2.isDisplayed()) {
	System.out.println("Button with text as: "+el2.getText()+" is Appeared");
}
driver.switchTo().newWindow(WindowType.TAB);
driver.get("http://www.leafground.com/pages/TextChange.html");
WebElement el3=driver.findElement(By.xpath("//button[@id='btn']"));
String firstText=el3.getText();
System.out.println(firstText);
wait.until(ExpectedConditions.textToBePresentInElement(el3, "Click ME!"));
if(firstText.equalsIgnoreCase("Click ME!")) {
	System.out.println("Text of button is not changed");
} else
	System.out.println("Text of button is changed");

	}

}
