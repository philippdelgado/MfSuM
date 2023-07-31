package com.example.mfsum.ui;

import com.example.mfsum.business.UserDAO;
import com.example.mfsum.util.FxmlUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.mfsum.util.UserUtils.getLoggedInUser;
import static com.example.mfsum.util.UserUtils.loggedInUser;

public class WeeklyAttendancesController implements Initializable {

    @FXML
    private TableView SingularPersonsAttendances;
    @FXML
    private CheckBox vegetarian; //NullCheck programmieren in der UI
    @FXML
    private CheckBox nonVegetarian;
    @FXML
    private CheckBox mondayAttendance;
    @FXML
    private CheckBox tuesdayAttendance;
    @FXML
    private CheckBox wednesdayAttendance;
    @FXML
    private CheckBox thursdayAttendance;
    @FXML
    private CheckBox fridayAttendance;
    @FXML
    private Button save;
    @FXML
    private Stage primaryStage;
    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private UserDAO userDAO;

    public WeeklyAttendancesController(){
        userDAO = new UserDAO();
    }

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        save.setOnAction(actionEvent -> {
            try{
                editUser();
                loadTableOfParticipants();
            }catch(SQLException | IOException exc) {
                log.log(Level.WARNING, exc.getMessage(), exc);
            }
        });

    }
    public void loadTableOfParticipants()throws IOException {
        FxmlUtils.openNewStage(primaryStage,"/fxml/TableOfParticipants.fxml");
    }
    public void editUser() throws SQLException, IOException{
        getLoggedInUser();
        if(vegetarian.isSelected()){
            loggedInUser.setVegetarian(true);
        }
        if(nonVegetarian.isSelected()){
            loggedInUser.setNon_vegetarian(true);
        }
        if(mondayAttendance.isSelected()){
            loggedInUser.setMonday_attendance(true);
        }
        if(tuesdayAttendance.isSelected()){
            loggedInUser.setTuesday_attendance(true);
        }
        if(wednesdayAttendance.isSelected()){
            loggedInUser.setWednesday_attendance(true);
        }
        if(thursdayAttendance.isSelected()){
            loggedInUser.setThursday_attendance(true);
        }
        if(fridayAttendance.isSelected()){
            loggedInUser.setFriday_attendance(true);
        }

        userDAO.updateUser();
    }

}
