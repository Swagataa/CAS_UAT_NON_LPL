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

public class Disbursal_Initiation extends BrowserSetup{
	
	WebDriverWait wait;
	static String app_id;
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";

	
	@SuppressWarnings({ "rawtypes", "unused" })
	@Test(dataProvider="data-provider",dataProviderClass=utility.DataProvider.class)
	public void Disbursal(String sLogin_id,String sPassword,String sArea,String First_Name,String Last_Name,String Father_Name,String Product,
			String credit_program,String Scheme,String asset_cat,String asset_make,String asset_model,String Dealer_Code,String TM_Code,String SE_Code,String Constitution,String loan_amount,
			String loan_Tennure,String first_EMI_Month,String first_EMI_Year,String Advance_EMI,String Disburse_To,String Life_Insurance) throws Throwable {
																																																																														
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, 10);		
			FileInputStream fis = new FileInputStream(ApplicationIdsfilepath1); 
			  Workbook wobk = WorkbookFactory.create(fis); 
			  Sheet Worksheet = wobk.getSheet("ApplicationId");
			  readexcel readXls = new readexcel(); 
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

		 WebElement DIsearch = driver.findElement(By.linkText("All"));

		 wait.until(ExpectedConditions.visibilityOf(DIsearch));

		DIsearch.click();

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

		Thread.sleep(1000);
		
		/*------------- Disbursal Details window ------------- */
				
		List<String> DisbursalInitiatescreen = new ArrayList<String>(driver.getWindowHandles());

		System.out.println(DisbursalInitiatescreen.size());

		Collections.sort(DisbursalInitiatescreen);

		System.out.println(DisbursalInitiatescreen);

		driver.switchTo().window(DisbursalInitiatescreen.get(2));

		System.out.println(DisbursalInitiatescreen.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(DisbursalInitiatescreen.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(DisbursalInitiatescreen.get(1));

				System.out.println(driver.getTitle());
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(DisbursalInitiatescreen.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(DisbursalInitiatescreen.get(0));

				System.out.println(driver.getTitle());
			}

		}
		
		WebElement selectproduct = driver.findElement(By.id("selProduct"));
		
		wait.until(ExpectedConditions.visibilityOf(selectproduct));
		
		Select selproduct = new Select(selectproduct);
		
		selproduct.selectByVisibleText(Product);
		
		WebElement btnSearch = driver.findElement(By.name("btnSearch"));
		
		wait.until(ExpectedConditions.visibilityOf(btnSearch));
		
		btnSearch.click();
		
		WebElement chkApplicationList = driver.findElement(By.name("chkApplicationList"));
		
		wait.until(ExpectedConditions.visibilityOf(chkApplicationList));
		
		chkApplicationList.click();
		
		WebElement btnAccept = driver.findElement(By.name("btnAccept"));
		
		wait.until(ExpectedConditions.visibilityOf(btnAccept));
		
		btnAccept.click();
		
		Thread.sleep(1500);
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		/*-------- DI Logout ---------*/
		
		WebElement DIlogout = driver.findElement(By.name("Image3"));

		wait.until(ExpectedConditions.visibilityOf(DIlogout));

		DIlogout.click();
		
		
		
		
		
	}
}