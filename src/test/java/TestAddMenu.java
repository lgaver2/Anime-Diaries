import com.fasterxml.jackson.annotation.JsonTypeInfo;
import mvc.controller.SwingMainController;
import mvc.controller.UncompleteFieldException;
import mvc.model.SwingMainModel;
import mvc.view.SwingMainView;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import repository.AnimeData;
import repository.JsonDataLoader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestAddMenu {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void testAddingAnime() {
        Path path = temporaryFolder.getRoot().toPath();
        JsonDataLoader jsonDataLoader = new JsonDataLoader(path + "/");
        SwingMainModel swingMainModel = new SwingMainModel(jsonDataLoader);
        SwingMainView swingMainView = new SwingMainView();
        SwingMainController swingMainController = new SwingMainController(swingMainModel, swingMainView);

        // changeing to add screen
        swingMainController.switchMenu("ADD");
        // should not fail to add normal anime
        try {
            swingMainController.getSwingAddMenuController().addAnime("Death note", 37);
        } catch (NumberFormatException | UncompleteFieldException e) {
            Assert.fail("failed to store data");
        }

        // test if the datas are correct
        try {
            AnimeData animeData = jsonDataLoader.load("Death note");
            Assert.assertEquals("Death note", animeData.getTitle());
            Assert.assertEquals(37, animeData.getTotalEpisodeNumber());
            Assert.assertEquals(1, animeData.getCurrentEpisode());
            Assert.assertNull(animeData.getComments());
        } catch (IOException e) {
            Assert.fail("failed to load data");
        }
    }

    @Test
    public void testWrongInput() {
        Path path = temporaryFolder.getRoot().toPath();
        JsonDataLoader jsonDataLoader = new JsonDataLoader(path + "/");
        SwingMainModel swingMainModel = new SwingMainModel(jsonDataLoader);
        SwingMainView swingMainView = new SwingMainView();
        SwingMainController swingMainController = new SwingMainController(swingMainModel, swingMainView);

        // changeing to add screen
        swingMainController.switchMenu("ADD");


        // try to add anime with empty title
        try {
            swingMainController.getSwingAddMenuController().addAnime("", 15);
            Assert.fail();
        } catch (UncompleteFieldException e) {
            System.out.println("Catch wrong input");
        }

        // try to add anime with wrong episode number
        try {
            swingMainController.getSwingAddMenuController().addAnime("o", -1);
            Assert.fail();
        } catch (UncompleteFieldException e) {
            Assert.fail();
        }
        catch (NumberFormatException e) {
            System.out.println("Catch wrong input");
        }
    }
}
