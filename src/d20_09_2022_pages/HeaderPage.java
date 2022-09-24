package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

//HeaderPage koja pribavlja:
//shop phone element - gde je prikazan broj telefona
//contact us link
//sign in link


public class HeaderPage {
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public HeaderPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getShopPhoneElement() {
		return driver.findElement(By.className("shop-phone"));
	}
	
	public WebElement getContactUsLink() {
		return driver.findElement(By.id("contact-link"));
	}
	
	public WebElement getSignInLink() {
		return driver.findElement(By.className("login"));
	}

	
}
