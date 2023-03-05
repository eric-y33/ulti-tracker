package ui;

import model.Player;
import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


// Stat tracker application
public class StatApp {

    private static final String JSON_STORE = "./data/team.json";
    private Team team;
    private Player player1;
    private Player player2;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: constructs team and runs stat tracking application
    public StatApp() {
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // NOTE: A built-in exception is caught if non-number inputs are passed into certain commands
    private void runApp() {
        boolean keepGoing = true;
        String command;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                try {
                    processCommand(command);
                } catch (Exception e) {
                    System.out.println("Sorry, something went wrong. Please try again.");
                }
            }

        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) throws Exception {
        switch (command) {
            case "v":
                viewPlayers();
                break;
            case "e":
                viewPlayer();
                break;
            case "a":
                addPlayerToTeam();
                break;
            case "d":
                deletePlayerFromTeam();
                break;
            case "s":
                saveTeam();
                break;
            case "l":
                loadTeam();
                break;
            default:
                System.out.println("Selection not valid...");
                break;
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
        System.out.println("\ts -> save work room to file");
        System.out.println("\tl -> load work room from file");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: displays players on roster
    private void viewPlayers() {
        List<String> playerList;
        playerList = team.getListOfPlayerNames();
        if (playerList.size() == 0) {
            System.out.println("There are no players on the team...");
        } else {
            System.out.println("The players on this team are:");
            for (String player : playerList) {
                System.out.println("\t" + player);
            }
        }
    }

    // EFFECTS: displays player info and edit options
    private void viewPlayer() throws Exception {
        System.out.println("Enter the name of the player you want to view/edit:");
        Player selected = selectPlayer();
        if (selected == null) {
            System.out.println("That player doesn't exist!");
        } else {
            System.out.println("Name: " + selected.getName());
            System.out.println("Jersey number: " + selected.getJerseyNumber());
            System.out.println("Position: " + selected.getPosition());
            System.out.println("Points played: " + selected.getPointsPlayed());
            System.out.println("Assists: " + selected.getAssists());
            System.out.println("Goals: " + selected.getGoals());
            editPlayer(selected);
        }
    }

    // EFFECTS: displays edit options
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void editPlayer(Player selected) throws Exception {
        String subSelection = "";

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

        switch (subSelection) {
            case "n":
                changeName(selected);
                break;
            case "j":
                changeJerseyNumber(selected);
                break;
            case "p":
                changePosition(selected);
                break;
            case "pp":
                changePointsPlayed(selected);
                break;
            case "a":
                changeAssists(selected);
                break;
            case "g":
                changeGoals(selected);
                break;
            case "q":
                System.out.println("Returning to main menu...");
                break;
        }
    }

    // EFFECTS: user can edit a selected player's name
    private void changeName(Player selected) {
        String newName;
        System.out.println("Change name to:");
        newName = input.next();
        if (newName.equals("")) {
            System.out.println("You can't make the name blank!");
        } else {
            selected.changeNameTo(newName);
            System.out.println("Successfully changed name!");
        }
    }

    // EFFECTS: user can edit a selected player's jersey number
    private void changeJerseyNumber(Player selected) throws Exception {
        int newNumber;
        System.out.println("Change jersey number to:");
        newNumber = Integer.parseInt(input.next());
        if (newNumber < 0 || newNumber > 99) {
            System.out.println("Sorry, that's an invalid jersey number!");
        } else {
            selected.changeJerseyNumberTo(newNumber);
            System.out.println("Successfully changed number!");
        }
    }

    // EFFECTS: user can edit a selected player's position
    private void changePosition(Player selected) {
        String newPosition;
        System.out.println("Change position to:");
        newPosition = input.next();
        if (!(newPosition.equals("Cutter") || newPosition.equals("Handler") || newPosition.equals("Hybrid"))) {
            System.out.println("Sorry, position must be either \"Cutter\", \"Handler\", or \"Hybrid\"!");
        } else {
            selected.changePositionTo(newPosition);
            System.out.println("Successfully changed position!");
        }
    }

    // EFFECTS: user can edit a selected player's points played by a given integer (as long as the resulting
    //          points played do not go below 0)
    private void changePointsPlayed(Player selected) throws Exception {
        int newNumber;
        System.out.println("Update points played by:");
        newNumber = Integer.parseInt(input.next());
        if (newNumber < (-1 * selected.getPointsPlayed())) {
            System.out.println("Sorry, that would make the total points played negative!");
        } else {
            selected.changePointsPlayedBy(newNumber);
            System.out.println("Successfully updated points played!");
        }
    }

    // EFFECTS: user can edit a selected player's assists by a given integer (as long as the resulting
    //          assists do not go below 0)
    private void changeAssists(Player selected) throws Exception {
        int newNumber;
        System.out.println("Update assists by:");
        newNumber = Integer.parseInt(input.next());
        if (newNumber < (-1 * selected.getAssists())) {
            System.out.println("Sorry, that would make the total assists negative!");
        } else {
            selected.changeAssistsBy(newNumber);
            System.out.println("Successfully updated assists!");
        }
    }

    // EFFECTS: user can edit a selected player's goals by a given integer (as long as the resulting
    //          goals do not go below 0)
    private void changeGoals(Player selected) throws Exception {
        int newNumber;
        System.out.println("Update goals by:");
        newNumber = Integer.parseInt(input.next());
        if (newNumber < (-1 * selected.getGoals())) {
            System.out.println("Sorry, that would make the total goals negative!");
        } else {
            selected.changeGoalsBy(newNumber);
            System.out.println("Successfully updated goals!");
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
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void addPlayerToTeam() throws Exception {
        String playerName = "";
        int playerNumber = -1;
        String playerPosition = "";

        while (playerName.equals("")) {
            System.out.println("Enter name of player to add:");
            playerName = input.next();
            if (playerName.equals("")) {
                System.out.println("You can't make the name blank!");
            }
        }

        while (playerNumber < 0 || playerNumber > 99) {
            System.out.println("Enter jersey number of player to add:");
            playerNumber = Integer.parseInt(input.next());
            if (playerNumber < 0 || playerNumber > 99) {
                System.out.println("Sorry, that's an invalid jersey number!");
            }
        }

        while (!(playerPosition.equals("Cutter") || playerPosition.equals("Handler")
                || playerPosition.equals("Hybrid"))) {
            System.out.println("Enter position of player to add:");
            playerPosition = input.next();
            if (!(playerPosition.equals("Cutter") || playerPosition.equals("Handler")
                    || playerPosition.equals("Hybrid"))) {
                System.out.println("Sorry, position must be either \"Cutter\", \"Handler\", or \"Hybrid\"!");
            }
        }

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

    // EFFECTS: saves the team to file
    private void saveTeam() {
        try {
            jsonWriter.open();
            jsonWriter.write(team);
            jsonWriter.close();
            System.out.println("Saved " + team.getTeamName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads team from file
    private void loadTeam() {
        try {
            team = jsonReader.read();
            System.out.println("Loaded " + team.getTeamName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
