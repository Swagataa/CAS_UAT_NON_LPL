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

public class FI_Verification_four_checklist extends BrowserSetup{

	
	public WebDriverWait wait;

	static String app_id;
	
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";

	@Test
	public void FI_Verification() throws Throwable {

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

		WebElement FI_verificationsearch = driver.findElement(By.linkText("All"));

		wait.until(ExpectedConditions.visibilityOf(FI_verificationsearch));

		FI_verificationsearch.click();

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

		/*-------------------------- FI Verification ----------------*/

		List<String> FIVerificationscreen = new ArrayList<String>(driver.getWindowHandles());

		Collections.sort(FIVerificationscreen);

		System.out.println(FIVerificationscreen);

		driver.switchTo().window(FIVerificationscreen.get(2));

		System.out.println(FIVerificationscreen.get(2));

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

			driver.switchTo().window(FIVerificationscreen.get(0));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

				driver.switchTo().window(FIVerificationscreen.get(1));

				System.out.println(driver.getTitle());
			}
		}

		else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {

			driver.switchTo().window(FIVerificationscreen.get(1));

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {

				driver.switchTo().window(FIVerificationscreen.get(0));

				System.out.println(driver.getTitle());
			}
		}
	
		/*----------------------- Office Tele Verification  ---------------------- */
		
		WebElement FIV1 = driver.findElement(By.id("apy_b0i1text"));
		
		wait.until(ExpectedConditions.visibilityOf(FIV1));
		
		FIV1.click();
		
	//	WebElement Office_verification = driver.findElement(By.linkText("Office Tele Verification"));
		
		WebElement Office_Tele_verification = driver.findElement(By.xpath("//form[@id='formID28']/p[3]/font[1]/a[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Office_Tele_verification));
		
		Office_Tele_verification.click();
		
		Thread.sleep(1000);
		
		WebElement Applicant_name = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[2]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Applicant_name));
		
		Applicant_name.sendKeys("Test");
		
		WebElement Scheme = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[2]/td[4]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Scheme));
		
		Scheme.sendKeys("Test");
		
		WebElement Application_id = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[3]/td[4]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Application_id));
		
		Application_id.sendKeys("123445");
		
		WebElement type_of_office = driver.findElement(By.xpath("//form[@id='formID45']/table[6]/tbody[2]/tr[1]/td[4]/Select[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(type_of_office));
		
		Select Sel_type_of_office = new Select(type_of_office);
		
		Sel_type_of_office.selectByIndex(1);
		
		WebElement address = driver.findElement(By.xpath("//form[@id='formID45']/table[7]/tbody[2]/tr[1]/td[2]/textarea[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(address));
		
		address.sendKeys("Test Address");
		
		WebElement pincode = driver.findElement(By.xpath("//form[@id='formID45']/table[7]/tbody[2]/tr[4]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(pincode));
		
		pincode.sendKeys("110029");
		
		WebElement positive = driver.findElement(By.name("rdoDecision"));
		
		wait.until(ExpectedConditions.visibilityOf(positive));
		
		positive.click();
		
		WebElement fivRemarks = driver.findElement(By.name("fivRemarks"));
		
		wait.until(ExpectedConditions.visibilityOf(fivRemarks));
		
		fivRemarks.sendKeys("Positive");
		
		WebElement save_proceed = driver.findElement(By.xpath("//input[@value='Save and Proceed']"));
		
		wait.until(ExpectedConditions.visibilityOf(save_proceed));
		
		save_proceed.click();
		
		Thread.sleep(2000);
		
		/*---------- Click on Field Verification Tab ----------*/
		
		WebElement FIV = driver.findElement(By.id("apy_b0i1text"));
		
		wait.until(ExpectedConditions.visibilityOf(FIV));
		
		FIV.click();
		
		Thread.sleep(2000);
		
		/*------------- Office Verification --------------*/
		
		WebElement Office_verification = driver.findElement(By.xpath("//form[@id='formID28']/p[4]/font[1]/a[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Office_verification));
		
		Office_verification.click();
		
		Thread.sleep(1000);
		
		WebElement Applicant_name2 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[2]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Applicant_name2));
		
		Applicant_name2.sendKeys("Test");
		
		WebElement Date_of_verification = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[2]/td[4]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Date_of_verification));
		
		Date_of_verification.sendKeys("01/06/2017");
		
		WebElement Organization_name = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[3]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Organization_name));
		
		Organization_name.sendKeys("Test Organization");
		
		WebElement office_adress = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[4]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(office_adress));
		
		office_adress.sendKeys("Test Office Address");		
		
		WebElement Hero_distance = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[11]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Hero_distance));
		
		Hero_distance.sendKeys("123");
		
		WebElement area_type = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[11]/td[4]/Select[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(area_type));
		
		Select Sel_area_type = new Select(area_type);
		
		Sel_area_type.selectByIndex(1);
		
		WebElement positive2 = driver.findElement(By.name("rdoDecision"));
		
		wait.until(ExpectedConditions.visibilityOf(positive2));
		
		positive2.click();
		
		WebElement fivRemarks2 = driver.findElement(By.name("fivRemarks"));
		
		wait.until(ExpectedConditions.visibilityOf(fivRemarks2));
		
		fivRemarks2.sendKeys("Positive");
		
		WebElement save_proceed2 = driver.findElement(By.xpath("//input[@value='Save and Proceed']"));
		
		wait.until(ExpectedConditions.visibilityOf(save_proceed2));
		
		save_proceed2.click();
		
		Thread.sleep(2000);
		
		/*---------- Click on Field Verification Tab ----------*/
		
		WebElement FIV2 = driver.findElement(By.id("apy_b0i1text"));
		
		wait.until(ExpectedConditions.visibilityOf(FIV2));
		
		FIV2.click();
		
		Thread.sleep(2000);
		
		/* -------------------- Residence Tele Verification ------------ */
		
	//	WebElement residence = driver.findElement(By.linkText("Residence Tele Verification"));
		
		WebElement residence_Tele = driver.findElement(By.xpath("//form[@id='formID28']/p[5]/font[1]/a[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(residence_Tele));
		
		residence_Tele.click();
		
		WebElement Applicant_name1 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[2]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Applicant_name1));
		
		Applicant_name1.sendKeys("Test");
		
		WebElement Scheme1 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[2]/td[4]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Scheme1));
		
		Scheme1.sendKeys("Test");
		
		WebElement Application_id1 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[3]/td[4]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Application_id1));
		
		Application_id1.sendKeys("123445");
		
		WebElement type_of_residence = driver.findElement(By.xpath("//form[@id='formID45']/table[6]/tbody[2]/tr[1]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(type_of_residence));
		
		type_of_residence.sendKeys("Permanent");
		
		WebElement residential_address = driver.findElement(By.xpath("//form[@id='formID45']/table[7]/tbody[2]/tr[1]/td[2]/textarea[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(residential_address));
		
		residential_address.sendKeys("Test Address");
		
		WebElement pincode1 = driver.findElement(By.xpath("//form[@id='formID45']/table[7]/tbody[2]/tr[4]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(pincode1));
		
		pincode1.sendKeys("110029");

		WebElement positive1 = driver.findElement(By.name("rdoDecision"));
		
		wait.until(ExpectedConditions.visibilityOf(positive1));
		
		positive1.click();
		
		WebElement fivRemarks1 = driver.findElement(By.name("fivRemarks"));
		
		wait.until(ExpectedConditions.visibilityOf(fivRemarks1));
		
		fivRemarks1.sendKeys("Positive");
		
		WebElement save_proceed1 = driver.findElement(By.xpath("//input[@value='Save and Proceed']"));
		
		wait.until(ExpectedConditions.visibilityOf(save_proceed1));
		
		save_proceed1.click();
		
		Thread.sleep(2000);
		
		/*---------- Click on Field Verification Tab ----------*/
		
		WebElement FIV4 = driver.findElement(By.id("apy_b0i1text"));
		
		wait.until(ExpectedConditions.visibilityOf(FIV4));
		
		FIV4.click();
		
		Thread.sleep(2000);
		
		/*------------ Residence Verification ------------ */
		
		WebElement residence_verification = driver.findElement(By.xpath("//form[@id='formID28']/p[6]/font[1]/a[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(residence_verification));
		
		residence_verification.click();
		
		WebElement Applicant_name4 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[2]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Applicant_name4));
		
		Applicant_name4.sendKeys("Test");
		
		WebElement Date_of_verfication2 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[2]/td[4]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Date_of_verfication2));
		
		Date_of_verfication2.sendKeys("01/06/2016");
		
		WebElement Applicant_status = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[4]/td[4]/Select[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Applicant_status));
		
		Select sel_Applicant_status = new Select(Applicant_status);
		
		sel_Applicant_status.selectByIndex(1);
		
		WebElement Address1 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[7]/td[4]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Address1));
		
		Address1.sendKeys("Test Residential Address");
		
		WebElement Distance_hero1 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[10]/td[4]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Distance_hero1));
		
		Distance_hero1.sendKeys("123");
		
		WebElement area_type2 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[11]/td[2]/Select[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(area_type2));
		
		Select Sel_area_type2 = new Select(area_type2);
		
		Sel_area_type2.selectByIndex(1);
		
		WebElement pincode3 = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[11]/td[4]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(pincode3));
		
		pincode3.sendKeys("110029");
		
		WebElement landmark = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[12]/td[2]/input[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(landmark));
		
		landmark.sendKeys("Test landmark");
		
		WebElement negative_area = driver.findElement(By.xpath("//form[@id='formID45']/table[5]/tbody/tr[23]/td[4]/Select[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(negative_area));
		
		Select sel_negative_area = new Select(negative_area);
		
		sel_negative_area.selectByIndex(2);
		
		WebElement positive4 = driver.findElement(By.name("rdoDecision"));
		
		wait.until(ExpectedConditions.visibilityOf(positive4));
		
		positive4.click();
		
		WebElement fivRemarks4 = driver.findElement(By.name("fivRemarks"));
		
		wait.until(ExpectedConditions.visibilityOf(fivRemarks4));
		
		fivRemarks4.sendKeys("Positive");
		
		WebElement save_proceed4 = driver.findElement(By.xpath("//input[@value='Save and Proceed']"));
		
		wait.until(ExpectedConditions.visibilityOf(save_proceed4));
		
		save_proceed4.click();
		
		Thread.sleep(2000);
		
		/*--------- FIV Check List ----------------*/
		
/*		WebElement FIV3 = driver.findElement(By.id("apy_b0i2text"));
		
		wait.until(ExpectedConditions.visibilityOf(FIV3));
		
		FIV3.click();
		
		Thread.sleep(1500);
		
		WebElement Selectoption1 = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody[1]/tr[2]/td[3]/Select[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Selectoption1));
		
		Select Seloption1 = new Select(Selectoption1);
		
		Seloption1.selectByIndex(2);
		
		WebElement Selectoption2 = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody[1]/tr[3]/td[3]/Select[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Selectoption2));
		
		Select Seloption2 = new Select(Selectoption2);
		
		Seloption2.selectByIndex(2);
		
		WebElement btn = driver.findElement(By.name("btnAdd"));
		
		wait.until(ExpectedConditions.visibilityOf(btn));
		
		btn.click();
		
		Thread.sleep(1000);
		
		WebElement FIVlogout = driver.findElement(By.name("Image3"));

		wait.until(ExpectedConditions.visibilityOf(FIVlogout));

		FIVlogout.click();*/
		
		WebElement exit = driver.findElement(By.name("Close"));

		wait.until(ExpectedConditions.visibilityOf(exit));

		exit.click();
	
	}
	
}
