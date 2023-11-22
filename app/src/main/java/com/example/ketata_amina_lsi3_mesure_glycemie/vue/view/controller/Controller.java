package com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.controller;
import com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.model.Patient;
public class  Controller
{
    private static Patient patient;
    private static Controller instance = null;
    public static final Controller getInstance()
    {
        if(Controller.instance==null)
            Controller.instance=new Controller();
        return Controller.instance;
    }
    private Controller()
    {
        super();
    }
    public void createPatient(int age,float valeur,boolean jen)
    {
        patient=new Patient(age,valeur,jen);
    }
    public String getResult()
    {
        return patient.getResult();
    }
}
