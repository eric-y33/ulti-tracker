package model;

import java.util.List;

// represents a team with a name and players,
public class Team {

    private String name;
    private List<Player> players;

    // REQUIRES: teamName has a non-zero length
    // EFFECTS: name is set to teamName;
    //          players is set to an empty list of Player
    public Team(String teamName) {
        // stub
    }

    // REQUIRES: newTeamName has a non-zero length
    // MODIFIES: this
    // EFFECTS: name is set to newTeamName
    public void changeTeamName(String newTeamName) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: adds player to players
    public void addPlayer(Player player) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: removes player from players
    public void removePlayer(Player player) {
        // stub
    }

    // EFFECTS: lists all players' names
    public String viewAllPlayers() {
        return ""; // stub
    }


}
