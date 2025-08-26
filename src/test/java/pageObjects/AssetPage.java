package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
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
	 
	 @FindBy(xpath = "//p[.='Log in successful']")
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
	    
	    @FindBy(xpath = "(//div[@data-field='asset_no'])[2]/span/span")
	    WebElement firstResult;
	    
	    public void searchAsset(String assetName) {
	    	scrollToElementIfNeeded(searchAssetsInput);
	        searchAssetsInput.clear();
	        searchAssetsInput.sendKeys(assetName);
	    }

	 // Method to fetch the first asset from the search result
	    public String getFirstSearchResult(String searchQuery) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        By resultCell = By.xpath("(//div[@data-field='asset_no'])[2]/span/span");
	        wait.until(ExpectedConditions.textToBePresentInElementLocated(resultCell, searchQuery));
	        return driver.findElement(resultCell).getText();
	    }
	    
	    public void clickFirstSearchResult() {
	    	scrollToElementIfNeeded(firstResult);
	        firstResult.click();
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
	    @FindBy(xpath = "//p[.='Data exported successfully']")
	    public WebElement exportSuccessMessage;
	    
	 // User Profile
	    @FindBy(xpath = "//div[@title='You are now logged']")
	    WebElement userEmail;
	    
	    public void clickAddAsset() throws InterruptedException {
	        addAssetButton.click();
	        Thread.sleep(2000);
	    }

	    public void clickExportExcel() {
	        exportExcelButton.click();
	    }
	    
	 // Method to check if Export was successful
	    public boolean isExportSuccessMessageDisplayed() {
	        try {
	            scrollToElementIfNeeded(exportSuccessMessage);
	            return exportSuccessMessage.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public String getUserEmail() {
	        return userEmail.getText();
	    }
	 
	 public boolean isAccountLoggedMessageDisplayed() {
	        try {
	            scrollToElementIfNeeded(accountLoggedMessage);
	            return accountLoggedMessage.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	 public String getTotalAssetsBought() {
		 scrollToElementIfNeeded(totalAssetsBought);
	        return totalAssetsBought.getText();
	    }

	    public String getTotalRentalAssets() {
	    	scrollToElementIfNeeded(totalRentalAssets);
	        return totalRentalAssets.getText();
	    }

	    public String getAssetsWithActiveLease() {
	    	scrollToElementIfNeeded(assetsWithActiveLease);
	        return assetsWithActiveLease.getText();
	    }

	    public String getAssetsWithExceededLease() {
	    	scrollToElementIfNeeded(assetsWithExceededLease);
	        return assetsWithExceededLease.getText();
	    }

	    public String getFreeAssets() {
	    	scrollToElementIfNeeded(freeAssets);
	        return freeAssets.getText();
	    }

	    public String getSoldAssets() {
	    	scrollToElementIfNeeded(soldAssets);
	        return soldAssets.getText();
	    }

	    public String getTrackerInstalledAssets() {
	        return trackerInstalledAssets.getText();
	    }

}
