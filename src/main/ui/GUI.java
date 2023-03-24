package ui;

import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GUI {

    private Team team;
    private static final String JSON_STORE = "./data/team.json";
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);;
    private JsonReader jsonReader = new JsonReader(JSON_STORE);;


    private JFrame mainFrame = new JFrame("Ultimate Team Manager");
    private JPanel rootPanel = new JPanel();

    private JPanel saveOptions = new JPanel();
    private JPanel playerPanel = new JPanel();
    private JPanel playerOptions = new JPanel();


    private JButton save = new JButton("Save");
    private JButton load = new JButton("Load");

    private JList playerList = new JList();
    private JTextArea playerInfo = new JTextArea();

    private JButton addPlayer = new JButton("add a new player");
    private JButton removePlayer = new JButton("remove an existing player");

    private GUI() {

        loadData(); // make this run after pressing the load data button

        mainFrame.setContentPane(rootPanel);
        mainFrame.setResizable(false);
        mainFrame.setMinimumSize(new java.awt.Dimension(500, 300));

        rootPanel.setLayout(new BorderLayout());

        setupSaveOptionsPanel();
        setupPlayerPanel();
        setupPlayerOptionsPanel();

        rootPanel.add(saveOptions, BorderLayout.PAGE_START);
        rootPanel.add(playerPanel);
        rootPanel.add(playerOptions, BorderLayout.PAGE_END);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: loads team from file
    private void loadData() {
        try {
            team = jsonReader.read();
            System.out.println("Loaded " + team.getTeamName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
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

        JScrollPane listScroller = adjustPlayerListComponent();

        adjustPlayerInfoComponent();

        playerPanel.add(listScroller, BorderLayout.WEST);
        playerPanel.add(playerInfo, BorderLayout.EAST);
    }

    // EFFECTS: adjusts player info component to be empty or have the selected player's info
    private void adjustPlayerInfoComponent() {
        playerInfo.setPreferredSize(new Dimension(250, 200));
        playerInfo.setEditable(false);
        playerInfo.append("Test");
    }

    // EFFECTS: adjusts player list component to have the list of players
    private JScrollPane adjustPlayerListComponent() {
//        String data[]= { "Monday","Tuesday","Wednesday",
//                "Thursday","Friday","Saturday"};

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
