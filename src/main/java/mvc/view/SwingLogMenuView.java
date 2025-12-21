// SPDX-License-Identifier: MIT

package mvc.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * SwingLogMenuView
 */
public class SwingLogMenuView extends SwingMenuView {
    private JMenuItem commitItem;
    private JMenuItem cancelItem;
    private JButton commitButton;
    private JLabel titleLabel;
    private JTextArea scoreArea;
    private JTextArea commentArea;

    public SwingLogMenuView() {
        super();
        setBorder(new EmptyBorder(0,20,0,20));

        // create header
        //create title label for the page
        titleLabel = new JLabel("TITLE: Episode:x");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // section for the content
        JPanel contentPanel = new JPanel(new BorderLayout());

        // create section for scoring input
        JPanel scorePanel = new JPanel(new BorderLayout());
        scorePanel.setOpaque(false);
        
        JLabel scoreLabel = new JLabel("Your score");
        scoreArea = new JTextArea(1, 20);
        scoreArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        scorePanel.add(scoreLabel, BorderLayout.NORTH);
        scorePanel.add(scoreArea, BorderLayout.CENTER);
        


        // create pannel for scoring
        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.setOpaque(false);
        
        JLabel commentLabel = new JLabel("Comment for this episode");
        commentArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(commentArea);
        commitButton = new JButton("Commit");
        
        commentPanel.add(commentLabel, BorderLayout.NORTH);
        commentPanel.add(scroll, BorderLayout.CENTER);

        contentPanel.add(scorePanel, BorderLayout.NORTH);
        contentPanel.add(commentPanel, BorderLayout.CENTER);
        contentPanel.add(commitButton, BorderLayout.SOUTH);

        add(contentPanel, BorderLayout.CENTER);
        // footer
        JLabel foot = new JLabel("Log Mode");
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

    public JMenuItem getCancelItem() {
        return cancelItem;
    }

    public JMenuItem getCommitItem() {
        return commitItem;
    }
    public JButton getCommitButton(){
        return commitButton;
    }

    public void setTitleLabel(String title) {
        titleLabel.setText(title);
    }

    public String getScore() {
        return scoreArea.getText();
    }

    public String getComment() {
        return commentArea.getText();
    }

    public void eraseInputs(){
        scoreArea.setText("");
        commentArea.setText("");
    }
}
