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

public class PDOC extends BrowserSetup{

	WebDriverWait wait;
	static String app_id;	
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";

	@Test
	public void PDOCDetails() throws Throwable {

//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

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
		// Screenshotpath = fn_screenshot(Screenshotpath);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameForwardToApp"));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("banner"));

		driver.switchTo().parentFrame();

		driver.switchTo().frame("contents");

		Actions move_AutoLoan1 = new Actions(driver);

		WebElement Auto_loan1 = driver.findElement(By.linkText("Auto Loan"));

		move_AutoLoan1.moveToElement(Auto_loan1).build().perform();

		WebElement PDOCsearch = driver.findElement(By.linkText("All"));

		wait.until(ExpectedConditions.visibilityOf(PDOCsearch));

		PDOCsearch.click();

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

		driver.switchTo().window(FinnoneCAS1.get(0));

		System.out.println(driver.getTitle());

		/*------------------- PDOC ----------------*/

		List<String> Pdocscreen = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(Pdocscreen);

		System.out.println(Pdocscreen);

		driver.switchTo().window(Pdocscreen.get(2));

		System.out.println(Pdocscreen.get(2));

		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(Pdocscreen.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Pdocscreen.get(1));
			
				System.out.println(driver.getTitle());

			}

		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(Pdocscreen.get(1));

			System.out.println(driver.getTitle());
			
			

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Pdocscreen.get(0));
				
				System.out.println(driver.getTitle());
			}
		}
		
		/* ----------------- Loan Details ------------*/
		
		WebElement savebutton = driver.findElement(By.name("btnSave"));
		 
		 wait.until(ExpectedConditions.visibilityOf(savebutton));
		 
		 savebutton.click();
		 

		WebElement chargesbutton = driver.findElement(By.name("btnFeeCharge"));

		wait.until(ExpectedConditions.visibilityOf(chargesbutton));

		chargesbutton.click();

		Thread.sleep(1000);

		/*---------------------------- Charges Details window ---------------------------*/

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

		driver.switchTo().window(chargeswindow.get(0));

		/*-----------------Return from Charges Details Window  -----------------------*/

		List<String> returnchargesdetails = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(returnchargesdetails);

		System.out.println(returnchargesdetails);

		driver.switchTo().window(returnchargesdetails.get(2));

		System.out.println(returnchargesdetails.get(2));

		System.out.println(driver.getTitle());

		if (!driver.getTitle().equalsIgnoreCase("Loan Details")) {

			driver.switchTo().window(returnchargesdetails.get(1));

			System.out.println(driver.getTitle());

			if (!driver.getTitle().equalsIgnoreCase("Loan Details")) {

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

//		driver.switchTo().window(repaymentwindow.get(0));
		
		Thread.sleep(1000);

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

		Thread.sleep(2000);
		
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

		WebElement Split_payment = driver.findElement(By.id("txtSplitDetails1"));
		
		wait.until(ExpectedConditions.visibilityOf(Split_payment));
		
		Split_payment.click();
		
		Thread.sleep(2000);
		
		/*----------- Split Payment ------------- */
		
		List<String> Splitdisbursalpaymentwindow = new ArrayList<String>(driver.getWindowHandles());
		
		System.out.println(Splitdisbursalpaymentwindow.size());
		
		System.out.println(Splitdisbursalpaymentwindow);
		
		driver.switchTo().window(Splitdisbursalpaymentwindow.get(4));
		
		System.out.println(Splitdisbursalpaymentwindow.get(4));
		
		System.out.println(driver.getTitle());

		if (!driver.getTitle().equalsIgnoreCase("Split/Disbursal Payment Details")) {

			driver.switchTo().window(Splitdisbursalpaymentwindow.get(3));

			System.out.println(driver.getTitle());
			
			if(!driver.getTitle().equalsIgnoreCase("Split/Disbursal Payment Details")){
				
				driver.switchTo().window(Splitdisbursalpaymentwindow.get(2));

				System.out.println(driver.getTitle());
				
				if(!driver.getTitle().equalsIgnoreCase("Split/Disbursal Payment Details")){
					
					driver.switchTo().window(Splitdisbursalpaymentwindow.get(1));

					System.out.println(driver.getTitle());				
				
				if(!driver.getTitle().equalsIgnoreCase("Split/Disbursal Payment Details")){
					
					driver.switchTo().window(Splitdisbursalpaymentwindow.get(0));

					System.out.println(driver.getTitle());
					
						}
					}
				}					
			}
		
			WebElement disbursalTo = driver.findElement(By.id("txtBpType"));
			
			wait.until(ExpectedConditions.visibilityOf(disbursalTo));
			
			Select SeldisbursalTo = new Select(disbursalTo);
			
			SeldisbursalTo.selectByIndex(3);
			
			WebElement FTMode = driver.findElement(By.id("FTMode"));
			
			wait.until(ExpectedConditions.visibilityOf(FTMode));
			
			Select SelFTMode = new Select(FTMode);
			
			SelFTMode.selectByIndex(1);
			
			WebElement cashAccount = driver.findElement(By.id("cashAccount"));
			
			wait.until(ExpectedConditions.visibilityOf(cashAccount));
			
			Select SelcashAccount = new Select(cashAccount);
			
			SelcashAccount.selectByIndex(1);
			
			WebElement accountNo = driver.findElement(By.name("accountNo"));
			
			accountNo.sendKeys("123455667");
			
			WebElement btnAdd = driver.findElement(By.name("btnAdd"));
			
			wait.until(ExpectedConditions.visibilityOf(btnAdd));
			
			btnAdd.click();
			
			Thread.sleep(1000);
			
			WebElement btnPayDetailsClose = driver.findElement(By.name("btnPayDetailsClose"));
			
			wait.until(ExpectedConditions.visibilityOf(btnPayDetailsClose));
			
			btnPayDetailsClose.click();
			
			Thread.sleep(2000);
			
			/*-------------- Return from Split / Disbursal Payment window ------------- */
			
			
			List<String> returnSplitdisbursalpaymentwindow = new ArrayList<String>(driver.getWindowHandles());
			
			System.out.println(returnSplitdisbursalpaymentwindow.size());
			
			System.out.println(returnSplitdisbursalpaymentwindow);
			
			driver.switchTo().window(returnSplitdisbursalpaymentwindow.get(3));
			
			System.out.println(returnSplitdisbursalpaymentwindow.get(3));
			
			System.out.println(driver.getTitle());
			
				if(!driver.getTitle().equalsIgnoreCase("Split Disbursal")){
					
					driver.switchTo().window(returnSplitdisbursalpaymentwindow.get(2));

					System.out.println(driver.getTitle());
					
					if(!driver.getTitle().equalsIgnoreCase("Split Disbursal")){
						
						driver.switchTo().window(returnSplitdisbursalpaymentwindow.get(1));

						System.out.println(driver.getTitle());				
					
					if(!driver.getTitle().equalsIgnoreCase("Split Disbursal")){
						
						driver.switchTo().window(returnSplitdisbursalpaymentwindow.get(0));

						System.out.println(driver.getTitle());
						
							}
						}
					}
			
				WebElement btnSplitMultDisbClose = driver.findElement(By.name("btnSplitMultDisbClose"));
			
				wait.until(ExpectedConditions.visibilityOf(btnSplitMultDisbClose));
				
				btnSplitMultDisbClose.click();
				
				Thread.sleep(2000);
				
				/*------------------ Return from Split Disbursal ---------- */
				
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

				WebElement Insutrumentdetails = driver.findElement(By.id("apy_b0i2text"));

				wait.until(ExpectedConditions.visibilityOf(Insutrumentdetails));

				Insutrumentdetails.click();
				
				WebElement selInstrument = driver.findElement(By.id("selInstrument"));
				
				wait.until(ExpectedConditions.visibilityOf(selInstrument));
				
				Select selectInstrument = new Select(selInstrument);
				
				selectInstrument.selectByIndex(4);
							
				WebElement city_name = driver.findElement(By.name("txtCityName"));
				
				wait.until(ExpectedConditions.visibilityOf(city_name));
				
				city_name.sendKeys("Delhi");
				
				city_name.sendKeys(Keys.TAB);
				
				Thread.sleep(2000);
				
				WebElement txtBankName = driver.findElement(By.name("txtBankName"));
				
				wait.until(ExpectedConditions.visibilityOf(txtBankName));
				
				txtBankName.sendKeys("Reserve Bank of India");
				
				txtBankName.sendKeys(Keys.TAB);

				Thread.sleep(2000);
				
				WebElement txtBranchName = driver.findElement(By.name("txtBranchName"));
				
				wait.until(ExpectedConditions.visibilityOf(txtBranchName));
				
				txtBranchName.sendKeys("KRISHNA NAGAR MATHURA KOTWALI ROAD MATHURA");
				
				txtBranchName.sendKeys(Keys.TAB);
				
				Thread.sleep(2000);				
				
				/*----------- Bank Branch window --------- */
				
				List<String> Bankbranchwindow = new ArrayList<String>(driver.getWindowHandles());

				Collections.sort(Bankbranchwindow);

				System.out.println(Bankbranchwindow);

				driver.switchTo().window(Bankbranchwindow.get(3));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(Bankbranchwindow.get(2));

					System.out.println(driver.getTitle());

					if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

						driver.switchTo().window(Bankbranchwindow.get(1));

						System.out.println(driver.getTitle());

						if (driver.getTitle().equalsIgnoreCase("Instrument Detail")) {

							driver.switchTo().window(Bankbranchwindow.get(0));

							System.out.println(driver.getTitle());
						}
					} else if (driver.getTitle().equalsIgnoreCase("Instrument Detail")) {

						driver.switchTo().window(Bankbranchwindow.get(0));

						System.out.println(driver.getTitle());

						if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

							driver.switchTo().window(Bankbranchwindow.get(1));

							System.out.println(driver.getTitle());
						}

					}

				} else if (driver.getTitle().equalsIgnoreCase("Instrument Detail")) {

					driver.switchTo().window(Bankbranchwindow.get(0));

					System.out.println(driver.getTitle());

					if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

						driver.switchTo().window(Bankbranchwindow.get(1));

						System.out.println(driver.getTitle());

						if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

							driver.switchTo().window(Bankbranchwindow.get(2));

						}
					} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

						driver.switchTo().window(Bankbranchwindow.get(1));

						System.out.println(driver.getTitle());

						if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

							driver.switchTo().window(Bankbranchwindow.get(2));

							System.out.println(driver.getTitle());
						}
					}
				}

				else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(Bankbranchwindow.get(1));

					System.out.println(driver.getTitle());

					if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

						driver.switchTo().window(Bankbranchwindow.get(0));

						System.out.println(driver.getTitle());

						if (driver.getTitle().equalsIgnoreCase("Instrument Detail")) {

							driver.switchTo().window(Bankbranchwindow.get(2));

							System.out.println(driver.getTitle());
						}

					} else if (driver.getTitle().equalsIgnoreCase("Instrument Detail")) {

						driver.switchTo().window(Bankbranchwindow.get(2));

						System.out.println(driver.getTitle());

						if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

							driver.switchTo().window(Bankbranchwindow.get(0));

							System.out.println(driver.getTitle());

						}
					}
				}

				WebElement searchcriteriaGo = driver.findElement(By.name("B1"));

				wait.until(ExpectedConditions.visibilityOf(searchcriteriaGo));

				searchcriteriaGo.click();
				
				Thread.sleep(1000);

			/*-----------------Return from Constitution Window  -----------------------*/

				List<String> returnbranchwindow = new ArrayList<String>(driver.getWindowHandles());

				Collections.sort(returnbranchwindow);

				System.out.println(returnbranchwindow);

				driver.switchTo().window(returnbranchwindow.get(2));

				System.out.println(returnbranchwindow.get(2));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(returnbranchwindow.get(0));

					System.out.println(driver.getTitle());

					if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

						driver.switchTo().window(returnbranchwindow.get(1));

						System.out.println(driver.getTitle());
					}

				} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(returnbranchwindow.get(1));

					System.out.println(driver.getTitle());

					if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

						driver.switchTo().window(returnbranchwindow.get(0));

						System.out.println(driver.getTitle());
					}
				}
				
				
				WebElement txtFinwareANCO = driver.findElement(By.id("txtFinwareANCO"));
				
				wait.until(ExpectedConditions.visibilityOf(txtFinwareANCO));
				
				txtFinwareANCO.sendKeys("12123234334");			
				
				WebElement selDestBank = driver.findElement(By.name("selDestBank"));
				
				wait.until(ExpectedConditions.visibilityOf(selDestBank));
				
				Select selectDestBank = new Select(selDestBank);
				
				selectDestBank.selectByIndex(1);
				
				WebElement savebtn = driver.findElement(By.name("btnAdd"));
				
				wait.until(ExpectedConditions.visibilityOf(savebtn));
				
				savebtn.click();
				
				Thread.sleep(2000);
				
				/*----------- Change Stage ------------ */
				
				WebElement changestate = driver.findElement(By.id("apy_b0i11text"));

				wait.until(ExpectedConditions.visibilityOf(changestate));

				changestate.click();

				// Screenshotpath = fn_screenshot(Screenshotpath);

				WebElement exit = driver.findElement(By.name("Close"));

				wait.until(ExpectedConditions.visibilityOf(exit));

				exit.click();
		
	}
}


