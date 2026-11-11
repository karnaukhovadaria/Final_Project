@card
Feature: Create card
  As registered user
  I want to create a card
  To post it to the system

  @creation
  Scenario: Successful creation of card
    Given User is registered in the system
    And User is authorized in the system to create card
    When User creates new card
    Then Card is displayed in user profile