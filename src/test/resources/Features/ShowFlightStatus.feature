#Author: Vikas Bharati
#Feature Description : Our website users should be able get the flights status of a given flight route by a given date.
Feature: Our website users should be able get the flights status of a given flight route by a given date

  @P1 @regression @smoke
  Scenario: User enters Departure, Destination and selects date to search for flight status
    Given User has launched flight status page
    And User enters <departure> in Departure field
    And User enters <destination> in Destination field
    And User selects <date> in Date field
    When clicks Show flight status button
    Then user can see the flight status for the route and date selected successfully
    And closes browser
    
     Examples: 
      | departure    | destination | date  |
      | CGN | BER      | today |
      #| Cologne-Bonn | Munich      | yesterday |
      #| Cologne-Bonn | Munich      | tomorrow |

  #@P2 @regression
  #Scenario Outline: User enters Departure, Destination and selects past/present/future date to search for flight status
    #Given User has launched flight status page
    #And User enters <departure> in Departure field
    #And User enters <destination> in Destination field
    #And User selects <date> in Date field
    #When clicks Show flight status button
    #Then user can see the flight status for the route and date selected.
#
    #Examples: 
      #| departure    | destination | date       |
      #| Cologne-Bonn | Hamburg     | 2021-07-27 |
      #| Cologne-Bonn | Munich      | 2021-07-28 |
      #| Cologne-Bonn | Munich      | 2021-07-29 |
