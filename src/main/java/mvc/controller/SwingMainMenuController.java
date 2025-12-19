// SPDX-License-Identifier: MIT 

package mvc.controller;

import java.util.Map;
import javax.swing.*;

import mvc.model.SwingMainMenuModel;
import mvc.model.SwingMenuModel;
import mvc.view.SwingMainMenuView;
import mvc.view.SwingMenuView;
import repository.AnimeData;


/**
 * SwingMainMenuController
 */
public class SwingMainMenuController extends SwingMenuController {

    public SwingMainMenuController(SwingMenuModel swingMenuModel, SwingMenuView swingMenuView, SwingMainController swingMainController) {
        super(swingMenuModel, swingMenuView, swingMainController);

        loadAnimeDatas();
        ((SwingMainMenuView) swingMenuView).addContents(((SwingMainMenuModel) swingMenuModel).getAnimeDatasPanels());
        addActionListeners();
        swingMainController.addPanel("MENU", swingMenuView, swingMenuView.getMenuBar());
    }

    public void reload(){
    }

    @Override
    protected void addActionListeners() {
        super.addActionListeners();
        SwingMainMenuView swingMainMenuView = (SwingMainMenuView) this.swingMenuView;

        swingMainMenuView.getAddAnimeItem().addActionListener(e -> {
            swingMainController.switchPanel("ADD");
        });

        for (JButton jButton : swingMainMenuView.getAddButtons()) {
            jButton.addActionListener(e -> {
                swingMainController.switchPanel("LOG");
            });
        }
    }

    private void loadAnimeDatas() {
        for (Map.Entry<String, AnimeData> set : swingMainController.getAnimeDatas().entrySet()) {
            String title = set.getKey();
            float avgScore = set.getValue().getAverageScore();
            int progress = (int) Math.floor((float) set.getValue().getCurrentEpisode() / set.getValue().getTotalEpisodeNumber() * 100);
            JPanel row = ((SwingMainMenuView) swingMenuView).createRow(title, avgScore, progress);
            ((SwingMainMenuModel) swingMenuModel).getAnimeDatasPanels().add(row);
        }
    }
}
