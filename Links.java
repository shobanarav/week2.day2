package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load URL
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		// Go to Homepage
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		
		//Finding result page without clicking on the link
		driver.get("http://leafground.com/pages/Link.html");
		String link = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println(link);
		
		//Verify if broken
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title = driver.getTitle();
		
		if(title.contains("404"))
		{
			System.out.println("The page is broken");
		}
		
		//Go to Home page with same link name
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		
		//Count of Links in the page
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.linkText("How many links are available in this page?")).click();
		WebElement links = driver.findElement(By.xpath("//section[@class='innerblock']"));
		java.util.List<WebElement> linksList = links.findElements(By.tagName("a"));
		System.out.println("The no of Links are "+ linksList.size());
		


	}

}
