// SPDX-License-Identifier: MIT

package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * SwingLogMenuView
 */
public class SwingLogMenuView extends JPanel{
 private JButton returnButton;
 private JButton commitButton;
 public SwingLogMenuView(){
    setLayout(new BorderLayout());

    // create inner Pannel
    JPanel innerPanel = new JPanel(new GridLayout(4, 1, 5,0));
    innerPanel.setOpaque(false);
    innerPanel.setBorder(new EmptyBorder(0,10,0,10));

    JLabel scoreLabel = new JLabel("Your score");
    JLabel comment = new JLabel("comment for this episode");

    // create text area
    JTextArea scoreArea = new JTextArea();
    JTextArea textArea = new JTextArea();
    JScrollPane scroll = new JScrollPane(textArea);

    innerPanel.add(scoreLabel);
    innerPanel.add(scoreArea);
    innerPanel.add(comment);
    innerPanel.add(scroll);

    add(innerPanel, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    returnButton = new JButton("Return");
    commitButton = new JButton("Commit");
    buttonPanel.add(returnButton);
    buttonPanel.add(commitButton);
    add(buttonPanel, BorderLayout.SOUTH);

    // footer
    //JLabel foot = new JLabel("Log Mode");
    //foot.setHorizontalAlignment(SwingConstants.CENTER);
    //foot.setBackground(Color.LIGHT_GRAY);
    //add(foot, BorderLayout.SOUTH);
  }


    public JButton getReturnButton() {
      return returnButton;
    }
    public JButton getCommitButton(){
      return commitButton;
    }
}
