package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load URL and maximize
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Click Button
		driver.findElement(By.xpath("//button[@id='home']")).click();
		
		//Find position of button
		WebElement position = driver.findElement(By.xpath("//button[@id='position']"));
		System.out.println(position.getLocation());
		
		//Find color of Button
		String colour = driver.findElement(By.xpath("//button[@id='color']")).getCssValue("background-color");
		System.out.println(colour);
		
		//Find height of Button
		int height = driver.findElement(By.xpath("//button[@id='size']")).getSize().getHeight();
		System.out.println("The height is " +height);

	}

}
