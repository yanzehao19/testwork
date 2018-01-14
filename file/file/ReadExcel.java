package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) {
		readExcel("C:\\Users\\yzh\\Desktop\\对账初始化\\退费表\\总的退费订单记录.xlsx");
	}

	public static List<String> readExcel(String path) {
		List<String> columnList = new ArrayList<String>();
		File file = new File(path);
		try {
			InputStream in = new FileInputStream(file);
			//POIFSFileSystem fs = new POIFSFileSystem(in); 
			XSSFWorkbook  wb = new XSSFWorkbook(in);

			XSSFSheet sheet = wb.getSheetAt(0);
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();

			XSSFRow row = null;
			XSSFCell cell_a = null;
			XSSFCell cell_b = null;
			for (int i = firstRowNum; i <= lastRowNum; i++) {
				row = sheet.getRow(i); // 取得第i行
				cell_a = row.getCell(0); // 取得i行的第一列
				String cellValue = cell_a.getStringCellValue().trim();

				System.out.println(cellValue);
				columnList.add(cellValue);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return columnList;
	}

}
