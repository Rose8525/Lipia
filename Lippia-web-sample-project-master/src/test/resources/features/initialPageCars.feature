Feature: Initial page cars
  As a web user
  I want to navigate PhpTravels Cars web page
  And search a Car using Chicago as a location and complete the form.

  @Test
  Scenario: As a web user I want to navigate PHPTravel and search a Car between two days.
    Given The user is in Cars page
    When The user search a car between two days
      | PickUp | DropOff | DepartDate | ReturnDate | DepartTime |
      | Madrid | Madrid  | 10/06/2020 | 18/06/2020 | 08:00      |
    Then The search page list the available cars in those days.

  @Test
  Scenario: As a web user I want to navigate PHPTravel and complete a cars booking process
    Given The user is in Cars page
    When The user search a car between two days
      | PickUp | DropOff | DepartDate | ReturnDate | DepartTime |
      | Madrid | Madrid  | 10/06/2020 | 18/06/2020 | 06:00      |
    And  the user select the first result in the list
    And The user complete the booking car form
    And The user complete the payment form <payment data provided below>
      | CardNumber       | CardHolderName | CardExpirationMonthDate | CardExpirationYearDate | CCV |
      | 4263982640269299 | Rosa           | 02                      | 2023                   | 837 |
    Then a reservation number is provided
