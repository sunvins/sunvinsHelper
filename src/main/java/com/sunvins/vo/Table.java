package com.sunvins.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sunvins.helper.MapHelper;

public class Table {
	private String tableDbName;
	private String voName;
	private String tableComment;
	private List<Field> fieldList;
	private Set<String> impSet;
	
	public Table() {
		fieldList=new ArrayList<Field>();
		impSet=new HashSet<String>();
	}
	
	public void addImp(String javaType) {
		String impValue=MapHelper.getImpName(javaType);
		if(impValue!=null)
			impSet.add(impValue);
	}
	
	public String getTableDbName() {
		return tableDbName;
	}
	public void setTableDbName(String tableDbName) {
		this.tableDbName = tableDbName;
	}
	public String getVoName() {
		return voName;
	}
	public void setVoName(String voName) {
		this.voName = voName;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	
	public void add(Field field) {
		fieldList.add(field);
	}
	public List<Field> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}

	public Set<String> getImpSet() {
		return impSet;
	}

	public void setImpSet(Set<String> impSet) {
		this.impSet = impSet;
	}
}
