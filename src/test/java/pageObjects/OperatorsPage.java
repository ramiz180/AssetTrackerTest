package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperatorsPage extends BasePage {
    
    public OperatorsPage(WebDriver driver) {
        super(driver);
    }

    // **Tabs**
    @FindBy(xpath = "//h1[.='Operators']")
    WebElement operatorsTab;

    @FindBy(xpath = "//button[contains(text(),'Salary Generate')]")
    WebElement salaryGenerateTab;

    // **Total Operators Count**
    @FindBy(xpath = "//div[contains(text(),'Total Operators')]")
    WebElement totalOperatorsCount;

    // **Search Box**
    @FindBy(xpath = "//input[@placeholder='Search by Name, Aadhaar No, etc']")
    WebElement searchBox;

    // **Check Availability Dropdown**
    @FindBy(xpath = "//select[contains(@class,'availability')]")
    WebElement checkAvailabilityDropdown;

    // **Buttons**
    @FindBy(xpath = "//button[contains(@title,'Add New Operator')]")
    WebElement addOperatorButton;

    @FindBy(xpath = "//button[contains(text(),'Export Excel')]")
    WebElement exportExcelButton;

    // **Table Data**
    @FindBy(xpath = "//table//tr/td[2]") 
    List<WebElement> nameColumn;

    @FindBy(xpath = "//table//tr/td[3]") 
    List<WebElement> aadhaarNumberColumn;

    @FindBy(xpath = "//table//tr/td[4]") 
    List<WebElement> operatorRoleColumn;

    @FindBy(xpath = "//table//tr/td[5]") 
    List<WebElement> contactNumberColumn;

    @FindBy(xpath = "//table//tr/td[6]") 
    List<WebElement> operatorSalesPersonColumn;

    @FindBy(xpath = "//table//tr/td[7]") 
    List<WebElement> assetsColumn;

    @FindBy(xpath = "//table//tr/td[8]") 
    List<WebElement> checkAvailabilityColumn;
    
    @FindBy(xpath="//input[@placeholder='Enter Aadhaar No']")
    private WebElement AadhaarNumberTxt;
    
    @FindBy(xpath="//div[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters MuiListItemButton-root MuiListItemButton-gutters css-16ac5r2-MuiButtonBase-root-MuiListItemButton-root']")
    private List<WebElement> AadhaarSearchSuggestions;

    public boolean IsVisibleAadhaarSuggestions() {
    	if(AadhaarSearchSuggestions.size()!=0)
    		return true;
    	else
    		return false;
    }
    
    public void SetAadhaarSuggestions(int i) {
    	AadhaarSearchSuggestions.get(i).click();
    }
    
    @FindBy(xpath="//input[@type='date']")
    private WebElement DateofBirth;
    
    @FindBy(xpath="//button[@title='Rejoin']")
    private WebElement RejoinButton;
    
    @FindBy(xpath="//button[@title='Create New']")
    private WebElement CreateNewButton;
    // **Methods to interact with elements**

    // Click Operators Tab
    public void clickOperatorsTab() {
        operatorsTab.click();
    }

    // Click Salary Generate Tab
    public void clickSalaryGenerateTab() {
        salaryGenerateTab.click();
    }

    // Get total operators count
    public String getTotalOperatorsCount() {
        return totalOperatorsCount.getText();
    }

    // Search for an operator
    public void searchOperator(String name) {
        searchBox.clear();
        searchBox.sendKeys(name);
    }

    // Select operator availability from dropdown
    public void selectAvailability(String option) {
        checkAvailabilityDropdown.sendKeys(option);
    }

    // Click Add Operator Button
    public void clickAddOperator() {
        addOperatorButton.click();
    }

    // Click Export Excel Button
    public void clickExportExcel() {
        exportExcelButton.click();
    }

    // **Fetch first row data**
    public String getFirstOperatorName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(nameColumn));
        return nameColumn.get(0).getText();
    }

    public String getFirstAadhaarNumber() {
        return aadhaarNumberColumn.get(0).getText();
    }

    public String getFirstOperatorRole() {
        return operatorRoleColumn.get(0).getText();
    }

    public String getFirstContactNumber() {
        return contactNumberColumn.get(0).getText();
    }

    public String getFirstAssets() {
        return assetsColumn.get(0).getText();
    }

    public String getFirstCheckAvailability() {
        return checkAvailabilityColumn.get(0).getText();
    }
    
    public void setAadhaarNumber(String AadhaarNumber)
    {
    	AadhaarNumberTxt.sendKeys(AadhaarNumber);
    }
    
    public void setDateOfBirth(String DOB)
    {
    	DateofBirth.sendKeys(DOB);
    }
    
    public void clickCreateNewButton()
    {
    	CreateNewButton.click();
    }
    
    public void clickRejoinButton()
    {
    	RejoinButton.click();
    }
    
    

    // Check if Export Success Message is Displayed
    @FindBy(xpath = "//div[contains(text(),'Data exported successfully')]")
    WebElement exportSuccessMessage;

    public boolean isExportSuccessMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(exportSuccessMessage));
            return exportSuccessMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
