// SPDX-License-Identifier: MIT

import mvc.controller.SwingMainController;
import mvc.model.SwingMainModel;
import repository.AnimeCommentData;
import repository.AnimeData;
import repository.DataLoader;
import repository.JsonDataLoader;
import mvc.view.SwingMainView;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        JsonDataLoader jsonDataLoader = new JsonDataLoader("data/");
        SwingMainModel swingMainModel = new SwingMainModel(jsonDataLoader);
        SwingMainView swingMainView = new SwingMainView();
        SwingMainController swingMainController = new SwingMainController(swingMainModel, swingMainView);

        swingMainController.display();
        AnimeData a = new AnimeData("a", 1,1,1,null);
        jsonDataLoader.save(a);
    }
}

