package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class JsonDataLoader implements DataLoader{
    private String pathPrefix;
    private String pathSuffix;

    public JsonDataLoader(String filePath) {

        pathPrefix = filePath;
        pathSuffix = "-diary.json";
    }

    @Override
    public AnimeData load(String title) {
        ObjectMapper mapper = new ObjectMapper();
        AnimeData loadedData;
        try {
            // 3. Define the file path (saves to the project root folder)
            File file = new File(pathPrefix+title+"-diary.json");
            loadedData = mapper.readValue(file, AnimeData.class);

            return loadedData;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap<String, AnimeData> loadAllDatas() {

        HashMap<String, AnimeData> animeDatas = new HashMap<>();
        Path dir = Paths.get(StringUtils.removeEnd(pathPrefix, "/"));

        // loop on .json files
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.json")) {
            for (Path p : stream) {
                String animeTitle = p.toString();
                animeTitle = StringUtils.removeStart(animeTitle, pathPrefix);
                animeTitle = StringUtils.removeEnd(animeTitle, pathSuffix);
                AnimeData animeData = load(animeTitle);
                animeDatas.put(animeTitle, animeData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            return animeDatas;
    }

    @Override
    public void save(AnimeData animeData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(pathPrefix+animeData.getTitle()+"-diary.json");

            mapper.writeValue(file, animeData);

            System.out.println("Success! Saved to " + file.getAbsolutePath());

            String jsonString = mapper.writeValueAsString(animeData);
            System.out.println("JSON Output: " + jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
