package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOperatorPage extends BasePage {

    public AddOperatorPage(WebDriver driver) {
        super(driver);
    }

    // **Input Fields**
    @FindBy(xpath = "//input[@placeholder='e.g. John Doe']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@placeholder='Enter 10-digit mobile no']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//input[@placeholder='Enter valid driving license']")
    WebElement drivingLicenseInput;

    @FindBy(xpath = "//input[@placeholder='Enter your bank account number']")
    WebElement bankAccountNumberInput;

    @FindBy(xpath = "//input[@placeholder=' e.g., SBIN0001234']")
    WebElement bankIFSCCodeInput;

    @FindBy(xpath = "//input[@placeholder='Enter your PF Account Number']")
    WebElement pfAccountNumberInput;

    @FindBy(xpath = "//input[@placeholder='e.g 20,000']")
    WebElement netSalaryInput;

    @FindBy(xpath = "//input[@placeholder='Advanced Payment Information']")
    WebElement advancedPaymentInput;

    // **Pre-Filled Fields**
    @FindBy(xpath = "//input[@value='1256 4654 6546']")
    WebElement aadhaarNumber;

    @FindBy(xpath = "//input[@value='06/02/2000']")
    WebElement dateOfBirth;

    // **Dropdowns**
    @FindBy(xpath = "//select[contains(@placeholder,'Operator role')]")
    WebElement operatorRoleDropdown;

    @FindBy(xpath = "//select[@placeholder='Operator Sales Person']")
    WebElement operatorSalesPersonDropdown;

    // **Date Picker**
    @FindBy(xpath = "//input[@placeholder='07-03-2021']")
    WebElement dateOfJoiningInput;

    // **Buttons**
    @FindBy(xpath = "//button[contains(text(),'Back')]")
    WebElement backButton;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveButton;
    
    @FindBy(xpath = "//div[contains(text(),'Operator created successfully')]")
    WebElement OperatorCreatedMsg;

    // **Methods to interact with elements**
    
    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.clear();
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void enterDrivingLicense(String licenseNumber) {
        drivingLicenseInput.clear();
        drivingLicenseInput.sendKeys(licenseNumber);
    }

    public void enterBankAccountNumber(String bankAccount) {
        bankAccountNumberInput.clear();
        bankAccountNumberInput.sendKeys(bankAccount);
    }

    public void enterBankIFSCCode(String ifscCode) {
        bankIFSCCodeInput.clear();
        bankIFSCCodeInput.sendKeys(ifscCode);
    }

    public void enterPFAccountNumber(String pfNumber) {
        pfAccountNumberInput.clear();
        pfAccountNumberInput.sendKeys(pfNumber);
    }

    public void enterNetSalary(String salary) {
        netSalaryInput.clear();
        netSalaryInput.sendKeys(salary);
    }

    public void enterAdvancedPaymentInfo(String paymentInfo) {
        advancedPaymentInput.clear();
        advancedPaymentInput.sendKeys(paymentInfo);
    }

    public void selectOperatorRole(String role) {
        Select dr=new Select(operatorRoleDropdown);
    	dr.selectByValue(role);
    }

    public void selectOperatorSalesPerson(int salesPerson) {
    	Select SPD=new Select(operatorSalesPersonDropdown);
    	SPD.selectByIndex(salesPerson);
    }

    public void setDateOfJoining(String date) {
        dateOfJoiningInput.sendKeys(date);
    }

    public void clickBackButton() {
        backButton.click();
    }

    public void clickSaveButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }
    
    public boolean isOperatorAddedSuccMsg() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(OperatorCreatedMsg));
            return OperatorCreatedMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
