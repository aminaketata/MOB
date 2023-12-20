package com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.controller;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.model.User;

// LoginController class responsible for managing user login information
public class LoginController
{
    // Constant for shared preferences
    private static final String SHERED_PREFS = "sharedPrefs";
    // Static instance of User and LoginController for implementing the Singleton pattern
    private static User user;
    private static LoginController instance = null;
    // Private constructor to enforce Singleton pattern and prevent external instantiation
    private LoginController()
    {
        super();
    }
    public static final LoginController getInstance(Context context)
    {
        if(LoginController.instance==null)
            LoginController.instance=new LoginController();
        // Retrieve user information from shared preferences and set it in the user object
        recapUser(context);
        return LoginController.instance;
    }
    // Private method to retrieve user information from shared preferences
    private static void recapUser(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHERED_PREFS,Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("userName","");
        String password = sharedPreferences.getString("password","");
        user = new User(userName,password);
    }
    // Method to create a new user with the provided username and password
    public void createUser(String userName, String password, Context context)
    {
        //creation de l'utilisateur
        user = new User(userName,password);
        //persistance des données de l'utilisateur
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHERED_PREFS,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName",userName);
        editor.putString("password",password);
        editor.apply();
    }
    // Method to get the username from the stored user object
    public String getUserName()
    {
        return user.getUserName();
    }
    // Method to get the password from the stored user object
    public String getPassword()
    {
        return user.getPassword();
    }
}
