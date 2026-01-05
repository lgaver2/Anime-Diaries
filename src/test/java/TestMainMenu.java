import mvc.controller.SwingMainController;
import mvc.model.SwingMainModel;
import mvc.view.SwingMainView;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import repository.JsonDataLoader;

public class TestMainMenu {
        @Rule
        public TemporaryFolder temporaryFolder = new TemporaryFolder();

        // test if 0 division error is handled
        @Test
        public void testAddingComment() {
            JsonDataLoader jsonDataLoader = new JsonDataLoader(temporaryFolder.getRoot().toPath()+ "/");
            SwingMainModel swingMainModel = new SwingMainModel(jsonDataLoader);
            SwingMainView swingMainView = new SwingMainView();
            SwingMainController swingMainController = new SwingMainController(swingMainModel, swingMainView);

            // prepare the anime because load by log screen on menu change
            swingMainController.storeAnimeData("Dragon Ball GT", 0, 0, 1, null);
            swingMainController.setCurrentAnime("Dragon Ball GT");
            // changeing to main screen
            swingMainController.switchMenu("MAIN");

        }
}
