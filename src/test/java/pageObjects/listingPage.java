package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class listingPage {
	public WebDriver driver;

	By ListPrice = By.xpath("//span[@itemprop='price']");

	public listingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getListingPrice() {
		return driver.findElement(ListPrice);
	}

}
