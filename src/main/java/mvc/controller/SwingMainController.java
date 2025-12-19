package mvc.controller;

import mvc.model.SwingAddMenuModel;
import mvc.model.SwingLogMenuModel;
import mvc.model.SwingMainMenuModel;
import mvc.model.SwingMainModel;
import mvc.view.SwingAddMenuView;
import mvc.view.SwingLogMenuView;
import mvc.view.SwingMainMenuView;
import mvc.view.SwingMainView;
import repository.AnimeData;
import repository.DataLoader;

import javax.swing.*;
import java.util.HashMap;

public class SwingMainController {
    private SwingMainModel swingMainModel;
    private SwingMainView swingMainView;
    private SwingMainMenuController swingMainMenuController;
    public SwingMainController(SwingMainModel swingMainModel, SwingMainView swingMainView){

        this.swingMainModel = swingMainModel;
        this.swingMainView = swingMainView;

        SwingMainMenuView swingMainMenuView = new SwingMainMenuView();
        SwingMainMenuModel swingMainMenuModel = new SwingMainMenuModel();
        swingMainMenuController = new SwingMainMenuController(swingMainMenuModel, swingMainMenuView, this);

        SwingLogMenuView swingLogMenuView = new SwingLogMenuView();
        SwingLogMenuModel swingLogMenuModel = new SwingLogMenuModel();
        SwingLogMenuController swingLogMenuController = new SwingLogMenuController(swingLogMenuModel, swingLogMenuView, this);

        SwingAddMenuView swingAddMenuView = new SwingAddMenuView();
        SwingAddMenuModel swingAddMenuModel = new SwingAddMenuModel();
        SwingAddMenuController swingAddMenuController = new SwingAddMenuController(swingAddMenuModel, swingAddMenuView, this);

        switchPanel("MENU");
    }
    public void addPanel(String panelName, JPanel panel, JMenuBar menuBar) {
        swingMainView.addCustomPanel(panel, panelName);
        swingMainModel.putMenuBar(panelName, menuBar);
    }

    public void switchPanel(String panelName){
        swingMainView.showPanel(panelName);
        swingMainView.switchMenuBar(swingMainModel.getMenuBarVal(panelName));
        if (panelName.compareTo("MENU") == 0){
            swingMainMenuController.reload();
        }
    }

    public void display(){
        swingMainView.setVisible(true);
    }

    public DataLoader getDataLoader(){
        return swingMainModel.getDataLoader();
    }

    public HashMap<String, AnimeData> getAnimeDatas(){
        return swingMainModel.getAnimeDatas();
    }
}
