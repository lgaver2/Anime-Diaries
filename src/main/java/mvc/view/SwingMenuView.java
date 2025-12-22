package mvc.view;

import mvc.controller.SwingMenuController;

import javax.swing.*;
import java.awt.*;

public abstract class SwingMenuView extends JPanel {
    protected JMenuItem quitItem;

    public SwingMenuView() {
        setLayout(new BorderLayout());
        quitItem = new JMenuItem("Quit");
    }

    /**
     * Method to create and return the custom menu bar of the screen
     * each menu bar has a quit item
     * @return
     */
    public JMenuBar getMenuBar() {
        return new JMenuBar();
    }

    public JMenuItem getQuitItem() {
        return this.quitItem;
    }
}
