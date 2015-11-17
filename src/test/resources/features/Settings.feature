Outline
@Add custom card type
Feature settings
  Scenario: Add custom card type
    Given I have a Board created
    When I want to add a custom card type
    Then I Have to enter to board settings
      And I have to select Add custom card type
      And I have to write a title card
      And Ii have to select a color for card
    When I add custom car type
    Then the new card type added should be display on the Card types list