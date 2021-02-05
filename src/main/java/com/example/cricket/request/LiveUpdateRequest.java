package com.example.cricket.request;

import java.net.http.HttpResponse;

import com.example.cricket.model.LiveUpdate;

public class LiveUpdateRequest {
	int wicketId;
	int playerRuns;
	String extras;
	String wickets;
	HttpResponse response;
	String message;
	LiveUpdate liveUpdate;

	public LiveUpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LiveUpdateRequest(int wicketId, int playerRuns, String extras, String wickets, HttpResponse response,
			String message, LiveUpdate liveUpdate) {
		super();
		this.wicketId = wicketId;
		this.playerRuns = playerRuns;
		this.extras = extras;
		this.wickets = wickets;
		this.response = response;
		this.message = message;
		this.liveUpdate = liveUpdate;
	}

	public int getPlayerRuns() {
		return playerRuns;
	}

	public void setPlayerRuns(int playerRuns) {
		this.playerRuns = playerRuns;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public String getWickets() {
		return wickets;
	}

	public void setWickets(String wickets) {
		this.wickets = wickets;
	}

	public int getWicketId() {
		return wicketId;
	}

	public void setWicketId(int wicketId) {
		this.wicketId = wicketId;
	}

	public HttpResponse getResponse() {
		return response;
	}

	public void setResponse(HttpResponse response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LiveUpdate getLiveUpdate() {
		return liveUpdate;
	}

	public void setLiveUpdate(LiveUpdate liveUpdate) {
		this.liveUpdate = liveUpdate;
	}

}
