package mvc.controller;

import mvc.model.SwingMenuModel;
import mvc.view.SwingAddMenuView;
import mvc.view.SwingMenuView;
import repository.AnimeData;

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

    private void addAnimeAction(){
        SwingAddMenuView swingAddMenuView = (SwingAddMenuView) swingMenuView;
        String title = swingAddMenuView.getTitle();
        //! add test here
        int totalEpisodes = Integer.parseInt(swingAddMenuView.getEpisodes());

        swingMainController.addAnimeData(title, totalEpisodes);
        swingMainController.switchMenu("MENU");
    }
}
