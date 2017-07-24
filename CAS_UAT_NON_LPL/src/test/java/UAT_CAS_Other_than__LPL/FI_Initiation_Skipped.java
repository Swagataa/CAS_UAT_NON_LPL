package UAT_CAS_Other_than__LPL;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utility.BrowserSetup;
import utility.readexcel;

public class FI_Initiation_Skipped extends BrowserSetup {
		
	public WebDriverWait wait;

		static String app_id;
		
		static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";

		@Test
		public void FIinitiation() throws Throwable {

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
			  
			/*-------------------------- CAS Screen ----------------------*/

			List<String> FinnoneCAS4 = new ArrayList<String>(driver.getWindowHandles());

			Collections.sort(FinnoneCAS4);

			System.out.println(FinnoneCAS4);

			driver.switchTo().window(FinnoneCAS4.get(0));

			String title5 = driver.getTitle();

			System.out.println(title5);

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(FinnoneCAS4.get(1));

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

			WebElement FI_initiationsearch = driver.findElement(By.linkText("All"));

			wait.until(ExpectedConditions.visibilityOf(FI_initiationsearch));

			FI_initiationsearch.click();

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));

			WebElement searchappId = driver.findElement(By.id("txtApplication"));

			wait.until(ExpectedConditions.visibilityOf(searchappId));

			// Excel should start

	//		searchappId.sendKeys(app_id);

			// Screenshotpath = fn_screenshot(Screenshotpath);

			Thread.sleep(1000);

			WebElement searchbtn = driver.findElement(By.name("btnSearch"));

			wait.until(ExpectedConditions.visibilityOf(searchbtn));

			searchbtn.click();

			WebElement linkappid = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[1]/a[1]"));

			wait.until(ExpectedConditions.visibilityOf(linkappid));

			linkappid.click();
			
			Thread.sleep(1000);

			/*-------------------------- FI Initiation ----------------*/

			List<String> FIInitiaionscreen = new ArrayList<String>(driver.getWindowHandles());

			Collections.sort(FIInitiaionscreen);

			System.out.println(FIInitiaionscreen);

			driver.switchTo().window(FIInitiaionscreen.get(2));

			System.out.println(FIInitiaionscreen.get(2));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(FIInitiaionscreen.get(0));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

					driver.switchTo().window(FIInitiaionscreen.get(1));

					System.out.println(driver.getTitle());
				}
			}

			else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(FIInitiaionscreen.get(1));

				System.out.println(driver.getTitle());

				if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

					driver.switchTo().window(FIInitiaionscreen.get(0));

					System.out.println(driver.getTitle());
				}
			}

			WebElement FIcheckbox = driver.findElement(By.name("chkAgencyList"));

			wait.until(ExpectedConditions.visibilityOf(FIcheckbox));
			
			FIcheckbox.click();
				 
			//		 Thread.sleep(1000);
					
			/*------------ Click on ADD Button ---------- */
					 
			WebElement FIaddbutton = driver.findElement(By.name("DataAction"));

			wait.until(ExpectedConditions.visibilityOf(FIaddbutton));

			FIaddbutton.click();

			WebElement FIlogout = driver.findElement(By.name("Image3"));

			wait.until(ExpectedConditions.visibilityOf(FIlogout));

			FIlogout.click();

		}

	}
