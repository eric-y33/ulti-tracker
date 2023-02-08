package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player testPlayer;

    @BeforeEach
    void runBefore(){
        testPlayer = new Player("Eric", 33, "Hybrid");
    }

    @Test
    void changeName(){
        testPlayer.changeNameTo("Ben");
        assertEquals("Ben", testPlayer.getName());
    }

    @Test
    void changePosition(){
        testPlayer.changePositionTo("Cutter");
        assertEquals("Cutter", testPlayer.getPosition());
    }

    @Test
    void increasePointsPlayed(){
        assertEquals(0, testPlayer.getPointsPlayed());
        testPlayer.changePointsPlayedBy(10);
        assertEquals(10, testPlayer.getPointsPlayed());
    }

    @Test
    void increasePointsPlayedMultipleTimes(){
        assertEquals(0, testPlayer.getPointsPlayed());
        testPlayer.changePointsPlayedBy(10);
        assertEquals(10, testPlayer.getPointsPlayed());
        testPlayer.changePointsPlayedBy(5);
        assertEquals(15, testPlayer.getPointsPlayed());
    }

    @Test
    void decreasePointsPlayed(){
        assertEquals(0, testPlayer.getPointsPlayed());
        testPlayer.changePointsPlayedBy(30);
        assertEquals(30, testPlayer.getPointsPlayed());
        testPlayer.changePointsPlayedBy(-10);
        assertEquals(20, testPlayer.getPointsPlayed());
    }

    @Test
    void decreasePointsPlayedMultipleTimes(){
        assertEquals(0, testPlayer.getPointsPlayed());
        testPlayer.changePointsPlayedBy(30);
        assertEquals(30, testPlayer.getPointsPlayed());
        testPlayer.changePointsPlayedBy(-10);
        assertEquals(20, testPlayer.getPointsPlayed());
        testPlayer.changePointsPlayedBy(-20);
        assertEquals(0, testPlayer.getPointsPlayed());
    }

    @Test
    void increaseAssists(){
        assertEquals(0, testPlayer.getAssists());
        testPlayer.changeAssistsBy(10);
        assertEquals(10, testPlayer.getAssists());
    }

    @Test
    void increaseAssistsMultipleTimes(){
        assertEquals(0, testPlayer.getAssists());
        testPlayer.changeAssistsBy(10);
        assertEquals(10, testPlayer.getAssists());
        testPlayer.changeAssistsBy(5);
        assertEquals(15, testPlayer.getAssists());
    }

    @Test
    void decreaseAssists(){
        assertEquals(0, testPlayer.getAssists());
        testPlayer.changeAssistsBy(30);
        assertEquals(30, testPlayer.getAssists());
        testPlayer.changeAssistsBy(-10);
        assertEquals(20, testPlayer.getAssists());
    }

    @Test
    void decreaseAssistsMultipleTimes(){
        assertEquals(0, testPlayer.getAssists());
        testPlayer.changeAssistsBy(30);
        assertEquals(30, testPlayer.getAssists());
        testPlayer.changeAssistsBy(-10);
        assertEquals(20, testPlayer.getAssists());
        testPlayer.changeAssistsBy(-20);
        assertEquals(0, testPlayer.getAssists());
    }

    @Test
    void increaseGoals(){
        assertEquals(0, testPlayer.getGoals());
        testPlayer.changeGoalsBy(10);
        assertEquals(10, testPlayer.getGoals());
    }

    @Test
    void increaseGoalsMultipleTimes(){
        assertEquals(0, testPlayer.getGoals());
        testPlayer.changeGoalsBy(10);
        assertEquals(10, testPlayer.getGoals());
        testPlayer.changeGoalsBy(5);
        assertEquals(15, testPlayer.getGoals());
    }

    @Test
    void decreaseGoals(){
        assertEquals(0, testPlayer.getGoals());
        testPlayer.changeGoalsBy(30);
        assertEquals(30, testPlayer.getGoals());
        testPlayer.changeGoalsBy(-10);
        assertEquals(20, testPlayer.getGoals());
    }

    @Test
    void decreaseGoalsMultipleTimes(){
        assertEquals(0, testPlayer.getGoals());
        testPlayer.changeGoalsBy(30);
        assertEquals(30, testPlayer.getGoals());
        testPlayer.changeGoalsBy(-10);
        assertEquals(20, testPlayer.getGoals());
        testPlayer.changeGoalsBy(-20);
        assertEquals(0, testPlayer.getGoals());
    }
}
