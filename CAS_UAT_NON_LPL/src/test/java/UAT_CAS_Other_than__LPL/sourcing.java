package UAT_CAS_Other_than__LPL;

import utility.BrowserSetup;
import utility.readexcel;
import utility.readexcel_save_applicationid;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sourcing extends BrowserSetup{

	// static String Screenshotpath = "C:\\Automation_Softwares\\eclipse\\Workspace\\CAS_UAT_NON_LPL\\Results\\";
	// static String TS;
	static String Row_No;	
	static int rownumber;
	static String Row_No1;	
	static int rownumber1;
	static String app_id;	
	static WebDriverWait wait;	
	static String ApplicationIdsfilepath = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";
	static String ApplicationIdsfilepath2 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\Saved_Application_ids.xlsx";
	
	
	@Test(dataProvider="data-provider",dataProviderClass=utility.DataProvider.class)
	public void Sourcing_CAS(String sLogin_id,String sPassword,String sArea,String First_Name,String Last_Name,String Father_Name,String Product,
			String credit_program,String Scheme,String asset_cat,String asset_make,String asset_model,String Dealer_Code,String TM_Code,String SE_Code,String Constitution,String loan_amount,
			String loan_Tennure,String first_EMI_Month,String first_EMI_Year,String Advance_EMI,String Disburse_To,String Life_Insurance) throws Exception {
	  
	/*---------------------------------- Finnone Application Main Screen ------------------------*/
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 10);
		try{

		List<String> browsertabs = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(browsertabs);

		driver.switchTo().window(browsertabs.get(0));

		driver.findElement(By.name("TxtUID")).sendKeys(sLogin_id);

		driver.findElement(By.name("TxtPWD")).sendKeys(sPassword);

		driver.findElement(By.name("DataAction")).click();		
		
		if(driver.switchTo().alert().getText().equalsIgnoreCase("User ID is already logged-in.")){
			
			driver.switchTo().alert().accept();
			
			if(driver.switchTo().alert().getText().equalsIgnoreCase("User ID is already logged-in. Wish to Re-Login?")){
				
				driver.switchTo().alert().accept();
				
				List<String> relogin = new ArrayList<String>(driver.getWindowHandles());

				System.out.println(relogin);

				driver.switchTo().window(relogin.get(0));

				driver.findElement(By.name("TxtUID")).sendKeys(sLogin_id);

				driver.findElement(By.name("TxtPWD")).sendKeys(sPassword);

				driver.findElement(By.name("DataAction")).click();
				}
			}				
	try {
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {

				String alertmessage = driver.switchTo().alert().getText();

				System.out.println(alertmessage);
				
				driver.switchTo().alert().accept();

			}
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		// Screenshotpath = fn_screenshot(Screenshotpath);

		driver.findElement(By.name("btnCAS")).click();

		driver.switchTo().window(browsertabs.get(0));

		/*---------------------------------- CAS SCREEN  ------------------------*/

		// Screenshotpath = fn_screenshot(Screenshotpath);

		List<String> FinnoneCAS = new ArrayList<String>(driver.getWindowHandles());
		
		Collections.sort(FinnoneCAS);

		System.out.println(FinnoneCAS);

		driver.switchTo().window(FinnoneCAS.get(0));

		String title = driver.getTitle();

		System.out.println(title);

		if (title.equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(FinnoneCAS.get(1));

			System.out.println(driver.getTitle());
		}

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameForwardToApp"));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("banner"));

		WebElement areasection = driver.findElement(By.id("selBranch"));

		areasection.clear();

		Thread.sleep(1000);

		areasection.sendKeys(sArea);

		areasection.sendKeys(Keys.TAB);

		/*----------------- Branch Search window --------------*/

		List<String> branch_search = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(branch_search.size());

		Collections.sort(branch_search);

		System.out.println(branch_search);

		driver.switchTo().window(branch_search.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(branch_search.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(branch_search.get(0));

				System.out.println(driver.getTitle());
			}
		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(branch_search.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(branch_search.get(1));

				System.out.println(driver.getTitle());
			}
		}

		WebElement branchsearchcriteriaGo = driver.findElement(By.name("B1"));

		wait.until(ExpectedConditions.visibilityOf(branchsearchcriteriaGo));

		branchsearchcriteriaGo.click();

		driver.switchTo().window(branch_search.get(0));
	
		/*------------- Return from Branch Search window ------------ */

		List<String> return_branch_window = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(return_branch_window);

		System.out.println(return_branch_window);

		driver.switchTo().window(return_branch_window.get(0));

		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(return_branch_window.get(1));

			System.out.println(driver.getTitle());
		}
		// Screenshotpath = fn_screenshot(Screenshotpath);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameForwardToApp"));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("banner"));

		driver.switchTo().parentFrame();

		driver.switchTo().frame("contents");

		Actions move_to_AutoLoan = new Actions(driver);

		WebElement Autoloan = driver.findElement(By.linkText("Auto Loan"));

		move_to_AutoLoan.moveToElement(Autoloan).build().perform();

		WebElement newapplication = driver.findElement(By.linkText("New Application"));

		move_to_AutoLoan.moveToElement(newapplication).click().build().perform();

		driver.switchTo().window(FinnoneCAS.get(0));

		System.out.println(FinnoneCAS.get(0));

		/*---------------------------------- QDE SOURCING ------------------------ */

		List<String> QDEScreentabs = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(QDEScreentabs);

		System.out.println(QDEScreentabs);

		driver.switchTo().window(QDEScreentabs.get(2));

		System.out.println(QDEScreentabs.get(2));

		String title1 = driver.getTitle();

		System.out.println(title1);

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(QDEScreentabs.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(QDEScreentabs.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(QDEScreentabs.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(QDEScreentabs.get(0));

				System.out.println(driver.getTitle());
			}
		}

		// Screenshotpath = fn_screenshot(Screenshotpath);

		WebElement Locationcode = driver.findElement(By.id("txtSourcingBranch"));

		wait.until(ExpectedConditions.visibilityOf(Locationcode));

		Locationcode.click();

		Locationcode.sendKeys("Delhi");

		Locationcode.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement products = driver.findElement(By.id("selProductId"));

		wait.until(ExpectedConditions.visibilityOf(products));

		Select selectproduct = new Select(products);
		
		selectproduct.selectByVisibleText(Product);
	
		WebElement creditprogram = driver.findElement(By.id("selSchemeGroupDesc"));

		wait.until(ExpectedConditions.visibilityOf(creditprogram));
		
		creditprogram.sendKeys(credit_program);
		
		Thread.sleep(1000);
		
		creditprogram.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement schemes = driver.findElement(By.id("selSchemeDesc"));

		wait.until(ExpectedConditions.visibilityOf(schemes));
		
		schemes.sendKeys(Scheme);
		
		Thread.sleep(1000);

		schemes.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement assetcat = driver.findElement(By.id("selAssetCat"));

		wait.until(ExpectedConditions.visibilityOf(assetcat));

		assetcat.sendKeys(asset_cat);

		Thread.sleep(2000);

		assetcat.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement assetmake = driver.findElement(By.id("selAssetMake"));

		assetmake.sendKeys(asset_make);

		Thread.sleep(2000);

		assetmake.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement assetmodel = driver.findElement(By.id("selAssetModel"));

		assetmodel.sendKeys(asset_model);

		Thread.sleep(2000);

		assetmodel.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement dealercode = driver.findElement(By.id("selDealerCode"));
		
		wait.until(ExpectedConditions.visibilityOf(dealercode));
	
		dealercode.sendKeys(Dealer_Code);

		Thread.sleep(2000);

		dealercode.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement TMcode = driver.findElement(By.id("selTMCode"));

		TMcode.sendKeys(TM_Code);

		TMcode.sendKeys(Keys.TAB);

		WebElement SEcode = driver.findElement(By.id("selSECode"));

		SEcode.sendKeys(SE_Code);

		Thread.sleep(2000);

		SEcode.sendKeys(Keys.TAB);

		// Screenshotpath = fn_screenshot(Screenshotpath);

		Thread.sleep(3000);

		driver.findElement(By.name("DataAction")).click();

		/*---------------------------------- QDE APPLICANT ------------------------ */

		Thread.sleep(3500);

		// Screenshotpath = fn_screenshot(Screenshotpath);

		WebElement applicationid = driver.findElement(By.className("WIDTH_20"));

		wait.until(ExpectedConditions.visibilityOf(applicationid));

		String app_idwithspace = applicationid.getText();
		
		app_id = app_idwithspace.replaceAll("\\s+","");

		System.out.println(app_id);

		updateApplicationIdExcel();
		
		Thread.sleep(500);
		
		SaveApplicationIdExcel();
		
		Thread.sleep(1000);

		WebElement selcontitution = driver.findElement(By.id("selConstitutionID"));

		wait.until(ExpectedConditions.visibilityOf(selcontitution));
		
		if(Constitution.equalsIgnoreCase("Staff")){
			
			selcontitution.sendKeys("Staff");
			
		}else if(Constitution.equalsIgnoreCase("INDIVIDUAL")){
			
			selcontitution.sendKeys("INDIVIDUAL");
		}

		Thread.sleep(1000);

		selcontitution.sendKeys(Keys.TAB);

		Thread.sleep(1000);

		/* ----------- Constitution Window ------------------------- */

		List<String> Constitutionwindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(Constitutionwindow);

		System.out.println(Constitutionwindow);

		driver.switchTo().window(Constitutionwindow.get(3));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(Constitutionwindow.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Constitutionwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Personal")) {

					driver.switchTo().window(Constitutionwindow.get(0));

					System.out.println(driver.getTitle());
				}
			} else if (driver.getTitle().equalsIgnoreCase("Personal")) {

				driver.switchTo().window(Constitutionwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(Constitutionwindow.get(1));

					System.out.println(driver.getTitle());
				}

			}

		} else if (driver.getTitle().equalsIgnoreCase("Personal")) {

			driver.switchTo().window(Constitutionwindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Constitutionwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(Constitutionwindow.get(2));

				}
			} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Constitutionwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(Constitutionwindow.get(2));

					System.out.println(driver.getTitle());
				}
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(Constitutionwindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Constitutionwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Personal")) {

					driver.switchTo().window(Constitutionwindow.get(2));

					System.out.println(driver.getTitle());
				}

			} else if (driver.getTitle().equalsIgnoreCase("Personal")) {

				driver.switchTo().window(Constitutionwindow.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(Constitutionwindow.get(0));

					System.out.println(driver.getTitle());

				}
			}
		}

		WebElement searchcriteriaGo = driver.findElement(By.name("B1"));

		wait.until(ExpectedConditions.visibilityOf(searchcriteriaGo));

		searchcriteriaGo.click();
		
		Thread.sleep(1000);

	//	driver.switchTo().window(Constitutionwindow.get(0));
		
		/*-----------------Return from Constitution Window  ----------------------- */

		List<String> returnConstitutionwindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returnConstitutionwindow);

		System.out.println(returnConstitutionwindow);

		driver.switchTo().window(returnConstitutionwindow.get(2));

		System.out.println(returnConstitutionwindow.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returnConstitutionwindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returnConstitutionwindow.get(1));

				System.out.println(driver.getTitle());
			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returnConstitutionwindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returnConstitutionwindow.get(0));

				System.out.println(driver.getTitle());
			}
		}

		/*------------ Select Category -------------- */

		WebElement selCat = driver.findElement(By.id("selCategory"));

		wait.until(ExpectedConditions.visibilityOf(selCat));

		selCat.sendKeys("SALARIED");

		Thread.sleep(1000);

		selCat.sendKeys(Keys.TAB);

		Thread.sleep(1000);

		/*------------ Category Window ---------------------------------- */

		List<String> Catergorywindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(Catergorywindow);

		System.out.println(Catergorywindow);

		driver.switchTo().window(Catergorywindow.get(3));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(Catergorywindow.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Catergorywindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Personal")) {

					driver.switchTo().window(Catergorywindow.get(0));

					System.out.println(driver.getTitle());
				}
			} else if (driver.getTitle().equalsIgnoreCase("Personal")) {

				driver.switchTo().window(Catergorywindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(Catergorywindow.get(1));

					System.out.println(driver.getTitle());
				}

			}

		} else if (driver.getTitle().equalsIgnoreCase("Personal")) {

			driver.switchTo().window(Catergorywindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Catergorywindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(Catergorywindow.get(2));

				}
			} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Catergorywindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(Catergorywindow.get(2));

					System.out.println(driver.getTitle());
				}
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(Catergorywindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Catergorywindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Personal")) {

					driver.switchTo().window(Catergorywindow.get(2));

					System.out.println(driver.getTitle());
				}

			} else if (driver.getTitle().equalsIgnoreCase("Personal")) {

				driver.switchTo().window(Catergorywindow.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(Catergorywindow.get(0));

					System.out.println(driver.getTitle());

				}
			}
		}

		WebElement searchcriteriaGo1 = driver.findElement(By.name("B1"));

		wait.until(ExpectedConditions.visibilityOf(searchcriteriaGo1));

		searchcriteriaGo1.click();
		
		Thread.sleep(2000);

		// driver.switchTo().window(Catergorywindow.get(0));

		/*-----------------Return from Catergory Window  -----------------------*/

		List<String> returnCatergorywindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returnCatergorywindow);

		System.out.println(returnCatergorywindow);

		driver.switchTo().window(returnCatergorywindow.get(2));

		System.out.println(returnCatergorywindow.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returnCatergorywindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returnCatergorywindow.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returnCatergorywindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returnCatergorywindow.get(0));

				System.out.println(driver.getTitle());
			}
		}

		WebElement seltitle = driver.findElement(By.id("selTitle"));

		wait.until(ExpectedConditions.visibilityOf(seltitle));

		Select sel = new Select(seltitle);

		sel.selectByIndex(1);

		WebElement fname = driver.findElement(By.id("txtFName"));

		wait.until(ExpectedConditions.visibilityOf(fname));

		fname.sendKeys(First_Name);

		WebElement lname = driver.findElement(By.id("txtLName"));

		wait.until(ExpectedConditions.visibilityOf(lname));

		lname.sendKeys(Last_Name);

		WebElement DOB = driver.findElement(By.id("txtDob"));

		wait.until(ExpectedConditions.visibilityOf(DOB));

		DOB.sendKeys("13/03/1987");

		WebElement fathername = driver.findElement(By.id("txtFatherName"));

		wait.until(ExpectedConditions.visibilityOf(fathername));

		fathername.sendKeys(Father_Name);

		WebElement selmaritial = driver.findElement(By.id("selMaritalStatus"));

		Select sel_maritial_status = new Select(selmaritial);

		sel_maritial_status.selectByIndex(2);

		WebElement Panno = driver.findElement(By.id("txtTINNo"));

		wait.until(ExpectedConditions.visibilityOf(Panno));

		Panno.sendKeys("AUTPO2796K");

		driver.findElement(By.name("txtLoanAmount")).sendKeys(loan_amount);

		driver.findElement(By.id("txtRequestedTerm")).sendKeys(loan_Tennure);

		WebElement seladdress = driver.findElement(By.id("selAddressType"));

		wait.until(ExpectedConditions.visibilityOf(seladdress));

		Select seladdresstype = new Select(seladdress);

		seladdresstype.selectByIndex(1);

		WebElement selresidence = driver.findElement(By.id("selResidenceType"));

		wait.until(ExpectedConditions.visibilityOf(selresidence));

		Select selresidencetype = new Select(selresidence);

		selresidencetype.selectByIndex(5);

		WebElement addressone = driver.findElement(By.id("txtAddressOne"));

		wait.until(ExpectedConditions.visibilityOf(addressone));

		addressone.sendKeys("Test address");

		WebElement selstate = driver.findElement(By.id("selState"));

		wait.until(ExpectedConditions.visibilityOf(selstate));

		selstate.sendKeys("Delhi");

		Thread.sleep(2000);

		selstate.sendKeys(Keys.TAB);

		Thread.sleep(4000);

		WebElement city = driver.findElement(By.id("txtCity"));

		city.sendKeys("Delhi");

		city.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement zipcode = driver.findElement(By.id("txtZip"));

		zipcode.sendKeys("110029");

		zipcode.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);

		WebElement mobile = driver.findElement(By.id("txtMobile"));

		mobile.sendKeys("9000000000");
		
		Thread.sleep(1000);

		driver.findElement(By.id("txtLandmark")).sendKeys("Test Landmark");

		Thread.sleep(1000);

		driver.findElement(By.id("txtAddYear")).sendKeys("6");

		driver.findElement(By.id("txtAddMonth")).sendKeys("0");

		WebElement mailing = driver.findElement(By.id("selMailingAddress"));

		Select selmailingaddress = new Select(mailing);

		selmailingaddress.selectByIndex(1);

		driver.findElement(By.id("txtYearInCity")).sendKeys("6");

		driver.findElement(By.id("txtMonthInCity")).sendKeys("0");

		Thread.sleep(2000);

		// Screenshotpath = fn_screenshot(Screenshotpath);

		// Thread.sleep(2000);

		driver.findElement(By.name("btnAdd")).click();

		/*-------------------------- Income And Liability Tab ------------ */

		Thread.sleep(3000);

		// Screenshotpath = fn_screenshot(Screenshotpath);

		// Thread.sleep(1000);

		WebElement Incometab = driver.findElement(By.id("apy_b1i2text"));

		wait.until(ExpectedConditions.visibilityOf(Incometab));

		Incometab.click();

		WebElement incomesal = driver.findElement(By.id("selIncomeSalHead"));

		wait.until(ExpectedConditions.visibilityOf(incomesal));

		incomesal.sendKeys("Others");

		incomesal.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement amount = driver.findElement(By.id("txtIncomeTotalAmount"));

		wait.until(ExpectedConditions.visibilityOf(amount));

		amount.sendKeys("70000");

		driver.findElement(By.name("btnAddIncome")).click();

		Thread.sleep(2000);

		/* --------- Change Stage ---------------- */

		WebElement changestate = driver.findElement(By.id("apy_b0i3text"));

		wait.until(ExpectedConditions.visibilityOf(changestate));

		changestate.click();

		// Screenshotpath = fn_screenshot(Screenshotpath);

		WebElement exit = driver.findElement(By.name("Close"));

		wait.until(ExpectedConditions.visibilityOf(exit));

		exit.click();
	
			}catch (NoSuchWindowException e) {
				e.getMessage();	
			}
	//	extent.endTest(logger);
}

	/*
	 * @SuppressWarnings("unused") 
	 * private static String fn_screenshot(String Screenshotpath) throws IOException { 
	 * String TS = fn_GetTimeStamp();
	 * TakesScreenshot TSS = (TakesScreenshot) driver; 
	 * File srcfileObj =TSS.getScreenshotAs(OutputType.FILE); 
	 * FileUtils.copyFile(srcfileObj, new File(Screenshotpath + TS + "_" + ".png")); 
	 * return Screenshotpath;
	 *  }
	 * 
	 * private static String fn_GetTimeStamp() { 
	 * DateFormat DF = DateFormat.getDateTimeInstance(); 
	 * Date dte = new Date(); 
	 * String DateValue = DF.format(dte); 
	 * DateValue = DateValue.replaceAll(":", "_"); 
	 * DateValue = DateValue.replaceAll(",", "");
	 *  return DateValue; 
	 *  }
	 */
	
	  @SuppressWarnings("rawtypes")
	public static void updateApplicationIdExcel() throws Exception {
		  
	  FileInputStream fis = new FileInputStream(ApplicationIdsfilepath); 
		Workbook wobk = WorkbookFactory.create(fis);
		Sheet Worksheet = wobk.getSheet("ApplicationId");
		readexcel readXls = new readexcel();
		List datalist = readXls.readexcelsheet();
		for (int i = 0; i < datalist.size(); i++) {
	         String[] test = (String[]) datalist.get(i);
	          Row_No = test[1];
	         
		}
		 try{ 
	         rownumber =  Integer.parseInt(Row_No); 
	       }catch(NumberFormatException ex){
	    	 
	       }
		Row rowobj = Worksheet.getRow(1);
		if (rowobj == null) {
			rowobj = Worksheet.createRow(1);
		}		
		Cell celobj = rowobj.getCell(0);
		celobj = rowobj.createCell(0);
		celobj.setCellValue(app_id);
		FileOutputStream fout = new FileOutputStream(ApplicationIdsfilepath);
		wobk.write(fout);
		fout.close();
		}
	  
	  public static void SaveApplicationIdExcel() throws Exception {
		  
		  FileInputStream fis = new FileInputStream(ApplicationIdsfilepath2); 
			Workbook wobk = WorkbookFactory.create(fis);
			Sheet Worksheet = wobk.getSheet("ApplicationId");
			int lastrow = Worksheet.getLastRowNum();
			readexcel_save_applicationid readsaveappids = new readexcel_save_applicationid();
			@SuppressWarnings("rawtypes")
			List datalist1 = readsaveappids.readexcelsheet();
			for (int i = 0; i < datalist1.size(); i++) {
		         String[] test = (String[]) datalist1.get(i);
		          Row_No1 = test[1];
		         
			}
			 try{ 
		         rownumber1 =  Integer.parseInt(Row_No1); 
		       }catch(NumberFormatException ex){
		    	 
		       }
			Row rowobj = Worksheet.getRow(lastrow);
			if (rowobj == null) {
				rowobj = Worksheet.createRow(lastrow);
			}
			else if (rowobj != null) {
				lastrow = lastrow + 1;
				rowobj = Worksheet.createRow(lastrow);
			}
			
			Cell celobj = rowobj.getCell(0);
			celobj = rowobj.createCell(0);
			celobj.setCellValue(app_id);
			FileOutputStream fout = new FileOutputStream(ApplicationIdsfilepath2);
			wobk.write(fout);
			fout.close();
			}
	  
	  
}
	