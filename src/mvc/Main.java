// SPDX-License-Identifier: MIT

import controller.SwingMainController;
import controller.SwingMainMenuController;
import model.SwingMainMenuModel;
import model.SwingMainModel;
import view.SwingMainMenuView;
import view.SwingMainView;

public class Main {

    public static void main(String[] args) {
        SwingMainModel swingMainModel = new SwingMainModel();
        SwingMainView swingMainView = new SwingMainView();
        SwingMainController swingMainController = new SwingMainController(swingMainModel, swingMainView);
        swingMainController.display();
    }
}

