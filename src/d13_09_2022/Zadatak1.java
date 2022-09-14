package d13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak
//		Maksimizirati prozor
//		Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//		Prijavite se na sistem 
//		Username: Admin
//		Password: admin123
//		Cekanje od 5s
//		U input za pretragu iz navigacije unesite tekst Me
//		Kliknite na prvi rezultat pretrage (to ce biti Time)
//		Cekanje od 1s
//		Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//		Klinkite na logout
//		Cekanje od 5s
//		Zatvorite pretrazivac
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@name = 'username']"))
			.sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name = 'password']"))
			.sendKeys("admin123");
		driver.findElement(By.className("orangehrm-login-button")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@placeholder = 'Search']"))
			.sendKeys("Me");
		List<WebElement> Results = driver.findElements(By.xpath("//*[@class = 'oxd-main-menu-item']"));
		Results.get(0).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
