package com.example.surya.myapplication;

/**
 * Created by surya on 9/21/17.
 */

public class User {
    private String userId;
    private String lastName;
    private String fisrtName;
    private String Email;
    private String Pass;
    private String PassAgain;


    public User(){}

    public User( String userId, String lastName, String fisrtName, String Email, String Pass, String PassAgain ) {
        this.lastName = lastName;
        this.fisrtName = fisrtName;
        this.Email = Email;
        this.Pass = Pass;
        this.PassAgain = PassAgain;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPass() {
        return Pass;
    }

    public String getPassAgain() {
        return PassAgain;
    }




}
