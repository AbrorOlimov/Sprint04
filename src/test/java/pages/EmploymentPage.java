package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;

import java.util.Random;

@Data
public class EmploymentPage {
    public EmploymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h6[.='Borrower Employment Information']")
    private WebElement h6;
    @FindBy(id = "employername1")
    private WebElement employerName;
    @FindBy(id = "position1")
    private WebElement position;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "state1")
    private WebElement state;
    @FindBy(id = "start_date1")
    private WebElement startDate;
    @FindBy(id = "grossmonthlyincome")
    private WebElement grossIncome;
    @FindBy(linkText = "Next")
    private WebElement nextBtn;

    public void fillAllSections(){
        Select select = new Select(getState());
        getEmployerName().sendKeys(ConfigReader.getProperty("employerName"));
        getPosition().sendKeys(ConfigReader.getProperty("position"));
        getCity().sendKeys(ConfigReader.getProperty("city"));
        select.selectByVisibleText(ConfigReader.getProperty("state"));
        getStartDate().sendKeys(ConfigReader.getProperty("startDate"));
        getGrossIncome().sendKeys(ConfigReader.getProperty("grossMonthly"));
    }




}
