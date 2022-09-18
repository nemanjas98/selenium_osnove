package d16_09_2022;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak
//		Napisati program koji ima:
//		Podesava:
//		implicitno cekanje za trazenje elemenata od 10s
//		implicitno cekanje za ucitavanje stranice od 10s
//		eksplicitno cekanje podeseno na 10s
//		Podaci:
//		Potrebno je u projektu ukljuciti 4 slike.
//		Imenovanje slika neka bude po pravilu pozicija_ime_prezime_polaznika.ekstenzija
//		Npr: front_milan_jovanovic.jpg, left_milan_jovanovic.jpg …
//		Koraci:
//		Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//		Maksimizuje prozor
//		Selektuje Image - Front klikom na tu karticu u dnu ekrana
//		Klik na add photo iz levog navigacionog menia
//		Upload slike. Upload preko File objekta koristeci getAbsolutePath
//		Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
//		Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljanje
//		Ceka da dijalog bude vidljiv
//		Klik na Use One Side Only dugme
//		Ceka da se pojavi dijalog sa slikom
//		Klik na Done
//		Ponoviti proces za Left, Right i Back
//		Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta
//		Kliknuti na Add To Cart dugme
//		Verifikovati postojanje greske Oops! It looks like you`ve not added an text to this 
//		field, please add one before continuing.
//		Xpath: //*[@action='error']
//		Zatvorite pretrazivac

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		driver.manage().window().maximize();
		
		List<WebElement> sides = driver.findElements(By.xpath("//*[@class = 'sc-bBrHrO bKLqss']//img"));
		
		for (int i = 0; i < 4; i++) {
			sides.get(i).click();
			driver.findElement(By.xpath("//*[text() = '+ Add photo']")).click();
			WebElement upload = driver.findElement(By.id("imageUpload"));
			upload.sendKeys("C:\\Users\\Nemanja\\Downloads\\front_nemanja_stojanovic.png");
			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']//img"), i + 1));
			List<WebElement> pics = driver.findElements(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']//img"));
			pics.get(0).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'sc-gYMRRK gMENHs']")));
			driver.findElement(By.xpath("//*[text() = 'Use One Side Only']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'reactEasyCrop_Container crop-container']")));
			driver.findElement(By.xpath("//*[text() = 'Done']")).click();
		}
		
		List<WebElement> confetti = driver.findElements(By.xpath("//*[@class = 'sc-hZgfyJ kFlYLE']//div"));
		Random r = new Random();
		confetti.get(r.nextInt(confetti.size() - 1)).click();
		
		driver.findElement(By.xpath("//*[@class = 'sc-bczRLJ gNSlAh']")).click();
		boolean isExists = true;
		
		try {
			driver.findElement(By.xpath("//*[@action='error']"));
		}catch(NoSuchElementException e){
			isExists = false;
		}
		
		if(isExists == true) {
			System.out.println("Dijalog se prikazao");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
