// SPDX-License-Identifier: MIT

import controller.SwingMainMenuController;
import model.SwingMainMenuModel;
import view.SwingMainMenuView;

public class Main{
  
  public static void main(String[] args) {
    SwingMainMenuModel mainMenuModel = new SwingMainMenuModel();
    SwingMainMenuView mainMenuView = new SwingMainMenuView();
    SwingMainMenuController mainMenuController = new SwingMainMenuController(mainMenuModel, mainMenuView);
    mainMenuController.display();
  }
}

