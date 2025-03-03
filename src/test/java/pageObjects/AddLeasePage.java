package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddLeasePage extends BasePage {

    public AddLeasePage(WebDriver driver) {
        super(driver);
    }

    // **Customer Details**
    @FindBy(xpath = "//span[@title='Customer Name']//input[@type='text']")
    private WebElement customerName;

    @FindBy(xpath = "//input[@placeholder='Customer PO No']")
    private WebElement customerPONo;

    @FindBy(xpath = "//input[@placeholder='Internal Reference Number']")
    private WebElement internalRefNo;

    @FindBy(xpath = "//select[@title='Lease Type']")
    private WebElement leaseTypeDropdown;

    @FindBy(xpath = "//select[contains(@class,'currency-dropdown')]")
    private WebElement currencyDropdown;

    @FindBy(xpath = "//input[@placeholder='Reimbursements']")
    private WebElement reimbursements;

    @FindBy(xpath = "//select[contains(@class,'border border-gray-300 p-2 focus:border-blue-400')]")
    private WebElement salesPersonDropdown;

    // **Add Machine Section**
    @FindBy(xpath = "//button[contains(text(),'Add Machine')]")
    private WebElement addMachineBtn;

    @FindBy(xpath = "(//div[@class='css-hlgwow'])[2]")
    private WebElement assetNoDropdown;

    @FindBy(xpath = "//input[@title='Select Number Of Operators']")
    private WebElement numberOfOperators;

    @FindBy(xpath = "//*[@id=\"react-select-7-input\"]")
    private WebElement operatorNameDropdown;
    
    @FindBy(xpath = "//div[@class='select__option css-10wo9uf-option']")
    private List<WebElement> operatorNameSelect;
    
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

    // **Buttons**
    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    private WebElement removeMachineBtn;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitBtn;
    
    @FindBy(xpath = "//div[contains(@class, 'css-10wo9uf-option')]") // XPath for the suggestion list
    private List<WebElement> customerSuggestions;
    
    @FindBy(xpath = "//div[.='ANANT ASHA CHARITABLE TRUST - AABTA7021L']") // XPath for the suggestion list
    private WebElement customerNameSuggestions;
    
    // **Methods for Actions**
    public void enterCustomerName(String customer, int i) throws InterruptedException {
    	Thread.sleep(5000);
    	customerName.click();
    	Thread.sleep(1000);
    	customerName.sendKeys(customer);
        customerSuggestions.get(i).click();
    }


    public void enterCustomerPONo(String poNumber) {
        customerPONo.sendKeys(poNumber);
    }

    public void enterInternalRefNo(String refNo) {
        internalRefNo.sendKeys(refNo);
    }

    public void selectLeaseType(String leaseType) {
        Select dropdown = new Select(leaseTypeDropdown);
        dropdown.selectByVisibleText(leaseType);
    }

    public void selectCurrency(String currency) {
        Select dropdown = new Select(currencyDropdown);
        dropdown.selectByVisibleText(currency);
    }

    public void selectSalesPerson(int salesPerson) throws InterruptedException {
        Select dropdown = new Select(salesPersonDropdown);
        Thread.sleep(2000);
        dropdown.selectByIndex(salesPerson);
    }

    public void clickAddMachine() {
        addMachineBtn.click();
    }

    public void selectAssetNo(String assetNo,int i) throws InterruptedException {
        assetNoDropdown.click();
        //assetNoDropdown.sendKeys(assetNo);
        Thread.sleep(1000);
        customerSuggestions.get(i).click();
    }

    public void selectNumberOfOperators(String numOperators) {
        numberOfOperators.sendKeys(numOperators);
    }

    public void selectOperatorName(String operator) {
        operatorNameDropdown.click();
        operatorNameSelect.get(1).click();
        //operatorNameSelect.get(2).click();
    }

    public void enterRentalStartDate(String startDate) {
        rentalStartDate.sendKeys(startDate);
    }

    public void enterRentalEndDate(String endDate) {
        rentalEndDate.sendKeys(endDate);
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
        submitBtn.click();
    }
    
    @FindBy(xpath="//div[contains(text(),'Lease created successfully!')]")
    private WebElement leaseCreatedSuccessMessage;
    
    public boolean isSuccessMessageDisplayed() 
	 {
		 try
		 {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	            WebElement message = wait.until(ExpectedConditions.visibilityOf(leaseCreatedSuccessMessage));
			 return message.isDisplayed();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	 }
}
