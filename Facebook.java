package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Create New Account")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Maanve");
		driver.findElement(By.name("lastname")).sendKeys("Shobana");
		driver.findElement(By.name("reg_email__")).sendKeys("7603959077");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Maanv@18");
		
		WebElement day = driver.findElement(By.xpath("(//select[@class='_9407 _5dba _9hk6 _8esg'])[1]"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		Select dayStr = new Select(day);
		Select monthStr = new Select(month);
		Select yearStr = new Select(year);
		
		dayStr.selectByVisibleText("3");
		monthStr.selectByVisibleText("Dec");
		yearStr.selectByVisibleText("2000");
		
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		
				
}
}