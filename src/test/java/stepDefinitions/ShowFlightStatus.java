package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlightStatusPage;

public class ShowFlightStatus {

	FlightStatusPage flightStatusPage = new FlightStatusPage();
	
//Scenario1	
	@Given("User has launched flight status page")
	public void user_has_launched_flight_status_page(String url) {
		System.out.println("Inside step >> User has launched eurowings.com flight status page");
		flightStatusPage.launch();
	}
	
	@When("clicks Show flight status button")
	public void clicks_show_flight_button() {
	   System.out.println("Inside step >> clicks Show flight button");
	   flightStatusPage.clickSubmit();
	}

	@Then("user can see the flight status for the route and date selected.")
	public void user_can_see_the_flight_status_for_the_route_and_date_selected() {
	    System.out.println("Inside step >> user can see the flight status for the route and date selected.");
	}

//Scenario2

	@And("^User enters (.*) in Departure field$")
	public void user_enters_name1_in_departure_field(String departure) {
		 System.out.println("Inside step >> user_enters_name1_in_departure_field. Departure = "+departure);
		 flightStatusPage.setDeparture(departure);
	}

	@And("^User enters (.*) in Destination field$")
	public void user_enters_in_in_destination_field(String destination) {
		 System.out.println("Inside step >> user_enters_in_in_destination_field. destination = "+destination);
		 flightStatusPage.setDestination(destination);
	}

	@And("^User selects (.*) in Date field$")
	public void user_selects_success_in_date_field(String flightDate) {
		 System.out.println("Inside step >> user_selects_success_in_date_field. flightDate = "+flightDate);
		 flightStatusPage.setDate(flightDate);
	}


	
}
