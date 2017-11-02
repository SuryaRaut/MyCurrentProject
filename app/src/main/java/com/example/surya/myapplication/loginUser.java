package com.example.surya.myapplication;

/**
 * Created by surya on 9/22/17.
 */

public class loginUser {
    private String id;
    private String email;
    private String pass;

    public loginUser(){

    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public loginUser(String id, String email, String pass) {

        this.id = id;
        this.email = email;
        this.pass = pass;
    }
}
