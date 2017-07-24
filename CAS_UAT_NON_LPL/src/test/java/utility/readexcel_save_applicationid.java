package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexcel_save_applicationid {

	@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	public  List readexcelsheet() throws IOException {
		
				// Location of source file
					String filepath = "C:\\Automation_Softwares\\eclipse\\WorkSpace\\CAS_UAT_NON_LPL\\src\\test\\java\\testdata\\Saved_Application_ids.xlsx";
														
					List dataList = new ArrayList();
					
					FileInputStream fis = null;
					
					try {
						 fis = new FileInputStream(filepath);

						XSSFWorkbook workbook = new XSSFWorkbook(fis);
						XSSFSheet sheet = workbook.getSheet("ApplicationId");
						java.util.Iterator rows = sheet.rowIterator();

						while (rows.hasNext()) {
							XSSFRow row = ((XSSFRow) rows.next());
							// int r=row.getRowNum();
							java.util.Iterator cells = row.cellIterator();
							int i = 1;
							String[] testData = new String[5];
							while (cells.hasNext()) {

								XSSFCell cell = (XSSFCell) cells.next();
								String value="";
							if(cell.getCellTypeEnum()==CellType.NUMERIC){
									value = String.valueOf(cell.getNumericCellValue());
								}
								
								else if(cell.getCellTypeEnum()==CellType.STRING){
									value = cell.getStringCellValue();
								}
							if (!value.equals(null)) {
									testData[i] = value;
									i++;
								}
							}
							dataList.add(testData);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return dataList;
				}
	
			}