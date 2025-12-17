// SPDX-License-Identifier: MIT 

package controller;

import java.util.Iterator;
import javax.swing.JButton;

import model.SwingMenuModel;
import view.SwingMainMenuView;
import view.SwingMenuView;


/**
 * SwingMainMenuController
 */
public class SwingMainMenuController extends SwingMenuController {
    public SwingMainMenuController(SwingMenuModel swingMenuModel, SwingMenuView swingMenuView, SwingMainController swingMainController) {
        super(swingMenuModel, swingMenuView, swingMainController);;

        swingMainController.addPanel("MENU", swingMenuView, swingMenuView.getMenuBar());
    }

    @Override
    protected void addActionListeners() {
        super.addActionListeners();
        SwingMainMenuView swingMainMenuView = (SwingMainMenuView) this.swingMenuView;

        swingMainMenuView.getAddAnimeItem().addActionListener(e -> {
            this.swingMainController.switchPanel("ADD");
        });

        Iterator<JButton> addButtonIter = swingMainMenuView.getAddButtons().iterator();
        while (addButtonIter.hasNext()) {
            addButtonIter.next().addActionListener(e -> {
                this.swingMainController.switchPanel("LOG");
            });
        }
    }
}
