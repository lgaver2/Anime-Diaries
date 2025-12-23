// SPDX-License-Identifier: MIT
package mvc.model;

import mvc.controller.SwingMenuController;
import repository.AnimeData;
import repository.DataLoader;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * SwingMainModel
 * the class which store the principle datas of the applications
 */
public class SwingMainModel {
    // datas of the custom menu bar of each screen
    private HashMap<String, JMenuBar> menuBarDict;
    // anime datas
    private HashMap<String, AnimeData> animeDatas;
    private DataLoader dataLoader;
    private String currentAnime;
    private HashMap<String, SwingMenuController> menuControllers;

    public SwingMainModel(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
        menuBarDict = new HashMap<>();
        menuControllers = new HashMap<>();
    }

    /**
     * store a new screen menu bar
     * @param key the screen name
     * @param val the custom menu bar
     */
    public void putMenuBar(String key, JMenuBar val) {
        this.menuBarDict.put(key, val);
    }

    /**
     * get the custom menu bar
     * @param key the name of the screen
     * @return the custom menu bar
     */
    public JMenuBar getMenuBarVal(String key) {
        return menuBarDict.get(key);
    }

    public DataLoader getDataLoader() {
        return dataLoader;
    }

    /**
     * The main method to load all datas from the storage and put in the anime datas
     * @throws IOException throws if the load has failed
     */
    public void loadAllDatas() throws IOException {
        animeDatas = dataLoader.loadAllDatas();
    }

    /**
     * Get the value of loaded anime datas
     * @return the raw anime datas which contains all datas
     */
    public HashMap<String, AnimeData> getAnimeDatas() {
        return animeDatas;
    }

    /**
     * Get the anime which the user is adding comment or viewing former comment
     * @return anime title
     */
    public String getCurrentAnime() {
        return currentAnime;
    }

    /**
     * Set the anime which the user want to edit/view
     * @param currentAnime the title of the anime which the user has chosen
     */
    public void setCurrentAnime(String currentAnime) {
        this.currentAnime = currentAnime;
    }

    /**
     * Method to store each screen controllers
     * @param menuName the name of the screen
     * @param swingMenuController the controller
     */
    public void addMenuController(String menuName, SwingMenuController swingMenuController) {
        menuControllers.put(menuName, swingMenuController);
    }

    public SwingMenuController getMenuController(String menuName) {
        return menuControllers.get(menuName);
    }

    /**
     * use to add localy an anime and not load datas each times
     * @param title the title of the anime
     * @param animeData the datas for the anime
     */
    public void addAnimeData(String title, AnimeData animeData) {
        animeDatas.put(title, animeData);
    }
}
