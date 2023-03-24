package ui;

import model.Player;
import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class GUI {

    private Team team = new Team("Default Team");
    private static final String JSON_STORE = "./data/team.json";
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);


    private JFrame mainFrame = new JFrame("Ultimate Team Manager");
    private JPanel rootPanel = new JPanel();

    private JPanel saveOptions = new JPanel();
    private JPanel playerPanel = new JPanel();
    private JPanel playerOptions = new JPanel();
    private JScrollPane playerListScroller = new JScrollPane();


    private JButton save = new JButton("Save");
    private JButton load = new JButton("Load");

    private JList playerList = new JList();
    private JTextArea playerInfo = new JTextArea();

    private JButton addPlayer = new JButton("add a new player");
    private JButton removePlayer = new JButton("remove selected player");

    Player selectedPlayer = null;

    private GUI() {

        mainFrame.setContentPane(rootPanel);
        mainFrame.setResizable(false);
        mainFrame.setMinimumSize(new java.awt.Dimension(500, 300));

        rootPanel.setLayout(new BorderLayout());

        setupSaveOptionsPanel();
        setupPlayerPanel();
        setupPlayerOptionsPanel();

        setupButtonFunctionality();
        setupListScrollerSelectionFunctionality();

        rootPanel.add(saveOptions, BorderLayout.PAGE_START);
        rootPanel.add(playerPanel);
        rootPanel.add(playerOptions, BorderLayout.PAGE_END);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    // EFFECTS: loads team from file
    private void loadData() {
        try {
            team = jsonReader.read();
            System.out.println("Loaded " + team.getTeamName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: saves team to file
    private void saveData() {
        try {
            jsonWriter.open();
            jsonWriter.write(team);
            jsonWriter.close();
            System.out.println("Saved " + team.getTeamName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: connects buttons to their functionality
    private void setupButtonFunctionality() {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
                refreshPlayerPanel();
            }
        });
        removePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                team.removePlayer(selectedPlayer);
                refreshPlayerPanel();
            }
        });
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewPlayerPrompts();
                refreshPlayerPanel();
            }
        });
    }

    private void showNewPlayerPrompts() {
        String name = JOptionPane.showInputDialog(mainFrame, "Enter the new player's name:");
        String jerseyNumber = JOptionPane.showInputDialog(mainFrame, "Enter the new player's jersey number:");
        String position = JOptionPane.showInputDialog(mainFrame, "Enter the new player's position:");
        try {
            Player newPlayer = new Player(name, Integer.parseInt(jerseyNumber), position);
            team.addPlayer(newPlayer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "Something went wrong, new player not created.");
        }

    }

    // EFFECTS: resets what is displayed in player panel
    private void refreshPlayerPanel() {
        playerPanel.removeAll();
        adjustPlayerListComponent();
        setupPlayerPanel();
        setupListScrollerSelectionFunctionality();
        playerPanel.revalidate();
        playerPanel.repaint();
        playerInfo.setText("");
    }

    // EFFECTS: connects clicking on a name to displaying the player's info
    private void setupListScrollerSelectionFunctionality() {
        playerList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String playerName = playerList.getSelectedValue().toString();
                    selectedPlayer = findPlayer(playerName);
                    playerInfo.setText(arrangePlayerInfo(selectedPlayer));
                }
            }
        });
    }

    // EFFECTS: finds player in team given the player's name
    private Player findPlayer(String playerName) {
        Player selectedPlayer = null;
        for (Player player : team.getTeamPlayers()) {
            if (playerName.equals(player.getName())) {
                selectedPlayer = player;
                break;
            }
        }
        return selectedPlayer;
    }

    // EFFECTS: arranges player's info nicely for display
    private String arrangePlayerInfo(Player selectedPlayer) {
        return "Jersey number: " + selectedPlayer.getJerseyNumber()
                + "\nPosition: " + selectedPlayer.getPosition()
                + "\nPoints played: " + selectedPlayer.getPointsPlayed()
                + "\nAssists: " + selectedPlayer.getAssists()
                + "\nGoals: " + selectedPlayer.getGoals();
    }

    // EFFECTS: sets up save options panel
    private void setupSaveOptionsPanel() {
        saveOptions.setLayout(new FlowLayout());
        saveOptions.add(save);
        saveOptions.add(load);
    }

    // EFFECTS: sets up main player panel
    private void setupPlayerPanel() {

        playerPanel.setBackground(Color.BLUE);

        playerListScroller = adjustPlayerListComponent();
        adjustPlayerInfoComponent();

        playerPanel.add(playerListScroller, BorderLayout.WEST);
        playerPanel.add(playerInfo, BorderLayout.EAST);
    }

    // EFFECTS: adjusts player info component to be empty or have the selected player's info
    private void adjustPlayerInfoComponent() {
        playerInfo.setPreferredSize(new Dimension(250, 200));
        playerInfo.setEditable(false);
    }

    // EFFECTS: adjusts player list component to have the list of players and turns it into a ScrollPane
    private JScrollPane adjustPlayerListComponent() {

        List<String> teamListOfPlayerNames = team.getListOfPlayerNames();

        DefaultListModel<String> playerModel = new DefaultListModel<>();
        for (String name : teamListOfPlayerNames) {
            playerModel.addElement(name);
        }

        playerList = new JList(playerModel);
        playerList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        playerList.setLayoutOrientation(JList.VERTICAL);
        playerList.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(playerList);
        listScroller.setPreferredSize(new Dimension(250, 200));
        return listScroller;
    }

    // EFFECTS: sets up player options panel
    private void setupPlayerOptionsPanel() {
        playerOptions.setLayout(new FlowLayout());
        playerOptions.add(addPlayer);
        playerOptions.add(removePlayer);
    }

    // EFFECTS: starts GUI application
    public static void main(String[] args) {
        new GUI();
    }

}
