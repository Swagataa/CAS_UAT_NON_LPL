package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	 static String Filepath = "";
	 	 
	 private static Workbook workbook;
	 
	 private static Sheet sheetname;
	 	
	 public static Object[][] getTableArray(String FilePath) throws Exception {   

		   String[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);

			   // Access the required test data sheet

			   workbook = new XSSFWorkbook(ExcelFile);

			   sheetname = workbook.getSheet("Data");
			   
			   Row firstrow = sheetname.getRow(0);

			   int startRow = 1;

			   int startCol = 0;

			   int ci,cj;

			   int totalRows = sheetname.getLastRowNum();

			   // you can write a function as well to get Column count

			   int totalCols = firstrow.getLastCellNum();

			   tabArray=new String[totalRows][totalCols];

			   ci=0;

			   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

				  cj=0;

				   for (int j=startCol;j<=totalCols-1;j++, cj++){

					   tabArray[ci][cj]=getCellData(i,j);

					   System.out.println(tabArray[ci][cj]);  

						}

					}

				}

			catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}
				public static String getCellData(int RowNum, int ColNum) throws Exception {

					try{

						Cell cell = sheetname.getRow(RowNum).getCell(ColNum);
						
						String CellData="";
						
						if(cell.getCellTypeEnum()==CellType.NUMERIC){
							
							CellData = String.valueOf(cell.getNumericCellValue());
							
							return CellData;

						}
						else{
							
							CellData = cell.getStringCellValue();

							return CellData;
						}

						}catch (Exception e){

						System.out.println(e.getMessage());

						throw (e);					
						}		
				}
	}
