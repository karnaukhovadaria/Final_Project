@card
Feature: Delete card
  As registered user
  I want to delete a card
  To clear out-of-date cards in the system
  (But I cannot because there is no delete button)

  @delete
  Scenario: Successful card delete
    Given User is registered in the system for card deletion
    And User is authorized in the system for card deletion
    And User has a created card for deletion
    When User goes to profile with cards
    Then Delete button is available