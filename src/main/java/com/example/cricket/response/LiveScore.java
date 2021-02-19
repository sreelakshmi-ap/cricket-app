package com.example.cricket.response;


import com.example.cricket.model.TeamScore;

import java.util.List;

public class LiveScore {

   private TeamScore team;

    private List<?> batsmen;

    private List<?> bowlers;

    private List<?> partnership;

    private List<?> fallOfWicket;

    private List<?> commentary;

    public LiveScore() {
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

    public List<?> getPartnership() {
        return partnership;
    }

    public void setPartnership(List<?> partnership) {
        this.partnership = partnership;
    }

    public List<?> getFallOfWicket() {
        return fallOfWicket;
    }

    public void setFallOfWicket(List<?> fallOfWicket) {
        this.fallOfWicket = fallOfWicket;
    }

    public List<?> getCommentary() {
        return commentary;
    }

    public void setCommentary(List<?> commentary) {
        this.commentary = commentary;
    }
}
