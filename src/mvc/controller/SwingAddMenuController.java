package controller;

import model.SwingMenuModel;
import view.SwingAddMenuView;
import view.SwingMenuView;

public class SwingAddMenuController extends SwingMenuController {
    public SwingAddMenuController(SwingMenuModel swingMenuModel, SwingMenuView swingMenuView, SwingMainController swingMainController) {
        super(swingMenuModel, swingMenuView, swingMainController);

        swingMainController.addPanel("ADD", swingMenuView, swingMenuView.getMenuBar());
    }
}
