package com.example.cricket.response;

import java.util.List;
import org.springframework.http.HttpStatus;

public class ListAndMessageResponse {

	List<?> resultList;
	private HttpStatus responseStatus;
	private int noOfItems;

	public ListAndMessageResponse() {
	}

	public ListAndMessageResponse(List<?> resultList, HttpStatus responseStatus, int noOfItems) {
		this.resultList = resultList;
		this.responseStatus = responseStatus;
		this.noOfItems = noOfItems;
	}
	
	

	public ListAndMessageResponse(HttpStatus responseStatus) {
		super();
		this.responseStatus = responseStatus;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

}
