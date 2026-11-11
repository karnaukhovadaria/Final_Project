@card
Feature: Card edit
  As registered user
  I want to edit a card
  To make it up-to-date in the system

  @edit
  Scenario: Successful card edit
    Given User is registered in the system for card edit
    And User is authorized in the system for card edit
    And User has a created card
    When User clicks edit button
    Then Edit card is opened