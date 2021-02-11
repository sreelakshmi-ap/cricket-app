package com.example.cricket.request;

public class Playing {
    private int playerId;

    private boolean onCrease;

    private boolean batting;

    private boolean bowling;

    public Playing() {
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
}
