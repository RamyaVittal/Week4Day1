package Week4Day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2Assign4LeafgroundTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		List<WebElement> e1 = driver.findElements(By.tagName("th"));
		int columncount = e1.size();
		System.out.println("No of Columns in Table: "+columncount);
		List<WebElement> e2 = driver.findElements(By.tagName("tr"));
		int rowcount = e2.size();
		System.out.println("No of Rows in Table: "+rowcount);
		String progress = driver.findElement(By.xpath("//table//tr[3]/td[2]/font")).getText();
		System.out.println("Progress of 'Learn to interact with Elements' in Table: "+progress);
		List<Integer> li = new ArrayList<Integer>();
		List<WebElement> eachProg = driver.findElements(By.xpath("//table//tr/td[2]/font"));
		for(int i=0;i<eachProg.size();i++) {
			li.add(Integer.parseInt(eachProg.get(i).getText().replaceAll("%","")));
		}
		System.out.println(li);
		Collections.sort(li);
		int lowestProg = li.get(0);
		String conv=Integer.toString(lowestProg);
		System.out.println(conv);
		List<String> q= new ArrayList<String>();
		int index=0;
		for(int i=0;i<eachProg.size();i++) {
				q.add(eachProg.get(i).getText().replaceAll("%",""));
				//System.out.println(q.get(i));
		if((q.get(i)).equalsIgnoreCase(conv)) {
			index=i;
			System.out.println("Print index: "+index);
		}}
		WebElement w=driver.findElement(By.xpath("//table//tr["+(index+2)+"]/td[3]/input"));
		w.click();
		
		}
	}


