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

public class Disbursal_details extends BrowserSetup{
	
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";
	WebDriverWait wait;
	static String app_id;

	@SuppressWarnings("unused")
	@Test
	public void Disbursal_detail() throws Throwable {
																																																																														
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 10);		
		FileInputStream fis = new FileInputStream(ApplicationIdsfilepath1); 
		  Workbook wobk = WorkbookFactory.create(fis); 
		  Sheet Worksheet = wobk.getSheet("ApplicationId");
		  readexcel readXls = new readexcel(); 
		  @SuppressWarnings("rawtypes")
		List datalist = readXls.readexcelsheet();
		  for (int i = 1; i < datalist.size()-1; i++){ 
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

		WebElement DDEsearch = driver.findElement(By.linkText("All"));

		wait.until(ExpectedConditions.visibilityOf(DDEsearch));

		// WebElement allsearch = driver.findElement(By.linkText("All"));

		// wait.until(ExpectedConditions.visibilityOf(allsearch));

		DDEsearch.click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));

		WebElement searchappId = driver.findElement(By.id("txtApplication"));

		wait.until(ExpectedConditions.visibilityOf(searchappId));

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
		
		/*------------- Disbursal Details window ------------- */
				
		List<String> Disbursalscreen = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(Disbursalscreen.size());

		Collections.sort(Disbursalscreen);

		System.out.println(Disbursalscreen);

		driver.switchTo().window(Disbursalscreen.get(2));

		System.out.println(Disbursalscreen.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(Disbursalscreen.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(Disbursalscreen.get(1));

				System.out.println(driver.getTitle());
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(Disbursalscreen.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(Disbursalscreen.get(0));

				System.out.println(driver.getTitle());
			}

		}
		
		WebElement balDisbursedAmt = driver.findElement(By.id("balDisbursedAmt"));
		
		wait.until(ExpectedConditions.visibilityOf(balDisbursedAmt));
		
		String amount = balDisbursedAmt.getText();
		
	//	System.out.println(amount);
					
		WebElement txtSelect1 = driver.findElement(By.id("txtSelect1"));
		
		wait.until(ExpectedConditions.visibilityOf(txtSelect1));
		
		txtSelect1.click();
		
		WebElement disbursal_initiation_btn = driver.findElement(By.id("btnAuthorize"));

		wait.until(ExpectedConditions.visibilityOf(disbursal_initiation_btn));
	
		disbursal_initiation_btn.click();
		
		/*----------- Exit Disbursal Details --------- */
	
		WebElement exit = driver.findElement(By.name("Close"));

		wait.until(ExpectedConditions.visibilityOf(exit));

		exit.click();
			
	}
	
}
