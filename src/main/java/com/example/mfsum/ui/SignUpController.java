package com.example.mfsum.ui;

import com.example.mfsum.business.User;
import com.example.mfsum.business.UserDAO;
import com.example.mfsum.util.FxmlUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class SignUpController implements Initializable {
    @FXML
    private Button save;
    @FXML
    private Stage primaryStage;
    @FXML
    private Button cancel;
    @FXML
    private TextField name;
    @FXML
    private TextField eMail;
    @FXML
    private TextField password;
    @FXML
    private Label loginMessageLabel;
    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private UserDAO userDAO;

    public SignUpController() { userDAO = new UserDAO(); }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        save.setOnAction(actionEvent -> {

                try {
                    addUser();
                    loadWeeklyAttendances();
                } catch (SQLException | IOException exc) {
                    loginMessageLabel.setText("Korrekte Eingabe, Fehler der Anwendung");
                    log.log(Level.WARNING, exc.getMessage(), exc);
                }

        });
        cancel.setOnAction(ActionEvent -> { //Commit vor Merge wiederherstellen
            eMail.setText("");
            password.setText("");

        });

    }
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    //public void loadWeeklyAttendances() throws IOException {
      //  FxmlUtils.openNewStage(primaryStage, "/fxml/StartScreen.fxml");
    //}
    public void loadWeeklyAttendances() throws IOException {
        FxmlUtils.openNewStage(primaryStage, "/fxml/WeeklyAttendances.fxml");
    }

    public void addUser() throws SQLException, IOException {
        User user = new User();
        user.setName(this.name.getText());
        user.setE_mail(this.eMail.getText());
        user.setPassword(this.password.getText());

        userDAO.insertUser(user);
    }



}
