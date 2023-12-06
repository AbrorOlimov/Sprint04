@positive
Feature: As a user should be able to fill out personal info and move next page

  Scenario: User fills fields personal information section with valid data
    Given The user is in personal information page
    When user enter valid details to all personal information fields and presses next button
    Then the page should switch to expenses section