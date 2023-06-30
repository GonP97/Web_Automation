Feature: Booking a flight on Ryanair

  Scenario: Search and book a flight
    Given I am on the Ryanair website
    When I search for a trip between "Lisbon" and "Paris Beauvais"
    And I select the departure date as "2023-07-06" and return date as "2023-10-30"
    And I add 2 adults and 1 child
    #And I change the departure date to "2023-12-06" and return date to "2023-12-12"
    #And I choose "Tarifa value" option
    #And I fill in the passenger details with the following data:
    #  | Name   | Surname     |
    #  | Sónia | Pereira |
    #  | Diogo | Bettencourt |
    #  | Inês | Marçal |
    #And I select a small package
    #And I select the same seats for the return trip
    #And I continue to payment
    #Then I should see the payment page