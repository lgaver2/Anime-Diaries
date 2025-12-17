package view;

import javax.swing.*;
import java.awt.*;

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

    public void addCustomPanel(JPanel panel, String panelName) {
        mainPanel.add(panel, panelName);
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public void switchMenuBar(JMenuBar menuBar) {
        this.setJMenuBar(menuBar);
        this.revalidate();
        this.repaint();
    }
}
