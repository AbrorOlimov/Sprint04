package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.PreapprovalDetailsPage;
import utils.SeleniumUtils;

public class PreApprovalStepDef {

    LoginPage loginPage = new LoginPage();
    PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();


    @Given("The user is in preapproval details page")
    public void theUserIsInPreapprovalDetailsPage() {
        loginPage.login();
        loginPage.getMortgageApp().click();
        Assert.assertTrue(preapprovalDetailsPage.getH5().isDisplayed());
    }

    @When("user enter valid details to all fields and presses next button")
    public void userEnterValidDetailsToAllFields() {
        preapprovalDetailsPage.fillAllSections();
    }

    @Then("the page should switch to personal information section")
    public void thePageShouldSwitchToPersonalInformationSection() {
        preapprovalDetailsPage.getNextButton().click();
        SeleniumUtils.waitFor(1);
    }
}
