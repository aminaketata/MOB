package com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.model;

// User class representing a user in the application
public class User
{
    // Private fields to store user information
    private String userName;
    private String password;
    // Constructor to initialize the User object with a username and password
    public User(String userName, String password)
    {
        this.userName=userName;
        this.password=password;
    }
    // Getter method to retrieve the username of the user

    public String getUserName()
    {
        return userName;
    }
    // Getter method to retrieve the password of the user
    public String getPassword()
    {
        return password;
    }
}
