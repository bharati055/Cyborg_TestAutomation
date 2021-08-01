package baseUtils;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	private WebDriver driver = null;
	public String browser = "chrome";
	public static HashMap<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	// public BrowserFactory(String browser, String driverPath) {
	// this.getDriver(browser,driverPath);
	// }

	public WebDriver getDriver(String url) {
		Log.info("In BrowserFactory >> getDriver and navigate with URL - " + url);
		driver = this.getDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver getDriver() {
		//Log.info("In BrowserFactory >> getDriver ");
//		Log.info("IDriver >>==================================>> " + drivers.get("driver"));
//		Log.info("Driver exist >> " + drivers.containsKey("driver"));
		if (!drivers.containsKey("driver")) {
			this.createDriver();
			Log.info("Driver not found. Creating Driver...........");
		}
		return drivers.get("driver");
	}

	public void createDriver() {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		drivers.put("driver", driver);
		Log.info("1st   === IDriver >>==================================>> " + drivers.get("driver"));
	}

	public void closeDriver() {
		Log.info("================================= Closing Browser =================================");
		driver = drivers.get("driver");
		driver.close();
		drivers.remove("driver");
	}
	public void quitDriver() {
		Log.info("================================= Closing Browser =================================");
		driver = drivers.get("driver");
		driver.quit();
		drivers.remove("driver");
	}

}
