#Author: Vikas Bharati
#Feature Description : Our website users should be able get the flights status of a given flight route by a given date.
Feature: Our website users should be able get the flights status of a given flight route by a given date

  @P1 @regression @smoke
  Scenario Outline: [TestID-01] User enters departure, destination city code and selects todays date to search for flight status
    Given User has launched flight status page
    And User enters <departure> in Departure field
    And User enters <destination> in Destination field
    And User selects <date> in Date field
    When clicks Show flight status button
    Then user can see the flight status as <ExpectedFlightStatus> for the route and date selected
    And closes browser

    Examples: 
      | departure | destination | date  | ExpectedFlightStatus |
      | CGN       | BER         | today | on time              |

  @P2 @regression
  Scenario Outline: [TestID-02] User enters Departure, Destination and selects tomorrows date to search for flight status
    Given User has launched flight status page
    And User enters <departure> in Departure field
    And User enters <destination> in Destination field
    And User selects <date> in Date field
    When clicks Show flight status button
    Then user can see the flight status as <ExpectedFlightStatus> for the route and date selected
    And closes browser

    Examples: 
      | departure    | destination        | date     | ExpectedFlightStatus |
      | Cologne-Bonn | Berlin Brandenburg | tomorrow | on time              |

  @P2 @regression
  Scenario Outline: [TestID-03] User enters Departure, Destination and selects yesterdays date to search for flight status
    Given User has launched flight status page
    And User enters <departure> in Departure field
    And User enters <destination> in Destination field
    And User selects <date> in Date field
    When clicks Show flight status button
    Then user can see the flight status as <ExpectedFlightStatus> for the route and date selected
    And closes browser

    Examples: 
      | departure    | destination        | date     | ExpectedFlightStatus |
      | Cologne-Bonn       | Berlin Brandenburg      | yesterday | arrived              |
      
  @P2 @regression
  Scenario Outline: [TestID-04] User should not be allowed to select date out of allowed range
    Given User has launched flight status page
    And tries to select date out of allowed range
    Then user is not allowed to select that day
    And closes browser

  @P2 @regression
  Scenario Outline: [TestID-05] User should not be allowed to enter same city in Departure, Destination
    Given User has launched flight status page
    And User enters <departure> in Departure field
    And User enters <destination> in Destination field
    Then User is not allowed to select same value in departure and destination
    And closes browser

    Examples: 
      | departure    | destination  |
      | Cologne-Bonn | Cologne-Bonn |

  @P2 @regression @sanity @cleanup
  Scenario: [Cleanup] Close Browser if open
    Given the test is over
    Then quit browser
