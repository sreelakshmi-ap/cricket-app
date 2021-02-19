package com.example.cricket.response;

public interface BestBowlingStrikeRate extends Comparable {
    Integer getId();
    String getName();
    String getImagePath();
    Integer getWickets();
    Float getOvers();
    Integer getBalls();
    Float getBestBowlingStrikeRate();


}
