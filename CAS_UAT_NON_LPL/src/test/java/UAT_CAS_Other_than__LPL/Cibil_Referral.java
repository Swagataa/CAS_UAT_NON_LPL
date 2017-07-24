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

public class Cibil_Referral extends BrowserSetup {
	
	WebDriverWait wait;
	static String app_id;
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";
	
	@SuppressWarnings("rawtypes")
	@Test
	public void CibilDetails() throws Exception{
		
		wait = new WebDriverWait(driver, 20);		
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
	  	  
		/*-------------------------- Retail Screen ----------------------*/

		List<String> FinnoneCAS3 = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(FinnoneCAS3);

		System.out.println(FinnoneCAS3);

		driver.switchTo().window(FinnoneCAS3.get(0));

		String title5 = driver.getTitle();

		System.out.println(title5);

		if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(FinnoneCAS3.get(1));

			System.out.println(driver.getTitle());
		}
		/*--------------- Auto Loan -------------- */
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameForwardToApp"));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("banner"));

		driver.switchTo().parentFrame();

		driver.switchTo().frame("contents");

		Actions move_AutoLoan1 = new Actions(driver);

		WebElement Auto_loan1 = driver.findElement(By.linkText("Auto Loan"));

		move_AutoLoan1.moveToElement(Auto_loan1).build().perform();

		WebElement Applicationsearch = driver.findElement(By.linkText("All"));

		wait.until(ExpectedConditions.visibilityOf(Applicationsearch));

		// WebElement allsearch = driver.findElement(By.linkText("All"));

		// wait.until(ExpectedConditions.visibilityOf(allsearch));

		Applicationsearch.click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));

		WebElement searchappId = driver.findElement(By.id("txtApplication"));

		wait.until(ExpectedConditions.visibilityOf(searchappId));

		// Excel should start

	//	searchappId.sendKeys(app_id);
		
		Thread.sleep(20000);

		WebElement searchbtn = driver.findElement(By.name("btnSearch"));

		wait.until(ExpectedConditions.visibilityOf(searchbtn));

		searchbtn.click();
		
		WebElement linkappid = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[1]/a"));

		wait.until(ExpectedConditions.visibilityOf(linkappid));

		linkappid.click();

		driver.switchTo().window(FinnoneCAS3.get(0));

		System.out.println(driver.getTitle());
		
		/*------------------------- CIBIL Referral ------------------ */
				
		List<String> CibilReferalScreen = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(CibilReferalScreen.size());

		Collections.sort(CibilReferalScreen);

		System.out.println(CibilReferalScreen);

		driver.switchTo().window(CibilReferalScreen.get(2));

		System.out.println(CibilReferalScreen.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(CibilReferalScreen.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(CibilReferalScreen.get(1));

				System.out.println(driver.getTitle());
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(CibilReferalScreen.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(CibilReferalScreen.get(0));

				System.out.println(driver.getTitle());
			}

		}
		
		WebElement selDecision = driver.findElement(By.id("selDecision"));
		
		wait.until(ExpectedConditions.visibilityOf(selDecision));
		
		Select selDecisiondropdown = new Select(selDecision);
		
		selDecisiondropdown.selectByVisibleText("Approve-Positive");
		
		WebElement selApplicationReasonCode = driver.findElement(By.id("selApplicationReasonCode"));
		
		wait.until(ExpectedConditions.visibilityOf(selApplicationReasonCode));
		
		selApplicationReasonCode.sendKeys("CIBIL Reason - Other");
		
		Thread.sleep(1000);
	
		selApplicationReasonCode.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		
		WebElement txtApplicationReasonDesc = driver.findElement(By.id("txtApplicationReasonDesc"));
		
		wait.until(ExpectedConditions.visibilityOf(txtApplicationReasonDesc));
		
		txtApplicationReasonDesc.sendKeys("Test Description");
		
		Thread.sleep(1000);
		
		WebElement addbtn = driver.findElement(By.name("btnAddList"));
		
		wait.until(ExpectedConditions.visibilityOf(addbtn));
		
		addbtn.click();
		
		Thread.sleep(2000);
		
		/* ---------- Save and Proceed Button -------- */
		
		WebElement save = driver.findElement(By.name("btnSP"));
		
		wait.until(ExpectedConditions.visibilityOf(save));
		
		save.click();		
		
		Thread.sleep(1000);
			
		WebElement exit = driver.findElement(By.name("Close"));

		wait.until(ExpectedConditions.visibilityOf(exit));

		exit.click();				
	}
}
