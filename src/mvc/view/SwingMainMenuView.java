// SPDX-License-Identifier: MIT

package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Menu;

import javax.swing.*;

/**
 * SwingMainMenuView
 */
public class SwingMainMenuView extends JFrame implements MainMenuView{
 
  private CardLayout cardLayout;
  private JPanel mainPanel;

  public SwingMainMenuView(){
    //display settings
    setTitle("Anime Diary");
    setSize(700,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    cardLayout = new CardLayout();
    mainPanel = new JPanel(cardLayout);
    mainPanel.setLayout(new BorderLayout());
    
    //layout for the mainPanel
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu("File");
    JMenuItem addAnimItem = new JMenuItem("Add anime");
    JMenuItem quitItem = new JMenuItem("Quit");
    menuFile.add(addAnimItem);
    menuFile.add(quitItem);
    menuBar.add(menuFile);
    setJMenuBar(menuBar);
    
    JLabel title = new JLabel("Main Menu");
    title.setHorizontalAlignment(SwingConstants.CENTER);
    mainPanel.add(title, BorderLayout.SOUTH);

    this.add(mainPanel);
  }

  public void addPanel(JPanel panel, String panelName){
    mainPanel.add(panel, panelName);
  }

  public void showPanel(String panelName){
    cardLayout.show(mainPanel, panelName);
  }

  @Override
  public void display(){
    setVisible(true);
  }
}
