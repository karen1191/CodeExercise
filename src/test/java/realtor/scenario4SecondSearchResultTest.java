package realtor;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.listingPage;

import realtor.reusableMethods;
import realtor.scenario1Test;

public class scenario4SecondSearchResultTest extends testBase {

	@Test(description = "Select and compare price of the second search result")
		public void priceCheck() throws IOException {
			scenario1Test.websiteNavigation();
			List<WebElement> links = driver.findElements(By.xpath("//span[@class='data-price']"));
			WebElement secondLink = links.get(1);
			String ImgPrice = secondLink.getText();
			System.out.println("Price on the second search result: "+ImgPrice);
			secondLink.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("scroll(0, 250);");
	        listingPage lp = new listingPage(driver);
			String LstPrice = lp.getListingPrice().getText();
			System.out.println("Listing price of the second search result: "+LstPrice);
			try {
	        Assert.assertEquals(ImgPrice, LstPrice, "The listing price matches with the price displayed on the search result image");
		} catch (AssertionError e) {
			Assert.fail();
		}
		
	}
	
	@AfterClass(description = "Close the browser") public void close() {
		  reusableMethods.closeBrowser();
		  }
}
