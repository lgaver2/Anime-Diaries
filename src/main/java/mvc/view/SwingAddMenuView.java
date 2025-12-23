package mvc.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SwingAddMenuView extends SwingMenuView {
    // for menu bar
    private final JMenuItem commitItem;
    private final JMenuItem returnItem;

    // button to commit the input
    private final JButton addButton;
    // text areas
    private final JTextArea titleArea;
    private final JTextArea episodesArea;

    public SwingAddMenuView() {
        super();
        setName("AddScreen");
        JPanel innerPanel = new JPanel(new GridLayout(2, 2, 5, 10));
        innerPanel.setOpaque(false);
        innerPanel.setBorder(new EmptyBorder(0, 10, 0, 10));

        // create the input field
        // create label for the explanation of the text areas
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
        // create the commit button
        JPanel footPanel = new JPanel(new BorderLayout());
        addButton = new JButton("ADD");
        addButton.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel foot = new JLabel("Add Mode");
        foot.setBackground(Color.LIGHT_GRAY);
        footPanel.add(addButton, BorderLayout.NORTH);
        footPanel.add(foot, BorderLayout.SOUTH);
        add(footPanel);

        // create the menu bar items
        commitItem = new JMenuItem("Commit");
        returnItem = new JMenuItem("Return");
    }

    @Override
    public JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuFile.add(commitItem);
        menuFile.add(returnItem);
        menuFile.add(quitItem);
        menuBar.add(menuFile);
        return menuBar;
    }

    public JMenuItem getCommitItem() {
        return commitItem;
    }

    public JMenuItem getReturnItem() {
        return returnItem;
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

    /**
     * to reset the input fields values
     * called when refresh the page
     */
    public void eraseInputs() {
        titleArea.setText("");
        episodesArea.setText("");
    }
}
