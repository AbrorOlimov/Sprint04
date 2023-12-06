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
    @Then("each load id should be an integer number")
    public void each_should_be_an_integer_number() {
        for (WebElement element : loanApplicationsPage.getLoadIds()) {
            String loadId = element.getText();
            try {
                Integer.parseInt(loadId);
            } catch (NumberFormatException e) {
                System.out.println("Invalid load ID: '" + loadId + "' from element: " + element);
            }
        }


    }




}


