package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowserSetup {
	
	public static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeSuite
	public WebDriver setupapplication() {
	
		System.setProperty("webdriver.ie.driver", "C:\\Automation_Softwares\\IEDriverServer\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		java.util.ResourceBundle.clearCache();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		driver.get("http://retail.herofincorp.com:7031/finnsso/gateway/SSOGateway?requestID=7000002");
		return driver;
		}		
	
	@AfterSuite
	public void Application_logout() throws Exception
	{
		wait = new WebDriverWait(driver, 5);	
		
		try{		
			
			/*----------- CAS Logout ------------ 
			
			List<String> FinnoneCAS1 = new ArrayList<String>(driver.getWindowHandles());

			Collections.sort(FinnoneCAS1);

			System.out.println(FinnoneCAS1);

			driver.switchTo().window(FinnoneCAS1.get(1));

			String title5 = driver.getTitle();

			System.out.println(title5);

			if (!driver.getTitle().equalsIgnoreCase("FinnOne CAS")) {

				driver.switchTo().window(FinnoneCAS1.get(0));

				System.out.println(driver.getTitle());
				}
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameForwardToApp"));

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("banner"));
			
			WebElement logout = driver.findElement(By.name("Image3"));
			
			wait.until(ExpectedConditions.visibilityOf(logout));
			
			if(logout.isDisplayed()== false){
				
				driver.close();
				
			}else{
					logout.click();
					
					driver.switchTo().alert().accept();
			}
		
			Thread.sleep(1000);	
			
		/*----------- Finnone Logout -----------*/
		
		List<String> browsertabs = new ArrayList<String>(driver.getWindowHandles());
		
		Collections.sort(browsertabs);

		System.out.println(browsertabs);
		
		if(browsertabs.size()>3)
		{
			driver.close();	
			}

		driver.switchTo().window(browsertabs.get(0));
		
		System.out.println(driver.getTitle());
		
			if (!driver.getTitle().equalsIgnoreCase("FinnOne SSO")) {

				driver.switchTo().window(browsertabs.get(1));

				System.out.println(driver.getTitle());
			
					if(!driver.getTitle().equalsIgnoreCase("FinnOne SSO")) {

							driver.switchTo().window(browsertabs.get(2));

							System.out.println(driver.getTitle());
							}
						}
			
		WebElement LogoutFinnone = driver.findElement(By.name("btnEXIT"));
		
		wait.until(ExpectedConditions.visibilityOf(LogoutFinnone));
		
		LogoutFinnone.click();
		
		LogoutFinnone.sendKeys(Keys.ENTER);
	
		Thread.sleep(300);
		
		driver.close();	
		
			}catch(Exception e){
				
				e.getMessage();
				
		}
	
	}
}