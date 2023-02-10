package ui;

import model.Player;
import model.Team;

import java.util.Scanner;


// Stat tracker application
public class StatApp {

    private Team team;
    private Player player1;
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
            viewPlayers();
        } else if (command.equals("e")) {
            viewPlayer();
        } else if (command.equals("a")) {
            addPlayerFromTeam();
        } else if (command.equals("d")) {
            deletePlayerFromTeam();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes team
    private void init() {
        team = new Team("The Best Ultimate Frisbee Team");
        player1 = new Player("Eric", 33, "Hybrid");
        team.addPlayer(player1);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWelcome to" + team.getTeamName());
        System.out.println("\nSelect from:");
        System.out.println("\tv -> view players");
        System.out.println("\te -> view/edit a player's information");
        System.out.println("\ta -> add a new player");
        System.out.println("\td -> delete an existing player");
        System.out.println("\tq -> quit");
    }

    private void viewPlayers() {
        // stub
    }

    private void viewPlayer() {
        // TODO: Make them print field info and add select stuff
        System.out.println("\nName: ");
        System.out.println("\nJersey number: ");
        System.out.println("\nPosition: ");
        System.out.println("\nPoints played: ");
        System.out.println("\nAssists: ");
        System.out.println("\nGoals: ");
        System.out.println("\nSelect from:");
        System.out.println("\tn -> update name");
        System.out.println("\tj -> update jersey number");
        System.out.println("\tp -> update position");
        System.out.println("\tpp -> update points played");
        System.out.println("\ta -> update assists");
        System.out.println("\tg -> update goals");
        System.out.println("\tq -> quit");
    }

    private void addPlayerFromTeam() {
        // stub
    }

    private void deletePlayerFromTeam() {
        // stub
    }

}
