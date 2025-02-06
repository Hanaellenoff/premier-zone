package com.pl.player;

import java.util.stream.Collectors;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {
  private final PlayerRepository playerRepository;

  @Autowired
  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public List<Player> getPlayers() {
    return playerRepository.findAll();
  }

  public List<Player> getPlayersFromTeam(String team_name){
    return playerRepository.findAll().stream()
     .filter(player -> team_name.equals(player.getTeam()))
     .collect(Collectors.toList());
  }

  public List<Player> getPlayersByName(String searchText) {
    return playerRepository.findAll().stream().filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
  }

  public List<Player> getPlayerByPosition(String searchText){
    return playerRepository.findAll().stream().filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
  }
  
    public List<Player> getPlayerByNation(String searchText){
    return playerRepository.findAll().stream().filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }
    public List<Player> getPlayerByTeamAndPos(String team, String pos){
    return playerRepository.findAll().stream().filter(player -> team.equals(player.getTeam()) && pos.equals(player.getPos())).collect(Collectors.toList());
    }
}

