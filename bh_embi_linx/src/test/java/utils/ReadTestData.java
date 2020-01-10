package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTestData {

	static String path = "C:\\Users\\bnandira\\Documents\\TestDataLocation\\PracticeData.xlsx";

		public static void main(String[] args) throws Exception{
			List<Map<String,String>> data = null; 
			data = ReadTestData.getTestData();
//			System.out.println(data);
//			List<Map<String, String>> list = null; // this is what you have already

			//To read the List of maps
			for (Map<String, String> map : data) {
			    for (Map.Entry<String, String> entry : map.entrySet()) {
			        String key = entry.getKey();
			        String value = entry.getValue();
//		        System.out.println("key is"+key+"Value is"+value);
			    }
			}
			 
			//To read the List of maps
//			data.stream().forEach(singleRow -> {
//				 System.out.println("Entered into java stream logic");
//				singleRow.entrySet().stream().forEach((rowValues) ->{
//					
//					System.out.println(rowValues.getKey()+" value is "+rowValues.getValue());
//				});
//			});
			
		}//main end
		
		  public static List<Map<String,String>> getTestData() throws EncryptedDocumentException, IOException, InvalidFormatException{
			  Workbook wBook = null;
			  List<Map<String,String>> lst = null;
			  Map<String,String>  map = null;
			  System.out.println("Data Processing From File" + path);
				FileInputStream fis = new FileInputStream(path);
				wBook = WorkbookFactory.create(fis);
//				XSSFWorkbook wb = new XSSFWorkbook(fis);
				
				Sheet sheet = wBook.getSheetAt(0);
				lst = new ArrayList<Map<String,String>>();

				int totalRows=sheet.getPhysicalNumberOfRows();
//	            System.out.println("Row Number:" +totalRows);
				
//	            int noOfcolumns = sh.getRow(0).getPhysicalNumberOfCells();
//				System.out.println("Column Number:" +noOfcolumns);
				
				
//				return null;
				for(int row=1;row<=totalRows;row++){
					Row rowData=sheet.getRow(row);
					if(rowData!=null){
						Cell cell=rowData.getCell(0);
						if(cell!=null){
//							String key = null;
//							if(new DataFormatter().formatCellValue(cell).equals(key)){
								int colNumber=sheet.getRow(0).getLastCellNum();
								map=new LinkedHashMap<String,String>(colNumber);
								for(int col=0;col<colNumber;col++){
//									System.out.println(sheet.getRow(0).getCell(col));
//									System.out.println(rowData.getCell(col));
									map.put(new DataFormatter().formatCellValue(sheet.getRow(0).getCell(col)).trim(), new DataFormatter().formatCellValue(rowData.getCell(col)).trim());
								}
								lst.add(map);
//							}
							
						}
						
					}
					
					
					
				}//row itr
				
				return lst;
				
				
				
				
		  }//test data fn end		
				

		  
		  
	}//class end

	
	
	
	
	
//String[][] array = new String[arrayList.size()][];
//for (int i = 0; i < arrayList.size(); i++) {
//    ArrayList<String> row = arrayList.get(i);
//    array[i] = row.toArray(new String[row.size()]);
//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

