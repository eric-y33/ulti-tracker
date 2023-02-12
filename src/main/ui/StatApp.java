package ui;

import model.Player;
import model.Team;

import java.util.List;
import java.util.Scanner;


// Stat tracker application
public class StatApp {

    private Team team;
    private Player player1;
    private Player player2;
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
            try {
                addPlayerToTeam();
            } catch (Exception e) {
                System.out.println("Sorry, something went wrong.");
            }
        } else if (command.equals("d")) {
            deletePlayerFromTeam();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes team
    private void init() {
        team = new Team("Eric's Ultimate Frisbee Team");
        player1 = new Player("Eric", 33, "Hybrid");
        player2 = new Player("Ben", 2, "Handler");
        team.addPlayer(player1);
        team.addPlayer(player2);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWelcome to " + team.getTeamName() + "!");
        System.out.println("\nSelect from:");
        System.out.println("\tv -> view players");
        System.out.println("\te -> view/edit a player's information");
        System.out.println("\ta -> add a new player");
        System.out.println("\td -> delete an existing player");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: displays players on roster
    private void viewPlayers() {
        List<String> playerList;
        playerList = team.getListOfPlayerNames();
        System.out.println("The players on this team are:");
        for (String player : playerList) {
            System.out.println("\t" + player);
        }
    }

    // EFFECTS: displays player info and edit options
    // TODO: put each method into its own option with the player to do it on passed into it
    private void viewPlayer() {
        System.out.println("Enter the name of the player you want to view/edit:");
        Player selected = selectPlayer();
        if (selected == null) {
            System.out.println("That player doesn't exist!");
        } else {
            String subSelection = "";

            System.out.println("Name: " + selected.getName());
            System.out.println("Jersey number: " + selected.getJerseyNumber());
            System.out.println("Position: " + selected.getPosition());
            System.out.println("Points played: " + selected.getPointsPlayed());
            System.out.println("Assists: " + selected.getAssists());
            System.out.println("Goals: " + selected.getGoals());

            while (!(subSelection.equals("n") || subSelection.equals("j") || subSelection.equals("p")
                    || subSelection.equals("pp") || subSelection.equals("a") || subSelection.equals("g")
                    || subSelection.equals("q"))) {
                System.out.println("\nSelect from:");
                System.out.println("\tn -> update name");
                System.out.println("\tj -> update jersey number");
                System.out.println("\tp -> update position");
                System.out.println("\tpp -> update points played");
                System.out.println("\ta -> update assists");
                System.out.println("\tg -> update goals");
                System.out.println("\tq -> quit to main menu");
                subSelection = input.next();
                subSelection = subSelection.toLowerCase();
            }

            if (subSelection.equals("n")) {
                String newName;
                System.out.println("Change name to:");
                newName = input.next();
                if (newName.equals("")) {
                    System.out.println("You can't make the name blank!");
                } else {
                    selected.changeNameTo(newName);
                    System.out.println("Successfully changed name!");
                }
            } else if (subSelection.equals("j")) {
                int newNumber;
                System.out.println("Change jersey number to:");
                newNumber = Integer.parseInt(input.next());
                selected.changeJerseyNumberTo(newNumber);
                System.out.println("Successfully changed number!");
            } else if (subSelection.equals("p")) {
                String newPosition;
                System.out.println("Change position to:");
                newPosition = input.next();
                selected.changePositionTo(newPosition);
                System.out.println("Successfully changed position!");
            } else if (subSelection.equals("pp")) {
                int newNumber;
                System.out.println("Update points played by:");
                newNumber = Integer.parseInt(input.next());
                selected.changePointsPlayedBy(newNumber);
                System.out.println("Successfully updated points played!");
            } else if (subSelection.equals("a")) {
                int newNumber;
                System.out.println("Update assists by:");
                newNumber = Integer.parseInt(input.next());
                selected.changeAssistsBy(newNumber);
                System.out.println("Successfully updated assists!");
            } else if (subSelection.equals("g")) {
                int newNumber;
                System.out.println("Update goals by:");
                newNumber = Integer.parseInt(input.next());
                selected.changeJerseyNumberTo(newNumber);
                System.out.println("Successfully updated goals!");
            } else if (subSelection.equals("q")) {
                System.out.println("Returning to main menu...");
            }

        }
    }

    // EFFECTS: prompts user to enter a player to select and returns them
    private Player selectPlayer() {
        String playerName;
        Player selectedPlayer = null;

        playerName = input.next();

        for (Player player : team.getTeamPlayers()) {
            if (playerName.equals(player.getName())) {
                selectedPlayer = player;
                break;
            }
        }
        return selectedPlayer;
    }

    // EFFECTS: adds a new player with their name, jersey number, and position
    private void addPlayerToTeam() throws Exception {
        String playerName;
        int playerNumber;
        String playerPosition;

        System.out.println("Enter name of player to add:");
        playerName = input.next();
        System.out.println("Enter jersey number of player to add:");
        playerNumber = Integer.parseInt(input.next());
        System.out.println("Enter position of player to add:");
        playerPosition = input.next();

        team.addPlayer(new Player(playerName, playerNumber, playerPosition));
        System.out.println("Successfully added a new player!");

    }

    private void deletePlayerFromTeam() {
        System.out.println("Enter name of player to delete:");
        Player selected = selectPlayer();
        if (selected == null) {
            System.out.println("That player doesn't exist!");
        } else {
            team.removePlayer(selected);
            System.out.println("Successfully removed!");
        }
    }

}
