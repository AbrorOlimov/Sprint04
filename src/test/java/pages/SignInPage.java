package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

@Data
public class SignInPage {
    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "exampleInputEmail1")
    private WebElement email;

    public void signInWithValidData(){
        getEmail().sendKeys(ConfigReader.getProperty("email"), Keys.TAB,ConfigReader.getProperty("password"),Keys.ENTER);
    }

}
