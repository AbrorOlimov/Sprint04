package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

@Data
public class PersonalInfoPage {

    public PersonalInfoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h6[.='Personal Information']")
    private WebElement h6;

    @FindBy(id = "b_firstName")
    private WebElement firstName;

    @FindBy(id = "b_lastName")
    private WebElement lastName;

    @FindBy(id = "b_email")
    private WebElement email;

    @FindBy(id = "b_dob")
    private WebElement dob;

    @FindBy(id = "b_ssn")
    private WebElement ssn;

    @FindBy(id = "select2-b_marital-container")
    private WebElement maritalStatus;

    @FindBy(id = "b_cell")
    private WebElement cellPhone;

    @FindBy(xpath = "//div[@class=\"checkbox\"]")
    private WebElement privacyCheckbox;

    @FindBy(linkText = "Next")
    private WebElement nextBtn;

    @FindBy(xpath = "//input[@type=\"search\"]")
    private WebElement searchMarried;

    public void fillAllSections(){

        getFirstName().sendKeys(ConfigReader.getProperty("borrowerFirstName"));
        getLastName().sendKeys(ConfigReader.getProperty("borrowerLastName"));
        getEmail().sendKeys(ConfigReader.getProperty("borrowerEmail"));
        getDob().sendKeys(ConfigReader.getProperty("borrowerDob"));
        SeleniumUtils.waitFor(1);
        getSsn().sendKeys(ConfigReader.getProperty("ssn"));
        getMaritalStatus().click();
        getSearchMarried().sendKeys("Single", Keys.ENTER);
        getCellPhone().sendKeys(ConfigReader.getProperty("cellPhone"));
        getPrivacyCheckbox().click();
    }

}
