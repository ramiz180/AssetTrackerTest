package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddLeasePage extends BasePage {

    public AddLeasePage(WebDriver driver) {
        super(driver);
    }

    // ---------- CUSTOMER DETAILS ----------

    // react-select customer name input
    @FindBy(xpath = "//input[@id='react-select-2-input']")
    private WebElement customerNameInput;

    // All customer suggestion options after typing
    @FindBy(xpath = "//div[@id='react-select-2-listbox']//div[contains(@id,'react-select-2-option-')]")
    private List<WebElement> customerNameOptions;

    @FindBy(xpath = "//input[@placeholder='Customer PO No']")
    private WebElement customerPONo;

    @FindBy(xpath = "//input[@title='Internal Reference Number']")
    private WebElement internalRefNo;

    @FindBy(xpath = "//select[@title='Lease Type']")
    private WebElement leaseTypeDropdown;

    @FindBy(xpath = "//select[@title='Currency']")
    private WebElement currencyDropdown;

    @FindBy(xpath = "//input[@title='Reimbursements']")
    private WebElement reimbursements;

    @FindBy(xpath = "//span[normalize-space()='Sale Person']/following::select[1]")
    private WebElement salesPersonDropdown;

    // ---------- ADD MACHINE SECTION ----------
    @FindBy(xpath = "//button[contains(text(),'Add Machine')]")
    private WebElement addMachineBtn;

    // react-select Asset No search input (dynamic id)
    @FindBy(xpath = "(//input[contains(@id,'react-select') and @type='text'])[position()=last()-1]")
    private WebElement assetNoInput;

    // All Asset No options after typing
    @FindBy(xpath = "//div[contains(@id,'-listbox')]//div[contains(@id,'-option-')]")
    private List<WebElement> assetNoOptions;

    @FindBy(xpath = "//input[@title='Select Number Of Operators']")
    private WebElement numberOfOperators;

    // Operator Name input (react-select, dynamic id)
    @FindBy(xpath = "(//span[normalize-space()='Operator Name']/following::input[contains(@id,'react-select')])[1]")
    private WebElement operatorNameInput;

    @FindBy(xpath = "//div[contains(@id,'-listbox')]//div[contains(@class,'select__option')]")
    private List<WebElement> operatorNameOptions;

    @FindBy(xpath = "//input[@placeholder='Rental Start Date']")
    private WebElement rentalStartDate;

    @FindBy(xpath = "//input[@placeholder='Rental End Date']")
    private WebElement rentalEndDate;

    @FindBy(xpath = "//input[@placeholder='Rental Location']")
    private WebElement rentalLocation;

    @FindBy(xpath = "//input[@placeholder='Contract Value']")
    private WebElement contractValue;

    @FindBy(xpath = "//input[@placeholder='Nominal Hrs/day']")
    private WebElement nominalHours;

    @FindBy(xpath = "//input[@placeholder='Total Working Days/Month']")
    private WebElement workingDaysPerMonth;

    @FindBy(xpath = "//input[@placeholder='₹ 0.00/-']")
    private WebElement monthlyRentalAmount;

    @FindBy(xpath = "//input[@placeholder='Normal Hourly Rent']")
    private WebElement normalHourlyRent;

    @FindBy(xpath = "//input[@placeholder='Enter Rate']")
    private WebElement overtimeRate;

    // ---------- BUTTONS ----------
    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    private WebElement removeMachineBtn;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitBtn;

    @FindBy(xpath="//p[.='Lease created successfully!']")
    private WebElement leaseCreatedSuccessMessage;


    // ---------- GENERIC REACT-SELECT HANDLER ----------
    public void selectFromReactSelect(WebElement inputField, String searchText, String optionToSelect, List<WebElement> dropdwonOptions, int delay) throws InterruptedException {

        // Step 1: Click field
        inputField.click();
        Thread.sleep(delay);
        // Step 2: Type at least 3 chars
        inputField.sendKeys(searchText);
        Thread.sleep(500);
        // Step 4: Click matching option
        for (WebElement opt : dropdwonOptions) {
            if (opt.getText().trim().equals(optionToSelect)) {
                opt.click();
                return;
            }
        }

        throw new RuntimeException("Option not found: " + optionToSelect);
    }


    // ---------- METHODS FOR ACTIONS ----------
    public void enterCustomerName(String typeText, String customerFullName) throws InterruptedException {
    	scrollToElementIfNeeded(customerNameInput);
    	selectFromReactSelect(customerNameInput, typeText, customerFullName, customerNameOptions,4000);
    }

    public void enterCustomerPONo(String poNumber) {
        customerPONo.sendKeys(poNumber);
    }

    public void enterInternalRefNo(String refNo) {
        internalRefNo.sendKeys(refNo);
    }

    public void selectLeaseType(String leaseType) {
        new Select(leaseTypeDropdown).selectByVisibleText(leaseType);
    }

    public void selectCurrency(String currency) {
        new Select(currencyDropdown).selectByVisibleText(currency);
    }
    
    public void SetReimbursements(String amount) {
    	reimbursements.sendKeys(amount);
    }

    public void selectSalesPerson(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until dropdown has more than 1 option
        wait.until(driver -> {
            Select dropdown = new Select(salesPersonDropdown);
            return dropdown.getOptions().size() > 1;
        });

        Select dropdown = new Select(salesPersonDropdown);
        dropdown.selectByIndex(index);
    }



    public void clickAddMachine() {
        addMachineBtn.click();
    }

    public void selectAssetNo(String typeText, String assetFullName) throws InterruptedException {
        selectFromReactSelect(assetNoInput, typeText, assetFullName, assetNoOptions, 1500);
    }

    public void selectNumberOfOperators(String numOperators) {
        numberOfOperators.sendKeys(numOperators);
    }

    public void selectOperatorName(String typeText, String operatorFullName) throws InterruptedException {
        selectFromReactSelect(operatorNameInput, typeText, operatorFullName, operatorNameOptions, 1000);
    }

    public void enterRentalStartDate(String startDate) {
    	setDateByJS(rentalStartDate, startDate);
    }

    public void enterRentalEndDate(String endDate) {
    	setDateByJS(rentalEndDate, endDate);
    }

    public void enterRentalLocation(String location) {
        rentalLocation.sendKeys(location);
    }

    public void enterContractValue(String value) {
        contractValue.sendKeys(value);
    }

    public void enterNominalHours(String hours) {
        nominalHours.sendKeys(hours);
    }

    public void enterWorkingDaysPerMonth(String days) {
        workingDaysPerMonth.sendKeys(days);
    }

    public void enterMonthlyRentalAmount(String amount) {
        monthlyRentalAmount.sendKeys(amount);
    }

    public void enterOvertimeRate(String rate) {
        overtimeRate.sendKeys(rate);
    }

    public void clickRemoveMachine() {
        removeMachineBtn.click();
    }

    public void clickCancel() {
        cancelBtn.click();
    }

    public void clickSubmit() {
    	scrollToElementIfNeeded(submitBtn);
        submitBtn.click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            scrollToElementIfNeeded(leaseCreatedSuccessMessage);
            return leaseCreatedSuccessMessage.isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }
}

