package com.sunvins.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.sunvins.vo.Field;
import com.sunvins.vo.Table;

public class TableHelper {

	private PoiHelper ph;
	public static void main(String[] args) {
		String fieldLength="17.0";
		int pos1=fieldLength.indexOf(',');
		int pos2=fieldLength.indexOf('.');
		String scale="";
		if(pos1>0) {
			scale=fieldLength.substring(pos1+1);
			if(Integer.valueOf(scale)==0) {
				scale="";
			}
			fieldLength=fieldLength.substring(0, pos1);
		}else if(pos2>0) {
			scale=fieldLength.substring(pos2+1);
			if(Integer.valueOf(scale)==0) {
				scale="";
			}
			fieldLength=fieldLength.substring(0, pos2);
		}
		System.out.println(scale+"--"+fieldLength);
	}
	
	public List<Table> makeTable() {
		return makeTable(null);
	}
	public List<Table> makeTable(List<String> tableFilter) {
		return makeTable(null,tableFilter);
	}
	
	/**
	 * 生成数据库表(集合）
	 * @param excelFileName
	 * @param tableFilter
	 * @return
	 */
	public List<Table> makeTable(String excelFileName,List<String> tableFilter) {
		if(StrHelper.isBlank(excelFileName)) {
			excelFileName="G:\\pro\\xls\\数据库表设计.xlsx";
		}
//		List<String> tableFilter= null;
//		tableFilter=new ArrayList<String>();
//		tableFilter.add("s_info");
//		tableFilter.add("s_data_dict");
		ph=new PoiHelper(excelFileName);
		Sheet sheet=ph.getSheet(0);
		String tableDbName=null;
		List<Table> tableList=new ArrayList<Table>();
		Table table=null;
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			Row row=ph.getRow(sheet, i);
			String tableDbNamePre=getCellStr(row,1); //准备变成数据库表名的单元格值
			if(StrHelper.isBlank(tableDbNamePre)) { //处理空行：注意（最后一个字段或者表名之前允许空行）
				tableDbName=null; 
				continue;
			}else if(isTable(tableDbNamePre)) {//是否符合表的特征 
				if(tableFilter==null || tableFilter.contains(tableDbNamePre)) {//如果有过滤条件，就过滤表
					tableDbName=StrHelper.trim(tableDbNamePre);
					String tableComment=getCellStr(row,0);
					table=createTable(tableDbName,tableComment);//创建表
					tableList.add(table);
				}
			}else {
				if(tableDbName==null)continue;
				Field field=createField(row);//创建字段
				table.add(field);
				String fieldJavaType=field.getFieldJavaType();
				table.addImp(fieldJavaType);//根据filed的Java类型添加import的内容
			}
		}
		return tableList;
	}
	
	/**
	 * 是否符合表的特征 
	 * @param fieldDbName
	 * @return
	 */
	private boolean isTable(String fieldDbName) {
		return fieldDbName.startsWith("s_");
	}
	
	/**
	 * 创建单个表
	 * @param tableDbName
	 * @param tableComment
	 * @return
	 */
	private Table createTable(String tableDbName,String tableComment) {
		Table table=new Table();
		table.setTableDbName(tableDbName); //表名
		table.setTableComment(tableComment); //表的中文名
		String voName=StrHelper.toCamel(tableDbName.substring(2)); 
		table.setVoName(StrHelper.upFirst(voName)); //表对应的Java名(首字母大写)
		return table;
	}
	
	/**
	 * 将Excel的行转为字段
	 * @param row
	 * @return
	 */
	private Field createField(Row row) {
		Field field=new Field();
		String fieldComment=getCellStr(row,0); //字段中文名
		String fieldDbName=getCellStr(row,1); //字段数据库名
		String fieldDbType=getCellStr(row,2); // 字段数据库
		String fieldLength=getCellStr(row,3); //字段长度
		String fieldIndex=getCellStr(row,4); //字段索引
		String fieldNullable=getCellStr(row,5); //是否允许空
		int pos1=fieldLength.indexOf(',');
		int pos2=fieldLength.indexOf('.');
		String scale="";
		if(pos1>0) {
			scale=fieldLength.substring(pos1+1);
			if(Integer.valueOf(scale)==0) {
				scale="";
			}
			fieldLength=fieldLength.substring(0, pos1);
		}else if(pos2>0) {
			scale=fieldLength.substring(pos2+1);
			if(Integer.valueOf(scale)==0) {
				scale="";
			}
			fieldLength=fieldLength.substring(0, pos2);
		}
		if(!StrHelper.isBlank(scale)) fieldDbType="decimal";
		String fieldJavaType=MapHelper.getJavaType(fieldDbType); //字段Java 类型
		field.setFieldDbName(fieldDbName);
		field.setFieldName(StrHelper.toCamel(fieldDbName));
		field.setFieldComment(fieldComment);
		field.setFieldDbType(fieldDbType);
		field.setFieldJavaType(fieldJavaType);
		field.setFieldLength(fieldLength);
		field.setFieldIndex(fieldIndex);
		field.setFieldNullable(fieldNullable);
		field.setFieldJdbcType(MapHelper.getJdbcType(fieldDbType));
		field.setScale(scale);
		return field;
	}
	
	/**
	 * 从Excel的单元格中取值，并trim
	 * @param row
	 * @param colNo
	 * @return
	 */
	private String getCellStr(Row row,int colNo) {
		String str=ph.getCellStr(row,colNo);
		return StrHelper.trim(str);
	}
}
