package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssetPage extends BasePage{
	
	public AssetPage(WebDriver driver)
	{
		super(driver);
	}	
	 @FindBy(xpath = "//div[@class='Toastify__toast-body' and contains(text(), 'User Successfully Logged In')]")
	 WebElement successMessage;
	 
	 @FindBy(xpath = "//div[@title='You are now logged']")
	public WebElement accountLoggedMessage;
 	 
	// Dashboard metrics
	 @FindBy(xpath = "//h2[contains(text(),'Total Assets Bought')]/following-sibling::p")
	    WebElement totalAssetsBought;
	 
	 @FindBy(xpath = "//h2[contains(text(),'Total Rental Assets')]/following-sibling::p")
	    WebElement totalRentalAssets;

	    @FindBy(xpath = "//h2[contains(text(),'Assets With Active Lease')]/following-sibling::p")
	    WebElement assetsWithActiveLease;

	    @FindBy(xpath = "//h2[contains(text(),'Assets With Exceeded Lease')]/following-sibling::p")
	    WebElement assetsWithExceededLease;

	    @FindBy(xpath = "//h2[contains(text(),'Free Assets')]/following-sibling::p")
	    WebElement freeAssets;

	    @FindBy(xpath = "//h2[contains(text(),'Sold Assets')]/following-sibling::p")
	    WebElement soldAssets;

	    @FindBy(xpath = "//h2[contains(text(),'Tracker Installed Assets')]/following-sibling::p")
	    WebElement trackerInstalledAssets;
	      
	 // Search and Filters
	    @FindBy(xpath = "//input[@placeholder='Search Assets...']")
	    WebElement searchAssetsInput;

	    @FindBy(xpath = "//div[@title='Filter Lease Status']")
	    WebElement allAssetsDropdown;

	    @FindBy(xpath = "//p[contains(text(),'Assets:')]/following-sibling::div[1]")
	    WebElement paginationDropdown;
	 
	 // First asset number from search results
	    @FindBy(xpath = "(//div[@data-field='asset_no'])[2]/span/span") // Assuming the 2nd column contains the Asset No
	    WebElement firstSearchResult;
	    
	    public void searchAsset(String assetName) {
	        searchAssetsInput.clear();
	        searchAssetsInput.sendKeys(assetName);
	    }

	 // Method to fetch the first asset from the search result
	    public String getFirstSearchResult() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(firstSearchResult)); // Ensure table loads
	        return firstSearchResult.getText();
	    }
	    
	    public void selectAssetCategory(String category) {
	        allAssetsDropdown.sendKeys(category);
	    }

	    public void changePagination(String itemsPerPage) {
	        paginationDropdown.sendKeys(itemsPerPage);
	    }
	    //------------------------------------------------------------------	    
	 // Buttons
	    @FindBy(xpath = "//button[@title='Add New Asset']")
		public WebElement addAssetButton;

	    @FindBy(xpath = "//button[contains(text(),'Export Excel')]")
	    WebElement exportExcelButton;
	    
	 // Success message after export
	    @FindBy(xpath = "//div[contains(text(),'Data exported successfully')]")
	    public WebElement exportSuccessMessage;
	    
	 // User Profile
	    @FindBy(xpath = "//div[@title='You are now logged']")
	    WebElement userEmail;
	    
	    public void clickAddAsset() {
	        addAssetButton.click();
	    }

	    public void clickExportExcel() {
	        exportExcelButton.click();
	    }
	    
	 // Method to check if Export was successful
	    public boolean isExportSuccessMessageDisplayed() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(exportSuccessMessage));
	            return exportSuccessMessage.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public String getUserEmail() {
	        return userEmail.getText();
	    }
	    
	 public boolean isSuccessMessageDisplayed() 
	 {
		 try
		 {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	            WebElement message = wait.until(ExpectedConditions.visibilityOf(successMessage));
			 return message.isDisplayed();
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	 }
	 
	 public boolean isAccountLoggedMessageDisplayed() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement loggedElement = wait.until(ExpectedConditions.visibilityOf(accountLoggedMessage));
	            return loggedElement.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	 public String getTotalAssetsBought() {
	        return totalAssetsBought.getText();
	    }

	    public String getTotalRentalAssets() {
	        return totalRentalAssets.getText();
	    }

	    public String getAssetsWithActiveLease() {
	        return assetsWithActiveLease.getText();
	    }

	    public String getAssetsWithExceededLease() {
	        return assetsWithExceededLease.getText();
	    }

	    public String getFreeAssets() {
	        return freeAssets.getText();
	    }

	    public String getSoldAssets() {
	        return soldAssets.getText();
	    }

	    public String getTrackerInstalledAssets() {
	        return trackerInstalledAssets.getText();
	    }

}
