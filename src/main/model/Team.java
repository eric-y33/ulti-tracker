package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a team with a name and players
public class Team implements Writable {

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

    // REQUIRES: player does not have the same name as
    //           a player already in players
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

    public String getTeamName() {
        return this.name;
    }

    public ArrayList<Player> getTeamPlayers() {
        return this.players;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("team name", name);
        json.put("players", playersToJson());
        return json;
    }

    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player p: players) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}
