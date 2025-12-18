// SPDX-License-Identifier: MIT

package mvc.controller;

import mvc.model.SwingMenuModel;
import mvc.view.SwingMainView;
import mvc.view.SwingMenuView;

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
