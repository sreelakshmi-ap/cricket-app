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

    @Column(name = "overs")
    private float overs;

    @Column(name = "noOfBalls")
    private int noOfBalls;

    @Column(name = "extraRuns")
    private int extraRuns;

    public TeamScore() {
    }

    public TeamScore(int matchId, int teamId, boolean battingOrder, int runs, int wickets, float currentRunRate, float requiredRunRate, float overs, int noOfBalls, int extraRuns) {
        this.matchId = matchId;
        this.teamId = teamId;
        this.battingOrder = battingOrder;
        this.runs = runs;
        this.wickets = wickets;
        this.currentRunRate = currentRunRate;
        this.requiredRunRate = requiredRunRate;
        this.overs = overs;
        this.noOfBalls = noOfBalls;
        this.extraRuns = extraRuns;
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

    public float getOvers() {
        return overs;
    }

    public void setOvers(float overs) {
        this.overs = overs;
    }

    public int getNoOfBalls() {
        return noOfBalls;
    }

    public void setNoOfBalls(int noOfBalls) {
        this.noOfBalls = noOfBalls;
    }

    public int getExtraRuns() {
        return extraRuns;
    }

    public void setExtraRuns(int extraRuns) {
        this.extraRuns = extraRuns;
    }
}
