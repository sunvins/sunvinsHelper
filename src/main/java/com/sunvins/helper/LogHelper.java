package com.sunvins.helper;

import org.apache.commons.lang.StringUtils;

public class LogHelper {

	private static long lastTime=0;
	
    public static void main(String[] args) {
    }
    public static boolean test1(String ss) {
    	return ss==null || "".equals(ss.trim());
    }
    public static boolean test2(String ss) {
    	return StringUtils.isBlank(ss);
    }
    public static boolean test3(String ss) {
    	return StrHelper.isBlank(ss);
    }
    
	public void show() {
		
	}
	public static void time() {
		long now=System.currentTimeMillis();
		if(lastTime!=0) {
			System.out.println("-----Time pass:\t"+(now-lastTime));
		}
//		System.out.println(now);
		lastTime=now;
	}
	
   
}
