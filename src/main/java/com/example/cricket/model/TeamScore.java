package com.example.cricket.model;

import javax.persistence.*;

@Entity
@Table(name = "teamScore")
public class TeamScore {

    @Id
    @Column(name = "teamScoredId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamScoredId;

    @Column(name = "matchId")
    private int matchId;

    @Column(name = "teamId")
    private int teamId;

    @Column(name = "battingOrder")
    private boolean battingOrder;

    @Column(name = "runs")
    private int runs;

    @Column(name = "wickets")
    private int wickets;

    @Column(name = "currentRunRate")
    private float currentRunRate;

    @Column(name = "requiredRunRate")
    private float requiredRunRate;

    public TeamScore() {
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

    public boolean isBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(boolean battingOrder) {
        this.battingOrder = battingOrder;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public float getCurrentRunRate() {
        return currentRunRate;
    }

    public void setCurrentRunRate(float currentRunRate) {
        this.currentRunRate = currentRunRate;
    }

    public float getRequiredRunRate() {
        return requiredRunRate;
    }

    public void setRequiredRunRate(float requiredRunRate) {
        this.requiredRunRate = requiredRunRate;
    }
}
