package com.example.mfsum.business;
import com.example.mfsum.business.sqlConnection.Configuration;
import com.example.mfsum.business.sqlConnection.Connect;
import com.example.mfsum.business.User;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.mfsum.util.UserUtils;

import static com.example.mfsum.util.UserUtils.loggedInUser;

public class UserDAO {
    private static final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private Configuration configuration;

    public UserDAO() {
        configuration = new Configuration();
    }

    public static User extractUserFromResultSet(ResultSet us) throws SQLException {
        User user = new User();

        user.setUser_id(us.getInt(Configuration.USER_ID));
        user.setName(us.getString(Configuration.NAME));
        user.setE_mail(us.getString(Configuration.E_MAIL));
        user.setPassword(us.getString(Configuration.PASSWORD));


        return user;
    }

    public static User getUserByEmailAndPassword(String e_mail, String password) throws SQLException {
        Connection connection = Connect.connection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM User_consumer WHERE e_mail =? AND password=?"); //SELECT employee_id FROM Employee WHERE e_mail = ? AND password = ?                 INSERT INTO EVENT(planner_id) Values (employee_id)
            ps.setString(1, e_mail);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            //$conn = mssql_connect(DB_URL, USER, PASS);
            //$result = connection(ps);
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException exc) {
            log.log(Level.WARNING, exc.getMessage(), exc);
        }
        connection.close();
        return null;
    }

    public boolean insertUser(User user) throws SQLException {
        Connection connection = Connect.connection();
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO User_consumer(name, e_mail," +
                    "password)"
                    + "Values (?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getE_mail());
            ps.setString(3, user.getPassword());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException exc){
            log.log(Level.WARNING, exc.getMessage(), exc);
        }
        connection.close();
        return false;
    }

    public boolean updateUser() throws SQLException {
        Connection connection = Connect.connection();
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE User_consumer SET vegetarian=?, " +
                    "non_vegetarian =?," +
                    "monday_attendance=?," +
                    " tuesday_attendance=?, wednesday_attendance=?,thursday_attendance=?,friday_attendance=?" +
                    " where user_id =?");
            ps.setBoolean(1, loggedInUser.getVegetarian());
            ps.setBoolean(2, loggedInUser.getNon_vegetarian());
            ps.setBoolean(3, loggedInUser.getMonday_attendance());
            ps.setBoolean(4, loggedInUser.getTuesday_attendance());
            ps.setBoolean(5, loggedInUser.getWednesday_attendance());
            ps.setBoolean(6, loggedInUser.getThursday_attendance());
            ps.setBoolean(7, loggedInUser.getFriday_attendance());
            ps.setInt(8, loggedInUser.getUser_id());

            int i = ps.executeUpdate();

            if (i == 1){
                return true;
            }
        }catch (SQLException exc){
            log.log(Level.WARNING, exc.getMessage(), exc);
        }
        connection.close();
        return false;
    }

}
