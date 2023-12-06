@positive
Feature: User fills fields in preapproval details section in application form

  Scenario: User fills fields preapproval details section with valid data
    Given The user is in preapproval details page
    When user enter valid details to all fields and presses next button
    Then the page should switch to personal information section