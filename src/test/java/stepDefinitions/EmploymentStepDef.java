package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.ConfigReader;
import utils.SeleniumUtils;

public class EmploymentStepDef {
    LoginPage loginPage = new LoginPage();
    PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    ExpensesPage expensesPage = new ExpensesPage();
    EmploymentPage employmentPage = new EmploymentPage();

    @Given("The user is in employment and income page")
    public void theUserIsInEmploymentAndIncomePage() {
        loginPage.login();
        loginPage.getMortgageApp().click();
        preapprovalDetailsPage.fillAllSections();
        preapprovalDetailsPage.getNextButton().click();
        SeleniumUtils.waitFor(1);
        personalInfoPage.fillAllSections();
        personalInfoPage.getNextBtn().click();
        SeleniumUtils.waitFor(1);
        expensesPage.getMonthlyRental().sendKeys(ConfigReader.getProperty("monthlyRental"));
        expensesPage.getNextBtn().click();
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(employmentPage.getH6().isDisplayed());
    }

    @When("user enter valid employment and income details to all fields and presses next button")
    public void userEnterValidEmploymentAndIncomeDetailsToAllFields() {
        employmentPage.fillAllSections();
    }

    @Then("the page should switch to credit report section")
    public void thePageShouldSwitchToCreditReportSection() {
        employmentPage.getNextBtn().click();
    }
}
