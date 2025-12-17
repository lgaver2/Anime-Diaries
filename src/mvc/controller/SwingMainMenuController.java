// SPDX-License-Identifier: MIT 

package controller;

import java.util.Iterator;
import javax.swing.JButton;

import model.SwingLogMenuModel;
import model.SwingMainMenuModel;
import view.SwingLogMenuView;
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

    SwingLogMenuView swingLogMenuView = new SwingLogMenuView();
    SwingLogMenuModel swingLogMenuModel = new SwingLogMenuModel();

    SwingLogMenuController swingLogMenuController = new SwingLogMenuController(swingLogMenuModel, swingLogMenuView, this);
    this.mainMenuView.addCustomPanel(swingLogMenuView, "LOG");

    addActionListeners();
  }

  /**
   * Add action to panel buttons
   */
  private void addActionListeners() {
    mainMenuView.getQuitItem().addActionListener(e ->{
      System.exit(0);
    });

    Iterator<JButton> addButtonIter = mainMenuView.getAddButtons().iterator();
    while (addButtonIter.hasNext()){
      addButtonIter.next().addActionListener(e -> {
        mainMenuView.showPanel("LOG"); 
      });
    }
  }

  public SwingMainMenuView getMainMenuView() {
    return mainMenuView;
  }

  public void display(){
    mainMenuView.setVisible(true);;
  }
}
