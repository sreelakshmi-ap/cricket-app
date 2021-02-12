package com.example.cricket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cricket.model.PlayerEntity;
import com.example.cricket.model.PlayersAchievements;
import com.example.cricket.model.TeamPlayerEntity;
import com.example.cricket.repository.PlayerRepository;
import com.example.cricket.repository.PlayerScoreRepository;
import com.example.cricket.repository.TeamPlayerRepository;
import com.example.cricket.response.MainResponse;
import com.example.cricket.response.MessageAndStatusResponse;
import com.example.cricket.response.PlayerInfoResponse;
import com.example.cricket.response.PlayerScoreInfo;
import com.example.cricket.response.PlayersOfTeamResponse;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamPlayerRepository teamPlayerRepository;
    
    @Autowired
    PlayerScoreRepository playerScoreRepository;

    public ResponseEntity<?> playersList() {

        return ResponseEntity.status(200).body(new MainResponse(200, "List of players", playerRepository.findAll()));
    }

    public ResponseEntity<?> addNewPlayer(PlayerEntity playerEntity, int teamId, String designation) {

        Optional<Integer> player = playerRepository.findByPhoneNumber(playerEntity.getPhoneNumber());
        if(player.isPresent()) {
            return ResponseEntity.status(409).body(new MainResponse(409,"Player already exist!!!",""));
        }
        else {
            playerRepository.save(playerEntity);
            Optional<Integer> playerId = playerRepository.findByPhoneNumber(playerEntity.getPhoneNumber());
            TeamPlayerEntity teamPlayerEntity = new TeamPlayerEntity(teamId, playerId.get(), designation);
            teamPlayerRepository.save(teamPlayerEntity);
            return ResponseEntity.status(200).body(new MainResponse(200,"Successfully registered the player", playersOfTeam(teamId)));
        }

    }

    public ResponseEntity<?> addExistingPlayer(TeamPlayerEntity teamPlayerEntity) {
        Optional<PlayerEntity> playerId = playerRepository.findById(teamPlayerEntity.getPlayerId());
        if(playerId.isPresent()) {
            Optional<TeamPlayerEntity> optTeamPlayer = teamPlayerRepository.findByPlayerId(teamPlayerEntity.getPlayerId());
            if(optTeamPlayer.isPresent()) {
                teamPlayerRepository.save(teamPlayerEntity);
                return  ResponseEntity.status(200).body(new MainResponse(200,"Successfully registered the player", playersOfTeam(teamPlayerEntity.getTeamId())));
            }else {
                TeamPlayerEntity teamPlayer = optTeamPlayer.get();
                teamPlayer.setTeamId(teamPlayerEntity.getTeamId());
                teamPlayer.setPlayerId(teamPlayerEntity.getPlayerId());
                teamPlayer.setDesignation(teamPlayerEntity.getDesignation());
                teamPlayerRepository.save(teamPlayer);
                return  ResponseEntity.status(200).body(new MainResponse(200,"Successfully registered the player", playersOfTeam(teamPlayerEntity.getTeamId())));
            }
        }
        else {
            return ResponseEntity.status(409).body(new MainResponse( 409,"Invalid player id",""));
        }
    }

    public List<PlayersOfTeamResponse> playersOfTeam(int teamId){
        List<TeamPlayerEntity> teamPlayers = teamPlayerRepository.findByTeamId(teamId);
        List<PlayersOfTeamResponse> playersOfTeam = new ArrayList<>();
        for(TeamPlayerEntity teamPlayer : teamPlayers) {
            Optional<PlayerEntity> player = playerRepository.findById(teamPlayer.getPlayerId());
            PlayersOfTeamResponse playerOfTeam = new PlayersOfTeamResponse(teamId, teamPlayer.getDesignation(), player.get());
            playersOfTeam.add(playerOfTeam);
        }
        return playersOfTeam;

    }
    
    public ResponseEntity<?> PlayerInfo(int playerId,int tournamentId)
    {
    	Optional<TeamPlayerEntity> player=teamPlayerRepository.CheckPlayerForTournament(playerId, tournamentId);
    	if(player.isPresent())
    	{
    		PlayerEntity playerDetails=playerRepository.findById(playerId).get();
    		
    		String PlayerName=playerDetails.getPlayerName();
    		
    		String PlayerPicture=playerDetails.getImagePath();
    		
    		String City=playerDetails.getLocation();
    		
    		String Role=playerDetails.getExpertise();
    		
    		String BattingStyle=playerDetails.getBatting();
    		
    		String Bowling=playerDetails.getBowling()+" "+playerDetails.getBowlingType();
    		
    		String TeamName=teamPlayerRepository.TeamNameByPlayerId(playerId, tournamentId);
    		
    		int captainCheck=teamPlayerRepository.CheckForCaptain(playerId, tournamentId);
    		
    		boolean Captain;
    		
    		if(captainCheck>0)
    		{
    			Captain=true;
    		}
    		
    		else
    		{
    			Captain=false;
    		}
    		
    		
    		PlayerScoreInfo scoreInfo=playerScoreRepository.getPlayerScoreInfo(playerId, tournamentId);
    		
    		int Runs=scoreInfo.getRuns();
    		
    		int Matches=scoreInfo.getMatches();
    		
    		int Wickets=scoreInfo.getWickets();
    		
    		//PlayersAchievements achievements=teamPlayerRepository.achievements(playerId, tournamentId);
    		
    		return ResponseEntity.ok(new PlayerInfoResponse(PlayerName,PlayerPicture, City, TeamName, Captain, Role, BattingStyle, Bowling, Matches, Runs, Wickets));
    	}
    	return ResponseEntity.status(400).body(new MessageAndStatusResponse("Player is Not Playing In This Tournament", HttpStatus.BAD_REQUEST));
    }
}