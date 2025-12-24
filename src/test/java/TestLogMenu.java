import com.fasterxml.jackson.annotation.JsonTypeInfo;
import mvc.controller.SwingMainController;
import mvc.controller.UncompleteFieldException;
import mvc.model.SwingMainModel;
import mvc.view.SwingMainView;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import repository.AnimeCommentData;
import repository.AnimeData;
import repository.JsonDataLoader;

import java.io.IOException;
import java.util.HashMap;

public class TestLogMenu {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    // test if adding comment work correctly
    @Test
    public void testAddingComment() {
        JsonDataLoader jsonDataLoader = new JsonDataLoader(temporaryFolder.getRoot().toPath()+ "/");
        SwingMainModel swingMainModel = new SwingMainModel(jsonDataLoader);
        SwingMainView swingMainView = new SwingMainView();
        SwingMainController swingMainController = new SwingMainController(swingMainModel, swingMainView);

        // prepare the anime because load by log screen on menu change
        swingMainController.storeAnimeData("Dragon Ball GT", 0, 64, 1, null);
        swingMainController.setCurrentAnime("Dragon Ball GT");
        // changeing to add screen
        swingMainController.switchMenu("LOG");


        // try to add the first comment
        String comment = "not the dragon ball i seen";
        int score = 3;
        try {
            swingMainController.getSwingLogMenuController().addComment(score, comment);
        } catch (UncompleteFieldException e) {
            Assert.fail("fail because uncompleted fields");
        }

        // test if the stored values are corrects

        try {
            AnimeData dbGT = swingMainModel.getDataLoader().load("Dragon Ball GT");

            // test if the current episode has been updated
            Assert.assertEquals(2, dbGT.getCurrentEpisode());

            // get the comment we put before
            AnimeCommentData commentData = dbGT.getComments().get(1);

            Assert.assertEquals(comment, commentData.getComment());
            Assert.assertEquals(score, commentData.getScore());
        } catch (IOException e) {
            Assert.fail("Failed to load the anime");
        }

        swingMainController.setCurrentAnime("Dragon Ball GT");
        // changeing to add screen
        swingMainController.switchMenu("LOG");
        // add another comment as not same function when add the second comment
        comment = "worse...";
        score = 1;
        try {
            swingMainController.getSwingLogMenuController().addComment(score, comment);
        } catch (UncompleteFieldException e) {
            Assert.fail("fail because uncomplete fields");
        }

        // test if the stored values are corrects

        try {
            AnimeData dbGT = swingMainModel.getDataLoader().load("Dragon Ball GT");

            // test if the current episode has been updated
            Assert.assertEquals(3, dbGT.getCurrentEpisode());

            // get the comment we put before
            AnimeCommentData commentData = dbGT.getComments().get(2);

            Assert.assertEquals(comment, commentData.getComment());
            Assert.assertEquals(score, commentData.getScore());
        } catch (IOException e) {
            Assert.fail("Failed to load the anime");
        }
    }

    // test wrong input as empty comment and wrong score
    @Test
    public void testWrongInput() {
        JsonDataLoader jsonDataLoader = new JsonDataLoader(temporaryFolder.getRoot().toPath() + "/");
        SwingMainModel swingMainModel = new SwingMainModel(jsonDataLoader);
        SwingMainView swingMainView = new SwingMainView();
        SwingMainController swingMainController = new SwingMainController(swingMainModel, swingMainView);

        // prepare the data
        swingMainController.storeAnimeData("Dragon Ball GT", 0, 64, 1, null);
        swingMainController.setCurrentAnime("Dragon Ball GT");
        swingMainController.switchMenu("LOG");


        // try to add anime with empty title
        try {
            swingMainController.getSwingLogMenuController().addComment(1, "");
            Assert.fail();
        } catch (UncompleteFieldException e) {
            System.out.println("Catch wrong input");
        }

        // try to add anime with wrong episode number
        try {
            swingMainController.getSwingLogMenuController().addComment(11, "oh no");
            Assert.fail();
        } catch (UncompleteFieldException e) {
            Assert.fail();
        }
        catch (NumberFormatException e) {
            System.out.println("Catch wrong input");
        }

    }
}
