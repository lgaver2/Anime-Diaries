// SPDX-License-Identifier: MIT

package mvc.controller;

import mvc.model.SwingMenuModel;
import mvc.view.SwingMainView;
import mvc.view.SwingMenuView;
import repository.DataLoader;

/**
 * MainMenuController
 * The abstract class for the screen controllers
 */
public abstract class SwingMenuController {
    protected SwingMenuModel swingMenuModel;
    protected SwingMenuView swingMenuView;
    protected SwingMainController swingMainController;
    public SwingMenuController(SwingMenuModel swingMenuModel, SwingMenuView swingMenuView, SwingMainController swingMainController) {
        this.swingMenuModel = swingMenuModel;
        this.swingMenuView = swingMenuView;
        this.swingMainController = swingMainController;
    }

    /**
     * add actions to the buttons
     */
    protected void addActionListeners(){
        swingMenuView.getQuitItem().addActionListener(e -> {
            System.exit(0);
        });
    }

    /**
     * Method to have a custom function when the screen change
     */
    protected void onMenuChange(){};
}
