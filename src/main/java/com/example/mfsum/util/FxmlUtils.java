package com.example.mfsum.util;

import com.example.mfsum.ui.base.NeedsStage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
public final class FxmlUtils {

    private FxmlUtils() {
        throw new UnsupportedOperationException();
    }

    public static void openNewStage(Stage parent, String fxml) throws IOException {
        Stage stage = new Stage();
        openInStage(stage, fxml);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parent);

        stage.showAndWait();
    }

    public static void openInStage(Stage stage, String fxml) throws IOException {
        FXMLLoader fxmlLoader = initFxmlLoader(fxml);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Object controller = fxmlLoader.getController();
        if(controller instanceof NeedsStage) {
            NeedsStage needsStage = (NeedsStage) controller;
            needsStage.setStage(stage);
        }

        stage.setScene(scene);
    }

    public static FXMLLoader initFxmlLoader(String fxml) {
        URL resource = FxmlUtils.class.getResource(fxml);
        return new FXMLLoader(Objects.requireNonNull(resource));
    }

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        FxmlUtils.stage = stage;
    }


}
