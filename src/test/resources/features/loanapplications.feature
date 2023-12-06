@positive
Feature: View and Manage Submitted Loan Applications

  Background:
    Given the user has successfully logged in with valid credentials
    Then the user is on the My Applications page

  Scenario: Verify Number of Entries Selection
    Then the dropdown should contain the following options:
      | 10  |
      | 25  |
      | 50  |
      | 100 |
    And each load id should be an integer number
