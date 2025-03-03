package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AssetPage;
import pageObjects.AddAssetPage;
import testBase.BaseClass;

public class TC004_AddAssetTest extends BaseClass {

    @Test(priority = 1, groups = {"Sanity", "Regression"})
    public void verify_add_new_asset() {
        logger.info("***** Starting TC004_AddAssetTest *****");

        try {
            // Step 1: Perform Login
            // Step 2: Navigate to Asset Page and Click Add Asset
            AssetPage assetPage = new AssetPage(driver);
            assetPage.clickAddAsset();
            logger.info("Clicked on 'Add Asset' button");

            // Step 3: Verify "Create New Asset" page is displayed
            AddAssetPage addAssetPage = new AddAssetPage(driver);
            Assert.assertTrue(addAssetPage.isCreateNewAssetPageDisplayed(), "'Create New Asset' page did not load!");
            logger.info("Verified 'Create New Asset' page is displayed");

            // Step 4: Fill Asset Details
            logger.info("Entering Asset Details...");
            addAssetPage.setAssetNumber("Automated asset "+randomeAlphaNumberic().toUpperCase());
            addAssetPage.setMake(randomeString().toUpperCase());
            addAssetPage.setModel(randomeAlphaNumberic().toUpperCase());
            addAssetPage.setSerialNumber("QA"+randomeAlphaNumberic().toUpperCase());
            addAssetPage.setPurchasedFrom("Kolkata "+randomeAlphaNumberic().toLowerCase());
            addAssetPage.setYearOfManufacturing("2022");
            addAssetPage.setSiteLocation("Chennai "+randomeAlphaNumberic().toLowerCase());
            addAssetPage.setHeightOfMachine("10");
            addAssetPage.setCapacityOfMachine("36");
            addAssetPage.setCategory("Telescopic Boom");
            //addAssetPage.setRatings("5");
            addAssetPage.setDescription("It is a New testing asset added by Ramiz"+randomeAlphaNumberic().toUpperCase());
            logger.info("Entered General Asset Details");
            //Configuration Details
            addAssetPage.selectUsedNew(1);
            addAssetPage.selectAnsiCeStandard("ANSI");
            logger.info("entered AnsiCeStandard");
            //addAssetPage.selectWheelDriveType("4WD");
            logger.info("entered WheelDriveType");
            addAssetPage.selectDriveTrain("Diesel");
            logger.info("entered DriveTrain");
            addAssetPage.enterEngineSerialNumber("ENG123456");
            logger.info("entered EngineSerialNumber");
            addAssetPage.enterAccessories("GPS, Rear Camera");
            //addAssetPage.selectTires(1);
            logger.info("entered Configuration Details");
            //Commercial Details
            addAssetPage.enterPoNumber("PO0045");
            addAssetPage.enterPoDate("02/02/2025");
            addAssetPage.enterInvoiceNumber("INV123456");
            addAssetPage.enterInvoiceDate("02/04/2025");
            addAssetPage.enterPaymentTerms("Net 30 Days");
            addAssetPage.enterPaymentRemittedToOem("50000");
            addAssetPage.enterDateOfPaymentRemittedToOem("02/08/2025");
            addAssetPage.enterExchangeRateRemittance("82.50");
            addAssetPage.enterDateOfCustomDutyPayment("02/01/2025");
            addAssetPage.enterCustomDutyDateOfClearance("02/01/2025");
            addAssetPage.enterExWorkPrice("100,000");
            addAssetPage.enterCustomDutyValue("4,28,347");
            addAssetPage.enterTotalCost("1,20,000");
            addAssetPage.enterBoeNumber("BOE998877");
            addAssetPage.enterClearingCharges("70,000");
            addAssetPage.enterChaCharges("2,00,000");
            addAssetPage.enterCifCharges("1,50,000");
            addAssetPage.enterGstAmount("2,00,000");
            addAssetPage.enterTransportationCharges("20,000");
            addAssetPage.enterExRateAsPerBoe("83.00");
            addAssetPage.enterCountryPortOfDispatch("Mumbai");
            addAssetPage.enterPortOfClearance("Chennai");
            addAssetPage.enterTotalLandedCost("₹4,50,000");
            addAssetPage.enterTotalLandedCostIncludingGst("₹5,00,000");
            addAssetPage.enterPeriodOfInsurance("1 Year");
//            addAssetPage.enterRenewalsDate("02/28/2026");
//            addAssetPage.enterValueOfSoldAsset("₹2,00,000");
//            addAssetPage.enterSoldToCustomerName("TATA");
            
            
            logger.info("Asset Details Entered Successfully!");

            // Step 5: Upload Files
            //logger.info("Uploading Asset Photo and Maintenance Document...");
            //addAssetPage.uploadAssetPhoto("‪C:\\Users\\Ramiz\\Downloads\\Screenshot (1).png");
            //addAssetPage.uploadMaintenanceDocument("C:\\Users\\User\\Downloads\\maintenance_doc.pdf");
            //logger.info("File Upload Completed!");
            Thread.sleep(3000);
            // Step 6: Click Save
            addAssetPage.clickSave();
            logger.info("Clicked on 'Save' button");

            // Step 7: Validate Success Message
            Assert.assertTrue(addAssetPage.isSuccessMessageDisplayed(), "Success message not displayed after adding asset!");
            logger.info("***** TC004_AddAssetTest PASSED *****");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        } finally {
            logger.info("***** Finished TC004_AddAssetTest *****");
        }
    }
}
