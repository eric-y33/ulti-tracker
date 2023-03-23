package ui;

import javax.swing.*;

import java.awt.*;

public class GUI {

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

    private void setupSaveOptionsPanel() {
        saveOptions.setLayout(new FlowLayout());
        saveOptions.add(save);
        saveOptions.add(load);
    }

    private void setupPlayerPanel() {

        playerPanel.setBackground(Color.BLUE);

        JScrollPane listScroller = adjustPlayerListComponent();

        adjustPlayerInfoComponent();

        playerPanel.add(listScroller, BorderLayout.WEST);
        playerPanel.add(playerInfo, BorderLayout.EAST);
    }

    private void adjustPlayerInfoComponent() {
        playerInfo.setPreferredSize(new Dimension(250, 200));
        playerInfo.setEditable(false);
        playerInfo.append("Test");
    }

    private JScrollPane adjustPlayerListComponent() {
        String data[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday"};

        playerList = new JList(data);
        playerList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        playerList.setLayoutOrientation(JList.VERTICAL);
        playerList.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(playerList);
        listScroller.setPreferredSize(new Dimension(250, 200));
        return listScroller;
    }

    private void setupPlayerOptionsPanel() {
        playerOptions.setLayout(new FlowLayout());
        playerOptions.add(addPlayer);
        playerOptions.add(removePlayer);
    }

    public static void main(String[] args) {
        new GUI();
    }

}
