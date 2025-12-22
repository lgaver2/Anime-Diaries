package mvc.model;

import mvc.controller.SwingMenuController;
import repository.AnimeData;
import repository.DataLoader;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class SwingMainModel {
    private HashMap<String, JMenuBar> menuBarDict;
    private HashMap<String, AnimeData> animeDatas;
    private DataLoader dataLoader;
    private String currentAnime;
    private HashMap<String, SwingMenuController> menuControllers;

    public SwingMainModel(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
        menuBarDict = new HashMap<>();
        menuControllers = new HashMap<>();
    }

    public void putMenuBar(String key, JMenuBar val) {
        this.menuBarDict.put(key, val);
    }

    public JMenuBar getMenuBarVal(String key) {
        return menuBarDict.get(key);
    }

    public DataLoader getDataLoader() {
        return dataLoader;
    }

    public void loadAllDatas() throws IOException {
        animeDatas = dataLoader.loadAllDatas();
    }

    public HashMap<String, AnimeData> getAnimeDatas() {
        return animeDatas;
    }

    public String getCurrentAnime() {
        return currentAnime;
    }

    public void setCurrentAnime(String currentAnime) {
        this.currentAnime = currentAnime;
    }

    public void addMenuController(String menuName, SwingMenuController swingMenuController) {
        menuControllers.put(menuName, swingMenuController);
    }

    public SwingMenuController getMenuController(String menuName) {
        return menuControllers.get(menuName);
    }

    public void addAnimeData(String title, AnimeData animeData) {
        animeDatas.put(title, animeData);
    }
}
