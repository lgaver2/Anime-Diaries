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
        // create the rows
        loadAnimeDatas();
        // add the created rows to the main window
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

    /**
     * Method call when switch form main menu to log menu
     * when user want to add a new comment
     * @param animeTitle the title wich user choose
     */
    private void switchLog(String animeTitle) {
        swingMainController.setCurrentAnime(animeTitle);
        swingMainController.switchMenu("LOG");
    }

    /**
     * Method call when switch from main menu to view menu
     * when user want to see former comments
     * @param animeTitle the title wich user choose
     */
    private void switchView(String animeTitle) {
        swingMainController.setCurrentAnime(animeTitle);
        swingMainController.switchMenu("VIEW");
    }

    /**
     * Method to load and create each rows of anime wich the user is viewing
     */
    private void loadAnimeDatas() {
        int i = 0;
        SwingMainMenuModel swingMainMenuModel = (SwingMainMenuModel) swingMenuModel;
        SwingMainMenuView swingMainMenuView = (SwingMainMenuView) swingMenuView;

        // reset former settings
        swingMainMenuView.resetButtons();
        swingMainMenuModel.removeAllList();


        // create rows for each anime
        for (Map.Entry<String, AnimeData> set : swingMainController.getAnimeDatas().entrySet()) {
            // get datas
            String title = set.getKey();
            System.out.println(title);
            float avgScore = set.getValue().getAverageScore();
            int progress = (int) Math.floor((float) set.getValue().getCurrentEpisode() / set.getValue().getTotalEpisodeNumber() * 100);

            // create the row and store to the model to use in the second part of onMenuChange
            JPanel row = swingMainMenuView.createRow(title, avgScore, progress);
            swingMainMenuModel.getAnimeDatasPanels().add(row);

            // set actions to buttons
            swingMainMenuView.getAddButtons()
                    .get(i)
                    .addActionListener(e -> {
                        switchLog(title);
                    });
            swingMainMenuView.getViewButtons()
                    .get(i)
                    .addActionListener(e -> {
                        switchView(title);
                    });
            i++;
        }
    }
}
