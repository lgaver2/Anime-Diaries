// SPDX-License-Identifier: MIT 

package controller;

import model.SwingMainMenuModel;
import view.SwingMainMenuView;

/**
 * SwingMainMenuController
 */
public class SwingMainMenuController extends MainMenuController{
  
  private SwingMainMenuModel mainMenuModel;
  private SwingMainMenuView mainMenuView;
  
  public SwingMainMenuController(SwingMainMenuModel mainMenuModel, SwingMainMenuView mainMenuView){
    this.mainMenuModel = mainMenuModel;
    this.mainMenuView = mainMenuView;
    mainMenuView.setVisible(true);
  }

  public void display(){
    mainMenuView.display();
  }
}
