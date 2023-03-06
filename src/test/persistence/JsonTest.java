package persistence;

import model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPlayer(String name, int jerseyNumber, String position,
                               int pointsPlayed, int assists, int goals, Player player) {
        assertEquals(name, player.getName());
        assertEquals(jerseyNumber, player.getJerseyNumber());
        assertEquals(position, player.getPosition());
        assertEquals(pointsPlayed, player.getPointsPlayed());
        assertEquals(assists, player.getAssists());
        assertEquals(goals, player.getGoals());
    }
}
