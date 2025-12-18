package mvc.controller;

import mvc.model.SwingMenuModel;
import mvc.view.SwingAddMenuView;
import mvc.view.SwingMenuView;

public class SwingAddMenuController extends SwingMenuController {
    public SwingAddMenuController(SwingMenuModel swingMenuModel, SwingMenuView swingMenuView, SwingMainController swingMainController) {
        super(swingMenuModel, swingMenuView, swingMainController);

        swingMainController.addPanel("ADD", swingMenuView, swingMenuView.getMenuBar());
    }
}
