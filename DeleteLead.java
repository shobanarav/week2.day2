package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9642696726");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		
		Thread.sleep(3000);
		
		//Selecting the first Lead Id that appears and Capturing it
		WebElement leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]"));
		String leadId = leadID.getText();
		leadID.click();
		
		
		Thread.sleep(3000);
		//Deleting the selected Lead
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		//Click on Find leads again
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter captured LeadId and select Find leads
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input)[13]")).sendKeys(leadId);
		
		//Click Find Leads
		driver.findElement(By.xpath("(//td[@class='x-btn-center']//button)[7]")).click();
		
		Thread.sleep(3000);
		//Display if the data exists or not
		String output = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println(output);
		
		driver.close();

	}

}
