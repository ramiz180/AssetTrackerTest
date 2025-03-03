package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.OperatorsPage;
import pageObjects.AddOperatorPage;
import testBase.BaseClass;

public class TC007_AddNewOperatorTest extends BaseClass {

    @Test(priority = 1, groups = {"Sanity", "Regression"})
    public void verify_add_new_operator() {
        logger.info("***** Starting TC007_AddOperatorTest *****");

        try {
            // Step 1: Navigate to Operators Page
            OperatorsPage operatorsPage = new OperatorsPage(driver);
            operatorsPage.clickOperatorsTab();
            logger.info("Navigated to Operators Page");

            // Step 2: Click 'Add Operator' Button
            operatorsPage.clickAddOperator();
            logger.info("Clicked on 'Add Operator' button");
            
            operatorsPage.setAadhaarNumber("00"+randomeNumber());
            operatorsPage.setDateOfBirth("2000-05-05");
            operatorsPage.clickCreateNewButton();
            // Step 3: Verify "Add Operator" page is displayed
            AddOperatorPage addOperatorPage = new AddOperatorPage(driver);
            Assert.assertTrue(driver.getCurrentUrl().contains("new-operator"), "Add Operator page did not load!");
            logger.info("Verified 'Add Operator' page is displayed");

            // Step 4: Fill Operator Details
            logger.info("Filling Operator Details...");
            Thread.sleep(2000); // Wait before entering details
            addOperatorPage.enterName("OP "+randomeString());
            addOperatorPage.enterMobileNumber(randomeNumber());
            addOperatorPage.enterDrivingLicense("DL-1234-"+randomeNumber());
            addOperatorPage.enterBankAccountNumber("00"+randomeNumber());
            addOperatorPage.enterBankIFSCCode("SBIN0005678");
            addOperatorPage.enterPFAccountNumber("PF123456");
            addOperatorPage.enterNetSalary("25000");
            addOperatorPage.enterAdvancedPaymentInfo("5000");

            // Step 5: Select Role and Sales Person
            addOperatorPage.selectOperatorRole("Operator");
            addOperatorPage.selectOperatorSalesPerson(1);

            // Step 6: Set Date of Joining
            addOperatorPage.setDateOfJoining("2025-03-25");
            logger.info("All operator details entered successfully!");

            // Step 7: Submit the Form
            addOperatorPage.clickSaveButton();
            logger.info("Clicked on 'Save' button");
            Thread.sleep(2000); // Wait for the operation to complete

            // Step 8: Validate Success Message
            boolean isSuccess = addOperatorPage.isOperatorAddedSuccMsg();
            Assert.assertTrue(isSuccess, "Success message not displayed!");
            logger.info("***** TC007_AddOperatorTest PASSED *****");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        } finally {
            logger.info("***** Finished TC007_AddOperatorTest *****");
        }
    }
}
