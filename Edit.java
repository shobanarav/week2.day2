package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Enter email ID
		driver.findElement(By.id("email")).sendKeys("testmailid@gmail.com");
		
		//Append and TAB
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Appended and Tab pressed", Keys.TAB);
		
		//Get the default text that is entered
		String defaultText = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");
		System.out.println("The default Text is " +defaultText);
		
		//Clear the value
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		
		//Check if edit box is Disenabled
		Boolean verify= driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		
		if(!verify)
		{
			System.out.println("The edit box is disenabled");
		}

	}

}
