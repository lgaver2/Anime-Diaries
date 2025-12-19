package mvc.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SwingAddMenuView extends SwingMenuView {
    private JMenuItem commitItem;
    private JMenuItem cancelItem;
    private JButton addButton;
    JTextArea titleArea;
    JTextArea episodesArea;

    public SwingAddMenuView() {
        super();

        JPanel innerPanel = new JPanel(new GridLayout(2, 2, 5, 10));
        innerPanel.setOpaque(false);
        innerPanel.setBorder(new EmptyBorder(0, 10, 0, 10));

        JLabel titleLabel = new JLabel("Anime Title");
        JLabel episodesLabel = new JLabel("Number of episodes");

        // create text area
        titleArea = new JTextArea(1, 20);
        episodesArea = new JTextArea(1, 20);

        innerPanel.add(titleLabel);
        innerPanel.add(titleArea);
        innerPanel.add(episodesLabel);
        innerPanel.add(episodesArea);

        add(innerPanel, BorderLayout.NORTH);

        // footer
        JPanel footPanel = new JPanel(new BorderLayout());
        addButton = new JButton("ADD");
        addButton.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel foot = new JLabel("Add Mode");
        foot.setBackground(Color.LIGHT_GRAY);
        footPanel.add(addButton, BorderLayout.NORTH);
        footPanel.add(foot, BorderLayout.SOUTH);
        add(footPanel);


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

    public JMenuItem getCommitItem() {
        return commitItem;
    }

    public JMenuItem getCancelItem() {
        return cancelItem;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public String getTitle() {
        return titleArea.getText();
    }

    public String getEpisodes() {
        return episodesArea.getText();
    }
}
