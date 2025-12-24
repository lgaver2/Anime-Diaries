// SPDX-License-Identifier: MIT
package mvc.model;

import repository.AnimeData;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * SwingLogMenuModel
 */
public class SwingLogMenuModel extends SwingMenuModel{
    private String title;
    private AnimeData loadedData;

    // some suggestion to write a comment
    private final List<String> commentHelper = Arrays.asList(
            "Develop a comment about one character",
            "Write a comment about the animation",
            "Write a comment about your current emotion"
    );

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public AnimeData getLoadedData() {
        return loadedData;
    }

    public void setLoadedData(AnimeData loadedData) {
        this.loadedData = loadedData;
    }

    /**
     * @return a random suggestion in the list of commentHelper
     */
    public String getCommentHelper() {
        return commentHelper.get(new Random().nextInt(commentHelper.size()));
    }
}
