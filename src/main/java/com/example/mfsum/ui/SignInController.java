package com.example.mfsum.ui;

import com.example.mfsum.business.User;
import com.example.mfsum.business.UserDAO;
import com.example.mfsum.util.FxmlUtils;
import com.example.mfsum.util.UserUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignInController implements Initializable{

    @FXML
    private Stage primaryStage;
    @FXML
    private Button register;

    @FXML
    private Button cancel;
    @FXML
    private Button save;
    @FXML
    private TextField eMail;
    @FXML
    private TextField password;
    @FXML
    private Label loginMessageLabel;
    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private UserDAO userDAO;

    public SignInController(){userDAO = new UserDAO();}


    public void initialize(URL url, ResourceBundle resourceBundle){
        register.setOnAction(actionEvent -> {
            try {
                loadRegistration();
            } catch (IOException exc) {
                log.log(Level.WARNING, exc.getMessage(), exc);
            }
        });
        save.setOnAction(actionEvent -> {
            if(!eMail.getText().isBlank() && !password.getText().isBlank()){
                try {
                     checkLogin();
                } catch (SQLException | IOException nwgrl) {
                    loginMessageLabel.setText("Korrekte Eingabe, Fehler der Anwendung");
                    log.log(Level.WARNING, nwgrl.getMessage(), nwgrl);
                }
            } else {
                loginMessageLabel.setText("Es wurden keine Logindaten eingegeben!");
            }
        });
        cancel.setOnAction(ActionEvent -> { //Commit vor Merge wiederherstellen
            eMail.setText("");
            password.setText("");
        });
    }

    public void loadRegistration() throws IOException {
        FxmlUtils.openNewStage (primaryStage, "/fxml/SignUp.fxml");
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public void checkLogin() throws SQLException, IOException {
        User user = UserDAO.getUserByEmailAndPassword(eMail.getText(), password.getText());
        if (user != null) {
            UserUtils.loginUser(user);
            loadSTSC();
        } else {
            loginMessageLabel.setText("ungültige Logindaten!");
        }
    }
    public void loadSTSC() throws IOException {
        FxmlUtils.openNewStage(primaryStage, "/fxml/WeeklyAttendances.fxml");
    }
}
