package com.sunvins.helper;

import java.util.List;

import com.sunvins.vo.DB;
import com.sunvins.vo.Field;
import com.sunvins.vo.Table;

public class SqlHelper {

	public static void main(String[] args) {
		SqlHelper sh=new SqlHelper();
		sh.makeSql();
	}
	
	public void makeSql() {
		TableHelper th=new TableHelper();
		String excelFileName="G:\\pro\\xls\\数据库表设计1.xlsx";
		List<Table> tableList=th.makeTable(excelFileName,null);
//		JsonHelper.show(tableList);
		FmtHelper fh=new FmtHelper();
		DB db=new DB(tableList);
		fh.toShow("G:\\workspace2\\sunvinsHelper\\src\\main\\resources\\fmt\\sql.fmt", db);
	}
//	public void makeSql(List<Table> tableList) {
//		StringBuffer allSql=new StringBuffer();
//		StringBuffer tbSql=new StringBuffer();
//		StringBuffer dropSql=new StringBuffer();
//		StringBuffer indexSql=new StringBuffer();
//		for(Table table:tableList) {
////			System.out.println(table.getTableDbName()+"\t"+table.getTableComment());
////			System.out.println("--------------------------");
//			String tableDbName=table.getTableDbName();
//			String tableComment=table.getTableComment();
//			dropSql.append("DROP TABLE ").append(tableDbName).append(";\n");
//			tbSql.append("CREATE TABLE ").append(tableDbName).append(" (\n");
//			List<Field> fieldList=table.getFieldList();
//			for(int j=0;j<fieldList.size();j++) {
//				Field field=fieldList.get(j);
//				String fieldDbName=field.getFieldDbName();
//				String fieldComment=field.getFieldComment();
//				String fieldDbType=field.getFieldDbType();
//				String fieldLenght=field.getFieldLength();
//				String fieldIndex=field.getFieldIndex();
////				String fieldNullable=field.getFieldNullable();
//				if("varchar2".equals(fieldDbType)) {
//					fieldDbType="varchar";
//				}
//				tbSql.append("\t").append(fieldDbName).append(" ").append(fieldDbType);
//				if(!StrHelper.isBlank(fieldLenght)) {
//					tbSql.append("(").append(fieldLenght).append(")");
//				}
//				if("主键".equals(fieldIndex)) {
//					tbSql.append(" PRIMARY KEY AUTO_INCREMENT");
//				}else if("索引".equals(fieldIndex)) {
//					indexSql.append("CREATE INDEX ").append(tableDbName).append("_").append(fieldDbName);
//					indexSql.append(" ON ").append(tableDbName).append("(").append(fieldDbName).append(");\n");
//				}
////				if("N".equals(fieldNullable)) {
//					tbSql.append(" NOT NULL");
////				}
//				if(!StrHelper.isBlank(fieldComment)) {
//					tbSql.append(" COMMENT '").append(fieldComment).append("'");
//				}
//				if(j!=fieldList.size()-1) {
//					tbSql.append(",\n");
//				}else {
//					tbSql.append("\n");
//				}
//			}
//			tbSql.append(")").append(" COMMENT='").append(tableComment).append("';\n");
////			allSql.append(dropSql);
//			allSql.append(tbSql);
//			allSql.append(indexSql);
//			allSql.append("\n");
//			
////			dropSql.setLength(0);
//			tbSql.setLength(0);
//			indexSql.setLength(0);
//		}
//		System.out.println(dropSql.toString());
//		System.out.println(allSql.toString());
//	}

}
