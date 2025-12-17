// SPDX-License-Identifier: MIT

package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.LinkedList;

/**
 * SwingMainMenuView
 */
public class SwingMainMenuView extends JFrame implements MainMenuView{
 
  private CardLayout cardLayout;
  private JPanel mainPanel;

  private JMenuItem quitItem;

  private LinkedList<JButton> addButtons;

  public SwingMainMenuView(){
    //display settings
    setTitle("Anime Diary");
    setSize(700,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    cardLayout = new CardLayout();
    mainPanel = new JPanel(cardLayout);
    JPanel menuView = new JPanel(new BorderLayout());
    
    //layout for the mainPanel
    //create the menu bar
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile = new JMenu("File");
    JMenuItem addAnimItem = new JMenuItem("Add anime");
    quitItem = new JMenuItem("Quit");
    menuFile.add(addAnimItem);
    menuFile.add(quitItem);
    menuBar.add(menuFile);
    setJMenuBar(menuBar);

    //create center scrollable list of animes
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

    addButtons = new LinkedList<>();

    for (int i = 1; i <= 15; i++) {
        JPanel ligne = createLine("Title " + i, i, i+2);
        contentPanel.add(ligne);
        
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    //create the footer
    JScrollPane scrollPane = new JScrollPane(contentPanel);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    menuView.add(scrollPane, BorderLayout.CENTER);
    
    JLabel foot = new JLabel("Main Menu");
    foot.setHorizontalAlignment(SwingConstants.CENTER);
    foot.setBackground(Color.LIGHT_GRAY);
    menuView.add(foot, BorderLayout.SOUTH);
    
    mainPanel.add(menuView, "MENU");

    this.add(mainPanel);
  }

  public void addCustomPanel(JPanel panel, String panelName){
    mainPanel.add(panel, panelName);
  }

  public void showPanel(String panelName){
    cardLayout.show(mainPanel, panelName);
  }

  /**
   * Create the rows of animes
   * @param title The title to show
   * @param score The average score of the anime
   * @param progress The progression of the anime (how many episodes left)
   * @return a JPanel with these informations plus two buttons (to view logs and 
   * add a new entry)
   */
  private JPanel createLine(String title, int score, int progress) {
    JPanel row = new JPanel(new BorderLayout());
    row.setBackground(Color.WHITE);
    row.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
    row.setPreferredSize(new Dimension(500, 100));

    JPanel textPanel = new JPanel(new GridLayout(1,3,10,0));
    textPanel.setOpaque(false);
    textPanel.setBorder(new EmptyBorder(0,10,0,10));

    JLabel animeTitle = new JLabel(title);
    animeTitle.setFont(animeTitle.getFont().deriveFont(Font.BOLD));
    JLabel scoreLabel = new JLabel("AVG Score: "+Integer.toString(score));
    JLabel progressLabel = new JLabel("Progress: "+Integer.toString(progress)+"%");

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

  public JPanel getMainPanel(){
    return mainPanel;
  }

  public CardLayout getCardLayout(){
    return cardLayout;
  }

  public JMenuItem getQuitItem(){
    return this.quitItem;
  } 

  public LinkedList<JButton> getAddButtons(){
    return this.addButtons;
  }


  @Override
  public void display(){
  }
}
