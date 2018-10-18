package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchResult {

	public WebDriver driver;

	By text = By.xpath("//*[@id=\"srp-header\"]/div/h1");
	By searchCount = By.xpath("//*[@id=\"search-result-count\"]");

	public searchResult(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getText() {
		return driver.findElement(text);
	}

	public WebElement getSearchCount() {
		return driver.findElement(searchCount);
	}

}
