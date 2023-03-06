package persistence;

import model.Player;
import model.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Team t = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyTeam() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTeam.json");
        try {
            Team t = reader.read();
            assertEquals("My Team", t.getTeamName());
            assertEquals(0, t.getTeamPlayers().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTeam() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTeam.json");
        try {
            Team t = reader.read();
            assertEquals("Eric's Ultimate Frisbee Team", t.getTeamName());
            List<Player> players = t.getTeamPlayers();
            assertEquals(2, players.size());
            checkPlayer("Eric", 33, "Hybrid", 0, 0, 0, players.get(0));
            checkPlayer("Ben", 2, "Handler", 0, 0, 0, players.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
