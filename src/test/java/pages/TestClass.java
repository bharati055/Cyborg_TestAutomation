package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseUtils.BrowserFactory;

public class TestClass {

	public static void main(String[] args) {

		BrowserFactory factory  = new BrowserFactory();
		
		WebDriver driver = factory.getDriver("https://www.eurowings.com/en/information/at-the-airport/flight-status.html");
		By btn_departure_initial=By.xpath("//span[text()='Departure airport']");
		By txt_departure=By.xpath("//input[@placeholder='Departure airport']");
		By btn_destination_initial=By.xpath("//span[text()='Destination airport']");
		By txt_destination=By.xpath("//input[@placeholder='Destination airport']");
		By btn_datePicker=By.xpath("//input[@name='datepicker_input_27]");
		By btn_submit=By.xpath("//span[text()='Show flight status']");
		By btn_selection=By.xpath("//ul[@class='o-station-select__station-list']");

	}

}
