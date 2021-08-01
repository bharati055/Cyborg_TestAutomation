package stepDefinitions;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import CommonUtils.Date;
import baseUtils.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BlankPage;
import pages.FlightStatusPage;

public class ShowFlightStatusStepDef {

	FlightStatusPage flightStatusPage = new FlightStatusPage();
	BlankPage blankPage = new BlankPage();
	String searchDate;
	boolean departureFlag;
	boolean destinationFlag;
	
	
	@Given("User has launched flight status page")
	public void user_has_launched_flight_status_page() {
		Log.info("Inside stepFile - ShowFlightStatus >> User has launched eurowings.com flight status page");
		
		blankPage.openFlightStatusPage();
	}
	
    @And("^User enters city code -  (.*) in Departure field$")
	public void user_enters_city_code_in_departure_field(String departure) {
		Log.info("Inside stepFile - ShowFlightStatus >> user_enters_name1_in_departure_field. Departure = "+departure);
		 
		 flightStatusPage.setDeparture(departure);
		 
	}

	@And("^User enters city code - (.*) in Destination field$")
	public void user_enters_city_code_in_destination_field(String destination) {
		Log.info("Inside stepFile - ShowFlightStatus >> user_enters_in_in_destination_field. destination = "+destination);
		
		flightStatusPage.setDestination(destination);

	}
    
    
	@And("^User enters (.*) in Departure field$")
	public void user_enters_name1_in_departure_field(String departure) {
		Log.info("Inside stepFile - ShowFlightStatus >> user_enters_name1_in_departure_field. Departure = "+departure);
		 
		 if(flightStatusPage.setDeparture(departure)) {
				departureFlag = true;
				assertTrue(true);
			}else {
				departureFlag = false;
				assertTrue(false);
			}
		 
	}

	@And("^User enters (.*) in Destination field$")
	public void user_enters_in_destination_field(String destination) {
		Log.info("Inside stepFile - ShowFlightStatus >> user_enters_in_in_destination_field. destination = "+destination);
		
		if(flightStatusPage.setDestination(destination)) {
			destinationFlag = true;
			assertTrue(true);
		}else {
			destinationFlag = false;
			assertTrue(false);
		}
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

	@Then("^user can see the flight status as (.*) for the route and date selected$")
	public void user_can_see_the_flight_status_for_the_route_and_date_selected(String expectedStatus) {
		Log.info("Inside stepFile - ShowFlightStatus >> user can see the flight status for the route and date selected.");
		
		String actualDate = flightStatusPage.get_activeSearchResultDate();
		//Fri, 28/07/
		//2021-07-28
		String[] splitup=searchDate.split("-");
		String newSearchString = splitup[2]+"/"+splitup[1];
		
		Log.info("Extected Search Date - "+newSearchString+" Actual search date in search result - " + actualDate);
		assertTrue(actualDate.contains(newSearchString));
		
		//Check result set - Flight not found message should not exist
		assertTrue(!flightStatusPage.flightNotFoundMessageExist());
		
		//Check the flight status is as expected
		String actualFlightStatus = flightStatusPage.getFlightStatus(expectedStatus);
		Log.info("Expected flight status - "+expectedStatus+", actual flight status on search result - "+actualFlightStatus);
		assertEquals(expectedStatus,actualFlightStatus);
		
	}
	
	@Then("User is not allowed to select same value in departure and destination")
	public void User_is_not_allowed_to_select_same_valure_in_departure_and_destination() {
		if (destinationFlag==true && departureFlag==true)
			fail("Failes: User was allowed to select same value in departure and destination");
		
	}
	
	@Given("tries to select date out of allowed range")
	public void tries_to_select_date_out_of_allowed_range() {
		String flightDate = Date.getDate("OutOfRange");
		Log.info("Inside stepFile - ShowFlightStatusStep >> tries_to_select_date_out_of_allowed_range. flightDate = "+flightDate);
		
		assertTrue(!flightStatusPage.setDate(flightDate));
	}
	@Then("user is not allowed to select that day")
	public void user_is_not_allowed_to_select_that_day() {
	    
	}
	
  	@Given ("the test is over")
  	public void given_the_test_is_over() {}
  	
  	@Then ("quit browser")
  	public void quit_browser() {
  		blankPage.closeBrowser();
  	}
	
	@And("closes browser")
	public void closes_browser() {
		blankPage.closeBrowser();
	}
	 
	
}
