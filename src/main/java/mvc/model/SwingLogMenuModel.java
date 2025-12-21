// SPDX-License-Identifier: MIT

package mvc.model;

import repository.AnimeData;

/**
 * SwingLogMenuModel
 */
public class SwingLogMenuModel extends SwingMenuModel{
    private String title;
    private AnimeData loadedData;

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
}
