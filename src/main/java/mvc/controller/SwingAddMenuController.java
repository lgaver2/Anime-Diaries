package mvc.controller;

import mvc.model.SwingMenuModel;
import mvc.view.SwingAddMenuView;
import mvc.view.SwingMenuView;
import repository.AnimeData;
import repository.DataLoader;

public class SwingAddMenuController extends SwingMenuController {
    public SwingAddMenuController(SwingMenuModel swingMenuModel, SwingMenuView swingMenuView, SwingMainController swingMainController) {
        super(swingMenuModel, swingMenuView, swingMainController);

        swingMainController.addPanel("ADD", swingMenuView, swingMenuView.getMenuBar());
        addActionListeners();
    }

    @Override
    protected void addActionListeners() {
        super.addActionListeners();

        SwingAddMenuView swingAddMenuView = (SwingAddMenuView) swingMenuView;

        swingAddMenuView.getAddButton().addActionListener(e -> {
            addAnimeAction();
        });
    }

    private void addAnimeAction(){
        SwingAddMenuView swingAddMenuView = (SwingAddMenuView) swingMenuView;
        String title = swingAddMenuView.getTitle();
        //! add test here
        int totalEpisodes = Integer.parseInt(swingAddMenuView.getEpisodes());

        AnimeData newAnime = new AnimeData(title, 0, totalEpisodes, 1, null);
        swingMainController.getDataLoader().save(newAnime);
        swingMainController.switchPanel("MENU");
    }
}
