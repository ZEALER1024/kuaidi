package com.example.kuaidi;

import java.io.Serializable;

public class Remark implements Serializable {

	private String datetime;
	private String remark;

	public Remark() {
		// TODO Auto-generated constructor stub
	}

	public Remark(String datetime, String remark) {
		super();
		this.datetime = datetime;
		this.remark = remark;

	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
