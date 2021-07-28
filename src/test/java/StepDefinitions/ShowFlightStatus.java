package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShowFlightStatus {

//Scenario1	
	@Given("User has launched eurowings.com flight status page")
	public void user_has_launched_eurowings_com_flight_status_page() {
		System.out.println("Inside step >> User has launched eurowings.com flight status page");

	}

	@And("enters Departure, Destination and selects date")
	public void enters_departure_destination_and_selects_date() {
	   System.out.println("Inside step >> enters Departure, Destination and selects date");
	}

	@When("clicks Show flight button")
	public void clicks_show_flight_button() {
	   System.out.println("Inside step >> clicks Show flight button");
	}

	@Then("user can see the flight status for the route and date selected.")
	public void user_can_see_the_flight_status_for_the_route_and_date_selected() {
	    System.out.println("Inside step >> user can see the flight status for the route and date selected.");
	}

//Scenario2
	@Given("User enters name1 in Departure field")
	public void user_enters_name1_in_departure_field() {
	    
	}

	@Given("User enters {int} in in Destination field")
	public void user_enters_in_in_destination_field(Integer int1) {
	    
	}

	@Given("User selects success in in Date field")
	public void user_selects_success_in_in_date_field() {
	    
	}

	@Given("User enters name2 in Departure field")
	public void user_enters_name2_in_departure_field() {
	   
	}

	@Given("User selects Fail in in Date field")
	public void user_selects_fail_in_in_date_field() {
	    
	}
	
	
}
