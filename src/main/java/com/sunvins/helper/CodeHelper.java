package com.sunvins.helper;

import java.util.List;

import com.sunvins.vo.Table;

public class CodeHelper {

	public static void main(String[] args) {
		CodeHelper ch=new CodeHelper();
		ch.makeCode();
//		int max=1000000;
//		LogHelper.time();
//		for(int i=0;i<max;i++) {
//			StrHelper.upFirst("goodboy");
//		}
//		LogHelper.time();
//		for(int i=0;i<max;i++) {
//
//		}
//		LogHelper.time();
	}
	
	public void makeCode() {
		TableHelper sh=new TableHelper();
		List<Table> tableList=sh.makeTable();
		String fmtFile="G:\\workspace2\\sunvinsHelper\\src\\main\\resources\\fmt\\${voName}VO.fmt";
		FmtHelper fh=new FmtHelper();
		for(Table table:tableList) {
			fh.toShow(fmtFile, table);
		}
//		JsonHelper.show(tableList.get(1));
//		for(Table table:tableList) {
//			System.out.println(ToStringBuilder.reflectionToString(table, ToStringStyle.SIMPLE_STYLE));
//		}
	}
	
}
