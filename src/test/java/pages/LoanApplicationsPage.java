package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.List;

@Data
public class LoanApplicationsPage {

    public LoanApplicationsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Application List")
    private WebElement applicationListButton;

    @FindBy(xpath = "//select[@class= 'custom-select custom-select-sm form-control form-control-sm']")
    private WebElement dropDown;

}



