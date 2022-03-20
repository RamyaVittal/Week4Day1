package Week4Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement Resultframe= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(Resultframe);
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		//int x= item1.getLocation().getX();
		//int y= item1.getLocation().getY();
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
	//	int x1= item1.getLocation().getX();
	//	int y1= item1.getLocation().getY();
		Actions builder = new Actions(driver);
		builder.dragAndDrop(item3, item1).perform();

	}

}
