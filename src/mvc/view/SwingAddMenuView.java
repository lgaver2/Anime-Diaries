package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SwingAddMenuView extends SwingMenuView {
    private JMenuItem commitItem;
    private JMenuItem cancelItem;

    public SwingAddMenuView() {
        super();

        JPanel innerPanel = new JPanel(new GridLayout(4, 1, 5, 0));
        innerPanel.setOpaque(false);
        innerPanel.setBorder(new EmptyBorder(0, 10, 0, 10));

        JLabel titleLabel = new JLabel("Anime Title");
        JLabel episodesLabel = new JLabel("Number of episodes");

        // create text area
        JTextArea scoreArea = new JTextArea();
        JTextArea episodesArea = new JTextArea();

        innerPanel.add(titleLabel);
        innerPanel.add(scoreArea);
        innerPanel.add(episodesLabel);
        innerPanel.add(episodesArea);

        add(innerPanel, BorderLayout.CENTER);

        // footer
        JLabel foot = new JLabel("Add Mode");
        foot.setHorizontalAlignment(SwingConstants.CENTER);
        foot.setBackground(Color.LIGHT_GRAY);
        add(foot, BorderLayout.SOUTH);


        commitItem = new JMenuItem("Commit");
        cancelItem = new JMenuItem("Cancel");
    }

    @Override
    public JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuFile.add(commitItem);
        menuFile.add(cancelItem);
        menuFile.add(quitItem);
        menuBar.add(menuFile);
        return menuBar;
    }
}
