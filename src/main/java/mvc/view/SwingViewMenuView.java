package mvc.view;

import repository.AnimeCommentData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SwingViewMenuView extends SwingMenuView {
    private JMenuItem returnItem;
    private JPanel contentPanel;
    public SwingViewMenuView() {
        super();
        JLabel foot = new JLabel("View Mode");
        foot.setHorizontalAlignment(SwingConstants.CENTER);
        foot.setBackground(Color.LIGHT_GRAY);
        add(foot, BorderLayout.SOUTH);

        // initialize menu item here to not be freed
        returnItem = new JMenuItem("return");
        contentPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuFile.add(returnItem);
        menuFile.add(quitItem);
        menuBar.add(menuFile);
        return menuBar;
    }

    public void removeContent() {
        contentPanel.removeAll();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
    }
    public void addContents(HashMap<Integer, AnimeCommentData> comments) {
        //create center scrollable list of animes

        for (Map.Entry<Integer, AnimeCommentData> set : comments.entrySet()) {
            JPanel row = createRow(set.getKey(), set.getValue().getScore(), set.getValue().getComment(), set.getValue().getLogDate());
            contentPanel.add(row);

            contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public JPanel createRow(int currentEpisode, float score, String comment, Date date) {
        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(Color.WHITE);
        row.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        row.setPreferredSize(new Dimension(500, 100));

        JLabel episodeLabel = new JLabel("Ep:" + currentEpisode);
        JLabel scoreLabel = new JLabel("Score: " + Float.toString(score) + " on " + date.toString());
        JLabel commentLabel = new JLabel(comment);

        row.add(episodeLabel, BorderLayout.NORTH);
        row.add(commentLabel, BorderLayout.CENTER);
        row.add(scoreLabel, BorderLayout.SOUTH);

        return row;
    }

    public JMenuItem getReturnItem() {
        return returnItem;
    }
}
