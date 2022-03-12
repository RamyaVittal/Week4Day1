package Week4Day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class week4ClassroomAssignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);
		al.accept();
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert al1 = driver.switchTo().alert();
		String text1=al1.getText();
		System.out.println(text1);
		al1.dismiss();
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert al2 = driver.switchTo().alert();
		String text2=al2.getText();
		System.out.println(text2);
		al2.sendKeys("Some Text");
		al2.accept();
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Alert al3 = driver.switchTo().alert();
		String text3=al3.getText();
		System.out.println(text3);
		al3.accept();
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		String text4=driver.findElement(By.xpath("//button[@id='btn']/following::div[@class='swal-text']")).getText();
		System.out.println(text4);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();

		
		

		
		


	}

}
