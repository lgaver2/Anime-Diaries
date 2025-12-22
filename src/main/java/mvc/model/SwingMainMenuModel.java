// SPDX-License-Identifier: MIT

package mvc.model;

import javax.swing.*;
import java.util.LinkedList;

/**
 * SwingMainMenuModel
 */
public class SwingMainMenuModel extends SwingMenuModel {

    LinkedList<JPanel> animeDatasPanels;
    public SwingMainMenuModel() {
        animeDatasPanels = new LinkedList<>();
    }

    public LinkedList<JPanel> getAnimeDatasPanels() {
        return animeDatasPanels;
    }


    public void removeAllList(){
        animeDatasPanels.removeAll(animeDatasPanels);
    }
}
