package com.example.mfsum.business;

public class User {
    private int user_id;
    private String name;
    private String e_mail;
    private String password;
    private Boolean vegetarian;
    private Boolean non_vegetarian;
    private Boolean monday_attendance;
    private Boolean tuesday_attendance;
    private Boolean wednesday_attendance;
    private Boolean thursday_attendance;
    private Boolean friday_attendance;

    public User() {

    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setNon_vegetarian(Boolean non_vegetarian) {
        this.non_vegetarian = non_vegetarian;
    }

    public void setMonday_attendance(Boolean monday_attendance) {
        this.monday_attendance = monday_attendance;
    }

    public void setTuesday_attendance(Boolean tuesday_attendance) {
        this.tuesday_attendance = tuesday_attendance;
    }

    public void setWednesday_attendance(Boolean wednesday_attendance) {
        this.wednesday_attendance = wednesday_attendance;
    }

    public void setThursday_attendance(Boolean thursday_attendance) {
        this.thursday_attendance = thursday_attendance;
    }

    public void setFriday_attendance(Boolean friday_attendance) {
        this.friday_attendance = friday_attendance;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public Boolean getNon_vegetarian() {
        return non_vegetarian;
    }

    public Boolean getMonday_attendance() {
        return monday_attendance;
    }

    public Boolean getTuesday_attendance() {
        return tuesday_attendance;
    }

    public Boolean getWednesday_attendance() {
        return wednesday_attendance;
    }

    public Boolean getThursday_attendance() {
        return thursday_attendance;
    }

    public Boolean getFriday_attendance() {
        return friday_attendance;
    }

}
