package CommonUtils;

import org.openqa.selenium.support.ui.WebDriverWait;

import baseUtils.BrowserFactory;

public class Wait {
	
	
	
	public static void wait(int miliseconds) {
	
			try {
				BrowserFactory factory  = new BrowserFactory();
				@SuppressWarnings("deprecation")
				WebDriverWait wait = new WebDriverWait(factory.getDriver(),10);
				wait.wait(miliseconds);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static void waitTill(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
