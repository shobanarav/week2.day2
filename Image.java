package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load URL and maximize
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Click on the image and travel to Home Page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		
		//Confirm if the page is broken
		driver.get("http://leafground.com/pages/Image.html");
		driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).click();
		
		String title = driver.getTitle();
		
		if(title.equals("TestLeaf - Interact with Images"))
		{
			System.out.println("The image is broken");
		}
		
		//Click using keyboard or mouse
		driver.findElement(By.xpath("//img[@src='../images/keyboard.png'")).click();

	}

}
