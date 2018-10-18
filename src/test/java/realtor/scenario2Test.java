package realtor;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.searchResult;

import realtor.reusableMethods;
import realtor.scenario1Test;

public class scenario2Test extends testBase {
	
	@Test(priority=1, description="Verify [N] Homes is greater than 0")
	public void resultSearch() throws IOException {
		scenario1Test.websiteNavigation();
		searchResult sres = new searchResult(driver);
		String housecount = sres.getSearchCount().getText();
		System.out.println(housecount);
		housecount = housecount.replace(" Homes","");
		System.out.println(housecount);
		String cleanHouseCount = housecount.replace(",", "");		
		System.out.println(cleanHouseCount);
		int N = Integer.parseInt(cleanHouseCount);
		System.out.println(N);
		try {
		Assert.assertTrue(N>0, "N is greater than 0");
		} catch(AssertionError e) {
			Assert.fail();
		}
		}
	
	@AfterClass(description = "Close the browser")
	public void close() {
		reusableMethods.closeBrowser();

	}
		
}