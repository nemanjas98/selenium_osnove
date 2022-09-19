package d19_09_2022;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class BootstrapTableTests {
	
//	1.Zadatak
//	Kreirati BootstrapTableTests klasu koja ima:
//	Base url: https://s.bootsnipp.com
//	Test #1: Edit Row
//	Podaci:
//	First Name: ime polaznika
//	Last Name: prezime polaznika
//	Middle Name: srednje ime polanzika
//	Koraci:
//	Ucitati stranu /iframe/K5yrx
//	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	Klik na Edit dugme prvog reda
//	Sacekati da dijalog za Editovanje bude vidljiv
//	Popuniti formu podacima. 
//	Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//	Klik na Update dugme
//	Sacekati da dijalog za Editovanje postane nevidljiv
//	Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//	Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//	Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//	Test #2: Delete Row
//	Podaci:
//	First Name: ime polaznika
//	Last Name: prezime polaznika
//	Middle Name: srednje ime polanzika
//	Koraci:
//	Ucitati stranu /iframe/K5yrx
//	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	Klik na Delete dugme prvog reda
//	Sacekati da dijalog za brisanje bude vidljiv
//	Klik na Delete dugme iz dijaloga 
//	Sacekati da dijalog za Editovanje postane nevidljiv
//	Verifikovati da je broj redova u tabeli za jedan manji
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//	Test #3: Take a Screenshot
//	Koraci:
//	Ucitati stranu  /iframe/K5yrx
//	Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	Kreirati screenshot stranice. Koristan link https://www.guru99.com/take-screenshot-selenium-webdriver.html
//	Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: src/paket_za_domaci/nazivslike.png

	private WebDriver driver;
	private String baseUrl = "https://s.bootsnipp.com";
	private WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@Test (priority = 100)
	public void editRow() {
		
		String firstName = "N";
		String lastName = "S";
		String middleName = "A";
		
		driver.get(baseUrl + "/iframe/K5yrx");
		
		Assert.assertTrue(driver.getTitle()
							.equals("Table with Edit and Update Data - Bootsnipp.com"),
							"Title should be Table with Edit and Update Data - Bootsnipp.com");
		
		driver.findElement(By.xpath("//tr[@id = 'd1']//td//button"))
							.click();
		wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@id = 'edit']//div/div")));
		
		WebElement fN = driver.findElement(By.id("fn"));
		fN.clear();
		fN.sendKeys(firstName);
		
		WebElement lN = driver.findElement(By.id("ln"));
		lN.clear();
		lN.sendKeys(lastName);
		
		WebElement mN = driver.findElement(By.id("mn"));
		mN.clear();
		mN.sendKeys(middleName);
		
		driver.findElement(By.id("up")).click();
		
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated
				(By.xpath("//div[@id = 'edit']//div/div[@class = 'modal-content']")));
		
		Assert.assertEquals(driver.findElement(By.id("f1"))
				.getText(),
				firstName, 
				"First name should be " + firstName);
		
		Assert.assertEquals(driver.findElement(By.id("l1"))
				.getText(), 
				lastName, 
				"Last name should be " + lastName);
		
		Assert.assertEquals(driver.findElement(By.id("m1"))
				.getText(),
				middleName,
				"Middle name should be " + middleName);
	}
	
	@Test (priority = 200)
	public void deleteRow() {
		
		driver.get(baseUrl + "/iframe/K5yrx");
		
		Assert.assertTrue(driver.getTitle()
				.equals("Table with Edit and Update Data - Bootsnipp.com"),
				"Title should be Table with Edit and Update Data - Bootsnipp.com");
		
		driver.findElement(By.xpath("//tr[@id = 'd2']//td//button[@class = 'delete btn btn-danger btn-sm']"))
							.click();
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@id = 'delete']//div/div[@class = 'modal-content']")));
		driver.findElement(By.id("del")).click();
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated
				(By.xpath("//div[@id = 'delete']//div/div[@class = 'modal-content']")));
		
		Assert.assertFalse(driver.findElement(By.id("d2"))
				.isDisplayed(),
				"Table row should be empty");
	}
	
	@Test (priority = 300)
	public void takeAScreenshoot() throws IOException {
		
		driver.get(baseUrl + "/iframe/K5yrx");
		
		Assert.assertTrue(driver.getTitle()
				.equals("Table with Edit and Update Data - Bootsnipp.com"),
				"Title should be Table with Edit and Update Data - Bootsnipp.com");
		
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("C:\\Users\\Nemanja\\eclipse-workspace\\selenium_osnove\\src\\img\\d19_09_2022_tablesc.jpg"));
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
