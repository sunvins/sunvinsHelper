package com.sunvins.helper;

public class StrHelper {
	
	public static final char UNDERLINE = '_';
	public static void main(String[] args) {
//		String str=" ";
//		System.out.println(StringUtils.isBlank(str));
//		System.out.println(StringUtils.isEmpty(str));
//		LogHelper.time();
//		int max=1000000;
//		LogHelper.time();
//		for(int i=0;i<max;i++) {
//			toCamel2("good_nice_why");
//		}
//		LogHelper.time();
//		for(int i=0;i<max;i++) {
//			toCamelOri("good_nice_why");
//		}
//		LogHelper.time();
//		System.out.println("Goodboy");
//		System.out.println(upFirst("goodboy"));
//		System.out.println(StringUtils.capitalize("goodboy"));
//		System.out.println(toCamel2("good_nice_why"));
	}
	public static String trim(String str) {  
		if(isBlank(str)) return "";
		return str.trim();
	}
	
	/** 
	 * 首字母大写 
	 *  
	 * @param string 
	 * @return 
	 */  
	public static String upFirst(String string) {  
	    char[] charArray = string.toCharArray();  
	    charArray[0] = Character.toUpperCase(charArray[0]);  
	    return String.valueOf(charArray);  
	}  
	
	/**
	 * 字符串是否为空，null或"  "都为True
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return (str==null || "".equals(str.trim()));//比StringUtils.isBlank(str)快
	}
	/**
	 * 字符串不为null，且不为"   "时为True
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	 /**
     * 再下划线格式字符串转换为驼峰格式字符串
     * @param str
     * @return
     */
    public static String toCamelOri(String str) {
        if (StrHelper.isBlank(str)) {
            return "";
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(str.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

	 /**
     * 再下划线格式字符串转换为驼峰格式字符串
     * @param str
     * @return
     */
    public static String toCamel2(String str) {
	    char[] charArray = str.toCharArray();
	    boolean needCap=false;
	    for(int i=0,leng=charArray.length;i<leng;i++) {
	    	char c=charArray[i];
	    	if(needCap) {
	    		charArray[i]=Character.toUpperCase(c);
	    		needCap=false;
	    	}
	    	 if (c == UNDERLINE) {
	    		 needCap=true;
	    	 }
	    }
	    return String.valueOf(charArray).replace("_", "");  
    }
    /**
     * 先全部变小写，再下划线格式字符串转换为驼峰格式字符串
     * @param str
     * @return
     */
    public static String toCamel(String str) {
        if (StrHelper.isBlank(str)) {
            return "";
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(str.charAt(i)));
                }
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
    /**
     * 将驼峰式变成下划线+小写
     * @param str
     * @return
     */
    public static String toUnderline(String str) { 
        if (StrHelper.isBlank(str)) {
            return "";
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
            	sb.append(UNDERLINE).append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
