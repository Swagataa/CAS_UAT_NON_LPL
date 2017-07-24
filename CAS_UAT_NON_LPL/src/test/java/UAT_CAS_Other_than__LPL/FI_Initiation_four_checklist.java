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

public class FI_Initiation_four_checklist extends BrowserSetup {

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
	
		Thread.sleep(1000);
		
		/*----------- Residence Verification ------------*/
		
		WebElement btnOpenCountry = driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody[1]/tr[2]/td[5]/a[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(btnOpenCountry));
		
		btnOpenCountry.click();
		
		Thread.sleep(2000);
		
		List<String> Residenceverificationwindow = new ArrayList<String>(driver.getWindowHandles());
		 
		 System.out.println(Residenceverificationwindow.size());
		 
		 Collections.sort(Residenceverificationwindow);
		 
		 System.out.println(Residenceverificationwindow);
		 
		 driver.switchTo().window(Residenceverificationwindow.get(3));
		 
		 System.out.println(driver.getTitle());
		 
		 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
			 
			 driver.switchTo().window(Residenceverificationwindow.get(2));
			 
			 System.out.println(driver.getTitle());
			 
			 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
				 
				 driver.switchTo().window(Residenceverificationwindow.get(1));
				 
				 System.out.println(driver.getTitle());
				 
				 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
					 
					 driver.switchTo().window(Residenceverificationwindow.get(0));
					 
					 System.out.println(driver.getTitle());
					 
				 }
			 }
			 
		 }
		 
		 WebElement searchcriteriaGo = driver.findElement(By.name("B1"));
		 
		 wait.until(ExpectedConditions.visibilityOf(searchcriteriaGo));
		 
		 searchcriteriaGo.click();
		 
		 /*----------- Return From residential Verification-------------- */
		 
		 List<String> returnResidenceverification = new ArrayList<String>(driver.getWindowHandles());
		 
		 Collections.sort(returnResidenceverification);
		 
		 System.out.println(returnResidenceverification);
		 
		 driver.switchTo().window(returnResidenceverification.get(2));
		 
		 System.out.println(returnResidenceverification.get(2));
		 
		 System.out.println(driver.getTitle());
		 
		 if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {
		 
		 driver.switchTo().window(returnResidenceverification.get(0));
		 
		 System.out.println(driver.getTitle());
		 
		 if(driver.getTitle().equalsIgnoreCase("Finnone SSO")){
		 
		 driver.switchTo().window(returnResidenceverification.get(1));
		 
		 System.out.println(driver.getTitle());
		 
		 	}
		 
		 } else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {
		 
		 driver.switchTo().window(returnResidenceverification.get(1));
		 
		 System.out.println(driver.getTitle());
		 
		 if(driver.getTitle().equalsIgnoreCase("Finnone CAS")){
		 
		 driver.switchTo().window(returnResidenceverification.get(0));
		 
		 System.out.println(driver.getTitle()); 
		 		} 
		 	}
		
		 Thread.sleep(1000);
		 
		 /*---------------- Office Tele Verfication ------------ */
		 
		WebElement Televerfication =  driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[6]/a[1]"));
		
		wait.until(ExpectedConditions.visibilityOf(Televerfication));
		
		Televerfication.click();
		
		Thread.sleep(2000);
		
		List<String> officeTeleverification = new ArrayList<String>(driver.getWindowHandles());
		 
		 System.out.println(officeTeleverification.size());
		 
		 Collections.sort(officeTeleverification);
		 
		 System.out.println(officeTeleverification);
		 
		 driver.switchTo().window(officeTeleverification.get(3));
		 
		 System.out.println(driver.getTitle());
		 
		 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
			 
			 driver.switchTo().window(officeTeleverification.get(2));
			 
			 System.out.println(driver.getTitle());
			 
			 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
				 
				 driver.switchTo().window(officeTeleverification.get(1));
				 
				 System.out.println(driver.getTitle());
				 
				 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
					 
					 driver.switchTo().window(officeTeleverification.get(0));
					 
					 System.out.println(driver.getTitle());
					 
				 }
			 }			 
		 }
		 
		 WebElement searchcriteriaGo1 = driver.findElement(By.name("B1"));
		 
		 wait.until(ExpectedConditions.visibilityOf(searchcriteriaGo1));
		 
		 searchcriteriaGo1.click();
		 
		 Thread.sleep(1000);
		 		 
		 /*----------- Return From residential Verification-------------- */
		 
		 List<String> returnofficeTeleverification = new ArrayList<String>(driver.getWindowHandles());
		 
		 Collections.sort(returnofficeTeleverification);
		 
		 System.out.println(returnofficeTeleverification);
		 
		 driver.switchTo().window(returnofficeTeleverification.get(2));
		 
		 System.out.println(returnofficeTeleverification.get(2));
		 
		 System.out.println(driver.getTitle());
		 
		 if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {
		 
		 driver.switchTo().window(returnofficeTeleverification.get(0));
		 
		 System.out.println(driver.getTitle());
		 
		 if(driver.getTitle().equalsIgnoreCase("Finnone SSO")){
		 
		 driver.switchTo().window(returnofficeTeleverification.get(1));
		 
		 System.out.println(driver.getTitle());
		 
		 	}
		 
		 } else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {
		 
		 driver.switchTo().window(returnofficeTeleverification.get(1));
		 
		 System.out.println(driver.getTitle());
		 
		 if(driver.getTitle().equalsIgnoreCase("Finnone CAS")){
		 
		 driver.switchTo().window(returnofficeTeleverification.get(0));
		 
		 System.out.println(driver.getTitle()); 
		 		} 
		 	}
		 Thread.sleep(1000);
		 			
		 /*--------- Residence Tele Verification ----------- */
		 
		 	WebElement residenceTeleverfication =  driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[7]/a[1]"));
			
			wait.until(ExpectedConditions.visibilityOf(residenceTeleverfication));
			
			residenceTeleverfication.click();
			
			Thread.sleep(2000);
			
			List<String> residenceTeleverficationwindow = new ArrayList<String>(driver.getWindowHandles());
			 
			 System.out.println(residenceTeleverficationwindow.size());
			 
			 Collections.sort(residenceTeleverficationwindow);
			 
			 System.out.println(residenceTeleverficationwindow);
			 
			 driver.switchTo().window(residenceTeleverficationwindow.get(3));
			 
			 System.out.println(driver.getTitle());
			 
			 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
				 
				 driver.switchTo().window(residenceTeleverficationwindow.get(2));
				 
				 System.out.println(driver.getTitle());
				 
				 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
					 
					 driver.switchTo().window(residenceTeleverficationwindow.get(1));
					 
					 System.out.println(driver.getTitle());
					 
					 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
						 
						 driver.switchTo().window(residenceTeleverficationwindow.get(0));
						 
						 System.out.println(driver.getTitle());
						 
					 }
				 }			 
			 }
			 
			 WebElement searchcriteriaGo2 = driver.findElement(By.name("B1"));
			 
			 wait.until(ExpectedConditions.visibilityOf(searchcriteriaGo2));
			 
			 searchcriteriaGo2.click();
			 
			 Thread.sleep(1000);
			 
			 /*----------- Return From residential Tele Verification-------------- */
			 
			 List<String> returnresidenceTeleverficationwindow = new ArrayList<String>(driver.getWindowHandles());
			 
			 Collections.sort(returnresidenceTeleverficationwindow);
			 
			 System.out.println(returnresidenceTeleverficationwindow);
			 
			 driver.switchTo().window(returnresidenceTeleverficationwindow.get(2));
			 
			 System.out.println(returnresidenceTeleverficationwindow.get(2));
			 
			 System.out.println(driver.getTitle());
			 
			 if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {
			 
			 driver.switchTo().window(returnresidenceTeleverficationwindow.get(0));
			 
			 System.out.println(driver.getTitle());
			 
			 if(driver.getTitle().equalsIgnoreCase("Finnone SSO")){
			 
			 driver.switchTo().window(returnresidenceTeleverficationwindow.get(1));
			 
			 System.out.println(driver.getTitle());
			 
			 	}
			 
			 } else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {
			 
			 driver.switchTo().window(returnresidenceTeleverficationwindow.get(1));
			 
			 System.out.println(driver.getTitle());
			 
			 if(driver.getTitle().equalsIgnoreCase("Finnone CAS")){
			 
			 driver.switchTo().window(returnresidenceTeleverficationwindow.get(0));
			 
			 System.out.println(driver.getTitle()); 
			 		} 
			 	}
		
			 Thread.sleep(1000);
			 
		 /*------------------- Office Verification --------------*/
			 
			 WebElement Officeverfication =  driver.findElement(By.xpath("//table[@class='TABLEATTRIBUTES']/tbody/tr[2]/td[8]/a[1]"));
				
				wait.until(ExpectedConditions.visibilityOf(Officeverfication));
				
				Officeverfication.click();
				
				Thread.sleep(2000);
				
				List<String> Officeverficationwindow = new ArrayList<String>(driver.getWindowHandles());
				 
				 System.out.println(Officeverficationwindow.size());
				 
				 Collections.sort(Officeverficationwindow);
				 
				 System.out.println(Officeverficationwindow);
				 
				 driver.switchTo().window(Officeverficationwindow.get(3));
				 
				 System.out.println(driver.getTitle());
				 
				 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
					 
					 driver.switchTo().window(Officeverficationwindow.get(2));
					 
					 System.out.println(driver.getTitle());
					 
					 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
						 
						 driver.switchTo().window(Officeverficationwindow.get(1));
						 
						 System.out.println(driver.getTitle());
						 
						 if(!driver.getTitle().equalsIgnoreCase("Verification Agencies Search")){
							 
							 driver.switchTo().window(Officeverficationwindow.get(0));
							 
							 System.out.println(driver.getTitle());
							 
						 }
					 }			 
				 }
				 
				 WebElement searchcriteriaGo3 = driver.findElement(By.name("B1"));
				 
				 wait.until(ExpectedConditions.visibilityOf(searchcriteriaGo3));
				 
				 searchcriteriaGo3.click();
				 
				 Thread.sleep(1000);
				 
				 /*----------- Return From residential Verification-------------- */
				 
				 List<String> returnOfficeverficationwindow = new ArrayList<String>(driver.getWindowHandles());
				 
				 Collections.sort(returnOfficeverficationwindow);
				 
				 System.out.println(returnOfficeverficationwindow);
				 
				 driver.switchTo().window(returnOfficeverficationwindow.get(2));
				 
				 System.out.println(returnOfficeverficationwindow.get(2));
				 
				 System.out.println(driver.getTitle());
				 
				 if (driver.getTitle().equalsIgnoreCase("Finnone CAS")) {
				 
				 driver.switchTo().window(returnOfficeverficationwindow.get(0));
				 
				 System.out.println(driver.getTitle());
				 
				 if(driver.getTitle().equalsIgnoreCase("Finnone SSO")){
				 
				 driver.switchTo().window(returnOfficeverficationwindow.get(1));
				 
				 System.out.println(driver.getTitle());
				 
				 	}
				 
				 } else if (driver.getTitle().equalsIgnoreCase("Finnone SSO")) {
				 
				 driver.switchTo().window(returnOfficeverficationwindow.get(1));
				 
				 System.out.println(driver.getTitle());
				 
				 if(driver.getTitle().equalsIgnoreCase("Finnone CAS")){
				 
				 driver.switchTo().window(returnOfficeverficationwindow.get(0));
				 
				 System.out.println(driver.getTitle()); 
				 		} 
				 	}
			 
				 Thread.sleep(1000);
				
		/*------------ Click on ADD Button ---------- */
				 
		WebElement FIaddbutton = driver.findElement(By.name("DataAction"));

		wait.until(ExpectedConditions.visibilityOf(FIaddbutton));

		FIaddbutton.click();

		WebElement FIlogout = driver.findElement(By.name("Image3"));

		wait.until(ExpectedConditions.visibilityOf(FIlogout));

		FIlogout.click();

	}

}
