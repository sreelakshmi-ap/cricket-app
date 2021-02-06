package com.example.cricket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teamPlayer")
public class TeamPlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamPlayerId;

    @Column
    private int teamId;

    @Column
    private int playerId;

    @Column
    private String designation;

    public TeamPlayerEntity() {

    }
    public TeamPlayerEntity(int teamId, int playerId, String designation) {
        super();
        this.teamId = teamId;
        this.playerId = playerId;
        this.designation = designation;
    }

    public int getTeamPlayerId() {
        return teamPlayerId;
    }

    public void setTeamPlayerId(int teamPlayerId) {
        this.teamPlayerId = teamPlayerId;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


}
