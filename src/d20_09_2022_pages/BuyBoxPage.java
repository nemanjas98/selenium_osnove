package d20_09_2022_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//Kreirati pageve:
//BuyBoxPage koja pribavlja:
//input za kolicinu
//select za velicinu
//add to cart dugme
//add to wishlist dugme
//metodu koja vraca element boje. 
//Metoda kao parametar prima naziv boje 
//(npr: “Orange”, “Blue”) a vraca link koji ima atribut title
//prema trazenoj vrednosti.
//metodu koja skrola do ovog dela stranice


public class BuyBoxPage {
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public BuyBoxPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getQuantityInput() {
		return driver.findElement(By.id("quantity_wanted"));
	}
	
	public Select selectSize() {
		Select size = new Select(driver.findElement(By.id("group_1")));
		return size;
	}
	
	public WebElement getAddToCardButton() {
		return driver.findElement(By.name("Submit"));
	}
	
	public WebElement getAddToWishListButton() {
		return driver.findElement(By.id("wishlist_button"));
	}
	
	public WebElement getColorPicker(String color) {
		List<WebElement> colors = driver.findElements(By.xpath("//*[@id = 'color_to_pick_list']//li//a"));
		for(int i = 0; i < colors.size(); i++) {
			if(color.equals(colors.get(i).getAttribute("title"))) {
				return colors.get(i);
			}
		}
		return colors.get(0);
	}
	
	public void scrollToElement() {
		WebElement s = driver.findElement(By.id("add_to_cart"));
        new Actions(driver)
                .scrollToElement(s)
                .perform();
	}

}
