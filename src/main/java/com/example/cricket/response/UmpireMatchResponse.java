package com.example.cricket.response;

public class UmpireMatchResponse {
	
	private Object umpireDetail;
	private Object matchDetails;
	public UmpireMatchResponse( ) {
		
	}
	public UmpireMatchResponse(Object umpireDetail, Object matchDetails) {
		super();
		this.umpireDetail = umpireDetail;
		this.matchDetails = matchDetails;
	}
	public Object getUmpireDetails() {
		return umpireDetail;
	}
	public void setUmpireDetails(Object umpireDetail) {
		this.umpireDetail = umpireDetail;
	}
	public Object getMatchDetails() {
		return matchDetails;
	}
	public void setMatchDetails(Object matchDetails) {
		this.matchDetails = matchDetails;
	}
	

	
	
	
	

}
