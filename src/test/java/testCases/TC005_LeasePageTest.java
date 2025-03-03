package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LeasePage;
import testBase.BaseClass;

public class TC005_LeasePageTest extends BaseClass {

    @Test(priority = 1, groups = {"Sanity", "Regression"})
    public void verify_lease_page_functions() {
        logger.info("***** Starting TC005_LeaseTest *****");

        try {
            // Step 1: Perform Login
            // Step 2: Navigate to Lease Page
            LeasePage leasePage = new LeasePage(driver);

            // Verify Total Items, Active Lease, and Expired Lease
            logger.info("Verifying total items, active leases, and expired leases...");
            Assert.assertNotNull(leasePage.getTotalItems(), "Total Items count is null");
            Assert.assertNotNull(leasePage.getActiveLeaseCount(), "Active Lease count is null");
            Assert.assertNotNull(leasePage.getExpiredLeaseCount(), "Expired Lease count is null");

            // Step 3: Search Lease
            logger.info("Searching for lease 'Asset 2210'...");
            leasePage.searchLease("Asset 2210");
            Assert.assertTrue(leasePage.isFirstLeaseDisplayed(), "Lease record not found!");

            // Step 4: Filter Lease Type
            logger.info("Selecting 'Active' lease type...");
            leasePage.selectLeaseType("Active");
            Assert.assertTrue(leasePage.isActiveLeaseDisplayed(), "Active lease filter not working!");

            // Step 5: Verify Lease Status
            logger.info("Checking exceeded lease status...");
            Assert.assertTrue(leasePage.isExceededLeaseDisplayed(), "Exceeded lease status not displayed!");

            // Step 6: Pagination Check
            logger.info("Clicking next page...");
            leasePage.goToNextPage();
            Thread.sleep(2000);
            leasePage.goToPreviousPage();
            Thread.sleep(2000);

            // Step 7: Click Add Lease
            logger.info("Clicking 'Add Lease' button...");
            leasePage.clickAddLease();

            // Step 8: Click Export Excel
            logger.info("Clicking 'Export Excel' button...");
            leasePage.clickExportExcel();

            // Step 9: Verify User Profile is Displayed
            logger.info("Verifying user profile is displayed...");
            Assert.assertTrue(leasePage.isUserProfileDisplayed(), "User profile is not displayed!");

            logger.info("***** TC005_LeaseTest PASSED *****");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        } finally {
            logger.info("***** Finished TC005_LeaseTest *****");
        }
    }
}
