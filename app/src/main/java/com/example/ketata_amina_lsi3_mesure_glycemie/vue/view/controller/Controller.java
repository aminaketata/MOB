package com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.controller;

import com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.model.Patient;

// Controller class responsible for managing Patient instances
public class  Controller
{
    // Static instance of Patient to ensure a single instance throughout the application
    private static Patient patient;
    // Static instance of the Controller for implementing the Singleton pattern
    private static Controller instance = null;
    // Singleton method to get or create the Controller instance
    public static final Controller getInstance()
    {
        if(Controller.instance==null)
            Controller.instance=new Controller();
        return Controller.instance;
    }
    // Private constructor to enforce Singleton pattern and prevent external instantiation
    private Controller()
    {
        super();
    }
    // Method to create a new Patient instance with the given parameters
    public void createPatient(int age,float valeur,boolean jen)
    {
        patient=new Patient(age,valeur,jen);
    }
    // Method to retrieve the result from the current Patient instance
    public String getResult()
    {
        return patient.getResult();
    }
}
