@positive
Feature: As a user should be able to put E-Consent and move forward

  Scenario: User fills fields in e-consent section with valid data
    Given The user is in e-consent page
    When user enter valid details to all e-consent fields and presses next button
    Then the page should switch to summary section