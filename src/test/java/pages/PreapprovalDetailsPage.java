package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

@Data
public class PreapprovalDetailsPage {
    public PreapprovalDetailsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h5[.='Uniform Residential Loan Application(URLA)']")
    private WebElement h5;
//_____________________________________________________________________________________________
    @FindBy(id = "realtor1")
    private WebElement realtorYesCheck;

    @FindBy(name = "realtor_info")
    private WebElement realtorInfoField;

    @FindBy(id = "loanofficer1")
    private WebElement loanOfficerYesCheck;

    @FindBy(id = "estimatedprice")
    private WebElement estimatedPrice;

    @FindBy(id="downpayment")
    private WebElement downPayment;

    @FindBy(linkText = "Next")
    private WebElement nextButton;


    public void fillAllSections() {
        if (!getRealtorYesCheck().isSelected()) {
            getRealtorYesCheck().click();
        }
        getRealtorInfoField().sendKeys(ConfigReader.getProperty("realtorInformation"), Keys.ENTER);
        if (!getLoanOfficerYesCheck().isSelected()) {
            getLoanOfficerYesCheck().click();
        }

        getEstimatedPrice().sendKeys(ConfigReader.getProperty("estimatedPurchasePrice"));
        getDownPayment().sendKeys(ConfigReader.getProperty("downPayment"));

    }



}
