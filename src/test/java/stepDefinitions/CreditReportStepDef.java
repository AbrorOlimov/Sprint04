package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.*;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class CreditReportStepDef {
    LoginPage loginPage = new LoginPage();
    PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    ExpensesPage expensesPage = new ExpensesPage();
    EmploymentPage employmentPage = new EmploymentPage();
    CreditReportPage creditReportPage = new CreditReportPage();
    @Given("The user is in credit report page")
    public void theUserIsInCreditReportPage() {
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
        employmentPage.fillAllSections();
        employmentPage.getNextBtn().click();
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(creditReportPage.getH6().isDisplayed());
    }

    @When("user enter valid credit report details to all fields and presses next button")
    public void userEnterValidCreditReportDetailsToAllFields() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", creditReportPage.getCreditReportNo());
        SeleniumUtils.waitFor(1);
    }

    @Then("the page should switch to e-consent section")
    public void thePageShouldSwitchToEConsentSection() {
        creditReportPage.getNextBtn().click();
    }
}
