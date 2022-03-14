package Week4Day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class week4ClassroomAssignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement Resultframe= driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(Resultframe);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);
		al.sendKeys("Ramya");
		al.accept();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(Resultframe);
        String text1= driver.findElement(By.xpath("//p[@id='demo']")).getText();
        if(text1.contains("Ramya"))
        	System.out.println("You entered name in alertbox");
        else
        	System.out.println("You pressed cancel in alert box");

	}


}
