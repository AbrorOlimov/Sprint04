@positive
Feature: As a user should be able to put CreditReport and move forward

  Scenario: User fills fields in credit report section with valid data
    Given The user is in credit report page
    When user enter valid credit report details to all fields and presses next button
    Then the page should switch to e-consent section