package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseUtils.BasePage;
import baseUtils.BrowserFactory;

public class FlightStatusPage extends BasePage{
	
	static final String _flightStatusPage_URL = "https://www.eurowings.com/en/information/at-the-airport/flight-status.html";
	static final String _flightStatusPage_title = "Flight status - Information - Eurowings";
	
	BrowserFactory factory  = new BrowserFactory();
	
	@FindBy(xpath="//span[text()='Departure airport']")
	WebElement txt_departure_initial;
	
	@FindBy(xpath="//span[text()='Departure airport']//span[text()='Destination airport']")
	WebElement txt_destination_initial;
	
	@FindBy(xpath="//input[@name='datepicker_input_27']")
	WebElement btn_datePicker;
	
	@FindBy(xpath="//span[text()='Show flight status']")
	WebElement btn_submit;
	
	public WebElement getDateElement(String date) {
		// date = "2021-07-28";
		String dateXpath = "//input[@value='"+date+"']";
		return getDriver().findElement(By.xpath(dateXpath));
	}
	
	public boolean launch() {
		factory.getDriver(_flightStatusPage_URL);
		String actualTitle = factory.getDriver().getTitle();
		if(actualTitle==_flightStatusPage_title) {
			System.out.println("Successfully launched URL");
			return true;
		}else {
			System.out.println("Failed to launch url - "+_flightStatusPage_URL);
			return false;
		}
	}
	
	public void setDeparture(String departure) {
		txt_departure_initial.sendKeys(departure);
	}
	
	public void setDestination(String destination) {
		txt_destination_initial.sendKeys(destination);	
	}
	
	public void setDate(String date) {
		btn_datePicker.click();
		this.getDateElement(date).click();
	}
	
	public void clickSubmit() {
		btn_submit.click();
	}

}
