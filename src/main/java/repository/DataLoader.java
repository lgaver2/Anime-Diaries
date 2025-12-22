package repository;

import java.io.IOException;
import java.util.HashMap;

public interface DataLoader {
    public AnimeData load(String title) throws IOException;
    public void save(AnimeData animeData) throws IOException;

    public HashMap<String, AnimeData> loadAllDatas() throws IOException;
}
