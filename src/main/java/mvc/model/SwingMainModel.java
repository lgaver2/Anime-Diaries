package mvc.model;

import repository.AnimeData;
import repository.DataLoader;

import javax.swing.*;
import java.util.HashMap;

public class SwingMainModel {
    private HashMap<String, JMenuBar> menuBarDict;
    private HashMap<String, AnimeData> animeDatas;
    private DataLoader dataLoader;

    public SwingMainModel(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
        menuBarDict = new HashMap<>();
        animeDatas = dataLoader.loadAllDatas();
    }

    public void putMenuBar(String key, JMenuBar val){
        this.menuBarDict.put(key, val);
    }

    public JMenuBar getMenuBarVal(String key) {
        return menuBarDict.get(key);
    }

    public DataLoader getDataLoader() {
        return dataLoader;
    }

    public HashMap<String, AnimeData> getAnimeDatas() {
        return animeDatas;
    }
}
