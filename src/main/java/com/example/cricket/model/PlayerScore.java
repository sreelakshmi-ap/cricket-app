package com.example.cricket.model;

import javax.persistence.*;

@Entity
@Table(name = "playerScore")
public class PlayerScore {

    @Id
    @Column(name = "playerScoredId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerScoredId;

    @Column(name = "teamId")
    private int teamId;

    @Column(name = "playerId")
    private int playerId;

    @Column(name = "onCrease")
    private boolean onCrease;

    @Column(name = "batting")
    private boolean batting;

    @Column(name = "bowling")
    private boolean bowling;

    @Column(name = "runScored")
    private int runScored;

    @Column(name = "ballFaced")
    private int ballFaced;

    @Column(name = "noOfFours")
    private int noOfFours;

    @Column(name = "noOfSixes")
    private int noOfSixes;

    @Column(name = "noOfOversBowled")
    private float noOfOversBowled;

    @Column(name = "noOfMaidens")
    private int noOfMaidens;

    @Column(name = "runs")
    private int runs;

    @Column(name = "wickets")
    private int wickets;

    @Column(name = "economyRate")
    private float economyRate;

    public PlayerScore() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public boolean isOnCrease() {
        return onCrease;
    }

    public void setOnCrease(boolean onCrease) {
        this.onCrease = onCrease;
    }

    public boolean isBatting() {
        return batting;
    }

    public void setBatting(boolean batting) {
        this.batting = batting;
    }

    public boolean isBowling() {
        return bowling;
    }

    public void setBowling(boolean bowling) {
        this.bowling = bowling;
    }

    public int getRunScored() {
        return runScored;
    }

    public void setRunScored(int runScored) {
        this.runScored = runScored;
    }

    public int getBallFaced() {
        return ballFaced;
    }

    public void setBallFaced(int ballFaced) {
        this.ballFaced = ballFaced;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public void setNoOfFours(int noOfFours) {
        this.noOfFours = noOfFours;
    }

    public int getNoOfSixes() {
        return noOfSixes;
    }

    public void setNoOfSixes(int noOfSixes) {
        this.noOfSixes = noOfSixes;
    }

    public float getNoOfOversBowled() {
        return noOfOversBowled;
    }

    public void setNoOfOversBowled(float noOfOversBowled) {
        this.noOfOversBowled = noOfOversBowled;
    }

    public int getNoOfMaidens() {
        return noOfMaidens;
    }

    public void setNoOfMaidens(int noOfMaidens) {
        this.noOfMaidens = noOfMaidens;
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

    public float getEconomyRate() {
        return economyRate;
    }

    public void setEconomyRate(float economyRate) {
        this.economyRate = economyRate;
    }
}
