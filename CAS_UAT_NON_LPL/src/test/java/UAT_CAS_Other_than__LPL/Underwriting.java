package UAT_CAS_Other_than__LPL;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import org.testng.annotations.Test;
import utility.BrowserSetup;
import utility.readexcel;

public class Underwriting extends BrowserSetup{
	static String app_id;	
	static WebDriverWait wait;
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";

	@Test(dataProvider="data-provider",dataProviderClass=utility.DataProvider.class)
	public void Underwriting_CAS(String sLogin_id,String sPassword,String sArea,String First_Name,String Last_Name,String Father_Name,String Product,
			String credit_program,String Scheme,String asset_cat,String asset_make,String asset_model,String Dealer_Code,String TM_Code,String SE_Code,String Constitution,String loan_amount,
			String loan_Tennure,String first_EMI_Month,String first_EMI_Year,String Advance_EMI,String Disburse_To,String Life_Insurance) throws Throwable 
	{
		wait = new WebDriverWait(driver, 10);		
		FileInputStream fis = new FileInputStream(ApplicationIdsfilepath1); 
		  Workbook wobk = WorkbookFactory.create(fis); 
		  @SuppressWarnings("unused")
		Sheet Worksheet = wobk.getSheet("ApplicationId");
		  readexcel readXls = new readexcel(); 
		  @SuppressWarnings("rawtypes")
		List datalist = readXls.readexcelsheet();
		  for (int i = 1; i < datalist.size(); i++){ 
			  String[] test = (String[])datalist.get(i); 
			  app_id = test[1]; 
			  System.out.println(app_id);
		  }
		  
		/*-------------------------- Retail Screen ----------------------*/

		List<String> FinnoneCAS5 = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(FinnoneCAS5);

		System.out.println(FinnoneCAS5);

		driver.switchTo().window(FinnoneCAS5.get(0));

		String title5 = driver.getTitle();

		System.out.println(title5);

		if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(FinnoneCAS5.get(1));

			System.out.println(driver.getTitle());
		}


		// Screenshotpath = fn_screenshot(Screenshotpath);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameForwardToApp"));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("banner"));

		driver.switchTo().parentFrame();

		driver.switchTo().frame("contents");

		Actions move_AutoLoan1 = new Actions(driver);

		WebElement Auto_loan1 = driver.findElement(By.linkText("Auto Loan"));

		move_AutoLoan1.moveToElement(Auto_loan1).build().perform();

		WebElement Underwritingsearch = driver.findElement(By.linkText("All"));

		wait.until(ExpectedConditions.visibilityOf(Underwritingsearch));

		Underwritingsearch.click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));

		WebElement searchappId = driver.findElement(By.id("txtApplication"));

		wait.until(ExpectedConditions.visibilityOf(searchappId));

		// Excel should start

	//	searchappId.sendKeys(app_id);

		// Screenshotpath = fn_screenshot(Screenshotpath);

		Thread.sleep(1000);

		WebElement searchbtn = driver.findElement(By.name("btnSearch"));

		wait.until(ExpectedConditions.visibilityOf(searchbtn));

		searchbtn.click();

		WebElement linkappid = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[1]/a"));

		wait.until(ExpectedConditions.visibilityOf(linkappid));

		linkappid.click();

		Thread.sleep(1000);

		/*----------------------------   Underwriting Screen ----------*/

		List<String> Underwritingscreen = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(Underwritingscreen);

		System.out.println(Underwritingscreen.size());

		System.out.println(Underwritingscreen);

		driver.switchTo().window(Underwritingscreen.get(2));

		System.out.println(Underwritingscreen.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(Underwritingscreen.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Underwritingscreen.get(1));

				System.out.println(driver.getTitle());
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(Underwritingscreen.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Underwritingscreen.get(0));

				System.out.println(driver.getTitle());
			}
		}

		WebElement Creditstatus = driver.findElement(By.id("apy_b0i1text"));

		wait.until(ExpectedConditions.visibilityOf(Creditstatus));

		Creditstatus.click();
		
		Thread.sleep(1000);

		/*----------- FI Report button  -----------*/

		WebElement FIreportbutton = driver.findElement(By.name("B5"));

		wait.until(ExpectedConditions.visibilityOf(FIreportbutton));

		FIreportbutton.click();
		
		Thread.sleep(1000);
		
		/*----------- FI Report Window -----------*/

		List<String> FIreportwindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(FIreportwindow);

		System.out.println(FIreportwindow);

		driver.switchTo().window(FIreportwindow.get(3));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(FIreportwindow.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(FIreportwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

					driver.switchTo().window(FIreportwindow.get(0));

					System.out.println(driver.getTitle());
				}
			} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

				driver.switchTo().window(FIreportwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(FIreportwindow.get(1));

					System.out.println(driver.getTitle());
				}

			}

		} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

			driver.switchTo().window(FIreportwindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(FIreportwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(FIreportwindow.get(2));

				}
			} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(FIreportwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(FIreportwindow.get(2));

					System.out.println(driver.getTitle());
				}
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(FIreportwindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(FIreportwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

					driver.switchTo().window(FIreportwindow.get(2));

					System.out.println(driver.getTitle());
				}

			} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

				driver.switchTo().window(FIreportwindow.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(FIreportwindow.get(0));

					System.out.println(driver.getTitle());

				}
			}
		}

		WebElement FIcheckbox = driver.findElement(By.name("selVerify"));

		wait.until(ExpectedConditions.visibilityOf(FIcheckbox));

		FIcheckbox.click();

		WebElement saveFIreport = driver.findElement(By.name("btnSaveDraft"));

		wait.until(ExpectedConditions.visibilityOf(saveFIreport));

		saveFIreport.click();
		
		Thread.sleep(1000);

//		driver.switchTo().window(FIreportwindow.get(0));

		/*-----------------Return from FI report Window  -----------------------*/

		List<String> returnFIreportwindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returnFIreportwindow);

		System.out.println(returnFIreportwindow);

		driver.switchTo().window(returnFIreportwindow.get(2));

		System.out.println(returnFIreportwindow.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returnFIreportwindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returnFIreportwindow.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returnFIreportwindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returnFIreportwindow.get(0));

				System.out.println(driver.getTitle());
			}
		}

		Thread.sleep(1000);

		/*------ Dedupe view file ------------*/

		WebElement dedupeviewfilebtn = driver.findElement(By.xpath("//form[@name='underWriterAF']/table[16]/tbody[1]/tr[2]/td[2]/input[1]"));

		wait.until(ExpectedConditions.visibilityOf(dedupeviewfilebtn));

		dedupeviewfilebtn.click();
		
		Thread.sleep(1000);

		/*----------- Dedupe view file Window -----------*/

		List<String> dedupeviewfilewindow = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(dedupeviewfilewindow.size());

		Collections.sort(dedupeviewfilewindow);

		System.out.println(dedupeviewfilewindow);

		driver.switchTo().window(dedupeviewfilewindow.get(3));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(dedupeviewfilewindow.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(dedupeviewfilewindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

					driver.switchTo().window(dedupeviewfilewindow.get(0));

					System.out.println(driver.getTitle());
				}
			} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

				driver.switchTo().window(dedupeviewfilewindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(dedupeviewfilewindow.get(1));

					System.out.println(driver.getTitle());
				}

			}

		} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

			driver.switchTo().window(dedupeviewfilewindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(dedupeviewfilewindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(dedupeviewfilewindow.get(2));

				}
			} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(dedupeviewfilewindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(dedupeviewfilewindow.get(2));

					System.out.println(driver.getTitle());
				}
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(dedupeviewfilewindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(dedupeviewfilewindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

					driver.switchTo().window(dedupeviewfilewindow.get(2));

					System.out.println(driver.getTitle());
				}

			} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

				driver.switchTo().window(dedupeviewfilewindow.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(dedupeviewfilewindow.get(0));

					System.out.println(driver.getTitle());

				}
			}
		}

		WebElement dedupecheckbox = driver.findElement(By.name("selVerify"));

		wait.until(ExpectedConditions.visibilityOf(dedupecheckbox));

		dedupecheckbox.click();

		WebElement dedupeclosebtn = driver.findElement(By.name("btnClose"));

		wait.until(ExpectedConditions.visibilityOf(dedupeclosebtn));

		dedupeclosebtn.click();
		
		Thread.sleep(1000);

//		driver.switchTo().window(dedupeviewfilewindow.get(0));

		/*-----------------Return from Dedupe Window  -----------------------*/

		List<String> returndedupeviewfilewindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returndedupeviewfilewindow);

		System.out.println(returndedupeviewfilewindow);

		driver.switchTo().window(returndedupeviewfilewindow.get(2));

		System.out.println(returndedupeviewfilewindow.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returndedupeviewfilewindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returndedupeviewfilewindow.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returndedupeviewfilewindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returndedupeviewfilewindow.get(0));

				System.out.println(driver.getTitle());
			}
		}

		Thread.sleep(1000);

		/*------------------ Initiate Deviation ---------- */

		WebElement initiatedevbtn = driver.findElement(By.name("B16"));

		wait.until(ExpectedConditions.visibilityOf(initiatedevbtn));

		initiatedevbtn.click();

		driver.switchTo().alert().accept();

		Thread.sleep(1500);

		/*------------------ Cibil View File TWL -------------------------*/

		WebElement cibilviewfilebtn = driver.findElement(By.xpath("//form[@name='underWriterAF']/table[16]/tbody[1]/tr[3]/td[4]/input[1]"));
	
		wait.until(ExpectedConditions.visibilityOf(cibilviewfilebtn));

		cibilviewfilebtn.click();
		
		Thread.sleep(1000);

		/*------------------- Cibil window -----------------------*/

		List<String> cibilviewfilewindow = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(cibilviewfilewindow.size());

		Collections.sort(cibilviewfilewindow);

		System.out.println(cibilviewfilewindow);

		driver.switchTo().window(cibilviewfilewindow.get(3));

		System.out.println(driver.getTitle());

		if (!driver.getTitle().equalsIgnoreCase("Dedupe")) {

			driver.switchTo().window(cibilviewfilewindow.get(2));

			System.out.println(driver.getTitle());

			if (!driver.getTitle().equalsIgnoreCase("Dedupe")) {

				driver.switchTo().window(cibilviewfilewindow.get(1));

				System.out.println(driver.getTitle());

				if (!driver.getTitle().equalsIgnoreCase("Dedupe")) {

					driver.switchTo().window(cibilviewfilewindow.get(0));

					System.out.println(driver.getTitle());
				}
			}
		}

		WebElement cibilcheckbox = driver.findElement(By.name("selVerifyCibil"));

		wait.until(ExpectedConditions.visibilityOf(cibilcheckbox));

		cibilcheckbox.click();
		
		driver.close();
		
		Thread.sleep(1000);

		/*-----------------Return from Cibil Window  -----------------------*/

		List<String> returncibilviewfilewindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returncibilviewfilewindow);

		System.out.println(returncibilviewfilewindow);

		driver.switchTo().window(returncibilviewfilewindow.get(2));

		System.out.println(returncibilviewfilewindow.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returncibilviewfilewindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returncibilviewfilewindow.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returncibilviewfilewindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returncibilviewfilewindow.get(0));

				System.out.println(driver.getTitle());
			}
		}

		Thread.sleep(1000);
		
		/*------------------------ Calculate IIR ------------*/

		WebElement calculateIIRbtn = driver.findElement(By.name("BtnIRR"));

		wait.until(ExpectedConditions.visibilityOf(calculateIIRbtn));

		calculateIIRbtn.click();

		Thread.sleep(2000);

		/*----------------- Eligibilty   -------------*/

		WebElement eligibility = driver.findElement(By.xpath("//input[@value='Eligibility']"));

		wait.until(ExpectedConditions.visibilityOf(eligibility));

		eligibility.click();

		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		/*----------- Deviation Approval  ---------------*/

		WebElement devApprovalbtn = driver.findElement(By.name("devApproval"));

		wait.until(ExpectedConditions.visibilityOf(devApprovalbtn));

		devApprovalbtn.click();
		
		Thread.sleep(1000);

		/*----------- Deviation Approval Window --------- */

		List<String> devApprovalwindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(devApprovalwindow);

		System.out.println(devApprovalwindow);

		driver.switchTo().window(devApprovalwindow.get(3));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(devApprovalwindow.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(devApprovalwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

					driver.switchTo().window(devApprovalwindow.get(0));

					System.out.println(driver.getTitle());
				}
			} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

				driver.switchTo().window(devApprovalwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(devApprovalwindow.get(1));

					System.out.println(driver.getTitle());
				}

			}

		} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

			driver.switchTo().window(devApprovalwindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(devApprovalwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(devApprovalwindow.get(2));

				}
			} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(devApprovalwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(devApprovalwindow.get(2));

					System.out.println(driver.getTitle());
				}
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(devApprovalwindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(devApprovalwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

					driver.switchTo().window(devApprovalwindow.get(2));

					System.out.println(driver.getTitle());
				}

			} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

				driver.switchTo().window(devApprovalwindow.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(devApprovalwindow.get(0));

					System.out.println(driver.getTitle());

				}
			}
		}

		WebElement devstatus = driver.findElement(By.name("deviationAction"));

	//	wait.until(ExpectedConditions.visibilityOf(devstatus));
		
		if(wait.until(ExpectedConditions.visibilityOf(devstatus)).isDisplayed()==true){
			
		Select seldevstatus = new Select(devstatus);

		seldevstatus.selectByIndex(1);

		WebElement approvebtn = driver.findElement(By.name("btnApprove"));

		wait.until(ExpectedConditions.visibilityOf(approvebtn));

		approvebtn.click();
		
		}
		else{
			System.out.println("Decision box is not available");
		}
		WebElement closebtndev = driver.findElement(By.name("btnReject"));

		wait.until(ExpectedConditions.visibilityOf(closebtndev));

		closebtndev.click();
		
		Thread.sleep(1000);

		/*-----------------Return from deviation Window  -----------------------*/

		List<String> returndeviationwindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returndeviationwindow);

		System.out.println(returndeviationwindow);

		driver.switchTo().window(returndeviationwindow.get(2));

		System.out.println(returndeviationwindow.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returndeviationwindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returndeviationwindow.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returndeviationwindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returndeviationwindow.get(0));

				System.out.println(driver.getTitle());
			}
		}
		
		Thread.sleep(1000);

		/*--------------  Mitigants   ------------*/

		WebElement selMitigants = driver.findElement(By.id("selMitigants"));

		wait.until(ExpectedConditions.visibilityOf(selMitigants));

		selMitigants.sendKeys("Good income");

		Thread.sleep(2000);

		selMitigants.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement addtolist = driver.findElement(By.name("btnSelMitigant"));

		wait.until(ExpectedConditions.visibilityOf(addtolist));

		addtolist.click();

		/*---------- Underwriter Checklist ----------*/

		WebElement btnQuestion = driver.findElement(By.name("btnQuestion"));

		wait.until(ExpectedConditions.visibilityOf(btnQuestion));

		btnQuestion.click();

		WebElement Underwritingchecklist = driver.findElement(By.name("devApproval"));

		wait.until(ExpectedConditions.visibilityOf(Underwritingchecklist));

		Underwritingchecklist.click();
		
		Thread.sleep(1000);

		/*------------------ Underwriting CheckList window ------------- */

		List<String> Underwritingchecklistwindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(Underwritingchecklistwindow);

		System.out.println(Underwritingchecklistwindow);

		driver.switchTo().window(Underwritingchecklistwindow.get(3));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(Underwritingchecklistwindow.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Underwritingchecklistwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

					driver.switchTo().window(Underwritingchecklistwindow.get(0));

					System.out.println(driver.getTitle());
				}
			} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

				driver.switchTo().window(Underwritingchecklistwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(Underwritingchecklistwindow.get(1));

					System.out.println(driver.getTitle());
				}
			}

		} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

			driver.switchTo().window(Underwritingchecklistwindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Underwritingchecklistwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(Underwritingchecklistwindow.get(2));

				}
			} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Underwritingchecklistwindow.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(Underwritingchecklistwindow.get(2));

					System.out.println(driver.getTitle());
				}
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(Underwritingchecklistwindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Underwritingchecklistwindow.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

					driver.switchTo().window(Underwritingchecklistwindow.get(2));

					System.out.println(driver.getTitle());
				}

			} else if (driver.getTitle().equalsIgnoreCase("UnderWriter")) {

				driver.switchTo().window(Underwritingchecklistwindow.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(Underwritingchecklistwindow.get(0));

					System.out.println(driver.getTitle());

				}
			}
		}

		WebElement selResponse1 = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[1]/td[3]/font[1]/Select[1]"));

//		wait.until(ExpectedConditions.visibilityOf(selResponse1));
		
		if(wait.until(ExpectedConditions.visibilityOf(selResponse1)).isDisplayed()==true){
			
		Select SelResponse1 = new Select(selResponse1);

		SelResponse1.selectByIndex(3);

		WebElement selResponse2 = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[3]/font[1]/Select[1]"));

		wait.until(ExpectedConditions.visibilityOf(selResponse2));

		Select SelResponse2 = new Select(selResponse2);

		SelResponse2.selectByIndex(3);

		WebElement selResponse3 = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[3]/td[3]/font[1]/Select[1]"));

		wait.until(ExpectedConditions.visibilityOf(selResponse3));

		Select SelResponse3 = new Select(selResponse3);

		SelResponse3.selectByIndex(3);

		WebElement selResponse4 = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[4]/td[3]/font[1]/Select[1]"));

		wait.until(ExpectedConditions.visibilityOf(selResponse4));

		Select SelResponse4 = new Select(selResponse4);

		SelResponse4.selectByIndex(3);

		WebElement selResponse5 = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[5]/td[3]/font[1]/Select[1]"));

		wait.until(ExpectedConditions.visibilityOf(selResponse5));

		Select SelResponse5 = new Select(selResponse5);

		SelResponse5.selectByIndex(3);

		WebElement selResponse6 = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[6]/td[3]/font[1]/Select[1]"));

		wait.until(ExpectedConditions.visibilityOf(selResponse6));

		Select SelResponse6 = new Select(selResponse6);

		SelResponse6.selectByIndex(3);

		WebElement btnsave = driver.findElement(By.name("btnSave"));

		wait.until(ExpectedConditions.visibilityOf(btnsave));

		btnsave.click();

		}
		else{
			System.out.println("Underwriting questionaire is not available");
		}
		
		WebElement btnclose = driver.findElement(By.name("btnClose"));

		wait.until(ExpectedConditions.visibilityOf(btnclose));

		btnclose.click();
		
		Thread.sleep(1000);

	//	driver.switchTo().window(devApprovalwindow.get(0));

		/*----------- Return from underwriting checklist ----------*/

		List<String> returnunderwritingwindow = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returnunderwritingwindow);

		System.out.println(returnunderwritingwindow);

		driver.switchTo().window(returnunderwritingwindow.get(2));

		System.out.println(returnunderwritingwindow.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(returnunderwritingwindow.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(returnunderwritingwindow.get(1));

				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(returnunderwritingwindow.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(returnunderwritingwindow.get(0));

				System.out.println(driver.getTitle());
			}
		}

		/*--------- Decision -------------*/

		WebElement selDecision = driver.findElement(By.id("selDecision"));

		wait.until(ExpectedConditions.visibilityOf(selDecision));

		Select selDecisiondd = new Select(selDecision);

		selDecisiondd.selectByIndex(1);

		/*---------------  Reason Code  -------------- */

		WebElement reasoncode = driver.findElement(By.id("selApplicationReasonCode"));

		wait.until(ExpectedConditions.visibilityOf(reasoncode));

		reasoncode.sendKeys("Qualitative / Others reasons");

		Thread.sleep(2000);

		reasoncode.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		/*---------- Reason Description ----------*/

		WebElement txtApplicationReasonDesc = driver.findElement(By.id("txtApplicationReasonDesc"));

		wait.until(ExpectedConditions.visibilityOf(txtApplicationReasonDesc));

		txtApplicationReasonDesc.sendKeys("Test reason");

		driver.findElement(By.name("btnAddList")).click();

		/*-----------Convenant Code ----------*/

		WebElement txtSpecialCovenantCode = driver.findElement(By.id("txtSpecialCovenantCode"));

		wait.until(ExpectedConditions.visibilityOf(txtSpecialCovenantCode));

		txtSpecialCovenantCode.sendKeys("Others");

		Thread.sleep(2000);

		txtSpecialCovenantCode.sendKeys(Keys.TAB);

		Thread.sleep(2000);

		WebElement txtApplicationCovenantComent = driver.findElement(By.name("txtApplicationCovenantComent"));

		wait.until(ExpectedConditions.visibilityOf(txtApplicationCovenantComent));

		txtApplicationCovenantComent.sendKeys("Test Comment");

		WebElement addtolist1 = driver.findElement(By.name("btnAddList1"));

		wait.until(ExpectedConditions.visibilityOf(addtolist1));

		addtolist1.click();

		/*--------------------- Password -------------*/

		WebElement pwd = driver.findElement(By.name("value2"));

		wait.until(ExpectedConditions.visibilityOf(pwd));

		pwd.sendKeys(sPassword);

		Thread.sleep(1000);

		WebElement saveandproceed = driver.findElement(By.name("btnSave"));

		wait.until(ExpectedConditions.visibilityOf(saveandproceed));

		saveandproceed.click();

		Thread.sleep(10000);

		WebElement exit = driver.findElement(By.name("Close"));

		wait.until(ExpectedConditions.visibilityOf(exit));

		exit.click();
	}


	
	
	
	
}
