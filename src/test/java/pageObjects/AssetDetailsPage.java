package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssetDetailsPage extends BasePage
{
	public AssetDetailsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h1[@title='Asset Number']")
	private WebElement dispAssetNumber;
	
	 @FindBy(xpath = "//span[@title='Brand']")
	    private WebElement dispMake;

	    @FindBy(xpath = "//span[@title='Model Number']")
	    private WebElement dispModel;

	    @FindBy(xpath = "//span[@title='Serial Number']")
	    private WebElement dispSerialNumber;

	    @FindBy(xpath = "//span[@title='Purchased From']")
	    private WebElement dispPurchasedFrom;

	    @FindBy(xpath = "//td[@title='Production Year']")
	    private WebElement dispYearOfManufacturing;

	    @FindBy(xpath = "//div[@title='Site Location']")
	    private WebElement dispSiteLocation;

	    @FindBy(xpath = "//td[@title='Capacity']")
	    private WebElement dispHeightOfMachine;

	    @FindBy(xpath = "//td[@title='Capacity']")
	    private WebElement dispCapacityOfMachine;

	    @FindBy(xpath = "//td[@title='Category']")
	    private WebElement dispCategory;

	    // Getter methods for assertions
	    public String getAssetNumberDisplayed() {
	        return dispAssetNumber.getText().trim();
	    }

	    public String getMakeDisplayed() {
	        return dispMake.getText().trim();
	    }

	    public String getModelDisplayed() {
	        return dispModel.getText().trim();
	    }

	    public String getSerialNumberDisplayed() {
	        return dispSerialNumber.getText().trim();
	    }

	    public String getPurchasedFromDisplayed() {
	        return dispPurchasedFrom.getText().toLowerCase().trim();
	    }

	    public String getYearOfManufacturingDisplayed() {
	        return dispYearOfManufacturing.getText().trim();
	    }

	    public String getSiteLocationDisplayed() {
	        return dispSiteLocation.getText().trim();
	    }

	    public String getHeightOfMachineDisplayed() {
	        return dispHeightOfMachine.getText().trim();
	    }

	    public String getCapacityOfMachineDisplayed() {
	        return dispCapacityOfMachine.getText().trim();
	    }

	    public String getCategoryDisplayed() {
	        return dispCategory.getText().trim();
	    }
	    
	    //COMMERCIAL DETAILS
	    
	    @FindBy(xpath = "//td[@title='Used Machine or New Machine']")
	    private WebElement dispUsedNew;

	    @FindBy(xpath = "//span[@title='ANSI or CE']")
	    private WebElement dispAnsiCeStandard;

	    @FindBy(xpath = "//td[@title='Drive Type']")
	    private WebElement dispDriveTrain;

	    @FindBy(xpath = "//td[@title='Wheels']")
	    private WebElement dispWheelDriveType;

	    @FindBy(xpath = "//div[normalize-space()='ENG123456']")
	    private WebElement dispEngineSerialNumber;

	    @FindBy(xpath = "//div[normalize-space()='GPS, Rear Camera']")
	    private WebElement dispAccessories;

	    @FindBy(xpath = "//span[@title='Tyres']")
	    private WebElement dispTires;

	    public String getUsedNewDisplayed() {
	        return dispUsedNew.getText().trim();
	    }

	    public String getAnsiCeStandardDisplayed() {
	        return dispAnsiCeStandard.getText().trim();
	    }

	    public String getDriveTrainDisplayed() {
	        return dispDriveTrain.getText().trim();
	    }

	    public String getWheelDriveTypeDisplayed() {
	        return dispWheelDriveType.getText().trim();
	    }

	    public String getEngineSerialNumberDisplayed() {
	        return dispEngineSerialNumber.getText().trim();
	    }

	    public String getAccessoriesDisplayed() {
	        return dispAccessories.getText().trim();
	    }

	    public String getTiresDisplayed() {
	        return dispTires.getText().trim();
	    }

	    @FindBy(xpath = "//span[normalize-space()='Commercial Details']")
	    private WebElement CommercialDetails;
	    
	    public void clcikCommercialDetails() {
	        CommercialDetails.click();
	    }
	    
	    
	    
	    @FindBy(xpath = "//*[@title=\"Purchase Order No\"]//span[2]")
	    private WebElement dispPoNumber;

	    @FindBy(xpath = "//div[@title='Purchase Order Date']//span[2]")
	    private WebElement dispPoDate;

	    @FindBy(xpath = "//div[text()='Invoice Number']/following-sibling::div")
	    private WebElement dispInvoiceNumber;

	    @FindBy(xpath = "//div[text()='Invoice Date']/following-sibling::div")
	    private WebElement dispInvoiceDate;

	    @FindBy(xpath = "//div[contains(@title,'Amount of Remitted OEM')]//span[2]")
	    private WebElement dispPaymentRemittedToOem;

	    @FindBy(xpath = "//div[contains(@title,'Date of Remittence to OEM')]//span[2]")
	    private WebElement dispDateOfPaymentRemittedToOem;

	    @FindBy(xpath = "//div[contains(@title,'Exchange Rate of Remitted OEM')]//span[2]")
	    private WebElement dispExchangeRateRemittance;

	    @FindBy(xpath = "//div[text()='Date of Custom Duty Payment']/following-sibling::div")
	    private WebElement dispDateOfCustomDutyPayment;

	    @FindBy(xpath = "//div[contains(@title,'Custom Duty Date of Clearance')]/span")
	    private WebElement dispCustomDutyDateOfClearance;

	    @FindBy(xpath = "//div[@title='Ex-Works Price']/span[2]")
	    private WebElement dispExWorkPrice;

	    @FindBy(xpath = "//div[contains(@title,'(CIF) Charges')]/span[2]")
	    private WebElement dispCifCharges;

	    @FindBy(xpath = "//div[contains(@title,'Total Cost = Ex Works (EXW) price + CIF Charges')]/span[2]")
	    private WebElement dispTotalCost;

	    @FindBy(xpath = "//div[contains(@title,'Bill of entry (BOE)')]/span")
	    private WebElement dispBoeNumber;

	    @FindBy(xpath = "//div[text()='Custom Duty Value']/following-sibling::div")
	    private WebElement dispCustomDutyValue;

	    @FindBy(xpath = "//div[text()='GST Amount']/following-sibling::div")
	    private WebElement dispGstAmount;

	    @FindBy(xpath = "//div[text()='Exchange Rate (as per BOE)']/following-sibling::div")
	    private WebElement dispExRateAsPerBoe;

	    @FindBy(xpath = "//div[text()='Clearing Charges']/following-sibling::div")
	    private WebElement dispClearingCharges;

	    @FindBy(xpath = "//div[text()='CHA Charges']/following-sibling::div")
	    private WebElement dispChaCharges;

	    @FindBy(xpath = "//div[text()='Transportation Charges']/following-sibling::div")
	    private WebElement dispTransportationCharges;

	    @FindBy(xpath = "//div[text()='Country/Port of Dispatch']/following-sibling::div")
	    private WebElement dispCountryPortOfDispatch;

	    @FindBy(xpath = "//div[text()='Port of Clearance']/following-sibling::div")
	    private WebElement dispPortOfClearance;

	    @FindBy(xpath = "//div[text()='Period of Insurance']/following-sibling::div")
	    private WebElement dispPeriodOfInsurance;

	    @FindBy(xpath = "//div[text()='Total Landed Cost']/following-sibling::div")
	    private WebElement dispTotalLandedCost;

	    @FindBy(xpath = "//div[text()='Total Landed Cost (incl. GST)']/following-sibling::div")
	    private WebElement dispTotalLandedCostIncludingGst;

	    // Add getters
		public String getPoNumberDisplayed() {
			scrollToElementIfNeeded(dispPoNumber);
			return dispPoNumber.getText().trim();
		}

		public String getPoDateDisplayed() {
			return dispPoDate.getText().trim();
		}

		public String getInvoiceNumberDisplayed() {
			return dispInvoiceNumber.getText().trim();
		}

		public String getInvoiceDateDisplayed() {
			return dispInvoiceDate.getText().trim();
		}

		public String getPaymentRemittedToOemDisplayed() {
			return dispPaymentRemittedToOem.getText().trim();
		}

		public String getDateOfPaymentRemittedToOemDisplayed() {
			return dispDateOfPaymentRemittedToOem.getText().trim();
		}

		public String getExchangeRateRemittanceDisplayed() {
			return dispExchangeRateRemittance.getText().trim();
		}

		public String getDateOfCustomDutyPaymentDisplayed() {
			return dispDateOfCustomDutyPayment.getText().trim();
		}

		public String getCustomDutyDateOfClearanceDisplayed() {
			return dispCustomDutyDateOfClearance.getText().trim();
		}

		public String getExWorkPriceDisplayed() {
			return dispExWorkPrice.getText().trim();
		}

		public String getCifChargesDisplayed() {
			return dispCifCharges.getText().trim();
		}

		public String getTotalCostDisplayed() {
			return dispTotalCost.getText().trim();
		}

		public String getBoeNumberDisplayed() {
			return dispBoeNumber.getText().trim();
		}

		public String getCustomDutyValueDisplayed() {
			return dispCustomDutyValue.getText().trim();
		}

		public String getGstAmountDisplayed() {
			return dispGstAmount.getText().trim();
		}

		public String getExRateAsPerBoeDisplayed() {
			return dispExRateAsPerBoe.getText().trim();
		}

		public String getClearingChargesDisplayed() {
			return dispClearingCharges.getText().trim();
		}

		public String getChaChargesDisplayed() {
			return dispChaCharges.getText().trim();
		}

		public String getTransportationChargesDisplayed() {
			return dispTransportationCharges.getText().trim();
		}

		public String getCountryPortOfDispatchDisplayed() {
			return dispCountryPortOfDispatch.getText().trim();
		}

		public String getPortOfClearanceDisplayed() {
			return dispPortOfClearance.getText().trim();
		}

		public String getPeriodOfInsuranceDisplayed() {
			return dispPeriodOfInsurance.getText().trim();
		}

		public String getTotalLandedCostDisplayed() {
			return dispTotalLandedCost.getText().trim();
		}

		public String getTotalLandedCostIncludingGstDisplayed() {
			return dispTotalLandedCostIncludingGst.getText().trim();
		}

}
