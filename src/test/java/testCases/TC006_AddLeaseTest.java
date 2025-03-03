package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddLeasePage;
import pageObjects.LeasePage;
import testBase.BaseClass;

public class TC006_AddLeaseTest extends BaseClass {

    @Test(priority = 1, groups = {"Sanity", "Regression"})
    public void verify_add_new_lease() {
        logger.info("***** Starting TC006_AddLeaseTest *****");

        try {
            LeasePage leasePage = new LeasePage(driver);
         // Step 1: Navigate to Lease Page
            leasePage.clickOnLease();
            logger.info("Navigating to Lease Page...");
            leasePage.clickAddLease();
            logger.info("Clicked on 'Add Lease' button");

            // Step 2: Verify "New Lease" page is displayed
            AddLeasePage addLeasePage = new AddLeasePage(driver);
            Assert.assertTrue(driver.getCurrentUrl().contains("new-lease"), "Add Lease page did not load!");
            logger.info("Verified 'New Lease' page is displayed");

            // Step 3: Fill Lease Details
            logger.info("Filling Lease Details...");
            Thread.sleep(1000);
            addLeasePage.enterCustomerPONo("PO2025-"+randomeNumber());
            addLeasePage.enterInternalRefNo("REF2025-"+randomeNumber());
            addLeasePage.selectLeaseType("Dry");
            addLeasePage.selectSalesPerson(2);
            addLeasePage.enterCustomerName("abt", 2);
            
            // Step 4: Add Machine Details
            logger.info("Adding Machine Details...");
            addLeasePage.clickAddMachine();
            addLeasePage.selectAssetNo("Auto", 2);
            addLeasePage.selectNumberOfOperators("1");
            addLeasePage.selectOperatorName("Operator 1");
            addLeasePage.enterRentalStartDate("2025-03-05");
            addLeasePage.enterRentalEndDate("2025-03-06");
            addLeasePage.enterRentalLocation("Kolkata");
            addLeasePage.enterContractValue("500000");
            addLeasePage.enterNominalHours("8");
            addLeasePage.enterWorkingDaysPerMonth("22");
            addLeasePage.enterMonthlyRentalAmount("45000");
            addLeasePage.enterOvertimeRate("100");

            logger.info("All lease details entered successfully!");

            // Step 5: Submit the Form
            addLeasePage.clickSubmit();
            logger.info("Clicked on 'Submit' button");
            Thread.sleep(2000);
            // Step 6: Validate Success Message
            boolean isSuccess = addLeasePage.isSuccessMessageDisplayed();
            Assert.assertTrue(isSuccess, "Success message not displayed!");
            logger.info("***** TC006_AddLeaseTest PASSED *****");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        } finally {
            logger.info("***** Finished TC006_AddLeaseTest *****");
        }
    }
}
