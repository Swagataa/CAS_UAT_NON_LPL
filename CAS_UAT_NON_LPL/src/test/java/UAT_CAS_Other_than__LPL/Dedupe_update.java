package UAT_CAS_Other_than__LPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Dedupe_update {

	static String app_id;	
	static String ApplicationIdsfilepath1 = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\ApplicationIds.xlsx";	

	@Test
	public void dedupe() throws Exception
	{
		    try 
		    {
		
		/*--------------------------- DB Connection CIBIL URL ----------------- */
		
		String dbUrl = "jdbc:oracle:thin:@10.3.9.10:1521/HFCUATL";
        
		// Database Username
		String username = "hero_castrans";

		// Database Password
		String password = "Gy20c8st";

		// Query to Execute
		String query = "BEGIN "
				+ "EXECUTEDEDUPE_DUP; "
				+ "END;";

		// Load SQL server jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
				   

		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute Update the SQL Query.
	
		stmt.executeQuery(query);
		
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
