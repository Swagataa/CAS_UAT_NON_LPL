package UAT_CAS_Other_than__LPL;

import org.testng.annotations.Test;
import utility.BrowserSetup;
import utility.readexcel;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DDE extends BrowserSetup{

	static String app_id;	
	WebDriverWait wait;
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";

	@SuppressWarnings({ "rawtypes"})
	@Test(dataProvider="data-provider",dataProviderClass=utility.DataProvider.class)
	public void DDE_CAS(String sLogin_id,String sPassword,String sArea,String First_Name,String Last_Name,String Father_Name,String Product,
			String credit_program,String Scheme,String asset_cat,String asset_make,String asset_model,String Dealer_Code,String TM_Code,String SE_Code,String Constitution,String loan_amount,
			String loan_Tennure,String first_EMI_Month,String first_EMI_Year,String Advance_EMI,String Disburse_To,String Life_Insurance) throws Throwable 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);		
		FileInputStream fis = new FileInputStream(ApplicationIdsfilepath1); 
		  Workbook wobk = WorkbookFactory.create(fis); 
		  @SuppressWarnings("unused")
		Sheet Worksheet = wobk.getSheet("ApplicationId");
		  readexcel readXls = new readexcel(); 
		  List datalist = readXls.readexcelsheet();
		  for (int i = 1; i < datalist.size(); i++){ 
			  String[] test = (String[])datalist.get(i); 
			  app_id = test[1]; 
			  System.out.println(app_id);
		  }
	  
		/*-------------------------- CAS Screen ----------------------*/
				  
		List<String> FinnoneCAS1 = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(FinnoneCAS1);

		System.out.println(FinnoneCAS1);

		driver.switchTo().window(FinnoneCAS1.get(0));

		String title5 = driver.getTitle();

		System.out.println(title5);

		if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(FinnoneCAS1.get(1));

			System.out.println(driver.getTitle());
		}

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameForwardToApp"));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("banner"));

		driver.switchTo().parentFrame();

		driver.switchTo().frame("contents");

		Actions move_AutoLoan1 = new Actions(driver);

		WebElement Auto_loan1 = driver.findElement(By.linkText("Auto Loan"));

		move_AutoLoan1.moveToElement(Auto_loan1).build().perform();

		WebElement DDEsearch = driver.findElement(By.linkText("All"));

		wait.until(ExpectedConditions.visibilityOf(DDEsearch));
		
		//Detail Data Entry

		DDEsearch.click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));

		WebElement searchappId = driver.findElement(By.id("txtApplication"));

		wait.until(ExpectedConditions.visibilityOf(searchappId));

		// Excel should start

		searchappId.sendKeys(app_id);

		// Screenshotpath = fn_screenshot(Screenshotpath);

		Thread.sleep(1000);

		WebElement searchbtn = driver.findElement(By.name("btnSearch"));

		wait.until(ExpectedConditions.visibilityOf(searchbtn));

		searchbtn.click();

		WebElement linkappid = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[1]/a"));

		wait.until(ExpectedConditions.visibilityOf(linkappid));

		linkappid.click();

		driver.switchTo().window(FinnoneCAS1.get(0));

		System.out.println(driver.getTitle());

		/*-------------- DDE ------------------------------------*/

		List<String> DDEscreen = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(DDEscreen.size());

		Collections.sort(DDEscreen);

		System.out.println(DDEscreen);

		driver.switchTo().window(DDEscreen.get(2));

		System.out.println(DDEscreen.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(DDEscreen.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(DDEscreen.get(1));

				System.out.println(driver.getTitle());
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(DDEscreen.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(DDEscreen.get(0));

				System.out.println(driver.getTitle());
			}

		}

		
		  WebElement demographic = driver.findElement(By.id("apy_b0i2text"));
		 
		 wait.until(ExpectedConditions.visibilityOf(demographic));
		
		 demographic.click();
		 
		  WebElement customername = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[1]/a"));
		 
		 wait.until(ExpectedConditions.visibilityOf(customername));
		 
		 customername.click();
		 
		 WebElement personaltab = driver.findElement(By.id("apy_b1i1font"));
		 
		 wait.until(ExpectedConditions.visibilityOf(personaltab));
		 
		 System.out.println(personaltab.getText());
		
		 WebElement qualification = driver.findElement(By.id("selEduQualification"));
		 
		 wait.until(ExpectedConditions.visibilityOf(qualification));
		 
		 qualification.sendKeys("Graduate");
		 
		 qualification.sendKeys(Keys.TAB);
		 
		 /*------------ Education window ------------ */
		 
		 // Set<String> educationwindow = driver.getWindowHandles();
		 
		 List<String> educationwindow = new ArrayList<String>(driver.getWindowHandles());
		 
		 System.out.println(educationwindow.size());
		 
		 Collections.sort(educationwindow);
		 
		 System.out.println(educationwindow);
		 
		 driver.switchTo().window(educationwindow.get(3));
		 
		 System.out.println(driver.getTitle());
		 
		 if(!driver.getTitle().equalsIgnoreCase("Education Search")){
			 
			 driver.switchTo().window(educationwindow.get(2));
			 
			 System.out.println(driver.getTitle());
			 
			 if(!driver.getTitle().equalsIgnoreCase("Education Search")){
				 
				 driver.switchTo().window(educationwindow.get(1));
				 
				 System.out.println(driver.getTitle());
				 
				 if(!driver.getTitle().equalsIgnoreCase("Education Search")){
					 
					 driver.switchTo().window(educationwindow.get(0));
					 
					 System.out.println(driver.getTitle());
					 
				 }
			 }
			 
		 }
		 
		 WebElement searchcriteriaGo = driver.findElement(By.name("B1"));
		 
		 wait.until(ExpectedConditions.visibilityOf(searchcriteriaGo));
		 
		 searchcriteriaGo.click();
		 
		 Thread.sleep(1500);
		 
	//	 driver.switchTo().window(educationwindow.get(0));
		 
		 /*-----------------Return from Education Window ----------------------- */
		 
		 List<String> returneducationdetails = new ArrayList<String>(driver.getWindowHandles());
		 
		 Collections.sort(returneducationdetails);
		 
		 System.out.println(returneducationdetails);
		 
		 driver.switchTo().window(returneducationdetails.get(2));
		 
		 System.out.println(returneducationdetails.get(2));
		 
		 System.out.println(driver.getTitle());
		 
		 if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {
		 
		 driver.switchTo().window(returneducationdetails.get(0));
		 
		 System.out.println(driver.getTitle());
		 
		 if(driver.getTitle().equalsIgnoreCase("Finnone SSO")){
		 
		 driver.switchTo().window(returneducationdetails.get(1));
		 
		 System.out.println(driver.getTitle());
		 
		 }
		 
		 } else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {
		 
		 driver.switchTo().window(returneducationdetails.get(1));
		 
		 System.out.println(driver.getTitle());
		 
		 if(driver.getTitle().equalsIgnoreCase("Finnone CAS")){
		 
		 driver.switchTo().window(returneducationdetails.get(0));
		 
		 System.out.println(driver.getTitle()); } }
		 
		 Thread.sleep(1000);
		 
		/*------------- Click on Update Button ------------- */
		
		driver.findElement(By.name("btnUpdate")).click(); 

		/*------------- Click on Address Tab ------------- */
		
		WebElement addresstab = driver.findElement(By.id("apy_b1i2font"));
		
		wait.until(ExpectedConditions.visibilityOf(addresstab));
		
		System.out.println(addresstab.getText());
		
		addresstab.click();
		
		WebElement addresstype = driver.findElement(By.id("selAddressType"));
		
		wait.until(ExpectedConditions.visibilityOf(addresstype));
		
		Select addresssel = new Select(addresstype);
		
		addresssel.selectByIndex(1);
		
		WebElement addressone1 = driver.findElement(By.id("txtAddressOne"));
		
		wait.until(ExpectedConditions.visibilityOf(addressone1));
		
		addressone1.sendKeys("Test address");
		
		WebElement state = driver.findElement(By.id("selState"));
		
		state.sendKeys("delhi");
		
		Thread.sleep(2000);
		
		state.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		
		WebElement cityenter = driver.findElement(By.id("txtCity"));
		
		wait.until(ExpectedConditions.visibilityOf(cityenter));
		
		cityenter.sendKeys("delhi");
		
		cityenter.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		
		WebElement zip = driver.findElement(By.id("txtZip"));
		
		zip.sendKeys("110029");
		
		zip.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		
		WebElement areacode = driver.findElement(By.id("txtStdisd"));
		
		wait.until(ExpectedConditions.visibilityOf(areacode));
		
		areacode.sendKeys("011");

		Thread.sleep(1000);
		
		WebElement landline = driver.findElement(By.id("txtPhoneOne"));
		
		wait.until(ExpectedConditions.visibilityOf(landline));
		
		landline.sendKeys("49487150");
		
		Thread.sleep(1000);
		
		WebElement txtmobile = driver.findElement(By.id("txtMobile"));
		
		wait.until(ExpectedConditions.visibilityOf(txtmobile));		
		
		txtmobile.sendKeys("9000000000");
		
		WebElement txtlandmark = driver.findElement(By.id("txtLandmark"));
		
		wait.until(ExpectedConditions.visibilityOf(txtlandmark));
		
		txtlandmark.sendKeys("Test address");
		
		WebElement txtAddyear = driver.findElement(By.id("txtAddYear"));
		
		wait.until(ExpectedConditions.visibilityOf(txtAddyear));
		
		txtAddyear.sendKeys("6");
		
		driver.findElement(By.id("txtAddMonth")).sendKeys("0");
		
		driver.findElement(By.id("txtYearInCity")).sendKeys("6");
		
		driver.findElement(By.id("txtMonthInCity")).sendKeys("0");
		
		Thread.sleep(1000);
		
		WebElement btnAdd = driver.findElement(By.name("btnAdd"));
		
		wait.until(ExpectedConditions.visibilityOf(btnAdd));
		
		btnAdd.click();		
		
		Thread.sleep(1500);

		/*---------------------- Work Details -------------- */
		
		WebElement work = driver.findElement(By.id("apy_b1i3text"));
		
		wait.until(ExpectedConditions.visibilityOf(work));
		
		work.click();
		
		WebElement organization_name = driver.findElement(By.id("txtCompnayName"));
		
		wait.until(ExpectedConditions.visibilityOf(organization_name));
		
		organization_name.sendKeys("Test Organization");
		
		WebElement companytype = driver.findElement(By.id("selTypeOfOrganization"));
		
		Select Selcompanytype = new Select(companytype);
		
		Selcompanytype.selectByIndex(5);
		
		WebElement designation = driver.findElement(By.id("selDesignation"));
		
		wait.until(ExpectedConditions.visibilityOf(designation));
		
		designation.sendKeys("Manager");
		
		WebElement Nature_business = driver.findElement(By.id("selNatureOfBusiness"));
		
		wait.until(ExpectedConditions.visibilityOf(Nature_business));
		
		Nature_business.sendKeys("test business");
		
		WebElement present_job = driver.findElement(By.id("txtYearInPresentJob"));
		
		wait.until(ExpectedConditions.visibilityOf(present_job));
				
		present_job.sendKeys("6");
		
		WebElement m_present_job = driver.findElement(By.id("txtMonthInPresentJob"));
		
		wait.until(ExpectedConditions.visibilityOf(m_present_job));
		
		m_present_job.sendKeys("0");
		
		WebElement save_btn = driver.findElement(By.name("btnAdd"));
		
		wait.until(ExpectedConditions.visibilityOf(save_btn));
		
		save_btn.click();

		/*-----------------------	Demographic-Financial Details  --------------- */
		
		WebElement financialdetails = driver.findElement(By.id("apy_b1i5text"));
		
		wait.until(ExpectedConditions.visibilityOf(financialdetails));
		
		financialdetails.click();
		
		WebElement selbankname = driver.findElement(By.id("selBankName"));
		
		wait.until(ExpectedConditions.visibilityOf(selbankname));
		
		selbankname.sendKeys("1BANK OF MAHARASHTRA");
		
		selbankname.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("txtBankBranch")).sendKeys("Delhi");
		
		WebElement accounttype = driver.findElement(By.id("selAccountType"));
		
		wait.until(ExpectedConditions.visibilityOf(accounttype));
		
		Select selaccounttype = new Select(accounttype);
		
		selaccounttype.selectByIndex(4);
		
		WebElement txtYearsHeld = driver.findElement(By.id("txtYearsHeld"));
		
		wait.until(ExpectedConditions.visibilityOf(txtYearsHeld));
		
		txtYearsHeld.sendKeys("2016");
		
		WebElement txtLengthMonth = driver.findElement(By.id("txtLengthMonth"));
		
		wait.until(ExpectedConditions.visibilityOf(txtLengthMonth));
		
		txtLengthMonth.sendKeys("1");
		
		WebElement txtAccountNumber = driver.findElement(By.id("txtAccountNumber"));
		
		wait.until(ExpectedConditions.visibilityOf(txtAccountNumber));
		
		txtAccountNumber.sendKeys("1234567890");
		
		WebElement addbank = driver.findElement(By.name("btnAddBank"));
		
		wait.until(ExpectedConditions.visibilityOf(addbank));
		
		addbank.click();
		
		/*------------------- Asset Details tab ---------------- */
		
		WebElement asset = driver.findElement(By.id("apy_b0i3font"));
		
		wait.until(ExpectedConditions.visibilityOf(asset));
		
		System.out.println(asset.getText());
		
		asset.click();
		
		WebElement assetlife = driver.findElement(By.id("txtAssetLife"));
		
		wait.until(ExpectedConditions.visibilityOf(assetlife));
		
		assetlife.sendKeys("500");
		
		WebElement assetage = driver.findElement(By.id("txtAssetAge"));
		
		wait.until(ExpectedConditions.visibilityOf(assetage));
		
		assetage.sendKeys("0");
		
		WebElement vehiclecost = driver.findElement(By.id("txtVehicleCost"));
		
		wait.until(ExpectedConditions.visibilityOf(vehiclecost));
		
		vehiclecost.sendKeys("60000");
		
		WebElement accessoriescost = driver.findElement(By.id("txtAccessoriesCost"));
		
		wait.until(ExpectedConditions.visibilityOf(accessoriescost));
		
		accessoriescost.sendKeys("800");
		
		WebElement tax = driver.findElement(By.id("txtRustProofingCost"));
		
		wait.until(ExpectedConditions.visibilityOf(tax));
		
		tax.sendKeys("200");
		
		WebElement amount_finance = driver.findElement(By.id("txtAmtFin"));
		
		wait.until(ExpectedConditions.visibilityOf(amount_finance));
		
		amount_finance.clear();
		
		amount_finance.sendKeys(loan_amount);
		
		WebElement insuranceapplicable = driver.findElement(By.id("selAssetLINSFlag"));
		
		wait.until(ExpectedConditions.visibilityOf(insuranceapplicable));
		
		Select selinsurance = new Select(insuranceapplicable);
		
		selinsurance.selectByVisibleText(Life_Insurance);
		
		WebElement updatebutton = driver.findElement(By.name("btnUpdate"));
		
		wait.until(ExpectedConditions.visibilityOf(updatebutton));
		
		updatebutton.click();

		/*----------------- Loan Details Tab ----------------------- */

		WebElement Loandetails = driver.findElement(By.id("apy_b0i4font"));

		wait.until(ExpectedConditions.visibilityOf(Loandetails));

		System.out.println(Loandetails.getText());

		Loandetails.click();

		 WebElement loanpurpose = driver.findElement(By.id("selLoanPurpose"));
		 
		 wait.until(ExpectedConditions.visibilityOf(loanpurpose));
		 
		 Select selloan = new Select(loanpurpose);
		 
		 selloan.selectByIndex(2);
		 
		 WebElement advance_emi = driver.findElement(By.name("txtAdvanceInstallment"));
		 
		 wait.until(ExpectedConditions.visibilityOf(advance_emi));

		 advance_emi.sendKeys(Advance_EMI);
		 
		 WebElement duedate = driver.findElement(By.id("selDueDate"));
		 
		 wait.until(ExpectedConditions.visibilityOf(duedate));
		 
		 Select selduedate = new Select(duedate);
		 
		 selduedate.selectByVisibleText("08");
		 
		 WebElement disburse_to = driver.findElement(By.name("selLoanPayTo"));
		 
		 wait.until(ExpectedConditions.visibilityOf(disburse_to));
		 
		 Select sel_disburse_to = new Select(disburse_to);
		 
		 sel_disburse_to.selectByVisibleText(Disburse_To);
		 
		 WebElement rateEmi = driver.findElement(By.id("selRateEMIFlag"));
		 
		 wait.until(ExpectedConditions.visibilityOf(rateEmi));
		 
		 Select selrateEmi = new Select(rateEmi);
		 
		 selrateEmi.selectByIndex(3);
		 
	/*	 WebElement flat = driver.findElement(By.id("txtFlat"));
		 
		 wait.until(ExpectedConditions.visibilityOf(flat));
		 
		 flat.clear();
		 
		 flat.sendKeys("9"); */
		 
		 WebElement firstEMI = driver.findElement(By.id("txtFirstEMIMonth"));
		 
		 wait.until(ExpectedConditions.visibilityOf(firstEMI));
		 
		 firstEMI.sendKeys(first_EMI_Month);
		 
		 WebElement firstemiyr = driver.findElement(By.id("txtFirstEMIYear"));
		 
		 wait.until(ExpectedConditions.visibilityOf(firstemiyr));
		 
		 firstemiyr.sendKeys(first_EMI_Year);
		 
	if(!Life_Insurance.equalsIgnoreCase("NO")){
		 
		  WebElement nomineename = driver.findElement(By.id("txtNomineeName"));
		 
		 wait.until(ExpectedConditions.visibilityOf(nomineename));
		 
		 nomineename.sendKeys("Test Nominee");
		 
		 WebElement nomineeaddress = driver.findElement(By.id("txtNomineeAddress"));
		 
		 wait.until(ExpectedConditions.visibilityOf(nomineeaddress));
		 
		 nomineeaddress.sendKeys("Test Nominee Address");
		 
		 WebElement nomineeDOB = driver.findElement(By.id("txtNomineeDOB"));
		 
		 wait.until(ExpectedConditions.visibilityOf(nomineeDOB));
		 
		 nomineeDOB.sendKeys("01/01/2001"); 
		 	}
		 
		 WebElement savebutton = driver.findElement(By.name("btnSave"));
		 
		 wait.until(ExpectedConditions.visibilityOf(savebutton));
		 
		 savebutton.click();
		 
		WebElement chargesbutton = driver.findElement(By.name("btnFeeCharge"));

		wait.until(ExpectedConditions.visibilityOf(chargesbutton));

		chargesbutton.click();

		Thread.sleep(1000);

		/*---------------------------- Charges Details window --------------------------- */

		List<String> chargeswindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(chargeswindow);

		System.out.println(chargeswindow);

		System.out.println(chargeswindow.size());

		driver.switchTo().window(chargeswindow.get(3));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(chargeswindow.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(chargeswindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

					driver.switchTo().window(chargeswindow.get(0));

					System.out.println(driver.getTitle());
				}
			} else if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

				driver.switchTo().window(chargeswindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(chargeswindow.get(1));

					System.out.println(driver.getTitle());
				}

			}

		} else if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

			driver.switchTo().window(chargeswindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(chargeswindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(chargeswindow.get(2));

				}
			} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(chargeswindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(chargeswindow.get(2));

					System.out.println(driver.getTitle());
				}
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(chargeswindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(chargeswindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

					driver.switchTo().window(chargeswindow.get(2));

					System.out.println(driver.getTitle());
				}

			} else if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

				driver.switchTo().window(chargeswindow.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(chargeswindow.get(0));

					System.out.println(driver.getTitle());

				}
			}
		}

		WebElement closebutton = driver.findElement(By.name("btnClose"));

		wait.until(ExpectedConditions.visibilityOf(closebutton));

		closebutton.click();
		
		Thread.sleep(1500);

	//	driver.switchTo().window(chargeswindow.get(0));

		/*-----------------Return from Charges Details Window  -----------------------*/

		List<String> returnchargesdetails = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returnchargesdetails);

		System.out.println(returnchargesdetails);

		driver.switchTo().window(returnchargesdetails.get(2));

		System.out.println(returnchargesdetails.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returnchargesdetails.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returnchargesdetails.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returnchargesdetails.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returnchargesdetails.get(0));

				System.out.println(driver.getTitle());
			}
		}

		WebElement repaymentbutton = driver.findElement(By.name("btnRepay"));

		wait.until(ExpectedConditions.visibilityOf(repaymentbutton));

		repaymentbutton.click();

		Thread.sleep(1000);


		/*---------------------- Re-payment window --------------- */

		List<String> repaymentwindow = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(repaymentwindow);

		driver.switchTo().window(repaymentwindow.get(3));

		System.out.println(repaymentwindow.get(3));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(repaymentwindow.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(repaymentwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

					driver.switchTo().window(repaymentwindow.get(0));

					System.out.println(driver.getTitle());
				}
			} else if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

				driver.switchTo().window(repaymentwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(repaymentwindow.get(1));

					System.out.println(driver.getTitle());
				}

			}

		} else if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

			driver.switchTo().window(repaymentwindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(repaymentwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(repaymentwindow.get(2));

				}
			} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(repaymentwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(repaymentwindow.get(2));

					System.out.println(driver.getTitle());
				}
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(repaymentwindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(repaymentwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

					driver.switchTo().window(repaymentwindow.get(2));

					System.out.println(driver.getTitle());
				}

			} else if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

				driver.switchTo().window(repaymentwindow.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(repaymentwindow.get(0));

					System.out.println(driver.getTitle());

				}
			}
		}

		WebElement repaymentclose = driver.findElement(By.name("btn9"));

		wait.until(ExpectedConditions.visibilityOf(repaymentclose));

		repaymentclose.click();
		
		Thread.sleep(1500);

	//	driver.switchTo().window(repaymentwindow.get(0));

		/*----------------- Return from Re-Payment ----------------- */

		List<String> returnrepayment = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returnrepayment);

		System.out.println(returnrepayment);

		driver.switchTo().window(returnrepayment.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returnrepayment.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returnrepayment.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returnrepayment.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returnrepayment.get(0));

				System.out.println(driver.getTitle());
			}
		}

		WebElement splitbutton = driver.findElement(By.name("btnSplitDisb"));

		wait.until(ExpectedConditions.visibilityOf(splitbutton));

		splitbutton.click();

		Thread.sleep(1000);

		/*------------------- Split Disbursal ----------------- */

		List<String> Splitdisbursal = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(Splitdisbursal);

		driver.switchTo().window(Splitdisbursal.get(3));

		System.out.println(Splitdisbursal.get(3));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(Splitdisbursal.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Splitdisbursal.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

					driver.switchTo().window(Splitdisbursal.get(0));

					System.out.println(driver.getTitle());
				}
			} else if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

				driver.switchTo().window(Splitdisbursal.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(Splitdisbursal.get(1));

					System.out.println(driver.getTitle());
				}

			}

		} else if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

			driver.switchTo().window(Splitdisbursal.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Splitdisbursal.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(Splitdisbursal.get(2));

				}
			} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Splitdisbursal.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(Splitdisbursal.get(2));

					System.out.println(driver.getTitle());
				}
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(Splitdisbursal.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Splitdisbursal.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

					driver.switchTo().window(Splitdisbursal.get(2));

					System.out.println(driver.getTitle());
				}

			} else if (driver.getTitle().equalsIgnoreCase("Loan Details")) {

				driver.switchTo().window(Splitdisbursal.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(Splitdisbursal.get(0));

					System.out.println(driver.getTitle());

				}
			}
		}

		WebElement select = driver.findElement(By.name("txtSelect"));
		
		wait.until(ExpectedConditions.visibilityOf(select));
		
		select.click();
		
		WebElement splitsave = driver.findElement(By.name("btnAdd"));

		wait.until(ExpectedConditions.visibilityOf(splitsave));

		splitsave.click();

		WebElement splitclose = driver.findElement(By.name("btnSplitMultDisbClose"));

		wait.until(ExpectedConditions.visibilityOf(splitclose));

		splitclose.click();
		
		Thread.sleep(1500);

	//	driver.switchTo().window(Splitdisbursal.get(0));

		/*-------------- Return from Split Disbursal ------------- */

		List<String> returnsplit = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returnsplit);

		System.out.println(returnsplit);

		driver.switchTo().window(returnsplit.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returnsplit.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returnsplit.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returnsplit.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returnsplit.get(0));

				System.out.println(driver.getTitle());
			}
		}

		WebElement refernces = driver.findElement(By.id("apy_b0i10font"));

		wait.until(ExpectedConditions.visibilityOf(refernces));

		refernces.click();

		Thread.sleep(4000);

		/*--------------------------- References ------------------------ */

		WebElement referncetitle1 = driver.findElement(By.id("selTitle"));

		wait.until(ExpectedConditions.visibilityOf(referncetitle1));

		Select selreferncetitle1 = new Select(referncetitle1);

		selreferncetitle1.selectByIndex(1);

		WebElement referencename1 = driver.findElement(By.id("txtReferenceName"));

		wait.until(ExpectedConditions.visibilityOf(referencename1));

		referencename1.sendKeys("Test One");

		referencename1.sendKeys(Keys.TAB);

		WebElement refereerelation = driver.findElement(By.id("selReferenceRelation"));

		wait.until(ExpectedConditions.visibilityOf(refereerelation));

		Select selrefereerelation = new Select(refereerelation);

		selrefereerelation.selectByIndex(1);

		WebElement addressline1 = driver.findElement(By.id("txtAddress1"));

		wait.until(ExpectedConditions.visibilityOf(addressline1));

		addressline1.sendKeys("Test address one");

		WebElement phone1 = driver.findElement(By.id("txtPhone1"));

		wait.until(ExpectedConditions.visibilityOf(phone1));

		phone1.sendKeys("9000000000");

		WebElement mobile1 = driver.findElement(By.id("txtMobile"));

		wait.until(ExpectedConditions.visibilityOf(mobile1));

		mobile1.sendKeys("9000000000");

		WebElement zip1 = driver.findElement(By.id("txtZip"));

		wait.until(ExpectedConditions.visibilityOf(zip1));

		zip1.sendKeys("110001");

		WebElement addbutton = driver.findElement(By.name("btnAdd"));

		wait.until(ExpectedConditions.visibilityOf(addbutton));

		addbutton.click();

		Thread.sleep(2000);

		WebElement clear = driver.findElement(By.name("btnClear"));

		wait.until(ExpectedConditions.visibilityOf(clear));

		clear.click();

		Thread.sleep(2000);

		/*------------------ Reference 2 ------------------------ */

		WebElement referncetitle2 = driver.findElement(By.id("selTitle"));

		wait.until(ExpectedConditions.visibilityOf(referncetitle2));

		Select selreferncetitle2 = new Select(referncetitle2);

		selreferncetitle2.selectByIndex(1);

		WebElement referencename2 = driver.findElement(By.id("txtReferenceName"));

		wait.until(ExpectedConditions.visibilityOf(referencename2));

		referencename2.sendKeys("Test two");

		referencename2.sendKeys(Keys.TAB);

		WebElement refereerelation2 = driver.findElement(By.id("selReferenceRelation"));

		wait.until(ExpectedConditions.visibilityOf(refereerelation2));

		Select selrefereerelation2 = new Select(refereerelation2);

		selrefereerelation2.selectByIndex(1);

		WebElement addressline2 = driver.findElement(By.id("txtAddress1"));

		wait.until(ExpectedConditions.visibilityOf(addressline2));

		addressline2.sendKeys("Test address one");

		WebElement phone2 = driver.findElement(By.id("txtPhone1"));

		wait.until(ExpectedConditions.visibilityOf(phone2));

		phone2.sendKeys("9000000000");

		WebElement mobile2 = driver.findElement(By.id("txtMobile"));

		wait.until(ExpectedConditions.visibilityOf(mobile2));

		mobile2.sendKeys("9000000000");

		WebElement zip2 = driver.findElement(By.id("txtZip"));

		wait.until(ExpectedConditions.visibilityOf(zip2));

		zip2.sendKeys("110001");

		WebElement addbutton1 = driver.findElement(By.name("btnAdd"));

		wait.until(ExpectedConditions.visibilityOf(addbutton1));

		addbutton1.click();

		Thread.sleep(2000);
	
		/*--------------------- Document Collection ------------------ */

		WebElement document = driver.findElement(By.id("apy_b0i11font"));

		wait.until(ExpectedConditions.visibilityOf(document));

		document.click();

		Thread.sleep(3000);
		
		/*-------- Document Collection Window --------------- */

		List<String> documentcollectionwindow = new ArrayList<>(driver.getWindowHandles());

		Collections.sort(documentcollectionwindow);

		System.out.println(documentcollectionwindow);

		System.out.println(documentcollectionwindow.size());

		driver.switchTo().window(documentcollectionwindow.get(3));

		System.out.println(driver.getTitle());
		
			if(!driver.getTitle().equalsIgnoreCase("Document Management System")){
				
				driver.switchTo().window(documentcollectionwindow.get(2));
				
				System.out.println(driver.getTitle());
				
				if(!driver.getTitle().equalsIgnoreCase("Document Management System")){
					
					driver.switchTo().window(documentcollectionwindow.get(1));
					
					System.out.println(driver.getTitle());
					
					if(!driver.getTitle().equalsIgnoreCase("Document Management System")){
						
						driver.switchTo().window(documentcollectionwindow.get(0));
						
						System.out.println(driver.getTitle());
					}					
				}		
			}
			
		WebElement checkone = driver.findElement(By.id("jqg_gridtableOfDocumets_1"));

		wait.until(ExpectedConditions.visibilityOf(checkone));

		WebElement addressproof = driver.findElement(By.id("docStatus1"));

		wait.until(ExpectedConditions.visibilityOf(addressproof));

		Select seladdressproofstatus = new Select(addressproof);

		seladdressproofstatus.selectByIndex(2);
		
		Thread.sleep(1000);

		WebElement Voterid = driver.findElement(By.id("jqg_gridtableOfChildDocumets_1"));
		
		wait.until(ExpectedConditions.visibilityOf(Voterid));
		
		Voterid.click();
		
		WebElement savevoterid = driver.findElement(By.linkText("Update and Close"));
		
		wait.until(ExpectedConditions.visibilityOf(savevoterid));
		
		savevoterid.click();		
		
		WebElement remarkId1 = driver.findElement(By.id("remarkId1"));
		
		wait.until(ExpectedConditions.visibilityOf(remarkId1));
		
		remarkId1.sendKeys("Test");
		
		Thread.sleep(1000);

		/*--------proof 2------*/

		WebElement checktwo = driver.findElement(By.id("jqg_gridtableOfDocumets_2"));

		wait.until(ExpectedConditions.visibilityOf(checktwo));

		WebElement idproof = driver.findElement(By.id("docStatus2"));

		wait.until(ExpectedConditions.visibilityOf(idproof));

		Select selidproof = new Select(idproof);

		selidproof.selectByIndex(2);
		
		WebElement UID = driver.findElement(By.id("jqg_gridtableOfChildDocumets_2"));
		
		wait.until(ExpectedConditions.visibilityOf(UID));
		
		UID.click();
		
		WebElement saveUID = driver.findElement(By.id("saveChildDoc"));
		
		wait.until(ExpectedConditions.visibilityOf(saveUID));
		
		saveUID.click();		
		
		WebElement remarkId2 = driver.findElement(By.id("remarkId2"));
		
		wait.until(ExpectedConditions.visibilityOf(remarkId2));
		
		remarkId2.sendKeys("Test");

		Thread.sleep(1000);
		
		/*-----------proof 3----------*/

		WebElement checkthree = driver.findElement(By.id("jqg_gridtableOfDocumets_3"));

		wait.until(ExpectedConditions.visibilityOf(checkthree));

		WebElement salaryproof = driver.findElement(By.id("docStatus3"));

		wait.until(ExpectedConditions.visibilityOf(salaryproof));

		Select selsalaryproof = new Select(salaryproof);

		selsalaryproof.selectByIndex(2);
		
		Thread.sleep(1000);
		
		WebElement BankID = driver.findElement(By.id("jqg_gridtableOfChildDocumets_1"));
		
		wait.until(ExpectedConditions.visibilityOf(BankID));
		
		BankID.click();
		
		WebElement saveBankID = driver.findElement(By.id("saveChildDoc"));
		
		wait.until(ExpectedConditions.visibilityOf(saveBankID));
		
		saveBankID.click();		

		WebElement remarkthree = driver.findElement(By.id("remarkId3"));
		
		wait.until(ExpectedConditions.visibilityOf(remarkthree));
		
		remarkthree.sendKeys("Test");
		
		Thread.sleep(1000);
		
		/*-------------proof 4--------*/

		WebElement checkfour = driver.findElement(By.id("jqg_gridtableOfDocumets_4"));

		wait.until(ExpectedConditions.visibilityOf(checkfour));

		WebElement valuationreport = driver.findElement(By.id("docStatus4"));

		wait.until(ExpectedConditions.visibilityOf(valuationreport));

		Select selvaluationreport = new Select(valuationreport);

		selvaluationreport.selectByIndex(2);
		
		Thread.sleep(1000);
		
		WebElement valuationID = driver.findElement(By.id("jqg_gridtableOfChildDocumets_1"));
		
		wait.until(ExpectedConditions.visibilityOf(valuationID));
		
		valuationID.click();
		
		WebElement savevaluationID = driver.findElement(By.linkText("Update and Close"));
		
		wait.until(ExpectedConditions.visibilityOf(savevaluationID));
		
		savevaluationID.click();		

		WebElement remarkId4 = driver.findElement(By.id("remarkId4"));
		
		wait.until(ExpectedConditions.visibilityOf(remarkId4));
		
		remarkId4.sendKeys("Test");

		WebElement savebtn = driver.findElement(By.id("save"));
				
		wait.until(ExpectedConditions.visibilityOf(savebtn));
				
		savebtn.click();			
		
		Thread.sleep(200);
		
		savebtn.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);		
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
		savebtn.sendKeys(Keys.TAB);
	
		Thread.sleep(100);
		
		driver.close();
			
		Thread.sleep(200);
		
		/* --------- Return from DMS --------- */
		
		List<String> returnDMS = new ArrayList<String>(driver.getWindowHandles());
		 
		 Collections.sort(returnDMS);
		 
		 System.out.println(returnDMS);
		 
		 driver.switchTo().window(returnDMS.get(2));
		 
		 System.out.println(returnDMS.get(2));
		 
		 System.out.println(driver.getTitle());
		 
		 if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {
		 
		 driver.switchTo().window(returnDMS.get(0));
		 
		 System.out.println(driver.getTitle());
		 
		 if(driver.getTitle().equalsIgnoreCase("Finnone SSO")){
		 
		 driver.switchTo().window(returnDMS.get(1));
		 
		 System.out.println(driver.getTitle());
		 
		 }
		 
		 } else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {
		 
		 driver.switchTo().window(returnDMS.get(1));
		 
		 System.out.println(driver.getTitle());
		 
		 if(driver.getTitle().equalsIgnoreCase("Finnone CAS")){
		 
		 driver.switchTo().window(returnDMS.get(0));
		 
		 System.out.println(driver.getTitle()); 
		} 

	}
		Thread.sleep(100);
		
		/*--------- Change Stage -------------*/

		WebElement changestage = driver.findElement(By.id("apy_b0i13font"));

		wait.until(ExpectedConditions.visibilityOf(changestage));

		changestage.click();

		WebElement exit = driver.findElement(By.name("Close"));

		wait.until(ExpectedConditions.visibilityOf(exit));

		exit.click();
				
	}
}

