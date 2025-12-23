package mvc.controller;

import mvc.model.SwingMenuModel;
import mvc.model.SwingViewMenuModel;
import mvc.view.SwingMenuView;
import mvc.view.SwingViewMenuView;

/**
 * SwingViewMenuController
 * Controller for the view screen, the screen where the user can see his former inputs
 */
public class SwingViewMenuController extends SwingMenuController {

    public SwingViewMenuController(SwingMenuModel swingViewMenuModel, SwingMenuView swingViewMenuView, SwingMainController swingMainController) {
        super(swingViewMenuModel, swingViewMenuView, swingMainController);

        swingMainController.addMenu("VIEW", this, swingViewMenuView, swingViewMenuView.getMenuBar());
        addActionListeners();
    }

    @Override
    protected void addActionListeners() {
        super.addActionListeners();

        SwingViewMenuView swingViewMenuView = (SwingViewMenuView) swingMenuView;
        swingViewMenuView.getReturnItem().addActionListener(e -> {
            swingMainController.switchMenu("MENU");
        });
    }

    @Override
    protected void onMenuChange() {
        // load comments of the anime
        loadCommentDatas();
        // put on screen the loaded comments
        addContent();
    }

    /**
     * Method to put on screen the loaded comment by loadCommentDatas
     */
    private void addContent() {
        SwingViewMenuView swingViewMenuView = (SwingViewMenuView) swingMenuView;
        SwingViewMenuModel swingViewMenuModel = (SwingViewMenuModel) swingMenuModel;

        // remove the previous content
        swingViewMenuView.removeContent();

        // if the anime does not have any comment do nothing
        if (swingViewMenuModel.getAnimeCommentData() != null)
            swingViewMenuView.addContents(swingViewMenuModel.getAnimeCommentData());
    }

    /**
     * Method to set the comment of the anime which the user has chosen
     */
    private void loadCommentDatas() {
        SwingViewMenuModel swingViewMenuModel = (SwingViewMenuModel) swingMenuModel;
        // load comment datas of the current anime
        swingViewMenuModel.setAnimeCommentData(swingMainController.getAnimeDatas().get(swingMainController
                .getCurrentAnime()).getComments());

    }
}
