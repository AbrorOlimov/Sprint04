package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ExpensesPage;
import pages.LoginPage;
import pages.PersonalInfoPage;
import pages.PreapprovalDetailsPage;
import utils.ConfigReader;
import utils.SeleniumUtils;

public class ExpensesStepDef {

    LoginPage loginPage = new LoginPage();
    PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    ExpensesPage expensesPage = new ExpensesPage();
    @Given("The user is in expenses page")
    public void theUserIsInExpensesPage() {
        loginPage.login();
        loginPage.getMortgageApp().click();
        preapprovalDetailsPage.fillAllSections();
        preapprovalDetailsPage.getNextButton().click();
        SeleniumUtils.waitFor(1);
        personalInfoPage.fillAllSections();
        personalInfoPage.getNextBtn().click();
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(expensesPage.getH6().isDisplayed());
    }

    @When("user enter valid expenses details to all fields and presses next button")
    public void userEnterValidExpensesDetailsToAllFields() {
        expensesPage.getMonthlyRental().sendKeys(ConfigReader.getProperty("monthlyRental"));
    }

    @Then("the page should switch to employment and income section")
    public void thePageShouldSwitchToEmploymentAndIncomeSection() {
        expensesPage.getNextBtn().click();
    }
}
