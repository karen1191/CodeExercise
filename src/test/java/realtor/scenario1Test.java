package realtor;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.searchResult;

import realtor.reusableMethods;

public class scenario1Test extends testBase {
	
	@Test(priority=1, description= "Navigate to realtor.com and search for Morgantown,MW")
	public static void websiteNavigation() throws IOException {
		reusableMethods.hitTheUrl();
		homePage hp = new homePage(driver);
		hp.getInputText().sendKeys(prop.getProperty("place"));
		driver.switchTo().frame("kx-proxy-J7KSr-4q");
		driver.switchTo().defaultContent();
		hp.clickSearch().click();
		searchResult sr = new searchResult(driver);
		try {
		Assert.assertEquals(sr.getText().getText(), prop.getProperty("Text"));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}
	
	@AfterClass(description = "Close the broswer")
	public void close() {
		reusableMethods.closeBrowser();

	}
		
}