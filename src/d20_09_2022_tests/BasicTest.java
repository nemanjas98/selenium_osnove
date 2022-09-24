package d20_09_2022_tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import d20_09_2022_pages.BuyBoxPage;
import d20_09_2022_pages.HeaderPage;
import d20_09_2022_pages.LayerCartPage;
import d20_09_2022_pages.TopMenuPage;

public abstract class BasicTest {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected BuyBoxPage buyBoxPage;
	protected LayerCartPage layerCartPage;
	protected TopMenuPage topMenuPage;
	protected HeaderPage headerPage;
	protected String baseUrl = "http://automationpractice.com/";
	protected SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		buyBoxPage = new BuyBoxPage(driver, wait);
		layerCartPage = new LayerCartPage(driver, wait);
		topMenuPage = new TopMenuPage(driver, wait);
		headerPage = new HeaderPage(driver, wait);


	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl); 
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
