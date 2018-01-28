package com.sunvins.vo;

public class Field {
	private String fieldDbName; //字段数据库名
	private String fieldName; //字段名
	private String fieldComment; //字段含义
	private String fieldDbType; //数据库类型
	private String fieldJavaType; //java类型
	private String fieldLength; //长度
	private String fieldNullable; //是否允许空
	private String fieldIndex; //索引
	
	public String getFieldDbName() {
		return fieldDbName;
	}
	public void setFieldDbName(String fieldDbName) {
		this.fieldDbName = fieldDbName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldComment() {
		return fieldComment;
	}
	public void setFieldComment(String fieldComment) {
		this.fieldComment = fieldComment;
	}
	public String getFieldDbType() {
		return fieldDbType;
	}
	public void setFieldDbType(String fieldDbType) {
		this.fieldDbType = fieldDbType;
	}
	public String getFieldJavaType() {
		return fieldJavaType;
	}
	public void setFieldJavaType(String fieldJavaType) {
		this.fieldJavaType = fieldJavaType;
	}
	public String getFieldLength() {
		return fieldLength;
	}
	public void setFieldLength(String fieldLength) {
		this.fieldLength = fieldLength;
	}
	public String getFieldNullable() {
		return fieldNullable;
	}
	public void setFieldNullable(String fieldNullable) {
		this.fieldNullable = fieldNullable;
	}
	public String getFieldIndex() {
		return fieldIndex;
	}
	public void setFieldIndex(String fieldIndex) {
		this.fieldIndex = fieldIndex;
	}
}
