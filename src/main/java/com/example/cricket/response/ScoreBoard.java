package com.example.cricket.response;

import com.example.cricket.model.TeamScore;

import java.util.List;

public class ScoreBoard {
    private TeamScore team;

    private List<?> batsmen;

    private List<?> bowlers;

    public ScoreBoard() {
    }

    public TeamScore getTeam() {
        return team;
    }

    public void setTeam(TeamScore team) {
        this.team = team;
    }

    public List<?> getBatsmen() {
        return batsmen;
    }

    public void setBatsmen(List<?> batsmen) {
        this.batsmen = batsmen;
    }

    public List<?> getBowlers() {
        return bowlers;
    }

    public void setBowlers(List<?> bowlers) {
        this.bowlers = bowlers;
    }
}
