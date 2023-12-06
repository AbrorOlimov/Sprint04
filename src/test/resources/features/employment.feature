@positive
Feature: As a user applying for a mortgage loan, I want to provide my employment
  and income details to the bank, so that they can evaluate my eligibility for
  a loan.

  Scenario: User fills fields employment and income section with valid data
    Given The user is in employment and income page
    When user enter valid employment and income details to all fields and presses next button
    Then the page should switch to credit report section