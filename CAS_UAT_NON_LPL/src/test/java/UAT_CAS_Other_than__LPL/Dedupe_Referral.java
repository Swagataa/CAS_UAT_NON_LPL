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

public class Dedupe_Referral extends BrowserSetup{
	
	public WebDriverWait wait;

	static String app_id;
	
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";

	@Test
	public void Dedupe_referral() throws Throwable {

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

	//	searchappId.sendKeys(app_id);

		// Screenshotpath = fn_screenshot(Screenshotpath);

		Thread.sleep(1000);

		WebElement searchbtn = driver.findElement(By.name("btnSearch"));

		wait.until(ExpectedConditions.visibilityOf(searchbtn));

		searchbtn.click();

		WebElement linkappid = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[1]/a[1]"));

		wait.until(ExpectedConditions.visibilityOf(linkappid));

		linkappid.click();
		
		Thread.sleep(1000);

		/*-------------------------- Dedupe Referral  ----------------*/

		List<String> DedupeScreen = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(DedupeScreen);

		System.out.println(DedupeScreen);

		driver.switchTo().window(DedupeScreen.get(2));

		System.out.println(DedupeScreen.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(DedupeScreen.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(DedupeScreen.get(1));

				System.out.println(driver.getTitle());
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(DedupeScreen.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(DedupeScreen.get(0));

				System.out.println(driver.getTitle());
			}
		}

		WebElement dedupe_ref = driver.findElement(By.id("apy_b0i1text"));
		
		wait.until(ExpectedConditions.visibilityOf(dedupe_ref));
		
		dedupe_ref.click();
		
		WebElement decision = driver.findElement(By.name("selDecision"));
		wait.until(ExpectedConditions.visibilityOf(decision) );
		Select sel_decision = new Select(decision);
		sel_decision.selectByIndex(1);
		
		WebElement reason = driver.findElement(By.name("selApplicationReasonCode"));
		
		wait.until(ExpectedConditions.visibilityOf(reason));
		reason.sendKeys("DUP Reason OTH");
		Thread.sleep(1000);
		reason.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		
		WebElement comments = driver.findElement(By.name("txtApplicationReasonDesc"));
		
		wait.until(ExpectedConditions.visibilityOf(comments));
		
		comments.sendKeys("Test Comments");
		
		Thread.sleep(1000);
		
		WebElement addbtn = driver.findElement(By.name("btnAddList"));
		
		wait.until(ExpectedConditions.visibilityOf(addbtn));
		
		addbtn.click();
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
