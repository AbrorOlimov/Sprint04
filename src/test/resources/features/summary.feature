@positive
Feature: Check if all edit buttons are available for all fields and navigates to intended pages

  Scenario: User fills fields all application sections with valid data
    Given The user is in summary page
    When the user is summary page, all edit buttons should be displayed

  Scenario: User clicks on edit buttons and the system should navigate to the needed page
    Given The user navigates to summary page
    When user clicks edit button, the page should switch to the intended one

    Scenario: User clicks save button and it should navigate back to the login page and the saved info should be seen in application list
      Given The user did necessary changes and filled everything
      When user clicks save button, it should navigate to the login page
      And  user navigates to the application list
    #  Then the previously saved data should be displayed in applications page


