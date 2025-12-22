package mvc.controller;

import mvc.model.*;
import mvc.view.*;
import repository.AnimeData;
import repository.DataLoader;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class SwingMainController {
    private SwingMainModel swingMainModel;
    private SwingMainView swingMainView;
    public SwingMainController(SwingMainModel swingMainModel, SwingMainView swingMainView){

        this.swingMainModel = swingMainModel;
        this.swingMainView = swingMainView;

        try {
            swingMainModel.loadAllDatas();

            SwingMainMenuView swingMainMenuView = new SwingMainMenuView();
            SwingMainMenuModel swingMainMenuModel = new SwingMainMenuModel();
            SwingMainMenuController swingMainMenuController = new SwingMainMenuController(swingMainMenuModel, swingMainMenuView, this);

            SwingLogMenuView swingLogMenuView = new SwingLogMenuView();
            SwingLogMenuModel swingLogMenuModel = new SwingLogMenuModel();
            SwingLogMenuController swingLogMenuController = new SwingLogMenuController(swingLogMenuModel, swingLogMenuView, this);

            SwingViewMenuModel swingViewMenuModel = new SwingViewMenuModel();
            SwingViewMenuView swingViewMenuView = new SwingViewMenuView();
            SwingViewMenuController swingViewMenuController = new SwingViewMenuController(swingViewMenuModel, swingViewMenuView, this);

            SwingAddMenuView swingAddMenuView = new SwingAddMenuView();
            SwingAddMenuModel swingAddMenuModel = new SwingAddMenuModel();
            SwingAddMenuController swingAddMenuController = new SwingAddMenuController(swingAddMenuModel, swingAddMenuView, this);

            switchMenu("MENU");
        } catch (IOException e) {
            swingMainView.showAlert("Failed to load anime datas. Do you have data directory with json files?");
        }
    }
    public void addMenu(String menuName, SwingMenuController swingMenuController, JPanel panel, JMenuBar menuBar) {
        swingMainView.addCustomPanel(panel, menuName);
        swingMainModel.putMenuBar(menuName, menuBar);
        swingMainModel.addMenuController(menuName, swingMenuController);
    }

    public void switchMenu(String menuName){
        swingMainView.showPanel(menuName);
        swingMainView.switchMenuBar(swingMainModel.getMenuBarVal(menuName));
        swingMainModel.getMenuController(menuName).onMenuChange();
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
    public String getCurrentAnime() {
        return swingMainModel.getCurrentAnime();
    }
    public void setCurrentAnime(String title){
        swingMainModel.setCurrentAnime(title);
    }

    public void addAnimeData(String title, int totalEpisodes){
        try {
            AnimeData newAnime = new AnimeData(title, 0, totalEpisodes, 1, null);
            getDataLoader().save(newAnime);
            swingMainModel.addAnimeData(title, newAnime);
        } catch (IOException e) {
            swingMainView.showAlert("Fail to save anime.");
        }
    }

    public void showAlert(String alertMessage) {
        swingMainView.showAlert(alertMessage);
    }
}
