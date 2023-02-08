package model;

// Represents an ultimate player with a name,
// jersey number, position, points played,
// assists, and goals
public class Player {
    private String name;
    private int jerseyNumber;
    private String position;
    private int pointsPlayed;
    private int assists;
    private int goals;

    // REQUIRES: playerName has a non-zero length;
    //           playerJerseyNumber >= 0 and playerJerseyNumber <= 99;
    //           playerPosition is "Cutter", "Handler", or "Hybrid"
    // EFFECTS: name is set to playerName;
    //          jerseyNumber is set to playerJerseyNumber;
    //          position is set to playerPosition;
    //          pointsPlayed, assists, and goals is set to 0 as the default
    public Player(String playerName, int playerJerseyNumber, String playerPosition) {
        name = playerName;
        jerseyNumber = playerJerseyNumber;
        position = playerPosition;
        pointsPlayed = 0;
        assists = 0;
        goals = 0;
    }

    // REQUIRES: newName has a non-zero length
    // MODIFIES: this
    // EFFECTS: name is updated to newName
    public void changeNameTo(String newName) {
        name = newName;
    }

    // REQUIRES: newNumber >= 0 and newNumber <= 99
    // MODIFIES: this
    // EFFECTS: jerseyNumber is updated to newNumber
    public void changeJerseyNumberTo(int newNumber) {
        jerseyNumber = newNumber;
    }

    // REQUIRES: newPosition is "Cutter", "Handler", or "Hybrid"
    // MODIFIES: this
    // EFFECTS: position is updated to newPosition
    public void changePositionTo(String newPosition) {
        position = newPosition;
    }

    // REQUIRES: newPoints is an integer >= (-1 * pointsPlayed)
    // MODIFIES: this
    // EFFECTS: pointsPlayed is changed by newPoints
    //          (increases for positive integers and decreases for negative integers)
    public void changePointsPlayedBy(int newPoints) {
        pointsPlayed += newPoints;
    }

    // REQUIRES: newAssists is an integer >= (-1 * assists)
    // MODIFIES: this
    // EFFECTS: assists is changed by newAssists
    //          (increases for positive integers and decreases for negative integers)
    public void changeAssistsBy(int newAssists) {
        assists += newAssists;
    }

    // REQUIRES: newGoals is an integer >= (-1 * assists)
    // MODIFIES: this
    // EFFECTS: goals is changed by newGoals
    //          (increases for positive integers and decreases for negative integers)
    public void changeGoalsBy(int newGoals) {
        goals += newGoals;
    }

    public String getName() {
        return name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getPosition() {
        return position;
    }

    public int getPointsPlayed() {
        return pointsPlayed;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoals() {
        return goals;
    }
}
