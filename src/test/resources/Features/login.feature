Feature: Feature to test HRS website functionality with Hotel booking test scenario

  Scenario: User is traveling to Barcelona on the date 21.06.2024 
  
    Given User navigates to the HRS booking portal

    When User clicks in the search textbox and enters valid destination- Barcelona

    And User selects the Arrival and departure date

    Then User selects number of rooms & persons

    And User clicks on the “Search Hotels”
    
    Then user can filter the hotels by low price availability
    
    Then User should be able to select the hotel 
    
    
