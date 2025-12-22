package mvc.controller;

import mvc.model.SwingMenuModel;
import mvc.view.SwingAddMenuView;
import mvc.view.SwingMenuView;
import repository.AnimeData;

import javax.swing.*;

/**
 * SwingAddMenuController
 * class wich control the screen to add new anime in the watch list
 */
public class SwingAddMenuController extends SwingMenuController {
    public SwingAddMenuController(SwingMenuModel swingMenuModel, SwingMenuView swingMenuView, SwingMainController swingMainController) {
        super(swingMenuModel, swingMenuView, swingMainController);

        swingMainController.addMenu("ADD", this, swingMenuView, swingMenuView.getMenuBar());
        addActionListeners();
    }

    @Override
    protected void addActionListeners() {
        super.addActionListeners();

        SwingAddMenuView swingAddMenuView = (SwingAddMenuView) swingMenuView;

        swingAddMenuView.getAddButton().addActionListener(e -> {
            addAnimeAction();
        });

        swingAddMenuView.getCommitItem().addActionListener(e -> {
            addAnimeAction();
        });

        swingAddMenuView.getCancelItem().addActionListener(e -> {
            swingMainController.switchMenu("MENU");
        });
    }

    @Override
    protected void onMenuChange() {
        // erase former inputs
        ((SwingAddMenuView) swingMenuView).eraseInputs();
    }

    /**
     * Method use to add an anime in the list of the watching animes
     * the anime will be saved in the MainController
     * if all fields are not complete or not an integer show error box
     */
    private void addAnimeAction() {
        try {
            SwingAddMenuView swingAddMenuView = (SwingAddMenuView) swingMenuView;
            String title = swingAddMenuView.getTitle();
            int totalEpisodes = Integer.parseInt(swingAddMenuView.getEpisodes());
            // number of episodes cannot be negative
            if (totalEpisodes <= 0)
                throw new NumberFormatException();
            // if not all fields are completed
            if (title.compareTo("") == 0)
                throw new UncompleteFieldException();
            swingMainController.addAnimeData(title, totalEpisodes);
            swingMainController.switchMenu("MENU");
        } catch (NumberFormatException e) {
            swingMainController.showAlert("Please put an non-negative integer");
        } catch (UncompleteFieldException e){
            swingMainController.showAlert("Please complete all fields");
        }
    }
}

