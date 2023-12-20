package com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.vue;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.ketata_amina_lsi3_mesure_glycemie.R;

// ConsultActivity class representing the activity for displaying consultation results
public class ConsultActivity extends AppCompatActivity
{
    private Button btnReturn;
    private TextView tvReponse;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        // Initialize UI elements
        init();
        // Retrieve the response string from the intent
        Intent intent=getIntent();
        String reponse=intent.getStringExtra("reponse");
        // Set the response text in the TextView
        tvReponse.setText(reponse);
        // Set up a click listener for the return button
        btnReturn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Create an intent to pass back the result to the calling activity
                Intent intent = new Intent();
                // Set the result as OK if a response is available, otherwise set it as CANCELED
                if(reponse!=null)
                    setResult(RESULT_OK,intent);
                else
                    setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
    }
    private void init()
    {
        tvReponse=(TextView)findViewById(R.id.tvReponse);
        btnReturn=(Button)findViewById(R.id.btnReturn);
    }
}