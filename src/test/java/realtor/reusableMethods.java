package realtor;

import java.io.IOException;

public class reusableMethods extends testBase {

	public static void hitTheUrl() throws IOException {
		driver = initializeDriver();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

	public static void closeBrowser() {
		driver.quit();
		driver = null;
	}

}
