package com.example.cricket.service;

import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.example.cricket.model.TeamPlayerEntity;
@Service
public class ComparatorService {
	public static Comparator<TeamPlayerEntity> mostFifties = new Comparator<TeamPlayerEntity>() {

		@Override
		public int compare(TeamPlayerEntity o1, TeamPlayerEntity o2) {
			// TODO Auto-generated method stub

			int r1 = o1.getFifties();
			int r2 = o2.getFifties();
			int ans =  r2 - r1;
			return ans;
		}
	};
	
	public static Comparator<TeamPlayerEntity> mostFiveWickets = new Comparator<TeamPlayerEntity>() {

		@Override
		public int compare(TeamPlayerEntity o1, TeamPlayerEntity o2) {
			// TODO Auto-generated method stub

			int r1 = o1.getFive_wickets_hauls();
			int r2 = o2.getFive_wickets_hauls();
			int ans =  r2 - r1;
			return ans;
		}
	};
	
	public static Comparator<TeamPlayerEntity> mostFours = new Comparator<TeamPlayerEntity>() {

		@Override
		public int compare(TeamPlayerEntity o1, TeamPlayerEntity o2) {
			// TODO Auto-generated method stub

			int r1 = o1.getFours();
			int r2 = o2.getFours();
			int ans =  r2 - r1;
			return ans;
		}
	};
	
	public static Comparator<TeamPlayerEntity> mosthundreds = new Comparator<TeamPlayerEntity>() {

		@Override
		public int compare(TeamPlayerEntity o1, TeamPlayerEntity o2) {
			// TODO Auto-generated method stub

			int r1 = o1.getHundreds();
			int r2 = o2.getHundreds();
			int ans =  r2 - r1;
			return ans;
		}
	};
	
	public static Comparator<TeamPlayerEntity> mostRuns = new Comparator<TeamPlayerEntity>() {

		@Override
		public int compare(TeamPlayerEntity o1, TeamPlayerEntity o2) {
			// TODO Auto-generated method stub

			int r1 = o1.getRuns();
			int r2 = o2.getRuns();
			int ans =  r2 - r1;
			return ans;
		}
	};
	
	
	public static Comparator<TeamPlayerEntity> mostSix = new Comparator<TeamPlayerEntity>() {

		@Override
		public int compare(TeamPlayerEntity o1, TeamPlayerEntity o2) {
			// TODO Auto-generated method stub

			int r1 = o1.getSixes();
			int r2 = o2.getSixes();
			int ans =  r2 - r1;
			return ans;
		}
	};
	
	
	public static Comparator<TeamPlayerEntity> mostWickets = new Comparator<TeamPlayerEntity>() {

		@Override
		public int compare(TeamPlayerEntity o1, TeamPlayerEntity o2) {
			// TODO Auto-generated method stub

			int r1 = o1.getWickets();
			int r2 = o2.getWickets();
			int ans =  r2 - r1;
			return ans;
		}
	};

}
