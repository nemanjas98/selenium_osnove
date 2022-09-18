package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		1.Zad
//		Napisati program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//		Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon
//		klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//		POMOC: Brisite elemente odozdo.
//		(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		
		List<WebElement> l = driver.findElements(By.className("close"));
		
		boolean exists = true;
		//brisanje odozgo
		for (int i = 0; i < l.size(); i++) {
			try {
				l.get(i).click();
			} catch (NoSuchElementException e) {
				exists = false;
			}
			if(exists) {
				System.out.println("Obrisan.");
			}else {
				System.out.println("Nije obrisan.");
			}
			Thread.sleep(1000);
		}
		//brisanje odozdo
//		for (int i = l.size() - 1; i >= 0; i--) {
//			try {
//				l.get(i).click();
//			} catch (NoSuchElementException e) {
//				exists = false;
//			}
//			if(exists) {
//				System.out.println("Obrisan.");
//			}else {
//				System.out.println("Nije obrisan.");
//			}
//			Thread.sleep(1000);
//		}
		
		
		driver.quit();
		
		


	}

}
