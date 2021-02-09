package com.example.cricket.request;

import com.example.cricket.model.LiveUpdate;

public class LiveUpdateRequest {
	
	private int wicketId;
	private LiveUpdate liveUpdate;
	
	
	
	public LiveUpdateRequest() {
		super();
	}


	public LiveUpdateRequest(LiveUpdate liveUpdate) {
		super();
		this.liveUpdate = liveUpdate;
	}


	public LiveUpdateRequest(int wicketId, LiveUpdate liveUpdate) {
		super();
		this.wicketId = wicketId;
		this.liveUpdate = liveUpdate;
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
