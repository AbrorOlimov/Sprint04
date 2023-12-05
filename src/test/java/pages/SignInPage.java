package pages;

import lombok.Data;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class SignInPage {
    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "exampleInputEmail1")
    private WebElement email;

    public void signInWithValidData(){
        getEmail().sendKeys("johndoe@gmail.com", Keys.TAB,"Duotech2023",Keys.ENTER);
    }

}
