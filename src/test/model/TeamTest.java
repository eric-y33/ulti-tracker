package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    private Team testTeam;
    private Player testPlayer1;
    private Player testPlayer2;

    @BeforeEach
    void runBefore(){
        testTeam = new Team("The Ultimate Ultimate Team");
        testPlayer1 = new Player("Eric", 33, "Hybrid");
        testPlayer2 = new Player("Ben", 2, "Handler");
    }

    @Test
    void changeName(){
        testTeam.changeTeamName("The Dogs");
        assertEquals("The Dogs", testTeam.getTeamName());
    }

    @Test
    void addPlayer(){
        testTeam.addPlayer(testPlayer1);
        assertEquals(testPlayer1, testTeam.getTeamPlayers().get(0));
    }

    @Test
    void addMultiplePlayers(){
        testTeam.addPlayer(testPlayer1);
        assertEquals(testPlayer1, testTeam.getTeamPlayers().get(0));
        testTeam.addPlayer(testPlayer2);
        assertEquals(testPlayer2, testTeam.getTeamPlayers().get(1));
    }

    @Test
    void viewPlayerNames(){
        testTeam.addPlayer(testPlayer1);
        testTeam.addPlayer(testPlayer2);
        assertEquals("Eric", testTeam.getListOfPlayerNames().get(0));
        assertEquals("Ben", testTeam.getListOfPlayerNames().get(1));
    }

    @Test
    void removePlayer(){
        testTeam.addPlayer(testPlayer1);
        testTeam.addPlayer(testPlayer2);
        testTeam.removePlayer(testPlayer1);
        assertEquals(testPlayer2, testTeam.getTeamPlayers().get(0));
        assertEquals(1, testTeam.getTeamPlayers().size());
    }

    @Test
    void removeMultiplePlayers(){
        testTeam.addPlayer(testPlayer1);
        testTeam.addPlayer(testPlayer2);
        testTeam.removePlayer(testPlayer1);
        testTeam.removePlayer(testPlayer2);
        assertEquals(0, testTeam.getTeamPlayers().size());
    }

}
