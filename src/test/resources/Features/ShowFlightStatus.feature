#Author: Vikas Bharati
#Feature Description : Our website users should be able get the flights status of a given flight route by a given date.

Feature: Our website users should be able get the flights status of a given flight route by a given date

  @P1 @regression @smoke
  Scenario: User enters Departure, Destination and selects date to search for flight status
    Given User has launched eurowings.com flight status page
    And enters Departure, Destination and selects date
    When clicks Show flight button
    Then user can see the flight status for the route and date selected.

  @P2 @regression
  Scenario Outline: User enters Departure, Destination and selects past/present/future date to search for flight status
    Given User has launched eurowings.com flight status page
    And User enters <departure> in Departure field
    And User enters <destination> in in Destination field
    And User selects <date> in in Date field
    Then user can see the flight status for the route and date selected.

    Examples: 
      | departure | destination | date    |
      | name1     |           5 | success |
      | name2     |           7 | Fail    |
