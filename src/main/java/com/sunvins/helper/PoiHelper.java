package com.sunvins.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiHelper {

	private Workbook curWb;
	private Sheet curSheet;
	private Row curRow;
	private String fileName;
	private FormulaEvaluator evaluator;
	private CreationHelper creationHelper; 
	public static void main(String[] args) {
//		String fileName = "G:\\pro\\xls\\天空.xlsx";
//		PoiHelper ph0 = new PoiHelper(fileName);
	}

	// 工作簿：
	// 创建
	public PoiHelper() {

	}

	public PoiHelper(String fileName) {
		createWb(fileName, false);
	}

	public PoiHelper(String fileName, boolean toCover) {
		createWb(fileName, toCover);

	}

	public void createWb(String fileName, boolean toCover) {
		this.fileName = fileName;
		if (toCover) {
			curWb = new XSSFWorkbook();
		} else {
			File file = new File(fileName);
			if (file.exists()) {
				try {
					curWb = new XSSFWorkbook(new FileInputStream(fileName));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				curWb = new XSSFWorkbook();
			}
		}
		creationHelper=curWb.getCreationHelper();
	}

	// 读取
	public Workbook getCurWb() {
		return curWb;
	}

	// 设置文件名
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// 删除
	// 打开
	public void open() {
		try {
			Runtime.getRuntime().exec("cmd  /c start " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		// File file=new File(fileName);
		// String command = "cmd.exe /c c:\\windows\\system32\\taskkill /f /im
		// "+"EXCEL.EXE";
		// try {
		// Runtime.getRuntime().exec(command);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// try {
		// Process listprocess = Runtime.getRuntime().exec("cmd.exe /c tasklist");
		// InputStream is = listprocess.getInputStream();
		// byte[] buf = new byte[256];
		// BufferedReader r = new BufferedReader(new InputStreamReader(is,"GBK"));
		//// StringBuffer sb = new StringBuffer();
		// String str = null;
		// while ((str = r.readLine()) != null) {
		// System.out.println(str);
		// String id = null;
		// Matcher matcher = Pattern.compile(fileName + "[ ]*([0-9]*)").matcher(str);
		// while (matcher.find()) {
		// if (matcher.groupCount() >= 1) {
		// id = matcher.group(1);
		// if (id != null) {
		// Integer pid = null;
		// try {
		// pid = Integer.parseInt(id);
		// } catch (NumberFormatException e) {
		// e.printStackTrace();
		// }
		// if (pid != null) {
		// Runtime.getRuntime().exec("cmd.exe /c taskkill /f /pid " + pid);
		// System.out.println("kill progress");
		// }
		// }
		// }
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	// 保存
	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			curWb.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ----------------------------------------
	// Sheet
	// 获取当前的Sheet
	public Sheet getCurSheet() {
		if(curSheet==null) {
			curSheet=getActiveSheet();
		}
		return curSheet;
	}

	// 获取当前活动的Sheet
	public Sheet getActiveSheet() {
		int index = getActiveSheetIndex();
		return getSheet(index);
	}

	// 获取当前活动的Sheet
	public int getActiveSheetIndex() {
		return curWb.getActiveSheetIndex();
	}

	// 设置当前活动的Sheet
	public void setActiveSheet(int index) {
		curWb.setActiveSheet(index);
	}

	// 设置当前活动的Sheet
	public void setActiveSheet(Sheet sheet) {
		int index = getSheetIndex(sheet);
		curWb.setActiveSheet(index);
	}

	// 设置当前活动的Sheet
	public void setActiveSheet(String sheetName) {
		int index = getSheetIndex(sheetName);
		curWb.setActiveSheet(index);
	}

	// 取得Sheet的数量
	public int getNumberOfSheets() {
		return curWb.getNumberOfSheets();
	}

	// 获取Sheet的位置
	public int getSheetIndex(Sheet sheet) {
		return curWb.getSheetIndex(sheet);
	}

	// 根据名称获取Sheet的位置
	public int getSheetIndex(String sheetName) {
		return curWb.getSheetIndex(sheetName);
	}

	// 获取Sheet的名称
	public String getSheetName(Sheet sheet) {
		return sheet.getSheetName();
	}

	// 根据位置获取Sheet的名称
	public String getSheetName(int index) {
		Sheet sheet = getSheet(index);
		return sheet.getSheetName();
	}

	// 根据位置获取Sheet
	public Sheet getSheet(int index) {
		return curWb.getSheetAt(index);
	}

	// 根据名称获取Sheet
	public Sheet getSheet(String sheetName) {
		Sheet sheet = curWb.getSheet(sheetName);
		if (sheet == null) {
			sheet = curWb.createSheet(sheetName);
		}
		return sheet;
	}

	// 根据位置修改Sheet的名称
	public void setSheetName(int index, String sheetName) {
		curWb.setSheetName(index, sheetName);
	}

	// 修改Sheet的名称
	public void setSheetName(Sheet sheet, String sheetName) {
		int index = getSheetIndex(sheet);
		curWb.setSheetName(index, sheetName);
	}

	// 修改Sheet的名称
	public void setSheetName(String sheetNameOld, String sheetName) {
		int index = getSheetIndex(sheetNameOld);
		curWb.setSheetName(index, sheetName);
	}

	// 根据名称修改Sheet的位置
	public void setSheetOrder(String sheetName, int pos) {
		curWb.setSheetOrder(sheetName, pos);
	}

	// 根据位置修改Sheet的位置
	public void setSheetOrder(int index, int pos) {
		String sheetName = getSheetName(index);
		curWb.setSheetOrder(sheetName, pos);
	}

	// 修改Sheet的位置
	public void setSheetOrder(Sheet sheet, int pos) {
		String sheetName = getSheetName(sheet);
		curWb.setSheetOrder(sheetName, pos);
	}

	// 根据位置删除Sheet
	public void removeSheet(int index) {
		curWb.removeSheetAt(index);
	}

	// 根据位置删除Sheet
	public void removeSheet(String sheetName) {
		int index = getSheetIndex(sheetName);
		if (index != -1)
			curWb.removeSheetAt(index);
	}

	// 根据Sheet来删除
	public void removeSheet(Sheet sheet) {
		int index = getSheetIndex(sheet);
		curWb.removeSheetAt(index);
	}

	// 根据Sheet来显示或隐藏Sheet
	public void hiddenSheet(Sheet sheet, boolean isHidden) {
		int index = getSheetIndex(sheet);
		curWb.setSheetHidden(index, isHidden);
	}

	// 根据位置来显示或隐藏Sheet
	public void hiddenSheet(int index, boolean isHidden) {
		curWb.setSheetHidden(index, isHidden);
	}

	// 根据名称来显示或隐藏Sheet
	public void hiddenSheet(String sheetName, boolean isHidden) {
		int index = getSheetIndex(sheetName);
		curWb.setSheetHidden(index, isHidden);
	}

	// ----------------------------------------
	// Row
	// 查
	// 返回Sheet
	public Sheet getSheet(Row row) {
		return row.getSheet();
	}
	//返回当前行
	public Row getCurRow() {
		if(curRow==null)curRow=getOriRow(getCurSheet(),0);
		return curRow;
	}
	public Row getOriRow(Sheet sheet, int rowNo) {
		Row row = sheet.getRow(rowNo);
		return row;
	}

	public Row getOriRow(String sheetName, int rowNo) {
		Sheet sheet = getSheet(sheetName);
		return getOriRow(sheet, rowNo);
	}

	// 返回Row
	public Row getRow(Sheet sheet, int rowNo) {
		Row row = getOriRow(sheet, rowNo);
		if (row == null) {
			row = sheet.createRow(rowNo);
		}
		return row;
	}

	// 返回Row
	public Row getRow(String sheetName, int rowNo) {
		Sheet sheet = getSheet(sheetName);
		return getRow(sheet, rowNo);
	}

	// 返回行号
	public int getRowNo(Row row) {
		return row.getRowNum();
	}

	// 清空行
	public void clearRow(Sheet sheet, int rowNo) {
		Row row = sheet.getRow(rowNo);
		if (row != null) {
			sheet.removeRow(row);
		}
	}

	// 清空行
	public void clearRow(Row row) {
		Sheet sheet = getSheet(row);
		sheet.removeRow(row);
	}

	// 删除行
	public void removeRow(Sheet sheet, int rowNo) {
		int lastRowNum = sheet.getLastRowNum();
		if (rowNo >= 0 && rowNo < lastRowNum)
			sheet.shiftRows(rowNo + 1, lastRowNum, -1);// 将行号为rowIndex+1一直到行号为lastRowNum的单元格全部上移一行，以便删除rowIndex行
		if (rowNo == lastRowNum) {
			clearRow(sheet, rowNo);
		}
	}

	// 复制行
	// 修改行的样式
	// 设置行高
	// ----------------------------------------
	// Cell
	// 查
	public Cell getOriCell(Row row, int colNo) {
		Cell cell = row.getCell(colNo);
		return cell;
	}

	public Cell getCell(Row row, int colNo) {
		Cell cell = row.getCell(colNo);
		if (cell == null) {
			cell = row.createCell(colNo);
		}
		return cell;
	}

	public Cell getCell(Sheet sheet, int rowNo, int colNo) {
		Row row = getRow(sheet, rowNo);
		return getCell(row, colNo);
	}

	public Cell getCell(String sheetName, int rowNo, int colNo) {
		Row row = getRow(sheetName, rowNo);
		return getCell(row, colNo);
	}

	// 返回Cell的值
	public String getCellStr(Cell cell) {
		String cellStr = "";
		if (cell == null)
			return cellStr;
		// System.out.println(cell.getCellType());
		switch (cell.getCellTypeEnum()) {
		case NUMERIC: // 数字
			if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				cellStr = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue()))
						.toString();
			} else {
				DataFormatter dataFormatter = new DataFormatter();
				cellStr = dataFormatter.formatCellValue(cell);
			}
			break;
		case STRING: // 字符串
			cellStr = cell.getStringCellValue();
			break;
		case BOOLEAN: // Boolean
			cellStr = cell.getBooleanCellValue() + "";
			break;
		case FORMULA: // 公式
			try {
				CellValue cellValue = getFormulaEvaluator().evaluate(cell);
				cellStr = getCellValueStr(cellValue);
			} catch (Exception e) {
				cellStr = cell.getCellFormula();
			}
			break;
		case BLANK: // 空值
			cellStr = "";
			break;
		case ERROR: // 故障
			cellStr = "非法字符";
			break;
		default:
			cellStr = "未知类型";
			break;
		}
		return cellStr;
	}

	public String getCellStr(Row row,int colNo) {
		Cell cell=getCell(row,colNo);
		return getCellStr(cell);
	}
	
	public String getCellStr(Sheet sheet,int rowNo,int colNo) {
		Cell cell=getCell(sheet,rowNo,colNo);
		return getCellStr(cell);
	}
	
	public String getCellValueStr(CellValue cellValue) {
		String cellStr = "";
		switch (cellValue.getCellTypeEnum()) {
		case BOOLEAN:
			cellStr = cellValue.getBooleanValue() + "";
			break;
		case NUMERIC:
			cellStr = cellValue.getNumberValue() + "";
			break;
		case STRING:
			cellStr = cellValue.getStringValue();
			break;
		case BLANK:
			break;
		case ERROR:
			break;
		case FORMULA:
			break;
		default:
			break;
		}
		return cellStr;
	}

	// 修改样式
	// 修改列宽
	public void setAutoColumn(Sheet sheet,int colNo) {
		 sheet.autoSizeColumn(colNo);
	}
	public void setColumnWidth(Sheet sheet,int colNo,int width) {
		sheet.setColumnWidth(colNo, 256*width+184);
	}
	// 修改单元格值
	public void setCellValue(Cell cell,String value) {
		cell.setCellValue(value);
	}
	public void setCellValue(Cell cell,boolean value) {
		cell.setCellValue(value);
	}
	public void setCellValue(Cell cell,double value) {
		cell.setCellValue(value);
	}
	public void setCellValue(Cell cell,RichTextString value) {
		cell.setCellValue(value);
	}
	public void setCellValue(Cell cell,Date value) {
		cell.setCellValue(value);
	}
	//添加链接
	public void linkTo(Sheet fromSheet,int fromRowNo,int fromColNo,Sheet toSheet,int toRowNo,int toColNo,boolean isCoverSrcStr) {
		Cell fromCell=getCell(fromSheet, fromRowNo,fromColNo);
		Cell toCell=getCell(toSheet, toRowNo,toColNo);
		linkTo(fromCell,toCell);
		if(isCoverSrcStr) {
			fromCell.setCellValue(getCellStr(toCell));
		}
	}
	public void linkTo(Sheet fromSheet,int fromRowNo,int fromColNo,Sheet toSheet,int toRowNo,int toColNo) {
		Cell fromCell=getCell(fromSheet, fromRowNo,fromColNo);
		Cell toCell=getCell(toSheet, toRowNo,toColNo);
		linkTo(fromCell,toCell);
	}
	public void linkTo(Cell fromCell,Cell toCell) {
		Hyperlink link = creationHelper.createHyperlink(HyperlinkType.DOCUMENT);
		link.setAddress("'"+getSheetName(toCell.getSheet())+"'!"+toCell.getAddress().formatAsString());
        fromCell.setHyperlink(link);
	}
	// 删除Cell
	public void removeCell(Row row, int colNo) {
		Cell cell = row.getCell(colNo);
		if (cell != null) {
			row.removeCell(cell);
		}
	}

	private FormulaEvaluator getFormulaEvaluator() {
		if (evaluator == null) {
			evaluator = curWb.getCreationHelper().createFormulaEvaluator();
		}
		return evaluator;
	}
}
