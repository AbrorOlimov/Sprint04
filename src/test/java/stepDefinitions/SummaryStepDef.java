package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.*;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class SummaryStepDef {
    LoginPage loginPage = new LoginPage();
    PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    ExpensesPage expensesPage = new ExpensesPage();
    EmploymentPage employmentPage = new EmploymentPage();
    CreditReportPage creditReportPage = new CreditReportPage();
    EconsentPage econsentPage = new EconsentPage();
    SummaryPage summaryPage = new SummaryPage();
    @Given("The user is in summary page")
    public void theUserIsInSummaryPage() {
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
        econsentPage.fillAllSections();
        econsentPage.getNextButton().click();
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(summaryPage.getSaveBtn().isDisplayed());
    }

    @When("the user is summary page, all edit buttons should be displayed")
    public void theUserIsSummaryPageAllEditButtonsShouldBeDisplayed() {
        Assert.assertTrue(summaryPage.getPreApprovalEdit().isDisplayed());
        Assert.assertTrue(summaryPage.getPersonalnformationEdit().isDisplayed());
        Assert.assertTrue(summaryPage.getExpenseEdit().isDisplayed());
        Assert.assertTrue(summaryPage.getEmploymentIncomeEdit().isDisplayed());
        Assert.assertTrue(summaryPage.getOrderCreditEdit().isDisplayed());
        Assert.assertTrue(summaryPage.getExpenseEdit().isDisplayed());
    }


    @Given("The user navigates to summary page")
    public void theUserNavigatesToSummaryPage() {
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
        econsentPage.fillAllSections();
        econsentPage.getNextButton().click();
        SeleniumUtils.waitFor(1);
    }
    @When("user clicks edit button, the page should switch to the intended one")
    public void userClicksEditButtonThePageShouldSwitchToTheIntendedOne() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", summaryPage.getPreApprovalEdit());
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(preapprovalDetailsPage.getUpperText().isDisplayed());
        summaryPage.getJumpToSummary().click();
        SeleniumUtils.waitFor(1);

        jsExecutor.executeScript("arguments[0].click();", summaryPage.getPersonalnformationEdit());
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(personalInfoPage.getH6().isDisplayed());
        summaryPage.getJumpToSummary().click();
        SeleniumUtils.waitFor(1);

        jsExecutor.executeScript("arguments[0].click();", summaryPage.getExpenseEdit());
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(expensesPage.getH6().isDisplayed());
        summaryPage.getJumpToSummary().click();
        SeleniumUtils.waitFor(1);

        jsExecutor.executeScript("arguments[0].click();", summaryPage.getEmploymentIncomeEdit());
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(employmentPage.getH6().isDisplayed());
        summaryPage.getJumpToSummary().click();
        SeleniumUtils.waitFor(1);

        jsExecutor.executeScript("arguments[0].click();", summaryPage.getOrderCreditEdit());
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(creditReportPage.getH6().isDisplayed());
        summaryPage.getJumpToSummary().click();
        SeleniumUtils.waitFor(1);

        jsExecutor.executeScript("arguments[0].click();", summaryPage.getEConsentEdit());
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(econsentPage.getH4().isDisplayed());
        summaryPage.getJumpToSummary().click();
        SeleniumUtils.waitFor(1);

    }


    @Given("The user did necessary changes and filled everything")
    public void theUserDidNecessaryChangesAndFilledEverything() {
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
        econsentPage.fillAllSections();
        econsentPage.getNextButton().click();
        SeleniumUtils.waitFor(1);
    }

    @When("user clicks save button, it should navigate to the login page")
    public void userClicksSaveButtonItShouldNavigateToTheLoginPage() {
        summaryPage.getSaveBtn().click();
        SeleniumUtils.waitFor(1);
    }

    @And("user navigates to the application list")
    public void userNavigatesToTheApplicationList() {
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php", Driver.getDriver().getCurrentUrl());
    }

}
