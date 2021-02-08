package com.example.cricket.request;

import com.example.cricket.model.LiveUpdate;

public class LiveUpdateRequest {
	private int runScored;
	private String extra;
	private String wicketCondition;
	private int wicketId;
	private LiveUpdate liveUpdate;
	
	public LiveUpdateRequest() {
		
	}
	
	public LiveUpdateRequest(int runScored, String extra, String wicketCondition, int wicketId, LiveUpdate liveUpdate) {
		super();
		this.runScored = runScored;
		this.extra = extra;
		this.wicketCondition = wicketCondition;
		this.wicketId = wicketId;
		this.liveUpdate = liveUpdate;
	}

	public int getRunScored() {
		return runScored;
	}

	public void setRunScored(int runScored) {
		this.runScored = runScored;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getWicketCondition() {
		return wicketCondition;
	}

	public void setWicketCondition(String wicketCondition) {
		this.wicketCondition = wicketCondition;
	}

	public int getWicketId() {
		return wicketId;
	}

	public void setWicketId(int wicketId) {
		this.wicketId = wicketId;
	}

	public LiveUpdate getLiveUpdate() {
		return liveUpdate;
	}

	public void setLiveUpdate(LiveUpdate liveUpdate) {
		this.liveUpdate = liveUpdate;
	}
	
	
	
	

}
