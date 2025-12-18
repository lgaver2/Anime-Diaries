// SPDX-License-Identifier: MIT

import mvc.controller.SwingMainController;
import mvc.model.SwingMainMenuModel;
import mvc.model.SwingMainModel;
import mvc.view.SwingMainMenuView;
import mvc.view.SwingMainView;

public class Main {

    public static void main(String[] args) {
        SwingMainModel swingMainModel = new SwingMainModel();
        SwingMainView swingMainView = new SwingMainView();
        SwingMainController swingMainController = new SwingMainController(swingMainModel, swingMainView);
        swingMainController.display();
    }
}

