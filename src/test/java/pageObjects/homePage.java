package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import realtor.testBase;

public class homePage extends testBase {

	public WebDriver driver;

	By searchbox = By.xpath("//input[@class='rdc-input_2P3mn']");
	By searchbutton = By.xpath("//*[@id=\'__next\']/div/div/section[1]/div[2]/div/div/form/button/span/span");

	public homePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getInputText() {
		return driver.findElement(searchbox);
	}

	public WebElement clickSearch() {
		return driver.findElement(searchbutton);
	}
}
