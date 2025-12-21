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


        addActionListeners();
        swingMainController.addMenu("MENU", this, swingMenuView, swingMenuView.getMenuBar());
    }

    @Override
    protected void onMenuChange() {
        loadAnimeDatas();
        ((SwingMainMenuView) swingMenuView).addContents(((SwingMainMenuModel) swingMenuModel).getAnimeDatasPanels());
    }

    @Override
    protected void addActionListeners() {
        super.addActionListeners();
        SwingMainMenuView swingMainMenuView = (SwingMainMenuView) this.swingMenuView;

        swingMainMenuView.getAddAnimeItem().addActionListener(e -> {
            swingMainController.switchMenu("ADD");
        });
    }

    private void switchLog(String animeTitle) {
        swingMainController.setCurrentAnime(animeTitle);
        swingMainController.switchMenu("LOG");
    }

    private void switchView(String animeTitle) {
        swingMainController.setCurrentAnime(animeTitle);
        swingMainController.switchMenu("VIEW");
    }

    private void loadAnimeDatas() {
        int i = 0;
        ((SwingMainMenuModel) swingMenuModel).removeAllList();
        for (Map.Entry<String, AnimeData> set : swingMainController.getAnimeDatas().entrySet()) {
            String title = set.getKey();
            System.out.println(title);
            float avgScore = set.getValue().getAverageScore();
            int progress = (int) Math.floor((float) set.getValue().getCurrentEpisode() / set.getValue().getTotalEpisodeNumber() * 100);
            JPanel row = ((SwingMainMenuView) swingMenuView).createRow(title, avgScore, progress);
            ((SwingMainMenuModel) swingMenuModel).getAnimeDatasPanels().add(row);
            ((SwingMainMenuModel) swingMenuModel).getAnimeTitles().add(title);

            // set actions to buttons
            ((SwingMainMenuView) swingMenuView).getAddButtons()
                    .get(i)
                    .addActionListener(e -> {
                        switchLog(title);
                    });
             ((SwingMainMenuView) swingMenuView).getViewButtons()
                    .get(i)
                    .addActionListener(e -> {
                        switchView(title);
                    });
             i++;
        }
    }
}
