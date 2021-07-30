package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.Wait;
import baseUtils.BasePage;
import baseUtils.BrowserFactory;
import baseUtils.Log;
import elementRepository.ElementFactory;

public class FlightStatusPage extends BasePage{
	
	BrowserFactory factory  = new BrowserFactory();
	WebDriver driver = factory.getDriver();

	//Page object method for - btn_departure_initial
	   public WebElement btn_departure_initial(){
	     Log.info("Element Page Object >> btn_departure_initial");
	     return ElementFactory.getElement("btn_departure_initial");
	   }

	   //Page object method for - txt_departure
	   public WebElement txt_departure(){
	     Log.info("Element Page Object >> txt_departure");
	     return ElementFactory.getElement("txt_departure");
	   }

	   //Page object method for - btn_destination_initial
	   public WebElement btn_destination_initial(){
	     Log.info("Element Page Object >> btn_destination_initial");
	     return ElementFactory.getElement("btn_destination_initial");
	   }

	   //Page object method for - txt_departure
	   public WebElement txt_destination(){
	     Log.info("Element Page Object >> txt_destination");
	     return ElementFactory.getElement("txt_destination");
	   }

	   //Page object method for - btn_datePicker
	   public WebElement btn_datePicker(){
	     Log.info("Element Page Object >> btn_datePicker");
	     return ElementFactory.getElement("btn_datePicker");
	   }

	   //Page object method for - btn_submit
	   public WebElement btn_submit(){
	     Log.info("Element Page Object >> btn_submit");
	     return ElementFactory.getElement("btn_submit");
	   }
	   
	   public WebElement btn_selection() {
		   Log.info("Element Page Object >> btn_selection");
		   return ElementFactory.getElement("btn_selection");
	   }
	   
	   public WebElement btn_activeSearchResultDate() {
		   Log.info("Element Page Object >> btn_activeSearchResultDate");
		   return ElementFactory.getElement("btn_activeSearchResultDate");
	   }
	   
	   public WebElement obj_searchedFlightStatusList() {
		   Log.info("Element Page Object >> obj_searchedFlightStatusList");
		   return ElementFactory.getElement("obj_searchedFlightStatusList");
	   }
	   
	//POM auto-generate complete =========================================================  
	
	public WebElement getDateElement(String date) {
		// date = "2021-07-28";
		String dateXpath = "//input[@value='"+date+"']";
		return driver.findElement(By.xpath(dateXpath));
	}
	
//	public WebElement getSelectiontoClick() {
//		String xpath = "//div[@class='o-station-select__station-list__text']/span[contains(text(),'United')]";
//		return driver.findElement(By.xpath(xpath));
//	}

	
	

	public void setDeparture(String departure) {
//		factory.getDriver().navigate().refresh();
		Log.info("Inside >> FlightStatusPage >> setDeparture: Setting departure field.");
		this.btn_departure_initial().click();
		this.txt_departure().sendKeys(departure);
		this.btn_selection().click();

	}
	
	public void setDestination(String destination) {
		Log.info("Inside >> FlightStatusPage >> setDestination: Setting destination field.");
		this.btn_destination_initial().click();
		Wait.waitTill(3000);
		this.txt_destination().sendKeys(destination);
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.btn_selection()))
        .click();
	}
	
	public void setDate(String date) {
		Log.info("Inside >> FlightStatusPage >> setDate: Setting date field.");
		this.btn_datePicker().click();
		Wait.waitTill(1000);
//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.getDateElement(date)))
//        .click();
		this.getDateElement(date).click();
	}
	
	public void clickSubmit() {
		Log.info("Inside >> FlightStatusPage >> clickSubmit: Clicking Submit button.");
		this.btn_submit().click();
	}
	
	public String get_activeSearchResultDate() {
		String date = btn_activeSearchResultDate().findElement(By.tagName("div")).getText();
		System.out.println("Tag name >> " +date);
		return date;
	}
	
	public boolean flightNotFoundMessageExist() {
		
		
		try{
		driver.findElement(By.xpath("//h2[text()='Unfortunately, we could not find any results for your search.']"));
		return true;
		}catch (Exception e) {
			return false;
		}
		
	}

}
