// SPDX-License-Identifier: MIT

package mvc.controller;

import mvc.model.SwingLogMenuModel;
import mvc.view.SwingLogMenuView;
import repository.AnimeCommentData;
import repository.AnimeData;

import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;

/**
 * SwingLogMenuController
 */
public class SwingLogMenuController extends SwingMenuController {
    public SwingLogMenuController(SwingLogMenuModel swingLogMenuModel, SwingLogMenuView swingLogMenuView, SwingMainController swingMainController) {
        super(swingLogMenuModel, swingLogMenuView, swingMainController);

        swingMainController.addMenu("LOG", this, swingMenuView, swingMenuView.getMenuBar());
        addActionListeners();
    }

    @Override
    protected void addActionListeners() {
        super.addActionListeners();

        SwingLogMenuView swingLogMenuView = (SwingLogMenuView) swingMenuView;
        swingLogMenuView.getCommitItem().addActionListener(e -> {
            storeEntry();
        });

        swingLogMenuView.getCommitButton().addActionListener(e -> {
            storeEntry();
        });

        swingLogMenuView.getCancelItem().addActionListener(e -> {
            this.swingMainController.switchMenu("MENU");
        });
    }

    @Override
    protected void onMenuChange() {
        SwingLogMenuModel swingLogMenuModel = (SwingLogMenuModel) swingMenuModel;
        SwingLogMenuView swingLogMenuView = (SwingLogMenuView) swingMenuView;

        String title = swingMainController.getCurrentAnime();
        ((SwingLogMenuModel) swingMenuModel).setTitle(title);
        swingLogMenuModel.setLoadedData(swingMainController.getDataLoader().load(title));

        int currentEpisode = swingLogMenuModel.getLoadedData().getCurrentEpisode();
        swingLogMenuView.setTitleLabel(title + " ep:" + currentEpisode);
    }

    private void storeEntry() {
        SwingLogMenuView swingLogMenuView = (SwingLogMenuView) swingMenuView;
        SwingLogMenuModel swingLogMenuModel = (SwingLogMenuModel) swingMenuModel;

        // get datas
        int score = Integer.parseInt(swingLogMenuView.getScore());
        //! add test here
        String comment = swingLogMenuView.getComment();

        String title = swingLogMenuModel.getTitle();
        AnimeData animeData = swingLogMenuModel.getLoadedData();

        // add a new entry for comment if it is the first comment
        HashMap<Integer, AnimeCommentData> animeCommentData;
        float newAvgScore;
        if (animeData.getComments() == null) {
            animeCommentData = new HashMap<>();
            newAvgScore = score;
        } else {
            animeCommentData = animeData.getComments();
            newAvgScore = score + animeData.getAverageScore() / 2;
        }

        int currentEpisode = animeData.getCurrentEpisode();
        animeCommentData.put(currentEpisode, new AnimeCommentData(Date.from(Instant.now()), score, comment));



        // save comment and go back to the main menu
        swingMainController.getDataLoader().save(
                new AnimeData(title, newAvgScore, animeData.getTotalEpisodeNumber(), currentEpisode + 1, animeCommentData)
        );
        swingMainController.switchMenu("MENU");

        //erase input fields
        swingLogMenuView.eraseInputs();
    }
}
