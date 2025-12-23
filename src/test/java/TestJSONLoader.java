// SPDX-License-Identifier: MIT
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import repository.AnimeData;
import repository.JsonDataLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class TestJSONLoader {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    // test store and load and check if the datas are equals
    @Test
    public void testLoader() {
        Path path = temporaryFolder.getRoot().toPath();
        JsonDataLoader dataLoader = new JsonDataLoader(path.toString()+"/");

        AnimeData animeData = new AnimeData("title", 2.5f, 30, 20, null);

        try {
            dataLoader.save(animeData);
            HashMap<String, AnimeData> loadedData = dataLoader.loadAllDatas();

            // test if the title is in data
            Assert.assertTrue(loadedData.containsKey("title"));

            // test if the loaded data are correct
            AnimeData loadedAnimeData = loadedData.get("title");
            Assert.assertEquals(animeData.getTitle(), loadedAnimeData.getTitle());
            Assert.assertEquals(animeData.getCurrentEpisode(), loadedAnimeData.getCurrentEpisode());
            Assert.assertEquals(animeData.getTotalEpisodeNumber(), loadedAnimeData.getTotalEpisodeNumber());
        }catch (IOException e) {
            Assert.fail("fail to load or save data. Do you create testData directory?");
        }
    }
}
