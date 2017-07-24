package UAT_CAS_Other_than__LPL;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import utility.BrowserSetup;
import utility.readexcel;

public class Cibil_Update extends BrowserSetup{
	
	static String app_id;	
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";	

	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void  cibil() throws Exception{
				
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
		  
		    try 
		    {
		
		/*--------------------------- DB Connection CIBIL URL ----------------- */
		
		String dbUrl = "jdbc:oracle:thin:@10.3.9.10:1521/HFCUATL";
        
		// Database Username
		String username = "hero_castrans";

		// Database Password
		String password = "Gy20c8st";
		
		// Load SQL server jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
			
		// Query to Execute
		String query = "update HERO_STAGE.CBL_BUREAU_STAGE_INTF set OVERALL_DECISION='REFER', REQUEST_STATUS=5 where APPLICATION_ID='"+app_id+"'";
	

		// Create Statement Object
		Statement stmt = con.createStatement();
		
		// Execute Update the SQL Query.
		stmt.executeQuery(query);	
		
		con.commit();
		
		// closing DB Connection
		con.close();
		    }
		    catch (ClassNotFoundException e) 
	    {
	     System.out.println("Class not found from database" );
	      e.printStackTrace();
	    } 
	    catch (SQLException e1) 
	    {
	     System.out.println("ORACLE Connection error " );
	      e1.printStackTrace();
	    }
		
		}	
	}
