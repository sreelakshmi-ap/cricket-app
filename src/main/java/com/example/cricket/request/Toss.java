package com.example.cricket.request;

public class Toss {

    private int matchId;
    private int teamId;
    private boolean tossWinner;

    public Toss() {
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public boolean isTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(boolean tossWinner) {
        this.tossWinner = tossWinner;
    }
}

