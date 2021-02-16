package com.example.cricket.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricket.model.TeamPlayerEntity;





@Service
public class SortingService {
	
    @Autowired
    private ComparatorService comparatorService ;
	
	public List<TeamPlayerEntity> PlayerSortByStat(List<TeamPlayerEntity> playerList, String value) {
		if(value.equalsIgnoreCase("most runs")) {
			Collections.sort(playerList,comparatorService.mostRuns);
			
		}
		else if(value.equalsIgnoreCase("most fifties")) {
			Collections.sort(playerList,comparatorService.mostFifties);
			
		}
		else if(value.equalsIgnoreCase("most hundreds")) {
			Collections.sort(playerList,comparatorService.mosthundreds);
			
		}
		else if(value.equalsIgnoreCase("most wickets")) {
			Collections.sort(playerList,comparatorService.mostWickets);
		}
		else if(value.equalsIgnoreCase("most five wickets")) {
			Collections.sort(playerList,comparatorService.mostFiveWickets);
		}
		else if(value.equalsIgnoreCase("most fours")) {
			Collections.sort(playerList,comparatorService.mostFours);
			
		}
		else if(value.equalsIgnoreCase("most six")) {
			Collections.sort(playerList,comparatorService.mostSix);
			
		}
		else {
			return null;
			
		}

	

		return playerList;

	}
	
	

}
