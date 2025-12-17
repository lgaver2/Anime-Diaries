// SPDX-License-Identifier: MIT

package controller;

import model.SwingLogMenuModel;
import model.SwingMainMenuModel;
import view.SwingLogMenuView;
import view.SwingMainView;

/**
 * SwingLogMenuController
 */
public class SwingLogMenuController extends SwingMenuController {
    public SwingLogMenuController(SwingLogMenuModel swingLogMenuModel, SwingLogMenuView swingLogMenuView, SwingMainController swingMainController) {
        super(swingLogMenuModel, swingLogMenuView, swingMainController);

        swingMainController.addPanel("LOG", swingMenuView, swingMenuView.getMenuBar());
    }

    @Override
    protected void addActionListeners() {
        super.addActionListeners();

        SwingLogMenuView swingLogMenuView = (SwingLogMenuView) swingMenuView;
        swingLogMenuView.getCommitItem().addActionListener(e -> {
           this.swingMainController.switchPanel("MENU");
        });

        swingLogMenuView.getCancelItem().addActionListener(e -> {
            this.swingMainController.switchPanel("MENU");
        });
    }
}
