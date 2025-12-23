// SPDX-License-Identifier: MIT
package mvc.model;

import repository.AnimeCommentData;

import java.util.HashMap;

public class SwingViewMenuModel extends SwingMenuModel{
    private HashMap<Integer, AnimeCommentData> animeCommentData;

    public HashMap<Integer, AnimeCommentData> getAnimeCommentData() {
        return animeCommentData;
    }

    public void setAnimeCommentData(HashMap<Integer, AnimeCommentData> animeCommentData) {
        this.animeCommentData = animeCommentData;
    }
}
