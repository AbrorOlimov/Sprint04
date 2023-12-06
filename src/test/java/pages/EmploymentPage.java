package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;
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


    @FindBy(id = "grossmonthlyincome")
    private WebElement monthlyGross;

    @FindBy(id = "monthlyovertime")
    private WebElement monthlyOvertime;

    @FindBy(id = "monthlybonuses")
    private WebElement monthlyBonuses;

    @FindBy(id = "monthlycommission")
    private WebElement monthlyComm;

    @FindBy(id = "monthlydividents")
    private WebElement monthlyDivident;

    @FindBy(id = "currentjob1")
    private WebElement currentJobBox;

    @FindBy(linkText = "Next")
    private WebElement nextButton;

    @FindBy(xpath = "(//div[@class=\"checkbox checkbox-primary checkbox-glow\"])[5]")
    private WebElement currJobBox;

    @FindBy(id = "addemployer")
    private WebElement addEmployer;

    @FindBy(id = "employername2")
    private WebElement employerName2;

    @FindBy(id = "position2")
    private WebElement position2;

    @FindBy(id = "city2")
    private WebElement city2;

    @FindBy(id = "state2")
    private WebElement state2;

    @FindBy(id = "start_date2")
    private WebElement startDate2;

    @FindBy(id = "end_date2")
    private WebElement endDate2;

    @FindBy(id = "clear2")
    private WebElement clear2;

    @FindBy(linkText = "Yes!")
    private WebElement clearYes2;

    @FindBy(xpath = "//*[text()='Yes!']")
    private WebElement yesButton2;

    public void fillAllSections(){
        Select select = new Select(getState());



        getEmployerName().sendKeys(ConfigReader.getProperty("employerName"));
        getPosition().sendKeys(ConfigReader.getProperty("position"));
        getCity().sendKeys(ConfigReader.getProperty("city"));
//        select.selectByVisibleText(ConfigReader.getProperty("state"));
        List<WebElement> options = select.getOptions();
        List<String> stateNames = new ArrayList<>();
        for (WebElement option : options) {
            stateNames.add(option.getText());
        }

        if (stateNames.size() == 50) {
            System.out.println("Dropdown contains all 50 states.");
        } else {
            System.out.println("Dropdown does not contain all 50 states.");
        }
        System.out.println("there are " + stateNames.size() + " states");
        select.selectByVisibleText("Virginia (VA)");

        getStartDate().sendKeys(ConfigReader.getProperty("startDate"));
        getGrossIncome().sendKeys(ConfigReader.getProperty("grossMonthly"));
        getMonthlyOvertime().sendKeys("3000");
        getMonthlyComm().sendKeys("1500");
        getMonthlyBonuses().sendKeys("1000");
        getMonthlyDivident().sendKeys("500");

        getAddEmployer().click();
        SeleniumUtils.waitFor(2);
        getEmployerName2().sendKeys(ConfigReader.getProperty("employerName"));
        getPosition2().sendKeys(ConfigReader.getProperty("position"));
        getCity2().sendKeys(ConfigReader.getProperty("city"));

        Select select2 = new Select(state2);
        select2.selectByVisibleText("California (CA)");

        getStartDate2().sendKeys(ConfigReader.getProperty("startDate"));
        getEndDate2().sendKeys("01012023");

        getClear2().click();
        SeleniumUtils.waitFor(2);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].click();", getYesButton2());


    }




}
