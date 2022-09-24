package d20_09_2022_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TopMenuPage koja pribavlja:
//metodu koja vraca WOMEN link iz glavnom menija
//metodu koja vraca DRESSES link iz glavnom menija
//metodu koja vraca T-SHIRTS link iz glavnom menija
//metodu koja vraca podmeni za WOMEN
//metodu koja vraca podmeni za DRESSES


public class TopMenuPage {
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public TopMenuPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	
	public WebElement getWomenLink() {
		List<WebElement> firstLinks = driver.findElements(By.xpath("//*[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a"));
		return firstLinks.get(0);
	}
	
	public WebElement getDressesLink() {
		List<WebElement> firstLinks = driver.findElements(By.xpath("//*[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a"));
		return firstLinks.get(1);
	}
	
	public WebElement getTshirtsLink() {
		List<WebElement> firstLinks = driver.findElements(By.xpath("//*[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a"));
		return firstLinks.get(2);
	}
	
	public WebElement getWomenSubMenu() {
		List<WebElement> secondLinks = driver.findElements(By.xpath("//ul[@class = 'submenu-container clearfix first-in-line-xs']"));
		return secondLinks.get(0);
	}
	
	public WebElement getDressesSubMenu() {
		List<WebElement> secondLinks = driver.findElements(By.xpath("//ul[@class = 'submenu-container clearfix first-in-line-xs']"));
		return secondLinks.get(1);
	}
	
	
	

}
