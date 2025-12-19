package repository;

import java.util.HashMap;

public interface DataLoader {
    public AnimeData load(String title);
    public void save(AnimeData animeData);

    public HashMap<String, AnimeData> loadAllDatas();
}
