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
		System.out.println("In BrowserFactory >> getDriver and navigate with URL - " + url);
		driver = this.getDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver getDriver() {
		System.out.println("In BrowserFactory >> getDriver ");
		System.out.println("IDriver >>==================================>> " + drivers.get("driver"));
		System.out.println("Driver exist >> " + drivers.containsKey("driver"));
		if (!drivers.containsKey("driver")) {
			this.createDriver();
			System.out.println("Driver not found. Creating Driver...........");
		}
		return drivers.get("driver");
	}

	public void createDriver() {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		drivers.put("driver", driver);
		System.out.println("1st   === IDriver >>==================================>> " + drivers.get("driver"));
	}

	public void closeDriver() {
		driver = drivers.get("driver");
		driver.close();
		drivers.remove("driver");
	}

}
