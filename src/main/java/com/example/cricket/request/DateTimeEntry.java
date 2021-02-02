package com.example.cricket.request;

public class DateTimeEntry {
	
	String startDate;
	String endDate;
	String startOfTime;
	String endOfTime;
	
	
	
	public DateTimeEntry() {
		super();
	}



	public DateTimeEntry(String startDate, String endDate, String startOfTime, String endOfTime) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.startOfTime = startOfTime;
		this.endOfTime = endOfTime;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public String getStartOfTime() {
		return startOfTime;
	}



	public void setStartOfTime(String startOfTime) {
		this.startOfTime = startOfTime;
	}



	public String getEndOfTime() {
		return endOfTime;
	}



	public void setEndOfTime(String endOfTime) {
		this.endOfTime = endOfTime;
	}
	
	
	
	

}
