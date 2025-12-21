// SPDX-License-Identifier: MIT

package mvc.model;

import javax.swing.*;
import java.util.LinkedList;

/**
 * SwingMainMenuModel
 */
public class SwingMainMenuModel extends SwingMenuModel {

    LinkedList<JPanel> animeDatasPanels;
    LinkedList<String> animeTitles;
    public SwingMainMenuModel() {
        animeDatasPanels = new LinkedList<>();
        animeTitles = new LinkedList<>();
    }

    public LinkedList<JPanel> getAnimeDatasPanels() {
        return animeDatasPanels;
    }

    public LinkedList<String> getAnimeTitles() {
        return animeTitles;
    }

    public void removeAllList(){
        animeTitles.removeAll(animeTitles);
    }
}
