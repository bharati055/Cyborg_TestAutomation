package stepDefinitions;


import static org.junit.Assert.assertTrue;

import CommonUtils.Date;
import baseUtils.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BlankPage;
import pages.FlightStatusPage;

public class ShowFlightStatusStepDef {

	FlightStatusPage flightStatusPage;
	BlankPage blankPage;
	String searchDate;
	
	
	@Given("User has launched flight status page")
	public void user_has_launched_flight_status_page() {
		Log.info("Inside stepFile - ShowFlightStatus >> User has launched eurowings.com flight status page");
		
		blankPage = new BlankPage();
		blankPage.openFlightStatusPage();
	}

	@And("^User enters (.*) in Departure field$")
	public void user_enters_name1_in_departure_field(String departure) {
		Log.info("Inside stepFile - ShowFlightStatus >> user_enters_name1_in_departure_field. Departure = "+departure);
		 
		 flightStatusPage = new FlightStatusPage();
		 flightStatusPage.setDeparture(departure);
	}

	@And("^User enters (.*) in Destination field$")
	public void user_enters_in_destination_field(String destination) {
		Log.info("Inside stepFile - ShowFlightStatus >> user_enters_in_in_destination_field. destination = "+destination);
		
		flightStatusPage.setDestination(destination);
	}

	@And("^User selects (.*) in Date field$")
	public void user_selects_success_in_date_field(String when) {
		
		String flightDate = Date.getDate(when);
		Log.info("Inside stepFile - ShowFlightStatus >> user_selects_success_in_date_field. flightDate = "+flightDate);
		
		flightStatusPage.setDate(flightDate);
		searchDate = flightDate;
	}

	@When("clicks Show flight status button")
	public void clicks_show_flight_button() {
		Log.info("Inside stepFile - ShowFlightStatus >> clicks Show flight button");
	   
	   flightStatusPage.clickSubmit();
	}

	@Then("user can see the flight status for the route and date selected successfully")
	public void user_can_see_the_flight_status_for_the_route_and_date_selected() {
		Log.info("Inside stepFile - ShowFlightStatus >> user can see the flight status for the route and date selected.");
		
		String actualDate = flightStatusPage.get_activeSearchResultDate();
		//Fri, 28/07/
		//2021-07-28
		String[] splitup=searchDate.split("-");
		String newSearchString = splitup[2]+"/"+splitup[1];
		assertTrue(actualDate.contains(newSearchString));
		
		//Check result set
		assertTrue(!flightStatusPage.flightNotFoundMessageExist());
			
		
	}
	
	@Then("closes browser")
	public void closes_browser() {
		blankPage.closeBrowser();
	}

	
}
