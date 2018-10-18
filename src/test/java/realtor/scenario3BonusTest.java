package realtor;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.listingPage;
import realtor.scenario1Test;

public class scenario3BonusTest extends testBase {

	@Test(priority = 1, description = "Bonus requirement: Select and compare price of search result")
	public void selectRandomImgUrl() throws IOException {
		scenario1Test.websiteNavigation();
		List<WebElement> links = driver.findElements(By.xpath("//span[@class='data-price']"));
		WebElement random = links.get(new Random().nextInt(links.size()));
		String randomPrice = random.getText();
		System.out.println("Price on the randomly selected search result: "+randomPrice);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", random);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 250);");
		listingPage lp = new listingPage(driver);
		String LstPrice = lp.getListingPrice().getText();
		System.out.println("Listing Price of that random search result : "+LstPrice);
		try {
			Assert.assertEquals(randomPrice, LstPrice,
					"The listing price matches with the price displayed on the search result image");
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	
	  @AfterClass(description = "Close the browser") public void close() {
	  reusableMethods.closeBrowser();
	  }
}
