package com.example.cricket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "liveupdate")
public class LiveUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long liveUpdateId;

    @Column
    int ballno;

    @Column
    int runs;

    @Column
    int batsman_id;

    @Column
    int bowler_id;

    @Column
    boolean batsman_out;

    @Column
    String ball_type;

    @Column
    int fielder_id;

    @Column
    int match_id;

    @Column
    int team_id;

    @Column
    String wicket_reason;

    @Column
    String commentary;

    public LiveUpdate() {
        super();
    }


    public LiveUpdate(int ballno, int runs, int batsman_id, int bowler_id, boolean batsman_out, String ball_type,
                      int fielder_id, int match_id, int team_id, String wicket_reason, String commentary) {
        super();
        this.ballno = ballno;
        this.runs = runs;
        this.batsman_id = batsman_id;
        this.bowler_id = bowler_id;
        this.batsman_out = batsman_out;
        this.ball_type = ball_type;
        this.fielder_id = fielder_id;
        this.match_id = match_id;
        this.team_id = team_id;
        this.wicket_reason = wicket_reason;
        this.commentary = commentary;
    }


    public LiveUpdate(Long liveUpdateId, int ballno, int runs, int batsman_id, int bowler_id, boolean batsman_out,
                      String ball_type, int fielder_id, int match_id, int team_id, String wicket_reason, String commentary) {
        super();
        this.liveUpdateId = liveUpdateId;
        this.ballno = ballno;
        this.runs = runs;
        this.batsman_id = batsman_id;
        this.bowler_id = bowler_id;
        this.batsman_out = batsman_out;
        this.ball_type = ball_type;
        this.fielder_id = fielder_id;
        this.match_id = match_id;
        this.team_id = team_id;
        this.wicket_reason = wicket_reason;
        this.commentary = commentary;
    }

    public Long getLiveUpdateId() {
        return liveUpdateId;
    }

    public void setLiveUpdateId(Long liveUpdateId) {
        this.liveUpdateId = liveUpdateId;
    }

    public int getBallno() {
        return ballno;
    }

    public void setBallno(int ballno) {
        this.ballno = ballno;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getBatsman_id() {
        return batsman_id;
    }

    public void setBatsman_id(int batsman_id) {
        this.batsman_id = batsman_id;
    }

    public int getBowler_id() {
        return bowler_id;
    }

    public void setBowler_id(int bowler_id) {
        this.bowler_id = bowler_id;
    }

    public boolean getBatsman_out() {
        return batsman_out;
    }

    public void setBatsman_out(boolean batsman_out) {
        this.batsman_out = batsman_out;
    }

    public String getBall_type() {
        return ball_type;
    }

    public void setBall_type(String ball_type) {
        this.ball_type = ball_type;
    }

    public int getFielder_id() {
        return fielder_id;
    }

    public void setFielder_id(int fielder_id) {
        this.fielder_id = fielder_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getWicket_reason() {
        return wicket_reason;
    }

    public void setWicket_reason(String wicket_reason) {
        this.wicket_reason = wicket_reason;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

}
