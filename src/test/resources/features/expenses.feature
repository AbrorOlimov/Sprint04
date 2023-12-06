@positive
Feature: As a user should be able to put expenses and move forward

  Scenario: User fills fields expenses section with valid data
    Given The user is in expenses page
    When user enter valid expenses details to all fields and presses next button
    Then the page should switch to employment and income section