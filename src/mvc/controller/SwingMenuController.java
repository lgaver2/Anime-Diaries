// SPDX-License-Identifier: MIT

package controller;

import model.SwingMenuModel;
import view.SwingMainView;
import view.SwingMenuView;

/**
 * MainMenuController
 */
public abstract class SwingMenuController {
    protected SwingMenuModel swingMenuModel;
    protected SwingMenuView swingMenuView;
    protected SwingMainController swingMainController;
    public SwingMenuController(SwingMenuModel swingMenuModel, SwingMenuView swingMenuView, SwingMainController swingMainController) {
        this.swingMenuModel = swingMenuModel;
        this.swingMenuView = swingMenuView;
        this.swingMainController = swingMainController;

        addActionListeners();
    }

    protected void addActionListeners(){
        swingMenuView.getQuitItem().addActionListener(e -> {
            System.exit(0);
        });
    }
}
