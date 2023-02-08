package model;

import java.util.ArrayList;

// represents a team with a name and players,
public class Team {

    private String name;
    private ArrayList<Player> players;

    // REQUIRES: teamName has a non-zero length
    // EFFECTS: name is set to teamName;
    //          players is set to an empty list of Player
    public Team(String teamName) {
        name = teamName;
        players = new ArrayList<Player>();
    }

    // REQUIRES: newTeamName has a non-zero length
    // MODIFIES: this
    // EFFECTS: name is set to newTeamName
    public void changeTeamName(String newTeamName) {
        name = newTeamName;
    }

    // MODIFIES: this
    // EFFECTS: adds player to players
    public void addPlayer(Player player) {
        players.add(player);
    }

    // MODIFIES: this
    // EFFECTS: removes player from players
    public void removePlayer(Player player) {
        players.remove(player);
    }

    // EFFECTS: lists all players' names
    public ArrayList<String> getListOfPlayerNames() {
        ArrayList<String> result = new ArrayList<String>();
        for (Player player : players) {
            result.add(player.getName());
        }
        return result;
    }

    public  String getTeamName() {
        return name;
    }

    public ArrayList<Player> getTeamPlayers() {
        return players;
    }

}
