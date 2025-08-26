package testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AddAssetPage;
import pageObjects.AssetPage;
import testBase.BaseClass;

public class TC002_AssetPageTest extends BaseClass {
	
    @Test(priority = 2, groups = {"Sanity", "Master"})
    public void validateDashboardMetrics() throws InterruptedException {
    	logger.info("****** Waiting for Asset Page to Load Fully ******");
        AssetPage assetPage = new AssetPage(driver);
        logger.info("****** Validating Asset Dashboard Metrics ******");
        SoftAssert softAssert = new SoftAssert();

        // Fetch values from UI
        int totalAssetsBought = Integer.parseInt(assetPage.getTotalAssetsBought());
        int totalRentalAssets = Integer.parseInt(assetPage.getTotalRentalAssets());
        int assetsWithActiveLease = Integer.parseInt(assetPage.getAssetsWithActiveLease());
        int assetsWithExceededLease = Integer.parseInt(assetPage.getAssetsWithExceededLease());
        int freeAssets = Integer.parseInt(assetPage.getFreeAssets());
        int soldAssets = Integer.parseInt(assetPage.getSoldAssets());

        // Validation 1: Total Rental Assets = Active Lease + Exceeded Lease + Free Assets
        int expectedTotalRentalAssets = assetsWithActiveLease + assetsWithExceededLease + freeAssets;
        softAssert.assertEquals(totalRentalAssets, expectedTotalRentalAssets,
                "Total Rental Assets mismatch! Expected: " + expectedTotalRentalAssets + ", Found: " + totalRentalAssets);

        // Validation 2: Total Assets Bought = Active Lease + Exceeded Lease + Free Assets + Sold Assets
        int expectedTotalAssetsBought = assetsWithActiveLease + assetsWithExceededLease + freeAssets + soldAssets;
        softAssert.assertEquals(totalAssetsBought, expectedTotalAssetsBought,
                "Total Assets Bought mismatch! Expected: " + expectedTotalAssetsBought + ", Found: " + totalAssetsBought);
        System.out.println("Expected:" + expectedTotalAssetsBought + ", Found: " + totalAssetsBought);
        logger.info("****** Dashboard Metrics Validation Completed ******");
        softAssert.assertAll(); // Ensure all assertions are reported
    }

    @Test(priority = 1, groups = {"Sanity", "Regression"})
    public void validateSearchFunctionality() {
        logger.info("****** Validating Asset Search Functionality ******");
        AssetPage assetPage = new AssetPage(driver);

        // Search for a specific asset
        String searchQuery = "MTU035";
        assetPage.searchAsset(searchQuery);
        logger.info("Entered search query: " + searchQuery);

        // Fetch the first result
        String firstResult = assetPage.getFirstSearchResult(searchQuery);
        logger.info("First search result displayed: " + firstResult);

        // Validate the search result
        Assert.assertEquals(firstResult, searchQuery, "Search validation failed: Expected " + searchQuery + " but found " + firstResult);

        logger.info("****** Asset Search Validation PASSED ******");
    }

    @Test(priority = 3, groups = {"Regression"},enabled=false)
    public void filterByCategory() {
        logger.info("****** Validating Asset Category Filter ******");
        AssetPage assetPage = new AssetPage(driver);

        assetPage.selectAssetCategory("Active");
        logger.info("Filtered assets by 'Active' category");

        logger.info("****** Asset Category Filter PASSED ******");
    }

    @Test(priority = 4, groups = {"Regression"},enabled=false)
    public void changePagination() {
        logger.info("****** Validating Asset Pagination ******");
        AssetPage assetPage = new AssetPage(driver);

        assetPage.changePagination("50");
        logger.info("Changed pagination to 50 assets per page");

        // Optionally, verify that 50 assets are loaded in the table
        // Example:
        // Assert.assertTrue(assetPage.isPaginationWorking(50), "Pagination not working!");

        logger.info("****** Asset Pagination PASSED ******");
    }

    @Test(priority = 5, groups = {"Regression"})
    public void validateExportExcel() throws InterruptedException {
        logger.info("****** Validating Export Excel Functionality ******");
        AssetPage assetPage = new AssetPage(driver);

        // Click Export Excel button
        assetPage.clickExportExcel();
        logger.info("Clicked on 'Export Excel' button");

        // Verify success message
        boolean isSuccess = assetPage.isExportSuccessMessageDisplayed();
        Assert.assertTrue(isSuccess, "Export success message not displayed!");
        logger.info("****** Export Excel Validation PASSED ******");
    }

    // Method to find the latest matching .xlsx file in the given directory
    public File getLatestFileFromDirectory(String directoryPath, String expectedPrefix, String fileExtension) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((d, name) -> name.toLowerCase().startsWith(expectedPrefix) && name.toLowerCase().endsWith("." + fileExtension));
        
        if (files == null || files.length == 0) {
            return null;
        }

        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }
    
    @Test(priority = 6, groups = {"Sanity", "Regression"})
    public void validateCreateNewAssetPage() throws InterruptedException {
        logger.info("****** Validating 'Create New Asset' Page ******");
        AssetPage assetPage = new AssetPage(driver);
        Thread.sleep(2000);
        // Click Add Asset
        assetPage.clickAddAsset();
        logger.info("Clicked on 'Add Asset' button");
        AddAssetPage addAssetPage = new AddAssetPage(driver);
        boolean isPageDisplayed = addAssetPage.isCreateNewAssetPageDisplayed();
        Assert.assertTrue(isPageDisplayed, "'Create New Asset' page did not load!");

        logger.info("****** 'Create New Asset' Page Validation PASSED ******");
    }
}
