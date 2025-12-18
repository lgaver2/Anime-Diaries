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

    public JMenuBar getMenuBar() {
        return new JMenuBar();
    }

    public JMenuItem getQuitItem() {
        return this.quitItem;
    }
}
