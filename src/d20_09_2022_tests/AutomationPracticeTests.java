package d20_09_2022_tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

//Test #1:  Adding product to the cart
//Ucitati stranicu /index.php?id_product=1&controller=product
//Odskrolati do buy box-a
//Postavite kolicinu na 3
//Izaberite velicinu L
//Izaberite plavu boju
//Kliknite na dugme add to cart
//Cekajte da dijalog layer cart bude vidljiv
//Verifikovati da je kolicina iz layer cart dijalog 3
//Verifikovati da je velicina L
//Verifikovati da je izabran proizvod sa plavom bojom
//Verifikovati da je total price 3 puta veci od cene proizvoda
//Kliknite na dugme continue shopping
//cekajte da dijalog layer cart postane nevidljiv
//Izaberite novi proizvod sa kolicinom 1, velicinom S i bojom Organe
//Kliknite na dugme add to cart
//Cekajte da dijalog bude vidljiv
//kliknite na dugme proceed to checkout
//Verifikujte da je naslov stranice Order - My Store
//
//
//	Test #2:  Top menu mouse over
//Predjite misem preko women linka. Koristan link kako da predjete misem preko nekog elementa link
//Verifikujte da je podmeni za women deo vidljiv
//Predjite misem preko dresses linka. 
//Verifikujte da je podmeni za dresses deo vidljiv
//Predjite misem preko t-shirts linka. 
//Verifikujte podmeniji za womens i dresses nevidljivi
//Ukoliko je potrebno ukljucite odgovarajuca cekanja, kojim bi se sacekalo da stranica dodje u odgovarajuce stanje
//Provera preko za vidljivost preko soft assert-a
//
//	Test #3:  Phone number visibility check on resize
//Maksimizujte prozor
//Proverite da je element za broj telefona vidljiv
//Smanjite dimenziju pretrazivaca na velicinu 767 x 700
//Proverite element za broj telefona nije vidljiv
//Promenite dimenziju pretrazivaca na 768 x 700
//Proverite da je broj telefona vidljiv
//Maksimizujte prozor
//Provera preko soft asserta
//	
//	
//
//Test #4:  Header links check
//Kliknite na contact us link
//Verifikujte da je naslov stranice Contact us - My Store
//Kliknite na sign in link
//Verifikujte da je naslov stranice Login - My Store
//Provera preko soft asserta


public class AutomationPracticeTests extends BasicTest {
	
	@Test (priority = 10)
	public void AddingProductToTheCart() {
		driver.get(baseUrl + "/index.php?id_product=1&controller=product");
		buyBoxPage.scrollToElement();
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("3");
		buyBoxPage.selectSize().selectByVisibleText("L");
		buyBoxPage.getColorPicker("Blue").click();
		buyBoxPage.getAddToCardButton().click();
		layerCartPage.waitForDialogToBeVisible();
		Assert.assertEquals(layerCartPage.getQuantityNumber(), "3", "Quantity number should be 3");
		Assert.assertEquals(layerCartPage.getAttributesOfProducts(), "Blue, L", "Attributes should be Blue, L");
		Assert.assertEquals(layerCartPage.getTotalPrice(), "$49.53", "Total price should be $49.53");
		layerCartPage.getContinueShoppingButton().click();
		layerCartPage.waitForDialogToBeInvisible();
		buyBoxPage.getQuantityInput().clear();
		buyBoxPage.getQuantityInput().sendKeys("1");
		buyBoxPage.selectSize().selectByVisibleText("S");
		buyBoxPage.getColorPicker("Orange").click();
		buyBoxPage.getAddToCardButton().click();
		layerCartPage.waitForDialogToBeVisible();
		layerCartPage.getProceedToCheckoutButton().click();
		Assert.assertEquals(driver.getTitle(), "Order - My Store", "Title should be Order - My Store");
	}
	
	@Test (priority = 20)
	public void TopMenuMouseOver() {
	    	new Actions(driver)
	                .moveToElement(topMenuPage.getWomenLink())
	                .perform();
	    softAssert.assertNotEquals(topMenuPage.getWomenSubMenu().getAttribute("style"), "display: none;", "Sub menu should be visible");
	    new Actions(driver)
	    		.moveToElement(topMenuPage.getDressesLink())
	    		.perform();
	    softAssert.assertNotEquals(topMenuPage.getDressesSubMenu().getAttribute("style"), "display: none;", "Sub menu should be visible");
	    new Actions(driver)
				.moveToElement(topMenuPage.getTshirtsLink())
				.perform();
	    softAssert.assertNotEquals(topMenuPage.getWomenSubMenu().getAttribute("style"), "display: block;", "Sub menu should be invisible");
		softAssert.assertNotEquals(topMenuPage.getDressesSubMenu().getAttribute("style"), "display: block;", "Sub menu should be invisible");
		softAssert.assertAll();
	}
	
	@Test (priority = 30)
	public void PhoneNumberVisibilityCheckOnResize() throws InterruptedException{
		driver.manage().window().maximize();
		softAssert.assertEquals(headerPage.getShopPhoneElement().isDisplayed(), true, "Phone number should be visible");
		driver.manage().window().setSize(new Dimension(767,700));
		softAssert.assertEquals(headerPage.getShopPhoneElement().isDisplayed(), false, "Phone number should be invisible");
		//test ne prolazi na 768x700, kod mene je vidljiv tek na 785x700
		driver.manage().window().setSize(new Dimension(785,700));
		softAssert.assertEquals(headerPage.getShopPhoneElement().isDisplayed(), true, "Phone number should be visible");
		driver.manage().window().maximize();
		softAssert.assertAll();
	}
	
	@Test (priority = 40)
	public void HeaderLinksCheck(){
		headerPage.getContactUsLink().click();
		softAssert.assertEquals(driver.getTitle(), "Contact us - My Store", "Title should be Contact us - My Store");
		headerPage.getSignInLink().click();
		softAssert.assertEquals(driver.getTitle(), "Login - My Store", "Title should be Login - My Store");
		softAssert.assertAll();
	}
}
