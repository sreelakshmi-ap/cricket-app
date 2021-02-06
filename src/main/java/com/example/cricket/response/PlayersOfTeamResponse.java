package com.example.cricket.response;

import com.example.cricket.model.PlayerEntity;

public class PlayersOfTeamResponse {

    private int teamId;
    private String designation;
    private PlayerEntity playerEntity;

    public PlayersOfTeamResponse(int teamId, String designation, PlayerEntity playerEntity) {
        super();
        this.teamId = teamId;
        this.designation = designation;
        this.playerEntity = playerEntity;
    }

    public int getTeamId() {
        return teamId;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }
    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }



}