package mvc.controller;

import mvc.model.*;
import mvc.view.*;
import repository.AnimeData;
import repository.DataLoader;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * SwingMainController
 * The main class which handles each screens and datas between each screens
 */
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

            // start from the main menu
            switchMenu("MENU");
        } catch (IOException e) {
            swingMainView.showAlert("Failed to load anime datas. Do you have data directory with json files?");
        }
    }

    /**
     * Method to add a custom menu into the view cardlayout
     * called by the constructor of each menu controllers
     * @param menuName
     * @param swingMenuController
     * @param panel the view of the menu
     * @param menuBar the custom menu bar of the menu view
     */
    public void addMenu(String menuName, SwingMenuController swingMenuController, JPanel panel, JMenuBar menuBar) {
        swingMainView.addCustomPanel(panel, menuName);
        swingMainModel.putMenuBar(menuName, menuBar);
        swingMainModel.addMenuController(menuName, swingMenuController);
    }

    /**
     * Method call when switching menu
     * it updates the screen and call the custom function of the new screen
     * @param menuName the new screen name
     */
    public void switchMenu(String menuName){
        // for the view of the new screen
        swingMainView.showPanel(menuName);
        swingMainView.switchMenuBar(swingMainModel.getMenuBarVal(menuName));
        // custom method of the new screen
        swingMainModel.getMenuController(menuName).onMenuChange();
    }

    /**
     * Method to display the window
     */
    public void display(){
        swingMainView.setVisible(true);
    }

    public DataLoader getDataLoader(){
        return swingMainModel.getDataLoader();
    }

    public HashMap<String, AnimeData> getAnimeDatas(){
        return swingMainModel.getAnimeDatas();
    }

    /**
     * Method to get the anime which user has selected
     * Use to store the data between screens
     * @return the current editing/viewing anime
     */
    public String getCurrentAnime() {
        return swingMainModel.getCurrentAnime();
    }

    /**
     * Method to set the anime which the user has selected
     * @param title the anime title
     */
    public void setCurrentAnime(String title){
        swingMainModel.setCurrentAnime(title);
    }

    /**
     * Method to save a new anime data into the storage
     * @param title
     * @param totalEpisodes
     */
    public void storeAnimeData(String title, int totalEpisodes){
        try {
            AnimeData newAnime = new AnimeData(title, 0, totalEpisodes, 1, null);
            getDataLoader().save(newAnime);
            swingMainModel.addAnimeData(title, newAnime);
        } catch (IOException e) {
            swingMainView.showAlert("Fail to save anime.");
        }
    }

    /**
     * Method used to create an alert box on errors
     * @param alertMessage the alert message
     */
    public void showAlert(String alertMessage) {
        swingMainView.showAlert(alertMessage);
    }
}
