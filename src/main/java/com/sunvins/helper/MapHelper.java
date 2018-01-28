package com.sunvins.helper;

import java.util.HashMap;
import java.util.Map;

public class MapHelper {
	private static Map<String,String> typeMap;
	private static Map<String,String> importMap;
	static {
		typeMap=new HashMap<String,String>();
		typeMap.put("int", "int");
		typeMap.put("varchar2", "String");
		typeMap.put("date", "Date");
		typeMap.put("datetime", "Date");
		
		importMap=new HashMap<String,String>();
		importMap.put("Date", "java.util.Date");
	}
	
	public static void main(String[] args) {

	}
	
	/**
	 * 根据数据库类型取java类型
	 * @param dbType
	 * @return
	 */
	public static String getJavaType(String dbType) {
		return typeMap.get(dbType);
	}
	
	public static String getImpName(String javaType) {
		return importMap.get(javaType);
	}
}
