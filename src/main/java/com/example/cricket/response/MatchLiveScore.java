package com.example.cricket.response;

import java.util.List;

public class MatchLiveScore {
    private int innings;
    private LiveScore teamOne;
    private LiveScore teamTwo;

    public MatchLiveScore() {
    }

    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public LiveScore getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(LiveScore teamOne) {
        this.teamOne = teamOne;
    }

    public LiveScore getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(LiveScore teamTwo) {
        this.teamTwo = teamTwo;
    }
}
