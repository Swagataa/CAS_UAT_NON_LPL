package utility;



public class DataProvider extends ExcelUtils{
	
	static String filepath = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\testdata.xlsx";
	
	@org.testng.annotations.DataProvider(name="data-provider")
	public Object[][] readExceldata() throws Exception{
		
		Object[][] testObjArray = ExcelUtils.getTableArray(filepath);
		
		return (testObjArray);	
		
	}
}
