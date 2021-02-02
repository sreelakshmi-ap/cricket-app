package com.example.cricket.model;

import javax.persistence.*;

@Entity
@Table(name = "tournamentGround")
public class TournamentGround {

    @Id
    @Column(name = "mapId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mapId;

    @Column(name = "tournamentId")
    private int tournamentId;

    @Column(name = "groundId")
    private int groundId;

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Integer getGroundId() {
        return groundId;
    }

    public void setGroundId(int groundId) {
        this.groundId = groundId;
    }
}
