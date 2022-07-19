package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Settingup Chromedriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Loading URL and maximizing the screen
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Logging in
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Traversing to Find Lead
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		// Entering the Name of Lead required
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Karthik");
		
		//click on Find Lead button
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
		
		//to allow table to load
		Thread.sleep(3000);
		
		//selecting the first Lead Id
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//Printing the page title
		String title = driver.getTitle();
		System.out.println(title);
		
		//Editing the Lead Data
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
	
		//Confirming if change made is reflecting
		String change = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(change.contains("TestLeaf"))
		{
			System.out.println("Change made");
		}
		
		//Closing the Browser
		driver.close();
		
	}

}
