package com.sunvins.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		FmtHelper fh=new FmtHelper();
		TableHelper sh=new TableHelper();
		List<Table> tableList=sh.makeTable();
		Map<String,String> pathMap=new HashMap<String,String>();
		String fmtPath="G:\\workspace2\\sunvinsHelper\\src\\main\\resources\\fmt\\";
		pathMap.put("${voName}-Mapper.xml", "G:\\workspace2\\mvc4\\src\\main\\resources\\mapper\\");
		pathMap.put("${voName}Dao.java", "G:\\workspace2\\mvc4\\src\\main\\java\\com\\sunvins\\dao\\");
		pathMap.put("${voName}Service.java", "G:\\workspace2\\mvc4\\src\\main\\java\\com\\sunvins\\service\\");
		pathMap.put("${voName}ServiceImpl.java", "G:\\workspace2\\mvc4\\src\\main\\java\\com\\sunvins\\service\\Impl\\");
		pathMap.put("${voName}VO.java", "G:\\workspace2\\mvc4\\src\\main\\java\\com\\sunvins\\model\\");
		
		for(Table table:tableList) {
			for (Entry<String, String> entry : pathMap.entrySet()) { 
				  String fileName=entry.getKey();
				  String outPath=entry.getValue();
				  String fmtFileName=fmtPath+fileName;
//				  System.out.println(fileName+"\t"+outPath+"\t"+fmtFileName);
				  String outFileName=outPath+fh.toStr(fileName, table);
				  System.out.println(outFileName);
				  fh.toFile(fmtFileName, table, outFileName);
			}
		}
		
//		String fmtFile="G:\\workspace2\\sunvinsHelper\\src\\main\\resources\\fmt\\${voName}-Mapper.xml";
//		String fmtFile="G:\\workspace2\\sunvinsHelper\\src\\main\\resources\\fmt\\${voName}VO.fmt";
		
//		fh.toShow(fmtFile, tableList.get(1));
//		for(Table table:tableList) {
//			fh.toShow(fmtFile, table);
//		}
//		JsonHelper.show(tableList.get(1));
//		for(Table table:tableList) {
//			System.out.println(ToStringBuilder.reflectionToString(table, ToStringStyle.SIMPLE_STYLE));
//		}
	}
	
}
