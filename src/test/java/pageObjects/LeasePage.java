package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeasePage extends BasePage {

    public LeasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//h1[.='Lease']")
    private WebElement leaseButton;
    
    // Total Items Count
    @FindBy(xpath = "//div[contains(text(),'Total Items')]/following-sibling::div")
    private WebElement totalItems;

    // Active Lease Count
    @FindBy(xpath = "//div[contains(text(),'Active Lease')]/following-sibling::div")
    private WebElement activeLease;

    // Expired Lease Count
    @FindBy(xpath = "//div[contains(text(),'Expired Lease')]/following-sibling::div")
    private WebElement expiredLease;

    // Search Lease Box
    @FindBy(xpath = "//input[@placeholder='Search leases']")
    private WebElement searchLeaseBox;

    // Lease Type Dropdown
    @FindBy(xpath = "//select[@class='lease-type-dropdown']")
    private WebElement leaseTypeDropdown;

    // Lease Table Headers
    @FindBy(xpath = "//table//th[contains(text(),'Asset No')]")
    private WebElement assetNoHeader;

    // First Lease Record (Sample)
    @FindBy(xpath = "//tr[td[contains(text(),'Asset 2210')]]")
    private WebElement firstLeaseRecord;

    // Lease Status (Active/Exceeded)
    @FindBy(xpath = "//td[contains(text(),'Active')]")
    private WebElement activeLeaseStatus;

    @FindBy(xpath = "//td[contains(text(),'Exceeded')]")
    private WebElement exceededLeaseStatus;

    // Add Lease Button
    @FindBy(xpath = "//button[@title='Add New Lease']")
    private WebElement addLeaseButton;

    // Export Excel Button
    @FindBy(xpath = "//button[contains(text(),'Export Excel')]")
    private WebElement exportExcelButton;

    // Pagination Controls
    @FindBy(xpath = "//button[contains(text(),'>')]")
    private WebElement nextPageButton;

    @FindBy(xpath = "//button[contains(text(),'<')]")
    private WebElement previousPageButton;

    // User Profile Menu
    @FindBy(xpath = "//span[contains(text(),'avijit@durbin.live')]")
    private WebElement userProfile;

    // ******************* Methods to Interact with Elements *******************

    public void clickOnLease(){
    	leaseButton.click();
    }
    
    public String getTotalItems() {
        return totalItems.getText();
    }

    public String getActiveLeaseCount() {
        return activeLease.getText();
    }

    public String getExpiredLeaseCount() {
        return expiredLease.getText();
    }

    public void searchLease(String leaseName) {
        searchLeaseBox.clear();
        searchLeaseBox.sendKeys(leaseName);
    }

    public void selectLeaseType(String leaseType) {
        Select dropdown = new Select(leaseTypeDropdown);
        dropdown.selectByVisibleText(leaseType);
    }

    public boolean isFirstLeaseDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(firstLeaseRecord));
            return firstLeaseRecord.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isActiveLeaseDisplayed() {
        return activeLeaseStatus.isDisplayed();
    }

    public boolean isExceededLeaseDisplayed() {
        return exceededLeaseStatus.isDisplayed();
    }

    public void clickAddLease() {
        addLeaseButton.click();
    }

    public void clickExportExcel() {
        exportExcelButton.click();
    }

    public void goToNextPage() {
        nextPageButton.click();
    }

    public void goToPreviousPage() {
        previousPageButton.click();
    }

    public boolean isUserProfileDisplayed() {
        return userProfile.isDisplayed();
    }
}

