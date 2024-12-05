package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAndLogo {

	static WebDriver driver;
	
	@Test(priority=1)
	
	void openPage() {
	 WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test(priority=3)
	void displayLogo() {
		
	Boolean logo =	driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		if(logo) {
			System.out.println("logo is displayed");
		}
		else {
			System.out.println("logo not displayed");
		}
	}
	@Test(priority=3)
	void pageLogin() {
		
		driver.findElement(By.cssSelector("[name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
	}
	@Test(priority=4)
	
	void pageLogout() throws InterruptedException {
        driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Logout")).click();
	}
	@Test(priority=5)
	void pageClose() {
		driver.close();
	}
	
}
