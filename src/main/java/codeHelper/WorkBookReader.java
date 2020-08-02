package codeHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
public class WorkBookReader {

	public HashMap<String,String> getWorkBook(String filePath) {
		HashMap<String,String> map=new HashMap<String,String>();
		
		try {
			File file=new File(System.getProperty("user.dir")+filePath);
			FileInputStream fis=new FileInputStream(file);
			HSSFWorkbook repository=new HSSFWorkbook(fis);
			HSSFSheet workSheet=repository.getSheet("Sheet1");
			for(int i=0;i<=workSheet.getLastRowNum();i++) {
				Row row=workSheet.getRow(i);				
				String key=(String) row.getCell(0).getStringCellValue().trim();
				String value=(String) row.getCell(1).getStringCellValue().trim();
				map.put(key, value);
			}
			
		} catch (Exception ex) {
			System.out.println("<<Exception>>"+ex.getMessage());
		}
		return map;

	}

}
