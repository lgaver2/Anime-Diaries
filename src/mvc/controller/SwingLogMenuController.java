// SPDX-License-Identifier: MIT

package controller;

import model.SwingLogMenuModel;
import model.SwingMainMenuModel;
import view.SwingLogMenuView;

/**
 * SwingLogMenuController
 */
public class SwingLogMenuController {

  private SwingLogMenuModel swingLogMenuModel;
  private SwingLogMenuView swingLogMenuView;
  private SwingMainMenuController swingMainMenuController;

  public SwingLogMenuController(SwingLogMenuModel swingLogMenuModel, SwingLogMenuView swingLogMenuView, SwingMainMenuController swingMainMenuController){
    this.swingLogMenuView = swingLogMenuView;
    this.swingLogMenuModel = swingLogMenuModel;
    this.swingMainMenuController = swingMainMenuController;

    addActionListeners();
  }
  private void addActionListeners(){
    swingLogMenuView.getReturnButton().addActionListener(e -> {
      swingMainMenuController.getMainMenuView().showPanel("MENU");
    });

    swingLogMenuView.getCommitButton().addActionListener(e -> {
      swingMainMenuController.getMainMenuView().showPanel("MENU");
    });
  }
}
