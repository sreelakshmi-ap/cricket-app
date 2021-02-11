package com.example.cricket.response;

public class BatsmanDetails {
    private int id;
    private String playerName;
    private int runScored;
    private int ballFaced;
    private float batsmenSr;
    private int noOfFours;
    private int noOfSixes;
    private boolean onCrease;
    private boolean batsmanOut;
    private String fielderName;
    private String wicketReason;

    public BatsmanDetails(int id, String playerName, int runScored, int ballFaced, float batsmenSr, int noOfFours, int noOfSixes, boolean onCrease,boolean batsmanOut, String fielderName, String wicketReason) {
        this.id = id;
        this.playerName = playerName;
        this.runScored = runScored;
        this.ballFaced = ballFaced;
        this.batsmenSr = batsmenSr;
        this.noOfFours = noOfFours;
        this.noOfSixes = noOfSixes;
        this.onCrease = onCrease;
        this.batsmanOut = batsmanOut;
        this.fielderName = fielderName;
        this.wicketReason = wicketReason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public float getBatsmenSr() {
        return batsmenSr;
    }

    public void setBatsmenSr(float batsmenSr) {
        this.batsmenSr = batsmenSr;
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

    public boolean isOnCrease() {
        return onCrease;
    }

    public void setOnCrease(boolean onCrease) {
        this.onCrease = onCrease;
    }

    public boolean isBatsmanOut() {
        return batsmanOut;
    }

    public void setBatsmanOut(boolean batsmanOut) {
        this.batsmanOut = batsmanOut;
    }

    public String getFielderName() {
        return fielderName;
    }

    public void setFielderName(String fielderName) {
        this.fielderName = fielderName;
    }

    public String getWicketReason() {
        return wicketReason;
    }

    public void setWicketReason(String wicketReason) {
        this.wicketReason = wicketReason;
    }
}
