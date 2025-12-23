// SPDX-License-Identifier: MIT
package repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * The principle method which this application use for saving, loading datas
 */
public interface DataLoader {
    /**
     * load one anime data from its title
     * @param title the title of this anime
     * @return the data of this anime
     * @throws IOException if the load has failed
     */
    public AnimeData load(String title) throws IOException, FileNotFoundException;

    /**
     * to save one anime data
     * @param animeData
     * @throws IOException if the store has failed
     */
    public void save(AnimeData animeData) throws IOException, FileNotFoundException;

    /**
     * to load all anime datas and create a hashmap of animes indexed by the anime title
     * @return the hashmap of anime which the user is watching
     * @throws IOException if the load has failed
     */
    public HashMap<String, AnimeData> loadAllDatas() throws IOException, FileNotFoundException;
}
