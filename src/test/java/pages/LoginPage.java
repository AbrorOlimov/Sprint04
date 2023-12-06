package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

@Data
public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "exampleInputEmail1")
    private WebElement emailField;

    @FindBy(id="exampleInputPassword1")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='mortgage.php'] ")
    private WebElement mortgageApp;

    @FindBy(xpath = "//span[@data-i18n='Analytics']")
    private WebElement applicationList;

    public void login(){
        getEmailField().sendKeys(ConfigReader.getProperty("email"));
        getPasswordField().sendKeys(ConfigReader.getProperty("password"));
        getLoginButton().click();
    }
}
