package ui;

import model.Player;
import model.Team;

import java.util.Scanner;


// Stat tracker application
public class StatApp {

    private Team team;
    private Scanner input;

    // EFFECTS: runs the stat tracking application
    public StatApp() {
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }

        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("v")) {
            System.out.println(); // stub
        } else if (command.equals("w")) {
            System.out.println(); // stub
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes team
    private void init() {
        team = new Team("Ultimate Frisbee Team");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tv -> view teams");
        System.out.println("\tq -> quit");
    }

    private void viewTeams() {
        // stub
    }

    private void selectTeam(String teamName) {
        // stub
    }

    private void viewPlayers() {
        // stub
    }

    private void viewPlayer() {
        // stub
    }

}
