package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class SummaryPage {

    public SummaryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Save']")
    private WebElement saveBtn;

    @FindBy(id = "PreApprovalEdit")
    private WebElement preApprovalEdit;

    @FindBy(id = "PersonalnformationEdit")
    private WebElement personalnformationEdit;

    @FindBy(id = "ExpenseEdit")
    private WebElement expenseEdit;

    @FindBy(id = "EmploymentIncomeEdit")
    private WebElement employmentIncomeEdit;

    @FindBy(id = "OrderCreditEdit")
    private WebElement orderCreditEdit;

    @FindBy(id = "eConsentEdit")
    private WebElement eConsentEdit;

    @FindBy(id = "steps-uid-0-t-6")
    private WebElement jumpToSummary;

}
