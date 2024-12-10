package Day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderdemo {
	
	WebDriver driver;
	@BeforeClass
	void setup(){
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	
	@Test(dataProvider="dp")
	void teslogin(String email,String pwd) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(5000);
		
		boolean status=driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		
		if(status==true)
		{
			System.out.println("Yes is shown");
		}
		
		else {
			System.out.println("Fail it is not shows");
		}
	}

	@AfterClass
	void teardown(){
		driver.close();
	}
	
	@DataProvider(name="dp")
	Object [][]logindata()
	{
		Object data[][]= {
				{"chandan005@gmail.com","passw"},
				{"chandan009@gmail.com","passw"},
				{"chandan000@gmail.com","passw"},
				{"chandan110@gmail.com","passw"},
				{"chandan390@gmail.com","passw"},
				
				
		};
		
		return data;
	}
}
