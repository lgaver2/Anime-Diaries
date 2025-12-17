package model;

import javax.swing.*;
import java.util.HashMap;

public class SwingMainModel {
    private HashMap<String, JMenuBar> menuBarDict;

    public SwingMainModel(){
        menuBarDict = new HashMap<>();
    }

    public void putMenuBar(String key, JMenuBar val){
        this.menuBarDict.put(key, val);
    }

    public JMenuBar getMenuBarVal(String key) {
        return menuBarDict.get(key);
    }
}
