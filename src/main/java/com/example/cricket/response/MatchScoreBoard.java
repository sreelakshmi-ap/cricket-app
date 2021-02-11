package com.example.cricket.response;

public class MatchScoreBoard {
    private ScoreBoard teamOne;
    private ScoreBoard teamTwo;

    public MatchScoreBoard() {
    }

    public ScoreBoard getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(ScoreBoard teamOne) {
        this.teamOne = teamOne;
    }

    public ScoreBoard getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(ScoreBoard teamTwo) {
        this.teamTwo = teamTwo;
    }
}
