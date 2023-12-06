package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.PersonalInfoPage;
import pages.PreapprovalDetailsPage;
import utils.SeleniumUtils;

public class PersonalInfoStepDef {

    LoginPage loginPage = new LoginPage();
    PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    @Given("The user is in personal information page")
    public void theUserIsInPersonalInformationPage() {
        loginPage.login();
        loginPage.getMortgageApp().click();
        preapprovalDetailsPage.fillAllSections();
        preapprovalDetailsPage.getNextButton().click();
        SeleniumUtils.waitFor(1);
        Assert.assertTrue(personalInfoPage.getH6().isDisplayed());
    }

    @When("user enter valid details to all personal information fields and presses next button")
    public void userEnterValidDetailsToAllPersonalInformationFields() {
        personalInfoPage.fillAllSections();
    }

    @Then("the page should switch to expenses section")
    public void thePageShouldSwitchToExpensesSection() {
        personalInfoPage.getNextBtn().click();
    }
}
