package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.util.Timeout;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
//		3.Zadatak (Za vezbanje)
//		Napisati program koji 
//		Ucitava https://seeds.sproutsocial.com/components/loader-button/
//		Odskrola do Loader buttons are used to display a loading indicator inside of a button. paragrafa. Koristan link
//		Klikce ne dugme 
//		Ceka da dugme zavrsi sa loadingom 
//		Ispisati poruku na ekranu
//		Zatvoriti pretrazivac
//		HINT: Koristite data-qa-button-isloading  atribut elementa za cekanje odredjenog stanja tog elementa
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://seeds.sproutsocial.com/components/loader-button/");
		  
        WebElement s = driver.findElement(By.className("CodeSandbox__Preview-sc-9lhwa5-1"));
        new Actions(driver)
        	.scrollToElement(s)
        	.perform();
        
        driver.findElement(By.xpath("//*[text() = 'Click me to load!']")).click();
      
        WebElement b = driver.findElement(By.xpath("//button[@class = 'styles__Container-sc-1juy94s-0 dzjEcK']"));
		String button = b.getAttribute("data-qa-button-isloading");
		
		if(button.equals("false")) {
			 System.out.println("Kraj.");
		}
		
        driver.quit(); 

	}

}
