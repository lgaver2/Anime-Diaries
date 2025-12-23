// SPDX-License-Identifier: MIT
package mvc.view;

import javax.swing.*;
import java.awt.*;

/**
 * SwingMainView
 * the class wich implement the main window
 */
public class SwingMainView extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SwingMainView() {
        setTitle("Anime Diary");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        this.add(mainPanel);
    }

    /**
     * add a panel for a type of screen (Main, Add, Log etc...)
     * @param panel the panel with layout datas
     * @param panelName the name of the screen
     */
    public void addCustomPanel(JPanel panel, String panelName) {
        mainPanel.add(panel, panelName);
    }

    /**
     * Method to change the current screen to other screen
     * @param panelName the name of the screen
     */
    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    /**
     * Method to change the content of the menu bar
     * @param menuBar the custom menu bar
     */
    public void switchMenuBar(JMenuBar menuBar) {
        this.setJMenuBar(menuBar);
        this.revalidate();
        this.repaint();
    }

    /**
     * Method called on error to display a error box
     * @param alertMessage
     */
    public void showAlert(String alertMessage){
        JOptionPane.showMessageDialog(this, alertMessage, "Anime Diaries",JOptionPane.WARNING_MESSAGE);
    }
}
