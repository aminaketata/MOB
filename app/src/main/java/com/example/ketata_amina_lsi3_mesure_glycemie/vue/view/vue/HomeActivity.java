package com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.vue;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ketata_amina_lsi3_mesure_glycemie.R;
import com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.controller.LoginController;

// HomeActivity class representing the main screen of the application
public class HomeActivity extends AppCompatActivity
{
    private Button btnConsultation;
    private EditText etUserName;
    private EditText etpassword;
    private LoginController loginController;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Initialize UI elements and the LoginController
        init();
        // Set the username and password fields with the saved values from the LoginController
        etUserName.setText(loginController.getUserName());
        etpassword.setText(loginController.getPassword());
        // Set up a click listener for the consultation button
        btnConsultation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String userName,password;
                Boolean verifUserName = false,verifPassword = false;
                // Check if the username is not empty
                if(!etUserName.getText().toString().isEmpty())
                    verifUserName = true;
                else
                    Toast.makeText(HomeActivity.this, "Veuillez saisir votre nom d'utilisateur", Toast.LENGTH_SHORT).show();
                // Check if the password is not empty
                if(!etpassword.getText().toString().isEmpty())
                    verifPassword = true;
                else
                    Toast.makeText(HomeActivity.this, "Veuillez saisir votre mot de passe", Toast.LENGTH_LONG).show();
                // If both username and password are provided, proceed to the main activity
                if (verifUserName && verifPassword)
                {
                    userName = etUserName.getText().toString();
                    password = etpassword.getText().toString();
                    loginController.createUser(userName, password, HomeActivity.this);
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    // Method to initialize UI elements and the LoginController
    private void init()
    {
        loginController = LoginController.getInstance(HomeActivity.this);
        btnConsultation = (Button)findViewById(R.id.btnConsultation);
        etpassword = (EditText)findViewById(R.id.etPassword);
        etUserName = (EditText)findViewById(R.id.etUserName);
    }
}