package ui;

import javax.swing.*;
import model.Player;
import model.Team;

import java.awt.*;

public class GUI {

    private JFrame mainFrame = new JFrame();
    private JPanel rootPanel = new JPanel();

    private JPanel playerPanel = new JPanel();
    private JPanel playerOptions = new JPanel();
    private JPanel saveOptions = new JPanel();


    private JList playerList = new JList();
    private JTextField playerInfo = new JTextField("Test");

    private JButton addPlayer = new JButton("add a new player");
    private JButton removePlayer = new JButton("remove an existing player");

    private GUI() {

        mainFrame.setContentPane(rootPanel);
        mainFrame.setResizable(false);
        mainFrame.setMinimumSize(new java.awt.Dimension(500, 300));

        setupPlayerPanel();


        rootPanel.add(playerPanel);
        rootPanel.add(playerOptions);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void setupPlayerPanel() {
        // TODO
    }

    private void setupPlayerOptions() {
        // TODO
    }

    public static void main(String[] args) {
        new GUI();
    }

}
