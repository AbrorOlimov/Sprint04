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

public class EconsentStepDef {
    LoginPage loginPage = new LoginPage();
    PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    ExpensesPage expensesPage = new ExpensesPage();
    EmploymentPage employmentPage = new EmploymentPage();
    CreditReportPage creditReportPage = new CreditReportPage();
    EconsentPage econsentPage = new EconsentPage();
    @Given("The user is in e-consent page")
    public void theUserIsInEConsentPage() {
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
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", creditReportPage.getCreditReportNo());
        creditReportPage.getNextBtn().click();
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(econsentPage.getH4().isDisplayed());
    }

    @When("user enter valid details to all e-consent fields and presses next button")
    public void userEnterValidDetailsToAllEConsentFieldsAndPressesNextButton() {
        econsentPage.fillAllSections();
    }

    @Then("the page should switch to summary section")
    public void thePageShouldSwitchToSummarySection() {
        econsentPage.getNextButton().click();
    }
}
