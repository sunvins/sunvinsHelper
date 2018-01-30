package com.sunvins.vo;

import java.util.List;

public class DB {
	private List<Table> tableList;

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}

	public DB(List<Table> tableList) {
		super();
		this.tableList = tableList;
	}
	
}
