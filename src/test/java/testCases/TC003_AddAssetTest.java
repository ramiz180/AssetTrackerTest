package testCases;

import java.io.File;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddAssetPage;
import pageObjects.AssetDetailsPage;
import pageObjects.AssetPage;
import testBase.BaseClass;

public class TC003_AddAssetTest extends BaseClass {

	@Test(priority = 1, groups = { "Sanity", "Regression" })
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

			// Step 4: Fill Asset Details
			logger.info("Entering Asset Details...");

			// Store each input into a variable
			String assetNumber = "Auto asset " + randomeAlphaNumberic().toUpperCase();
			BaseClass.assetNumber=assetNumber;
			String make = randomeString().toUpperCase();
			String model = randomeAlphaNumberic().toUpperCase();
			String serialNumber = "QA" + randomeAlphaNumberic().toUpperCase();
			String purchasedFrom = "Kolkata " + randomeAlphaNumberic().toLowerCase();
			String yearOfManufacturing = "2022";
			String siteLocation = "Chennai " + randomeAlphaNumberic().toLowerCase();
			String heightOfMachine = "10";
			String capacityOfMachine = "36";// need to use contain
			String category = "Telescopic Boom";

			// Use those variables to fill form
			addAssetPage.setAssetNumber(assetNumber);
			addAssetPage.setMake(make);
			addAssetPage.setModel(model);
			addAssetPage.setSerialNumber(serialNumber);
			addAssetPage.setPurchasedFrom(purchasedFrom);
			addAssetPage.setYearOfManufacturing(yearOfManufacturing);
			addAssetPage.setSiteLocation(siteLocation); // Not verified
			addAssetPage.setHeightOfMachine(heightOfMachine);
			addAssetPage.setCapacityOfMachine(capacityOfMachine);
			addAssetPage.setCategory(category);
			addAssetPage.clickOnSaveNext();

			// ---------------- CONFIGURATION DETAILS ----------------
			String usedNew = "Used"; // index 1 = Used (assuming)
			String ansiCeStandard = "ANSI";
			String driveTrain = "Diesel";
			String wheelDriveType = "4WD";
			String engineSerialNumber = "ENG123456";
			String accessories = "GPS, Rear Camera";
			String tires = "Airfiled"; // assuming index 1 = Airfiled

			// Use stored values in the test
			addAssetPage.selectUsedNew(1);
			addAssetPage.selectAnsiCeStandard(ansiCeStandard);
			addAssetPage.selectDriveTrain(driveTrain);
			addAssetPage.selectWheelDriveType(wheelDriveType);
			addAssetPage.enterEngineSerialNumber(engineSerialNumber);
			addAssetPage.enterAccessories(accessories);
			addAssetPage.selectTires(1);
			addAssetPage.clickOnSaveNext();

//      // ---------------- COMMERCIAL DETAILS ----------------
			String poNumber = "PO0045";
			String poDate = LocalDate.now().toString();// "2024-07-26";
			String invoiceNumber = "INV123456";
			String invoiceDate = "2024-07-26";
			String paymentRemittedToOem = "50000";
			String dateOfPaymentRemittedToOem = "2024-07-26";
			String exchangeRateRemittance = "82.50";
			String dateOfCustomDutyPayment = "2024-07-26";
			String customDutyDateOfClearance = "2024-07-26";
			String exWorkPrice = "100000";
			String cifCharges = "150000";
			String totalCost = "1,20,000";
			String boeNumber = "BOE998877";
			String customDutyValue = "4,28,347";
			String gstAmount = "2,00,000";
			String exRateAsPerBoe = "83.00";
			String clearingCharges = "70,000";
			String chaCharges = "2,00,000";
			String transportationCharges = "20,000";
			String countryPortOfDispatch = "Mumbai";
			String portOfClearance = "Chennai";
			String periodOfInsurance = "1 Year";
			String totalLandedCost = "₹4,50,000";
			String totalLandedCostIncludingGst = "₹5,00,000";

			// Use variables in methods
			addAssetPage.enterPoNumber(poNumber);
			addAssetPage.enterPoDate(poDate);
			addAssetPage.enterInvoiceNumber(invoiceNumber);
			addAssetPage.enterInvoiceDate(invoiceDate);
			addAssetPage.enterPaymentRemittedToOem(paymentRemittedToOem);
			addAssetPage.enterDateOfPaymentRemittedToOem(dateOfPaymentRemittedToOem);
			addAssetPage.enterExchangeRateRemittance(exchangeRateRemittance);
			addAssetPage.enterDateOfCustomDutyPayment(dateOfCustomDutyPayment);
			addAssetPage.enterCustomDutyDateOfClearance(customDutyDateOfClearance);
			addAssetPage.enterExWorkPrice(exWorkPrice);
			addAssetPage.enterCifCharges(cifCharges);
			addAssetPage.enterTotalCost(totalCost);
			addAssetPage.enterBoeNumber(boeNumber);
			addAssetPage.enterCustomDutyValue(customDutyValue);
			addAssetPage.enterGstAmount(gstAmount);
			addAssetPage.enterExRateAsPerBoe(exRateAsPerBoe);
			addAssetPage.enterClearingCharges(clearingCharges);
			addAssetPage.enterChaCharges(chaCharges);
			addAssetPage.enterTransportationCharges(transportationCharges);
			addAssetPage.enterCountryPortOfDispatch(countryPortOfDispatch);
			addAssetPage.enterPortOfClearance(portOfClearance);
			addAssetPage.enterPeriodOfInsurance(periodOfInsurance);
			addAssetPage.enterTotalLandedCost(totalLandedCost);
			addAssetPage.enterTotalLandedCostIncludingGst(totalLandedCostIncludingGst);

//          addAssetPage.enterRenewalsDate("02/28/2026");
//          addAssetPage.enterValueOfSoldAsset("₹2,00,000");
//          addAssetPage.enterSoldToCustomerName("TATA");

			logger.info("Asset Details Entered Successfully!");

			// Step 5: Upload Files

			String imageRelative = p.getProperty("uploadImagePath");
			String pdfRelative = p.getProperty("uploadPdfPath");

			File imageFile = new File(System.getProperty("user.dir") + File.separator + imageRelative);
			File pdfFile = new File(System.getProperty("user.dir") + File.separator + pdfRelative);

			addAssetPage.uploadAssetPhoto(imageFile.getAbsolutePath());
			addAssetPage.uploadMaintenanceDocument(pdfFile.getAbsolutePath());

			// Step 6: Click Save
			addAssetPage.clickSave();
			logger.info("Clicked on 'Save' button");

			// Step 7: Validate Success Message
			Assert.assertTrue(addAssetPage.isSuccessMessageDisplayed(),
					"Success message not displayed after adding asset!");
			driver.navigate().refresh();
			Thread.sleep(5000);
			logger.info("***** Asset is created *****");

			// Step 8: Search and view this respective asset
			assetPage.searchAsset(assetNumber);
			assetPage.clickFirstSearchResult();

			
			
			
			// Step 9: Validate each field whether all the correctly displayed
			AssetDetailsPage detailsPage = new AssetDetailsPage(driver);

			logger.info("🔍 Verifying Asset Number: expected -> " + assetNumber + ", actual -> " + detailsPage.getAssetNumberDisplayed());
			Assert.assertEquals(detailsPage.getAssetNumberDisplayed(), assetNumber, "❌ Asset Number mismatch!");

			logger.info("🔍 Verifying Make: expected -> " + make + ", actual -> " + detailsPage.getMakeDisplayed());
			Assert.assertEquals(detailsPage.getMakeDisplayed(), make, "❌ Make mismatch!");

			logger.info("🔍 Verifying Model: expected -> " + model + ", actual -> " + detailsPage.getModelDisplayed());
			Assert.assertEquals(detailsPage.getModelDisplayed(), model, "❌ Model mismatch!");

			logger.info("🔍 Verifying Serial Number: expected -> " + serialNumber + ", actual -> " + detailsPage.getSerialNumberDisplayed());
			Assert.assertEquals(detailsPage.getSerialNumberDisplayed(), serialNumber, "❌ Serial Number mismatch!");

			logger.info("🔍 Verifying Purchased From: expected -> " + purchasedFrom.toLowerCase() + ", actual -> " + detailsPage.getPurchasedFromDisplayed().toLowerCase());
			Assert.assertEquals(detailsPage.getPurchasedFromDisplayed().toLowerCase(), purchasedFrom.toLowerCase(), "❌ Purchased From mismatch!");

			logger.info("🔍 Verifying Year of Manufacturing: expected -> " + yearOfManufacturing + ", actual -> " + detailsPage.getYearOfManufacturingDisplayed());
			Assert.assertEquals(detailsPage.getYearOfManufacturingDisplayed(), yearOfManufacturing, "❌ Year of Manufacturing mismatch!");

			// logger.info("🔍 Verifying Site Location: expected -> " + siteLocation + ", actual -> " + detailsPage.getSiteLocationDisplayed());
			// Assert.assertEquals(detailsPage.getSiteLocationDisplayed(), siteLocation, "❌ Site Location mismatch!");

			logger.info("🔍 Verifying Height of Machine: expected contains -> " + heightOfMachine + ", actual -> " + detailsPage.getHeightOfMachineDisplayed());
			Assert.assertTrue(detailsPage.getHeightOfMachineDisplayed().contains(heightOfMachine), "❌ Height mismatch!");

			logger.info("🔍 Verifying Capacity of Machine: expected contains -> " + capacityOfMachine + ", actual -> " + detailsPage.getCapacityOfMachineDisplayed());
			Assert.assertTrue(detailsPage.getCapacityOfMachineDisplayed().contains(capacityOfMachine), "❌ Capacity mismatch!");

			logger.info("🔍 Verifying Category: expected -> " + category + ", actual -> " + detailsPage.getCategoryDisplayed());
			Assert.assertEquals(detailsPage.getCategoryDisplayed(), category, "❌ Category mismatch!");

			logger.info("🔍 Verifying Used/New: expected -> " + usedNew + ", actual -> " + detailsPage.getUsedNewDisplayed());
			Assert.assertTrue(detailsPage.getUsedNewDisplayed().equalsIgnoreCase(usedNew), "❌ Used/New mismatch!");

			logger.info("🔍 Verifying ANSI/CE Standard: expected -> " + ansiCeStandard + ", actual -> " + detailsPage.getAnsiCeStandardDisplayed());
			Assert.assertEquals(detailsPage.getAnsiCeStandardDisplayed(), ansiCeStandard, "❌ ANSI/CE Standard mismatch!");

			logger.info("🔍 Verifying Drive Train: expected -> " + driveTrain + ", actual -> " + detailsPage.getDriveTrainDisplayed());
			Assert.assertEquals(detailsPage.getDriveTrainDisplayed(), driveTrain, "❌ Drive Train mismatch!");

			logger.info("🔍 Verifying Wheel Drive Type: expected -> " + wheelDriveType + ", actual -> " + detailsPage.getWheelDriveTypeDisplayed());
			Assert.assertEquals(detailsPage.getWheelDriveTypeDisplayed(), wheelDriveType, "❌ Wheel Drive Type mismatch!");

			logger.info("🔍 Verifying Engine Serial Number: expected -> " + engineSerialNumber + ", actual -> " + detailsPage.getEngineSerialNumberDisplayed());
			Assert.assertEquals(detailsPage.getEngineSerialNumberDisplayed(), engineSerialNumber, "❌ Engine Serial Number mismatch!");

			logger.info("🔍 Verifying Accessories: expected -> " + accessories + ", actual -> " + detailsPage.getAccessoriesDisplayed());
			Assert.assertEquals(detailsPage.getAccessoriesDisplayed(), accessories, "❌ Accessories mismatch!");

			logger.info("🔍 Verifying Tires: expected -> " + tires + ", actual -> " + detailsPage.getTiresDisplayed());
			Assert.assertEquals(detailsPage.getTiresDisplayed(), tires, "❌ Tires mismatch!");

			
			
			
			
			detailsPage.clcikCommercialDetails();
			
			logger.info("🔍 Verifying PO Number: expected -> " + poNumber + ", actual -> " + detailsPage.getPoNumberDisplayed());
			Assert.assertEquals(detailsPage.getPoNumberDisplayed(), poNumber, "❌ PO Number mismatch!");

			// logger.info("🔍 Verifying PO Date: expected -> " + poDate + ", actual -> " + detailsPage.getPoDateDisplayed());
			// Assert.assertEquals(detailsPage.getPoDateDisplayed(), poDate, "❌ PO Date mismatch!");

			// logger.info("🔍 Verifying Invoice Number: expected -> " + invoiceNumber + ", actual -> " + detailsPage.getInvoiceNumberDisplayed());
			// Assert.assertEquals(detailsPage.getInvoiceNumberDisplayed(), invoiceNumber, "❌ Invoice Number mismatch!");

			// logger.info("🔍 Verifying Invoice Date: expected -> " + invoiceDate + ", actual -> " + detailsPage.getInvoiceDateDisplayed());
			// Assert.assertEquals(detailsPage.getInvoiceDateDisplayed(), invoiceDate, "❌ Invoice Date mismatch!");

			logger.info("🔍 Verifying Payment to OEM: expected contains -> " + paymentRemittedToOem + ", actual -> " + freshCurrency(detailsPage.getPaymentRemittedToOemDisplayed()));
			Assert.assertTrue(freshCurrency(detailsPage.getPaymentRemittedToOemDisplayed()).contains(paymentRemittedToOem), "❌ Payment to OEM mismatch!");

			// logger.info("🔍 Verifying Date of Payment to OEM: expected -> " + dateOfPaymentRemittedToOem + ", actual -> " + detailsPage.getDateOfPaymentRemittedToOemDisplayed());
			// Assert.assertEquals(detailsPage.getDateOfPaymentRemittedToOemDisplayed(), dateOfPaymentRemittedToOem, "❌ Date of Payment to OEM mismatch!");

			logger.info("🔍 Verifying Exchange Rate Remittance: expected contains -> " + exchangeRateRemittance + ", actual -> " + detailsPage.getExchangeRateRemittanceDisplayed());
			Assert.assertTrue(detailsPage.getExchangeRateRemittanceDisplayed().contains(exchangeRateRemittance), "❌ Exchange Rate mismatch!");

			// logger.info("🔍 Verifying Custom Duty Payment Date: expected -> " + dateOfCustomDutyPayment + ", actual -> " + detailsPage.getDateOfCustomDutyPaymentDisplayed());
			// Assert.assertEquals(detailsPage.getDateOfCustomDutyPaymentDisplayed(), dateOfCustomDutyPayment, "❌ Custom Duty Payment Date mismatch!");

			// logger.info("🔍 Verifying Custom Duty Clearance Date: expected -> " + customDutyDateOfClearance + ", actual -> " + detailsPage.getCustomDutyDateOfClearanceDisplayed());
			// Assert.assertEquals(detailsPage.getCustomDutyDateOfClearanceDisplayed(), customDutyDateOfClearance, "❌ Clearance Date mismatch!");

			logger.info("🔍 Verifying Ex-Work Price: expected contains -> " + exWorkPrice + ", actual -> " + freshCurrency(detailsPage.getExWorkPriceDisplayed()));
			Assert.assertTrue(freshCurrency(detailsPage.getExWorkPriceDisplayed()).contains(exWorkPrice), "❌ Ex-Work Price mismatch!");

			logger.info("🔍 Verifying CIF Charges: expected contains -> " + cifCharges + ", actual -> " + freshCurrency(detailsPage.getCifChargesDisplayed()));
			Assert.assertTrue(freshCurrency(detailsPage.getCifChargesDisplayed()).contains(cifCharges), "❌ CIF Charges mismatch!");

			logger.info("🔍 Verifying Total Cost: expected contains -> " + totalCost + ", actual -> " + detailsPage.getTotalCostDisplayed());
			Assert.assertTrue(detailsPage.getTotalCostDisplayed().contains(totalCost), "❌ Total Cost mismatch!");

			logger.info("🔍 Verifying BOE Number: expected contains -> " + boeNumber + ", actual -> " + detailsPage.getBoeNumberDisplayed());
			Assert.assertTrue(detailsPage.getBoeNumberDisplayed().contains(boeNumber), "❌ BOE Number mismatch!");

			
			
//            Assert.assertEquals(detailsPage.getCustomDutyValueDisplayed(), customDutyValue, "Custom Duty Value mismatch!");
//            Assert.assertEquals(detailsPage.getGstAmountDisplayed(), gstAmount, "GST Amount mismatch!");
//            Assert.assertEquals(detailsPage.getExRateAsPerBoeDisplayed(), exRateAsPerBoe, "Exchange Rate (BOE) mismatch!");
//            Assert.assertEquals(detailsPage.getClearingChargesDisplayed(), clearingCharges, "Clearing Charges mismatch!");
//            Assert.assertEquals(detailsPage.getChaChargesDisplayed(), chaCharges, "CHA Charges mismatch!");
//            Assert.assertEquals(detailsPage.getTransportationChargesDisplayed(), transportationCharges, "Transportation Charges mismatch!");
//            Assert.assertEquals(detailsPage.getCountryPortOfDispatchDisplayed(), countryPortOfDispatch, "Port of Dispatch mismatch!");
//            Assert.assertEquals(detailsPage.getPortOfClearanceDisplayed(), portOfClearance, "Port of Clearance mismatch!");
//            Assert.assertEquals(detailsPage.getPeriodOfInsuranceDisplayed(), periodOfInsurance, "Insurance Period mismatch!");
//            Assert.assertEquals(detailsPage.getTotalLandedCostDisplayed(), totalLandedCost, "Landed Cost mismatch!");
//            Assert.assertEquals(detailsPage.getTotalLandedCostIncludingGstDisplayed(), totalLandedCostIncludingGst, "Landed Cost + GST mismatch!");

			Thread.sleep(2000);

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC004_AddAssetTest *****");
		}
	}
}
