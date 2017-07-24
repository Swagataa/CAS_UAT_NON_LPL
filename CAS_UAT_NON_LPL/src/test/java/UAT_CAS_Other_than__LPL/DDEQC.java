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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utility.BrowserSetup;
import utility.readexcel;

public class DDEQC extends BrowserSetup {

	public WebDriverWait wait;
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";
	static String app_id;

	@Test(dataProvider="data-provider",dataProviderClass=utility.DataProvider.class)
	public void DDEQC_CAS(String sLogin_id,String sPassword,String sArea,String First_Name,String Last_Name,String Father_Name,String Product,
			String credit_program,String Scheme,String asset_cat,String asset_make,String asset_model,String Dealer_Code,String TM_Code,String SE_Code,String Constitution,String loan_amount,
			String loan_Tennure,String first_EMI_Month,String first_EMI_Year,String Advance_EMI,String Disburse_To,String Life_Insurance) throws Throwable {

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

		List<String> FinnoneCAS2 = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(FinnoneCAS2);

		System.out.println(FinnoneCAS2);

		driver.switchTo().window(FinnoneCAS2.get(0));

		String title5 = driver.getTitle();

		System.out.println(title5);

		if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(FinnoneCAS2.get(1));

			System.out.println(driver.getTitle());
		}

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameForwardToApp"));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("banner"));

		driver.switchTo().parentFrame();

		driver.switchTo().frame("contents");

		Actions move_AutoLoan1 = new Actions(driver);

		WebElement Auto_loan1 = driver.findElement(By.linkText("Auto Loan"));

		move_AutoLoan1.moveToElement(Auto_loan1).build().perform();

		WebElement DDEQCsearch = driver.findElement(By.linkText("All"));

		wait.until(ExpectedConditions.visibilityOf(DDEQCsearch));

		// WebElement allsearch = driver.findElement(By.linkText("All"));

		// wait.until(ExpectedConditions.visibilityOf(allsearch));

		DDEQCsearch.click();

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

		/*-------------- DDEQC ------------------------------------*/

		List<String> DDEQCscreen = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(DDEQCscreen.size());

		Collections.sort(DDEQCscreen);

		System.out.println(DDEQCscreen);

		driver.switchTo().window(DDEQCscreen.get(2));

		System.out.println(DDEQCscreen.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(DDEQCscreen.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(DDEQCscreen.get(1));

				System.out.println(driver.getTitle());

			}
		} else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(DDEQCscreen.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(DDEQCscreen.get(0));

				System.out.println(driver.getTitle());
			}
		}

		Thread.sleep(1000);
		
		WebElement demographic = driver.findElement(By.id("apy_b0i2text"));

		wait.until(ExpectedConditions.visibilityOf(demographic));

		demographic.click();

		WebElement customername = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[1]/a"));

		wait.until(ExpectedConditions.visibilityOf(customername));

		customername.click();

		WebElement personaltab = driver.findElement(By.id("apy_b1i1font"));

		wait.until(ExpectedConditions.visibilityOf(personaltab));

		System.out.println(personaltab.getText());

		WebElement verfiycheckbox = driver.findElement(By.id("chkSelVerify"));

		wait.until(ExpectedConditions.visibilityOf(verfiycheckbox));

		verfiycheckbox.click();
		
		WebElement select = driver.findElement(By.name("selDecision"));
		
		Select sel_decision = new Select(select);
		
		sel_decision.selectByIndex(2);

		/* --------- Change Stage ------ */

		WebElement changestage = driver.findElement(By.id("apy_b0i13font"));

		wait.until(ExpectedConditions.visibilityOf(changestage));

		changestage.click();

		WebElement exit = driver.findElement(By.name("Close"));

		wait.until(ExpectedConditions.visibilityOf(exit));

		exit.click();		
	}

}
