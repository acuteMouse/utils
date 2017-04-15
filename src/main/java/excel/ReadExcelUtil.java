package excel;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelUtil {

	private Workbook wb = null;
	private Sheet sheet = null;
	private Row row = null;
	private int sheetNum = 0;
	private int rowNum = 0;
	private FileInputStream fis = null;
	private File file = null;

	public ReadExcelUtil() {
	}

	public ReadExcelUtil(File file) {
		this.file = file;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public void setSheetNum(int sheetNum) {
		this.sheetNum = sheetNum;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * 解决exlce版本兼容问题
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	public void open() throws IOException, EncryptedDocumentException, InvalidFormatException {
		fis = new FileInputStream(file);
		//由workBookFactory来字段判断是.exl,还是.exls文件
		wb=WorkbookFactory.create(fis);
		fis.close();
	}

	/**
	 * 获取excle页数
	 */
	public int getSheetCount() {
		int sheetCount = -1;
		sheetCount = wb.getNumberOfSheets();
		return sheetCount;
	}

	/**
	 * 获取当前行数
	 */
	public int getRowCount() {
		if (wb == null)
			System.out.println("=============>WorkBook为空");
		Sheet sheet = wb.getSheetAt(this.sheetNum);
		int rowCount = -1;
		rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	/**
	 * 获取指定页的行数
	 */
	public int getRowCount(int sheetNum) {
		Sheet sheet = wb.getSheetAt(sheetNum);
		int rowCount = -1;
		rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	/**
	 * 读取指定行数据
	 */
	public String[] readExcelLine(int lineNum) {
		return readExcelLine(this.sheetNum, lineNum);
	}

	/**
	 * 获取指定 页，行数据
	 */
	public String[] readExcelLine(int sheetNum, int lineNum) {
		if (sheetNum < 0 || lineNum < 0)
			return null;
		String[] strExcelLine = null;
		try {
			sheet = wb.getSheetAt(sheetNum);
			row = sheet.getRow(lineNum);

			int cellCount = row.getLastCellNum();
			strExcelLine = new String[cellCount + 1];
			for (int i = 0; i <= cellCount; i++) {
				strExcelLine[i] = readStringExcelCell(lineNum, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strExcelLine;
	}

	/**
	 * 获取单元格信息
	 */
	public String readStringExcelCell(int cellNum) {
		return readStringExcelCell(this.rowNum, cellNum);
	}

	/**
	 * 获取指定 行，指定单元格信息
	 */
	public String readStringExcelCell(int rowNum, int cellNum) {
		return readStringExcelCell(this.sheetNum, rowNum, cellNum);
	}

	/**
	 * 获取指定页，行，单元格内容
	 */
	public String readStringExcelCell(int sheetNum, int rowNum, int cellNum) {
		if (sheetNum < 0 || rowNum < 0)
			return "";
		String strExcelCell = "";
		try {
			sheet = wb.getSheetAt(sheetNum);
			row = sheet.getRow(rowNum);

			if (row.getCell((short) cellNum) != null) {
				switch (row.getCell((short) cellNum).getCellType()) {
				case HSSFCell.CELL_TYPE_FORMULA:
					strExcelCell = "FORMULA ";
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					strExcelCell = String.valueOf(row.getCell((short) cellNum).getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_STRING:
					strExcelCell = row.getCell((short) cellNum).getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					strExcelCell = "";
					break;
				default:
					strExcelCell = "";
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strExcelCell;
	}

	/**
	 * 把excle内容加载到list中
	 */
//	public static List<> read(String path) {
//		List<ExcelData> datas = new ArrayList<ExcelData>();
//		try {
//			File file = new File(path);
//			ReadExcelUtil readExcel = new ReadExcelUtil(file);
//			try {
//				readExcel.open();
//			} catch (Exception e) {
//				System.out.println("版本冲突");
//				e.printStackTrace();
//			}
//			readExcel.setSheetNum(0);
//			int count = readExcel.getRowCount();
//			for (int i = 0; i <= count; i++) {
//				String[] rows = readExcel.readExcelLine(i);
//				ExcelData excelData = new ExcelData();
//				for (int j = 0; j < rows.length; j++) {
//					excelData.setName(rows[0]);
//					excelData.setAge(rows[1]);
//					excelData.setAddress(rows[2]);
//				}
//				datas.add(excelData);
//			}
//		} catch (Exception e) {
//			System.out.println("加载到list中失败");
//		}
//		return datas;
//	}

}
