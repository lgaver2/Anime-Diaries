package mvc.controller;

import mvc.model.SwingMenuModel;
import mvc.view.SwingMenuView;

public class SwingViewMenuController extends SwingMenuController{

    public SwingViewMenuController(SwingMenuModel swingViewMenuModel, SwingMenuView swingViewMenuView, SwingMainController swingMainController) {
        super(swingViewMenuModel, swingViewMenuView, swingMainController);

        swingMainController.addMenu("VIEW", this, swingViewMenuView, swingViewMenuView.getMenuBar());
    }
}
