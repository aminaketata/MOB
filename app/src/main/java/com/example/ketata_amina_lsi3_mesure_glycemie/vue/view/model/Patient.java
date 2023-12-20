package com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.model;
public class Patient
{
    // Private fields to store patient information
    private int age;
    private float Vmesurer;
    private boolean jen;
    private String result;
    //notify controle---->Model
    // Constructor to initialize the Patient object with age, Vmesurer, and jen
    // Also calculates the result immediately upon object creation
    public Patient(int age, float Vmesurer, boolean jen)
    {
        this.age=age;
        this.Vmesurer=Vmesurer;
        this.jen=jen;
        calculer();// Calculate the result based on the provided information
    }
    // Getter method to retrieve the age of the patient
    public double getAge()
    {
        return age;
    }
    // Getter method to retrieve the Vmesurer (glycemic level) of the patient
    public double getVmesurer()
    {
        return Vmesurer;
    }
    // Getter method to check if the patient is in a fasting state (jen)
    public boolean isJen()
    {
        return jen;
    }
    // Getter method to retrieve the calculated result based on the patient's information
    public String getResult()
    {
        return result;
    }
    // Private method to perform the calculation of the result based on age, Vmesurer, and jen
    private void calculer()
    {
        // Check if the patient is in a fasting state
        if (jen=true)
        {
            // Check different age ranges and glycemic levels to determine the result
            if (age>=13)
            {
                if (Vmesurer<5)
                    result="niveau de glycémie est bas";
                else if (Vmesurer>=5 && Vmesurer<=7.2)
                    result="niveau de glycémie est normale";
                else
                    result="niveau de glycémie est élevé";
            }
            else if (age>=6 && age<=12)
            {
                if (Vmesurer<5)
                    result="niveau de glycémie est bas";
                else if (Vmesurer>=5 && Vmesurer<=10)
                    result="niveau de glycémie est normale";
                else
                    result="niveau de glycémie est élevé";
            }
            else if (age<6)
            {
                if (Vmesurer<5.5)
                    result="niveau de glycémie est bas";
                else if (Vmesurer>=5.5 && Vmesurer<=10)
                    result="niveau de glycémie est normale";
                else
                    result="niveau de glycémie est élevé";
            }
        }
        else
        {
            // If not in a fasting state, check glycemic level to determine the result
            if (Vmesurer> 10.5)
                result="niveau de glycémie est élevé";
            else
                result="niveau de glycémie est normale";
        }
    }
}
