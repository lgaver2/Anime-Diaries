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

/**
 * implementation of the data loader to store/load in json format
 * use Jakson package
 */
public class JsonDataLoader implements DataLoader{
    // the path prefix (data/)
    private final String pathPrefix;
    // the path suffix or file suffix (-diary.json)
    private final String pathSuffix;

    public JsonDataLoader(String filePath) {

        pathPrefix = filePath;
        pathSuffix = "-diary.json";
    }

    @Override
    public AnimeData load(String title) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        AnimeData loadedData;
        try {
            File file = new File(pathPrefix+title+"-diary.json");
            loadedData = mapper.readValue(file, AnimeData.class);

            return loadedData;

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    @Override
    public HashMap<String, AnimeData> loadAllDatas() throws IOException{

        HashMap<String, AnimeData> animeDatas = new HashMap<>();
        // remove the / because not compatible with the next loop
        Path dir = Paths.get(StringUtils.removeEnd(pathPrefix, "/"));

        // loop on .json files
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.json")) {
            for (Path p : stream) {
                // get the file name and remove parts which are unuseful as datas/ and -diary.json
                // to get the original anime title
                String animeTitle = p.toString();
                animeTitle = StringUtils.removeStart(animeTitle, pathPrefix);
                animeTitle = StringUtils.removeEnd(animeTitle, pathSuffix);

                // laod the single anime data
                AnimeData animeData = load(animeTitle);
                animeDatas.put(animeTitle, animeData);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
            return animeDatas;
    }

    @Override
    public void save(AnimeData animeData) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(pathPrefix+animeData.getTitle()+"-diary.json");

            mapper.writeValue(file, animeData);
            String jsonString = mapper.writeValueAsString(animeData);

        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }
}
