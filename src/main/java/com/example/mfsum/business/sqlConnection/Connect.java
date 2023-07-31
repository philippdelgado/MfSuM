package com.example.mfsum.business.sqlConnection;
import com.example.mfsum.ui.SignInController;
import com.example.mfsum.ui.SignUpController;
import com.example.mfsum.util.FxmlUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.*;
import java.util.Objects;

import static com.example.mfsum.business.sqlConnection.Configuration.*;
public class Connect extends Application{

    public static void main(String[] args) throws ClassNotFoundException {
        // Open a connection
        launch(args);
    }

    public static Connection connection() throws SQLException {
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException exc) {
            throw new RuntimeException("Error connecting to the database", exc);
        }

    }

    //final Employee<Long> simpleReference = Connect::connVar;

    public void start(Stage stage) throws Exception {

        FxmlUtils.setStage(stage);

        URL resource = Connect.class.getResource("/fxml/SignIn.fxml");

        // FX StartsS
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(resource));
        Parent root = fxmlLoader.load();

        SignInController controller = fxmlLoader.getController();
        controller.setPrimaryStage(stage);
        Scene scene = new Scene(root);
        //stage.getIcons().add(new Image("/images/socialab.png"));
        stage.setTitle("Erfassung der Kantinenanwesenheiten");
        stage.setScene(scene);
        stage.show();
    }
}
