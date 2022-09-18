package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {

//	2.Zadatak
//	Napisati program koji ucitava stranicu https://geodata.solutions/
//	Bira Country, State i City po vasoj zelji
//	Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//	I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//	Izabrerit Country, State i City tako da imate podatke da selektujete!
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://www.plus2net.com/jquery/msg-demo/dropdown3.php");
		
		Select country = new Select(driver.findElement(By.id("country_code")));
		country.selectByVisibleText("USA");
		
		Select state = new Select(driver.findElement(By.id("state_id")));
		state.selectByVisibleText("16:California");
		
		Select city = new Select(driver.findElement(By.id("city_id")));
		city.selectByVisibleText("Los Angeles");
		
		Thread.sleep(1000);
		driver.quit();
		
		


	}

}
