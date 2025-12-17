package controller;

import model.SwingAddMenuModel;
import model.SwingLogMenuModel;
import model.SwingMainMenuModel;
import model.SwingMainModel;
import view.SwingAddMenuView;
import view.SwingLogMenuView;
import view.SwingMainMenuView;
import view.SwingMainView;

import javax.swing.*;

public class SwingMainController {
    private SwingMainModel swingMainModel;
    private SwingMainView swingMainView;
    public SwingMainController(SwingMainModel swingMainModel, SwingMainView swingMainView){

        this.swingMainModel = swingMainModel;
        this.swingMainView = swingMainView;

        SwingMainMenuView swingMainMenuView = new SwingMainMenuView();
        SwingMainMenuModel swingMainMenuModel = new SwingMainMenuModel();
        SwingMainMenuController swingMainMenuController = new SwingMainMenuController(swingMainMenuModel, swingMainMenuView, this);

        SwingLogMenuView swingLogMenuView = new SwingLogMenuView();
        SwingLogMenuModel swingLogMenuModel = new SwingLogMenuModel();
        SwingLogMenuController swingLogMenuController = new SwingLogMenuController(swingLogMenuModel, swingLogMenuView, this);

        SwingAddMenuView swingAddMenuView = new SwingAddMenuView();
        SwingAddMenuModel swingAddMenuModel = new SwingAddMenuModel();
        SwingAddMenuController swingAddMenuController = new SwingAddMenuController(swingAddMenuModel, swingAddMenuView, this);

        this.swingMainView.switchMenuBar(swingMainMenuView.getMenuBar());
    }
    public void addPanel(String panelName, JPanel panel, JMenuBar menuBar) {
        swingMainView.addCustomPanel(panel, panelName);
        swingMainModel.putMenuBar(panelName, menuBar);
    }

    public void switchPanel(String panelName){
        swingMainView.showPanel(panelName);
        swingMainView.switchMenuBar(swingMainModel.getMenuBarVal(panelName));
    }

    public void display(){
        swingMainView.setVisible(true);
    }
}
