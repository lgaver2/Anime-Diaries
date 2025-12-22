package mvc.controller;

import mvc.model.SwingLogMenuModel;
import mvc.view.SwingLogMenuView;
import repository.AnimeCommentData;
import repository.AnimeData;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;

/**
 * SwingLogMenuController
 * class which control the screen where user put comment and score of the current episode
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

        swingLogMenuView.getReturnItem().addActionListener(e -> {
            this.swingMainController.switchMenu("MENU");
        });
    }

    @Override
    protected void onMenuChange() {
        SwingLogMenuModel swingLogMenuModel = (SwingLogMenuModel) swingMenuModel;
        SwingLogMenuView swingLogMenuView = (SwingLogMenuView) swingMenuView;

        try {
            //erase previous input fields
            swingLogMenuView.eraseInputs();

            // when change menu get the anime title wich the user clicked (stored by mainMenuController)
            String title = swingMainController.getCurrentAnime();
            // store the title in the model
            swingLogMenuModel.setTitle(title);
            // get the datas from the json file
            swingLogMenuModel.setLoadedData(swingMainController.getDataLoader().load(title));

            int currentEpisode = swingLogMenuModel.getLoadedData().getCurrentEpisode();
            // set title + the current episode on the topbar of the screen
            swingLogMenuView.setTitleLabel(title + " ep:" + currentEpisode);
        } catch (IOException e) {
            swingMainController.showAlert("Failed to load datas.");
        }
    }

    /**
     * Method to store the comment and score of the user
     * show error box if not complete all fields or not an integer less than 5
     */
    private void storeEntry() {
        SwingLogMenuView swingLogMenuView = (SwingLogMenuView) swingMenuView;
        SwingLogMenuModel swingLogMenuModel = (SwingLogMenuModel) swingMenuModel;

        try {
            // get user inputs with a test
            int score = Integer.parseInt(swingLogMenuView.getScore());
            if (score <= 0 || 5 < score)
                throw new NumberFormatException();
            String comment = swingLogMenuView.getComment();

            if (comment.compareTo("") == 0)
                throw new UncompleteFieldException();

            // get the title of the anime wich the user is
            // writing a comment
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

            // add directly to the anime hashset to not load all anime every times
            animeCommentData.put(currentEpisode, new AnimeCommentData(Date.from(Instant.now()), score, comment));


            // save comment and go back to the main menu
            swingMainController.getDataLoader().save(
                    new AnimeData(title, newAvgScore, animeData.getTotalEpisodeNumber(), currentEpisode + 1, animeCommentData)
            );
            swingMainController.switchMenu("MENU");

        } catch (NumberFormatException e) {
            swingMainController.showAlert("Please put an integer wich is in [0,5]");
        } catch (UncompleteFieldException e) {
            swingMainController.showAlert("Please complete comment field");
        } catch (IOException e) {
            swingMainController.showAlert("Failed to save data.");
        }

    }
}
