package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.LoanApplicationsPage;
import pages.SignInPage;
import utils.Driver;

import java.util.List;

import static utils.Driver.*;

public class LoanApplicationsStepDefs {

    SignInPage signInPage = new SignInPage();
    LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage();

    @Given("the user has successfully logged in with valid credentials")
    public void the_user_has_successfully_logged_in_with_valid_credentials() {
        signInPage.signInWithValidData();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", getDriver().getCurrentUrl());
    }

    @Then("the user is on the My Applications page")
    public void the_user_is_on_the_my_applications_page() {
        loanApplicationsPage.getApplicationListButton().click();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/applications.php", getDriver().getCurrentUrl());
    }

    @Then("the dropdown should contain the following options:")
    public void the_dropdown_should_contain_the_following_options(List<Integer> options)  {
        Select dropdown = new Select((WebElement) loanApplicationsPage.getDropDown());
        List<WebElement> actualOptions = dropdown.getOptions();
        for (int i = 0; i < options.size(); i++) {
            String actualOptionText = actualOptions.get(i).getText();
            int expectedOptionValue = options.get(i);
            Assert.assertEquals(Integer.parseInt(actualOptionText), expectedOptionValue);
        }
    }





}

/*
    @Then("the user enters {string} in the search field")
    public void the_user_enters_in_the_search_field(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the list of submitted applications should be filtered based on the search term {string}")
    public void the_list_of_submitted_applications_should_be_filtered_based_on_the_search_term(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the list of submitted applications should be displayed in a table with columns:")
    public void the_list_of_submitted_applications_should_be_displayed_in_a_table_with_columns(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Then("each loan ID should be an integer number")
    public void each_loan_id_should_be_an_integer_number() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("each borrower name should be displayed in the format of first name, last name")
    public void each_borrower_name_should_be_displayed_in_the_format_of_first_name_last_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("each loan amount should be displayed in US dollars and should be an integer")
    public void each_loan_amount_should_be_displayed_in_us_dollars_and_should_be_an_integer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

  Scenario Outline: Validate Application Filtering by Search Term
    Then the user enters "<SearchTerm>" in the search field
    And the list of submitted applications should be filtered based on the search term "<SearchTerm>"

    Examples:
      | SearchTerm |
      | John Doe   |
      | Thomas     |
      | Smith      |
      |   2700     |

  Scenario: Verify Display and Formatting of Submitted Loan Applications
    Then the list of submitted applications should be displayed in a table with columns:
      | Loan ID | Borrower Name     | Loan Amount | Loan Details               |
      | 1       | John Doe          | $50,000     |   View Details button      |
      | 2       | Jane Smith        | $30,000     |  View Details  button      |
      | 3       | Robert Johnson    | $80,000     |  View Details  button      |

    And each loan ID should be an integer number
    And each borrower name should be displayed in the format of first name, last name
    And each loan amount should be displayed in US dollars and should be an integer
*/


