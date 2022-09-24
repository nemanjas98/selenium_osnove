package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//LayerCartPage koja pribavlja:
//continue shopping dugme
//proced to checkout dugme
//element koji vraca atrubute
// proizvoda (sa slike je to desno od devojke)
//element koji cuva quantity
//(takodje desno od devojke)
//element koji cuva total price
//metodu koja ceka da dijalog bude vidljiv
//metodu koja ceka da dijalog bude nevidljiv


public class LayerCartPage {
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.xpath("//*[contains(@title, 'Continue shopping')]"));
	}
	
	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.xpath("//*[@class = 'btn btn-default button button-medium']"));
	}
	
	public String getAttributesOfProducts() {
		return driver.findElement(By.id("layer_cart_product_attributes")).getText();
	}
	
	public String getQuantityNumber() {
		return driver.findElement(By.id("layer_cart_product_quantity")).getText();
	}
	
	public String getTotalPrice() {
		return driver.findElement(By.id("layer_cart_product_price")).getText();
	}
	
	public void waitForDialogToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
	}
	
	public void waitForDialogToBeInvisible() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("layer_cart")));
	}
		

}
