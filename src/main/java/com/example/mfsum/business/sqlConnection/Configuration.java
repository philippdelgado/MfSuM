package com.example.mfsum.business.sqlConnection;

public class Configuration {

    public static final String DB_URL = "jdbc:sqlserver://10.111.190.213:1433;database=tsociallab_phde";
    public static final String USER = "sa";
    public static final String PASS = "FCBayern2017!";

    public static final String USER_ID = "user_id";
    public static final String NAME = "name";
    public static final String E_MAIL = "e_mail";
    public static final String PASSWORD = "password";
    public static final Boolean MONDAYATTENDANCE = Boolean.valueOf("monday_attandance");
    public static final Boolean TUESDAYATTENDANCE = Boolean.valueOf("tuesday_attandance");
    public static final Boolean WEDNESDAYATTENDANCE = Boolean.valueOf("wednesday_attandance");
    public static final Boolean THURSDAYATTENDANCE = Boolean.valueOf("thursday_attandance");
    public static final Boolean FRIDAYATTENDANCE = Boolean.valueOf("friday_attandance");
    public static final Boolean VEGETARIAN = Boolean.valueOf("vegetarian");
    public static final Boolean NONVEGETARIAN = Boolean.valueOf("non_vegetarian");

}
