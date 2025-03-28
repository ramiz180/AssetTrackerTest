package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class AddAssetPage extends BasePage {

    public AddAssetPage(WebDriver driver) 
    {
        super(driver);
    }
 // Heading text on "Create New Asset" page
    @FindBy(xpath = "//p[normalize-space()='Create New Asset']")
    public WebElement createNewAssetHeader;

// Verify if "Create New Asset" page is displayed
    public boolean isCreateNewAssetPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(createNewAssetHeader));
            return createNewAssetHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // General Details
    @FindBy(xpath = "//input[@placeholder='e.g. MA0123']")
    private WebElement assetNumber;

    @FindBy(xpath = "//input[@placeholder='e.g. Genie']")
    private WebElement make;

    @FindBy(xpath = "//input[@placeholder='e.g. S60J']")
    private WebElement model;

    @FindBy(xpath = "//input[@placeholder='e.g. GS46D-12345']")
    private WebElement serialNumber;

    @FindBy(xpath = "//input[@placeholder='e.g. TATA']")
    private WebElement purchasedFrom;

    @FindBy(xpath = "//input[@placeholder='e.g. Chennai']")
    private WebElement siteLocation;

    @FindBy(xpath = "//input[@placeholder='e.g. 10 ft']")
    private WebElement heightOfMachine;
    
    @FindBy(xpath = "//input[@placeholder='e.g. 80 kg.']")
    private WebElement capacityOfMachine;

    @FindBy(xpath = "//textarea[contains(@placeholder, 'Description must not be greater than 250 words')]")
    private WebElement description;

    @FindBy(xpath = "//select[@id='year-picker']")
    private WebElement yearOfManufacturingDropdown;

    @FindBy(xpath = "//div[@title='Enter Category']/select")
    private WebElement categoryDropdown;

    @FindBy(xpath = "//select[@id='ratings']")
    private WebElement ratingsDropdown;

    // Upload Sections
    @FindBy(xpath = "//button[@title='Search photos in your device']")
    private WebElement uploadAssetPhotos;

    @FindBy(xpath = "//input[@type='file' and @accept='.pdf,.doc,.docx,.xls,.xlsx']")
    private WebElement uploadMaintenanceDocuments;

    // Buttons
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveButton;

    // *************** Individual Setter Methods ***************

    public void setAssetNumber(String assetNum) {
        assetNumber.clear();
        assetNumber.sendKeys(assetNum);
    }

    public void setMake(String makeVal) {
        make.clear();
        make.sendKeys(makeVal);
    }

    public void setModel(String modelVal) {
        model.clear();
        model.sendKeys(modelVal);
    }

    public void setSerialNumber(String serialNum) {
        serialNumber.clear();
        serialNumber.sendKeys(serialNum);
    }

    public void setPurchasedFrom(String purchased) {
        purchasedFrom.clear();
        purchasedFrom.sendKeys(purchased);
    }

    public void setSiteLocation(String location) {
        siteLocation.clear();
        siteLocation.sendKeys(location);
    }

    public void setHeightOfMachine(String height) {
        heightOfMachine.clear();
        heightOfMachine.sendKeys(height);
    }
    
    public void setCapacityOfMachine(String capacity){
    	capacityOfMachine.clear();
    	capacityOfMachine.sendKeys(capacity);
    }

    public void setDescription(String desc) {
        description.clear();
        description.sendKeys(desc);
    }

    public void setYearOfManufacturing(String year) 
    {
    	Select yearDropdown = new Select(yearOfManufacturingDropdown);
        yearDropdown.selectByValue(year);
    }

    public void setCategory(String category) {
    	Select catDropdown = new Select(categoryDropdown);
    	catDropdown.selectByValue(category);
    }

    public void setRatings(String rating) {
        ratingsDropdown.sendKeys(rating);
    }
    
 // Asset Information Section
    @FindBy(xpath = "//label[contains(text(),'Used/New')]/following-sibling::select")
    private WebElement usedNewDropdown;

    @FindBy(xpath = "//label[contains(text(),'Wheel Drive Type')]/following-sibling::select")
    private WebElement wheelDriveTypeDropdown;

    @FindBy(xpath = "//label[contains(text(),'ANSI/CE')]/following-sibling::select")
    private WebElement ansiCeDropdown;

    @FindBy(xpath = "//label[contains(text(),'Drive Train')]/following-sibling::select")
    private WebElement driveTrainDropdown;

    @FindBy(xpath = "//label[contains(text(),'Engine Serial Number')]/following-sibling::input")
    private WebElement engineSerialNumberField;

    @FindBy(xpath = "//label[contains(text(),'Accessories')]/following-sibling::input")
    private WebElement accessoriesField;

    @FindBy(xpath = "//label[contains(text(),'Tires')]/following-sibling::select")
    private WebElement tiresDropdown;

    
 // Set Methods for Asset Information Section
    public void selectUsedNew(int option) {
        Select select = new Select(usedNewDropdown);
        select.selectByIndex(option);;
    }

    public void selectWheelDriveType(String option) {
        Select select = new Select(wheelDriveTypeDropdown);
        select.selectByVisibleText(option);
    }

    public void selectAnsiCeStandard(String option) {
        Select select = new Select(ansiCeDropdown);
        select.selectByVisibleText(option);
    }

    public void selectDriveTrain(String option) {
        Select select = new Select(driveTrainDropdown);
        select.selectByVisibleText(option);
    }

    public void enterEngineSerialNumber(String serialNumber) {
        engineSerialNumberField.sendKeys(serialNumber);
    }

    public void enterAccessories(String accessories) {
        accessoriesField.sendKeys(accessories);
    }

    public void selectTires(int i) {
        Select select = new Select(tiresDropdown);
        select.selectByIndex(i);
    }
    
 // Commercial Details Section
    @FindBy(xpath = "//label[contains(text(),'PO Number')]/following-sibling::input")
    private WebElement poNumberField;

    @FindBy(xpath = "//label[contains(text(),'PO Date')]/following-sibling::input")
    private WebElement poDateField;

    @FindBy(xpath = "//label[contains(text(),'Invoice Number')]/following-sibling::input")
    private WebElement invoiceNumberField;

    @FindBy(xpath = "//label[contains(text(),'Invoice Date')]/following-sibling::input")
    private WebElement invoiceDateField;

    @FindBy(xpath = "//label[contains(text(),'Payment Terms')]/following-sibling::input")
    private WebElement paymentTermsField;

    @FindBy(xpath = "//label[contains(text(),'Payment Remitted to OEM')]/following-sibling::input")
    private WebElement paymentRemittedToOemField;

    @FindBy(xpath = "//label[contains(text(),'Date of Payment Remitted to OEM')]/following-sibling::input")
    private WebElement dateOfPaymentRemittedToOemField;

    @FindBy(xpath = "//div[@title='Exchange Rate of Remittence']//input[@placeholder='Exchange Rate of Remittence']")
    private WebElement exchangeRateRemittanceField;

    @FindBy(xpath = "//label[contains(text(),'Date of Custom Duty Payment')]/following-sibling::input")
    private WebElement dateOfCustomDutyPaymentField;

    @FindBy(xpath = "//label[contains(text(),'Custom Duty Date of Clearance')]/following-sibling::input")
    private WebElement customDutyDateOfClearanceField;

    @FindBy(xpath = "//label[contains(text(),'Ex Work Price')]/following-sibling::input")
    private WebElement exWorkPriceField;

    @FindBy(xpath = "//label[contains(text(),'Custom Duty Value')]/following-sibling::input")
    private WebElement customDutyValueField;

    @FindBy(xpath = "//label[contains(text(),'Total Cost')]/following-sibling::input")
    private WebElement totalCostField;

    @FindBy(xpath = "//label[contains(text(),'BOE Number')]/following-sibling::input")
    private WebElement boeNumberField;

    @FindBy(xpath = "//label[contains(text(),'Clearing Charges')]/following-sibling::input")
    private WebElement clearingChargesField;

    @FindBy(xpath = "//label[contains(text(),'CHA Charges')]/following-sibling::input")
    private WebElement chaChargesField;

    @FindBy(xpath = "//label[contains(text(),'CIF Charges')]/following-sibling::input")
    private WebElement cifChargesField;

    @FindBy(xpath = "//label[contains(text(),'GST Amount')]/following-sibling::input")
    private WebElement gstAmountField;

    @FindBy(xpath = "//label[contains(text(),'Transportation charges upto yard')]/following-sibling::input")
    private WebElement transportationChargesField;

    @FindBy(xpath = "//label[contains(text(),'Ex Rate as per BOE')]/following-sibling::input")
    private WebElement exRateAsPerBoeField;

    @FindBy(xpath = "//label[contains(text(),'Country / Port of dispatch')]/following-sibling::input")
    private WebElement countryPortOfDispatchField;

    @FindBy(xpath = "//label[contains(text(),'Port of clearance')]/following-sibling::input")
    private WebElement portOfClearanceField;

    @FindBy(xpath = "//label[contains(text(),'Total Landed Cost')]/following-sibling::input")
    private WebElement totalLandedCostField;

    @FindBy(xpath = "//div[@title='Total Landed Cost (including GST)']//input")
    private WebElement totalLandedCostIncludingGstField;

    @FindBy(xpath = "//label[contains(text(),'Period of Insurance')]/following-sibling::input")
    private WebElement periodOfInsuranceField;

    @FindBy(xpath = "//label[contains(text(),'Renewal’s Date')]/following-sibling::input")
    private WebElement renewalsDateField;

    @FindBy(xpath = "//label[contains(text(),'Value of sold asset')]/following-sibling::input")
    private WebElement valueOfSoldAssetField;

    @FindBy(xpath = "//label[contains(text(),'Sold to customer name')]/following-sibling::input")
    private WebElement soldToCustomerNameField;
    
    //** Setter Methods **
    
    public void enterPoNumber(String poNumber) {
        poNumberField.sendKeys(poNumber);
    }

    public void enterPoDate(String date) {
        poDateField.sendKeys(date);
    }

    public void enterInvoiceNumber(String invoiceNumber) {
        invoiceNumberField.sendKeys(invoiceNumber);
    }

    public void enterInvoiceDate(String date) {
        invoiceDateField.sendKeys(date);
    }

    public void enterPaymentTerms(String paymentTerms) {
        paymentTermsField.sendKeys(paymentTerms);
    }

    public void enterPaymentRemittedToOem(String payment) {
        paymentRemittedToOemField.sendKeys(payment);
    }

    public void enterDateOfPaymentRemittedToOem(String date) {
        dateOfPaymentRemittedToOemField.sendKeys(date);
    }

    public void enterExchangeRateRemittance(String rate) {
        exchangeRateRemittanceField.sendKeys(rate);
    }

    public void enterDateOfCustomDutyPayment(String date) {
        dateOfCustomDutyPaymentField.sendKeys(date);
    }

    public void enterCustomDutyDateOfClearance(String date) {
        customDutyDateOfClearanceField.sendKeys(date);
    }

    public void enterExWorkPrice(String price) {
        exWorkPriceField.sendKeys(price);
    }

    public void enterCustomDutyValue(String value) {
        customDutyValueField.sendKeys(value);
    }

    public void enterTotalCost(String cost) {
        totalCostField.sendKeys(cost);
    }

    public void enterBoeNumber(String boeNumber) {
        boeNumberField.sendKeys(boeNumber);
    }

    public void enterClearingCharges(String charges) {
        clearingChargesField.sendKeys(charges);
    }

    public void enterChaCharges(String charges) {
        chaChargesField.sendKeys(charges);
    }

    public void enterCifCharges(String charges) {
        cifChargesField.sendKeys(charges);
    }

    public void enterGstAmount(String amount) {
        gstAmountField.sendKeys(amount);
    }

    public void enterTransportationCharges(String charges) {
        transportationChargesField.sendKeys(charges);
    }

    public void enterExRateAsPerBoe(String rate) {
        exRateAsPerBoeField.sendKeys(rate);
    }

    public void enterCountryPortOfDispatch(String port) {
        countryPortOfDispatchField.sendKeys(port);
    }

    public void enterPortOfClearance(String port) {
        portOfClearanceField.sendKeys(port);
    }

    public void enterTotalLandedCost(String cost) {
        totalLandedCostField.sendKeys(cost);
    }

    public void enterTotalLandedCostIncludingGst(String cost) {
        totalLandedCostIncludingGstField.sendKeys(cost);
    }

    public void enterPeriodOfInsurance(String period) {
        periodOfInsuranceField.sendKeys(period);
    }

    public void enterRenewalsDate(String date) {
        renewalsDateField.sendKeys(date);
    }

    public void enterValueOfSoldAsset(String value) {
        valueOfSoldAssetField.sendKeys(value);
    }

    public void enterSoldToCustomerName(String customerName) {
        soldToCustomerNameField.sendKeys(customerName);
    }

    

    public void uploadAssetPhoto(String filePath) throws InterruptedException {
            // Scroll to the upload element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", uploadAssetPhotos);
            Thread.sleep(1000);

            // Wait until the file input is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(uploadAssetPhotos));

            // Upload the file
            uploadAssetPhotos.sendKeys(filePath);
    }

    public void uploadMaintenanceDocument(String filePath) 
    {
        uploadMaintenanceDocuments.sendKeys(filePath);
    }

    public void clickSave() {
        saveButton.click();
    }

    // Verify success message
    public boolean isSuccessMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[.='Asset successfully created!' and @role='alert']")
            ));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    
    
    
}
