// SPDX-License-Identifier: MIT

package mvc.view;

import repository.AnimeData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.LinkedList;

/**
 * SwingMainMenuView
 */
public class SwingMainMenuView extends SwingMenuView {


    private JMenuItem addAnimeItem;

    private LinkedList<JButton> addButtons;
    private JPanel contentPanel;
    public SwingMainMenuView() {
        super();
        JLabel foot = new JLabel("Main Menu");
        foot.setHorizontalAlignment(SwingConstants.CENTER);
        foot.setBackground(Color.LIGHT_GRAY);
        add(foot, BorderLayout.SOUTH);

        // initialize menu item here to not be freed
        addAnimeItem = new JMenuItem("Add anime");
        addButtons = new LinkedList<>();
        contentPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuFile.add(addAnimeItem);
        menuFile.add(quitItem);
        menuBar.add(menuFile);
        return menuBar;
    }

    public void addContents(LinkedList<JPanel> animeDatasPanels) {
        //create center scrollable list of animes
        contentPanel.removeAll();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        for (JPanel row : animeDatasPanels) {
            contentPanel.add(row);

            contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        contentPanel.revalidate();
        contentPanel.repaint();
    }


    /**
     * Create the rows of animes
     *
     * @param title    The title to show
     * @param score    The average score of the anime
     * @param progress The progression of the anime (how many episodes left)
     * @return a JPanel with these informations plus two buttons (to view logs and
     * add a new entry)
     */
    public JPanel createRow(String title, float score, int progress) {
        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(Color.WHITE);
        row.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        row.setPreferredSize(new Dimension(500, 100));

        JPanel textPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        textPanel.setOpaque(false);
        textPanel.setBorder(new EmptyBorder(0, 10, 0, 10));

        JLabel animeTitle = new JLabel(title);
        animeTitle.setFont(animeTitle.getFont().deriveFont(Font.BOLD));
        JLabel scoreLabel = new JLabel("AVG Score: " + Float.toString(score));
        JLabel progressLabel = new JLabel("Progress: " + Integer.toString(progress) + "%");

        textPanel.add(animeTitle);
        textPanel.add(scoreLabel);
        textPanel.add(progressLabel);
        row.add(textPanel);


        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1, 0, 2));
        buttonsPanel.setOpaque(false);
        JButton btn1 = new JButton("Add");
        JButton btn2 = new JButton("View");

        btn1.setFont(new Font("Arial", Font.PLAIN, 10));
        btn2.setFont(new Font("Arial", Font.PLAIN, 10));

        buttonsPanel.add(btn1);
        addButtons.add(btn1);
        buttonsPanel.add(btn2);

        row.add(buttonsPanel, BorderLayout.EAST);

        return row;
    }

    public JMenuItem getAddAnimeItem() {
        return addAnimeItem;
    }

    public LinkedList<JButton> getAddButtons() {
        return this.addButtons;
    }


}
