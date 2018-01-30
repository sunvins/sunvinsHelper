package com.sunvins.helper;

import java.util.HashMap;
import java.util.Map;

public class MapHelper {
	private static Map<String,String> typeMap;
	private static Map<String,String> importMap;
	private static Map<String,String> jdbcMap;
	static {
		typeMap=new HashMap<String,String>();
		typeMap.put("int", "int");
		typeMap.put("decimal", "double");
		typeMap.put("varchar", "String");
		typeMap.put("date", "Date");
		typeMap.put("datetime", "Date");
		
		jdbcMap=new HashMap<String,String>();
		jdbcMap.put("int", "INTEGER");
		jdbcMap.put("decimal", "DOUBLE");
		jdbcMap.put("varchar", "VARCHAR");
		jdbcMap.put("date", "DATE");
		jdbcMap.put("datetime", "DATE");
		
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
	
	/**
	 * 根据数据库类型取jdbc类型
	 * @param dbType
	 * @return
	 */
	public static String getJdbcType(String dbType) {
		return jdbcMap.get(dbType);
	}
	
	public static String getImpName(String javaType) {
		return importMap.get(javaType);
	}
}
