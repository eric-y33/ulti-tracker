package persistence;

import model.Player;
import model.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Team t = new Team("My Team");
            JsonWriter writer = new JsonWriter("./data/myIllegal\0fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTeam() {
        try {
            Team t = new Team("My Team");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTeam.json");
            writer.open();
            writer.write(t);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTeam.json");
            t = reader.read();
            assertEquals("My Team", t.getTeamName());
            assertEquals(0, t.getTeamPlayers().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralTeam() {
        try {
            Team t = new Team("The Ultimate Ultimate Team");
            t.addPlayer(new Player("Eric", 33, "Hybrid"));
            t.addPlayer(new Player("Ben", 2, "Handler"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTeam.json");
            writer.open();
            writer.write(t);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTeam.json");
            t = reader.read();
            assertEquals("The Ultimate Ultimate Team", t.getTeamName());
            List<Player> players = t.getTeamPlayers();
            assertEquals(2, players.size());
            checkPlayer("Eric", 33, "Hybrid", 0, 0, 0, players.get(0));
            checkPlayer("Ben", 2, "Handler", 0, 0, 0, players.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
